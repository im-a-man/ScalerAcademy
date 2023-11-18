package classes.scaler.interviewPreparation.rxJava

/**
In Java, method references provide a shorthand syntax for writing lambda expressions.
Method references make your code more readable by allowing you to refer to an existing
method or constructor by name. You can use method references in various contexts,
including as parameters for functional interfaces (interfaces with a single abstract method,
also known as functional interfaces).

Here's a brief overview of method references and how they can be used as parameters in Java:

Method Reference Syntax: There are several types of method references in Java:

1=>Reference to a static method:
ClassName::staticMethodName

2=>Reference to an instance method of a particular object:
instance::instanceMethodName

3=>Reference to an instance method of an arbitrary object of a particular type:
ClassName::instanceMethodName

4=>Reference to a constructor:
ClassName::new

Using Method References as Parameters:
You can use method references as parameters in places where a functional interface is expected.
Here's an example using the Consumer functional interface and a method reference:

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

public static void main(String[] args) {
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Using a lambda expression
names.forEach(name -> System.out.println(name));

// Using a method reference
names.forEach(System.out::println);
}
}
In this example, the forEach method of the List interface expects a Consumer as a parameter.
Both the lambda expression and the method reference represent the same functionality:
printing each element of the list. The method reference System.out::println is a shorthand
for the lambda expression (name -> System.out.println(name)).

Method references can be particularly useful when the lambda expression only calls an existing method,
as it allows you to express the same logic more concisely.

Note that the method being referenced must match the functional interface's method signature.
In the example above, the Consumer interface has a method void accept(T t),
and System.out::println matches this signature.
 * */

fun main() {
    val functionalInterface = Thread(object : Runnable {
        override fun run() {

        }
    })
    //Here Runnable is functional interface because it has only one abstract method(non-implemented) run(){},
    // but a functional interface can have static and default methods in it.

    fun runIt() {
        //Its signature is the same as run method of runnable.
    }

    val functionalInterface1 = Thread(::runIt) //Method reference

    //Note=> In method references we do not need to write parentheses.
    //If you are using Lambda and you want to call a method from there,
    //Keep in mind that we just need to call a method from here nothing else.
    //The method that you want to call.
    //And the method from which that you want to call the method,
    //In our case, It's runnable. If there signature matches, we can safely convert to method reference...
    //Like run(){} method does not take any arguments and return void.
    //and our runIt(){} method does the same thing so we call this is a Signature match,

    //Whenever we find the combination of lambda and signature match, we can use method references.
}