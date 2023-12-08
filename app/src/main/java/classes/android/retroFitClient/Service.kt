package classes.android.retroFitClient

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    val retrofitClient = classes.android.retroFitClient.RetrofitClient(
        "https://api.publicapis.org",
        classes.android.retroFitClient.ApiMethods::class.java
    )
    val disposable = retrofitClient.getService().getApi()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { it.toString() }
        .subscribe(
            { onNext -> println(onNext) },
            { onError -> println(onError) },
            { println("Completed") })
    disposable.dispose()
}

/**
Retrofit and OkHttp are both popular libraries in the Android ecosystem, and they are often used together for building network-related functionalities. However, they serve different purposes and can be used independently. Let's discuss each one:

1. **OkHttp:**
- **Purpose:** OkHttp is an HTTP client for making network requests. It abstracts the complexities of making HTTP requests and handles tasks such as connection pooling, response caching, and request/response compression.
- **Key Features:**
- Efficient connection management.
- Automatic response caching.
- Interceptor support for modifying requests and responses.
- WebSocket support.
- SPDY protocol support.
- **Use Case:** Use OkHttp when you need a powerful and flexible HTTP client for making network requests in your Android app. It's commonly used as the underlying network layer for other libraries like Retrofit.

2. **Retrofit:**
- **Purpose:** Retrofit is a type-safe HTTP client for Android and Java. It simplifies the process of consuming RESTful APIs by allowing you to define an interface with annotated methods that represent API endpoints. It uses annotations to describe the HTTP request type, URL, request parameters, headers, and expected response type.
- **Key Features:**
- Declarative API for defining HTTP requests.
- Automatic conversion of JSON/XML responses to Java/Kotlin objects.
- Support for synchronous and asynchronous request execution.
- Request and response manipulation through converters and adapters.
- Integration with OkHttp for efficient network operations.
- **Use Case:** Use Retrofit when you want a higher-level abstraction for working with APIs, making the code cleaner, and reducing boilerplate. It's particularly useful for handling RESTful services.

 **Combining OkHttp and Retrofit:**
- While OkHttp can be used independently for basic HTTP requests, Retrofit is often used in conjunction with OkHttp to build robust and efficient network layers in Android applications. Retrofit uses OkHttp as its default HTTP client, taking advantage of its features and performance optimizations.

 **Summary:**
- If you need a low-level HTTP client with features like connection pooling,
caching, and interceptors, use OkHttp.
- If you are working with RESTful APIs and want a high-level, type-safe,
and declarative approach to define and consume API endpoints, use Retrofit.
- In many cases, using Retrofit with OkHttp as the underlying HTTP client provides
a powerful and convenient solution for building network-related functionality in Android applications.
* */