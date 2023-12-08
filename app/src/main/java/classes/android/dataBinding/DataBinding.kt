package classes.android.dataBinding

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * Certainly, let me clarify the difference between `@BindingMethods` and `@BindingAdapter` in Android's data binding library.
 *
 * ### `@BindingMethods`:
 *
 * - **Purpose:**
 *   - Used to declare a list of binding methods for a custom view class.
 *   - Specifies a mapping between XML attributes and the corresponding methods in the custom view class.
 *
 * - **Location:**
 *   - Typically applied to a separate class that contains static methods annotated with `@BindingMethod`.
 *
 * - **Example:**
 *   ```java
 *   @BindingMethods({
 *           @BindingMethod(type = CustomView.class, attribute = "customText", method = "setCustomText"),
 *           @BindingMethod(type = CustomView.class, attribute = "customTextAttrChanged", method = "setCustomTextAttrChangedListener")
 *   })
 *   public class CustomViewBindings {
 *       // This class contains the binding methods
 *   }
 *   ```
 *   In this example, `CustomViewBindings` is a separate class where you declare how specific XML attributes (`customText` and `customTextAttrChanged`) map to methods in the `CustomView` class.
 *
 * ### `@BindingAdapter`:
 *
 * - **Purpose:**
 *   - Used to define custom data binding adapters.
 *   - Data binding adapters are responsible for binding data to views in XML layouts.
 *
 * - **Location:**
 *   - Applied to static methods that define how to set values for specific attributes in custom views.
 *
 * - **Example:**
 *   ```java
 *   @BindingAdapter("customText")
 *   public static void setCustomText(CustomView view, String text) {
 *       view.setCustomText(text);
 *   }
 *   ```
 *   In this example, `setCustomText` is a custom binding adapter that sets the text for a `CustomView` based on the provided data. The `@BindingAdapter("customText")` annotation specifies that this method handles the "customText" attribute in XML layouts.
 *
 * ### Summary:
 *
 * - `@BindingMethods` is used to declare the mapping between XML attributes and methods in a custom view class.
 * - `@BindingAdapter` is used to define how data should be bound to specific attributes in XML layouts.
 *
 * In many cases, both annotations are used together when working with custom views and data binding in Android, where `@BindingMethods` sets up the overall mapping, and `@BindingAdapter` handles the details of data binding for specific attributes.
 **/

fun main() {
//  TODO:Steps to implement data binding
//    1st=> id("kotlin-kapt")
//    2nd=> buildFeatures {
//        viewBinding = true
//        dataBinding = true
//    }
//    3rd=> implementation("androidx.databinding:baseLibrary:3.2.0-alpha11")


    val observableField = ObservableField<Int>()
    //Its a part of the data binding, and used to directly observe the views values,
    //Use this when lifecycle awareness do not matter.
    val liveData = MutableLiveData<Int>()
    //LiveData is the part of architecture components, and its lifecycle aware.
    /**
    * Choosing Between Them:
     * Use ObservableField when:
     *
     * You are working with the Data Binding library and want to observe changes directly in XML layouts.
     * You need to observe changes to simple fields or custom objects within your ViewModel.
     * Use LiveData when:
     *
     * You want a lifecycle-aware data holder that automatically manages subscriptions based on the component's lifecycle.
     * You are working with the Android Architecture Components and want to follow best practices for reactive programming.
     * In general, if you are using the Android Architecture Components, LiveData is often preferred for its lifecycle awareness and integration with other components in the architecture. If you are primarily using Data Binding and need to observe changes directly in XML layouts, ObservableField may be more suitable.
    * */
}

/*
    `@BindingMethods` is used to declare the mapping between XML attributes and methods in a custom view class.
    * */
@BindingMethods(
    BindingMethod(
        type = ImageView::class,
        attribute = "app:srcCompat",
        method = "setImageResource"
    )
)
class MyBindingMethods


/*
    `@BindingAdapter` is used to define how data should be bound to specific attributes in XML layouts.
    * */
@BindingAdapter("app:popularityIcon")
fun popularityIcon(view: ImageView) {
    view.setImageResource(android.R.drawable.ic_secure)
}

object MyBindingConversions {
    /*
    The @BindingConversion annotation is used in Android's data binding library
    to define a method that converts a specific type to another type when binding data.
    This can be useful when you want to perform automatic type conversion for data binding expressions.
    * */
    @BindingConversion
    fun convertIntToString(value: Int): String {
        return value.toString()
    }
    /*
    <TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{viewModel.someInt}" />
    * */
}