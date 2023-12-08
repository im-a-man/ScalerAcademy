package classes.android.masterClasses

fun main() {
    /**
    In Java, there are four types of references differentiated by the way by which they are garbage collected.

    Strong References
    Weak References
    Soft References
    Phantom References

    These references play a vital role at the time of garbage collection.

    Strong Reference:

    This is the default type/class of Reference Object. Any object which has an active strong reference is not eligible for garbage collection. The object is garbage collected only when the variable which was strongly referenced points to null.

    For example: Student s= new Student();

    Here s is bound referenced with the new Obj of Student hence this is a strong reference so it is not eligible for garbage collection, To make it available for garbage collection we need to nullify this once our work is done.

    s=null;

    Now s is available for garbage collection.

    =================================================================

    Week References:

    Weak Reference Objects are not the default type/class of Reference Objects and they should be explicitly specified while using them.

    This type of reference is used in WeakHashMap to reference the entry objects.
    If JVM detects an object with only weak references (i.e. no strong or soft references linked to any object), this object will be marked for garbage collection.
    To create such references java.lang.ref.WeakReference class is used.
    These references are used in real-time applications while establishing a DBConnection which might be cleaned up by Garbage Collector when the application using the database gets closed.

    For example: Student s= new Student();

    WeekReference<Student>weekref=new WeekRefernece(s);

    s=null;

    After this s of above will be available for the GC, But remember this will be garbage collected only when the memory needed by JVM

    you can get obj back by the method

    s=weekref.get();

    =================================================================

    Soft Reference:

    In Soft reference, even if the object is free for garbage collection then it also it's not garbage collected until JVM badly needs memory. The objects get cleared from the memory when JVM runs out of memory. To create such references java.lang.ref.SoftReference class is used.

    =================================================================

    Phantom References:

    The objects which are being referenced by phantom references are eligible for garbage collection. But, before removing them from memory, JVM puts them in a queue called ‘reference queue’. They are put in a reference queue after calling finalize() method on them. To create such references java.lang.ref.PhantomReference class is used.

    =================================================================
    * */
}