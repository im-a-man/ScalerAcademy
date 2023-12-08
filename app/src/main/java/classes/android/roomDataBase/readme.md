=> A Room database is a part of the Android Jetpack library
that provides an abstraction layer over SQLite,
which is a widely used relational database management system.
Room simplifies database interactions and helps manage
the SQLite database in Android applications.
It is designed to be more robust, efficient,
and developer-friendly compared to direct SQLite usage.

=> Room Database in Android is built on top of
the SQLiteOpenHelper class, which is part of the Android framework.
The SQLiteOpenHelper class is a helper class that manages
database creation and version management.

=> Main Advantage of using RoomDatabase are=>
1=> The Compile-time verification of the SQL Queries
2=> Easily integrated with architecture components like LiveData

There are 3 main components of RoomDatabase=>
1-> @Entity
2-> @DAO
3-> @Database


         //SQLiteDatabase uses Cursor and Content-Values,
    //This was hard to create and manage SQLite Database in android

    //Room database is just an abstraction layer over the SQLiteDatabase,
    // or can say abstracted implementations of SQLiteDatabase,
    // using which we can write very little code to create a database
    //and then create Entities (Tables) or can say model classes
    //and then perform the actual operations using DAO methods