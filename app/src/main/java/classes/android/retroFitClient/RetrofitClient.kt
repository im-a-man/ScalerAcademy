/*
 * Copyright 2021 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package classes.android.retroFitClient

import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GetTokenResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Creates Retrofit instances
 * @param <S>
 */
class RetrofitClient<S>(baseUrl: String, serviceClass: Class<S>) {
    private var service: S

    init {
        //Create converter factory for serialization and deserialization of objects. */
        val gson: Gson = GsonBuilder().setLenient().create()

        //An OkHttp interceptor which logs request and response information in logcat for debugging.
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        //To log to a custom location, pass a Logger instance to the constructor.
        //val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }

        //Create okHttpClient
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(classes.android.retroFitClient.RetrofitClient.Companion.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(classes.android.retroFitClient.RetrofitClient.Companion.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(classes.android.retroFitClient.RetrofitClient.Companion.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(classes.android.retroFitClient.UserIdTokenInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()

        //Create retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            //A converter for strings and both primitives and their boxed types.
            .addConverterFactory(ScalarsConverterFactory.create())
            //A converter which uses Gson for JSON.
            .addConverterFactory(GsonConverterFactory.create(gson))
            //Add a call adapter factory for supporting service method return types
            /**
             * Returns an instance which creates asynchronous observables that run on a background thread by
             * default. Applying {@code subscribeOn(..)} has no effect on instances created by the returned
             * factory.
             * ----------------------------------------------------------------
             * A {@linkplain CallAdapter.Factory call adapter} which uses RxJava 3 for creating observables.
             *
             * <p>Adding this class to {@link Retrofit} allows you to return an {@link Observable}, {@link
             * Flowable}, {@link Single}, {@link Completable} or {@link Maybe} from service methods.
             *
             * <pre><code>
             * interface MyService {
             *   &#64;GET("user/me")
             *   Observable&lt;User&gt; getUser()
             * }
             * </code></pre>
             *
             * There are three configurations supported for the {@code Observable}, {@code Flowable}, {@code
             * Single}, {@link Completable} and {@code Maybe} type parameter:
             *
             * <ul>
             *   <li>Direct body (e.g., {@code Observable<User>}) calls {@code onNext} with the deserialized
             *       body for 2XX responses and calls {@code onError} with {@link HttpException} for non-2XX
             *       responses and {@link IOException} for network errors.
             *   <li>Response wrapped body (e.g., {@code Observable<Response<User>>}) calls {@code onNext} with
             *       a {@link Response} object for all HTTP responses and calls {@code onError} with {@link
             *       IOException} for network errors
             *   <li>Result wrapped body (e.g., {@code Observable<Result<User>>}) calls {@code onNext} with a
             *       {@link Result} object for all HTTP responses and errors.
             * </ul>
             */
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        service = retrofit.create(serviceClass)
    }

    fun getService(): S {
        return service
    }

    companion object {
        private const val NETWORK_TIMEOUT_SECONDS: Long = 60
    }
}


/**
 * An [Interceptor] that adds the Firebase Auth ID token to the retrofit request headers.
 */
class UserIdTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val user = FirebaseAuth.getInstance().currentUser
        val request: Request = chain.request()
        if (user == null) {
            Log.i(classes.android.retroFitClient.UserIdTokenInterceptor.Companion.TAG, "user is null")
            throw IOException("user is null")
        }
        val task = user.getIdToken(false)

        val result: GetTokenResult? = try {
            Tasks.await(task, 30000, TimeUnit.MILLISECONDS)
        } catch (e: Exception) {
            throw IOException("Failed to get new user ID token", e)
        }
        val token = result?.token

        if (token == null) {
            Log.i(classes.android.retroFitClient.UserIdTokenInterceptor.Companion.TAG, "token is null")
            throw IOException("token is null")
        } else {
            val modifiedRequest: Request = request.newBuilder()
                .addHeader(classes.android.retroFitClient.UserIdTokenInterceptor.Companion.X_FIREBASE_ID_TOKEN, token)
                .build()
            return chain.proceed(modifiedRequest)
        }
    }

    companion object {
        private const val X_FIREBASE_ID_TOKEN = "X-FireIDToken"
        private const val TAG = "Interceptor"
    }
}