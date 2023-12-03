package classes.android.roomDataBase

fun main() {
    /**
    Room 🔗 RxJava=>

    Insert
    The Room integration with RxJava allows the following corresponding return types for insert:
    Completable — where onComplete is called as soon as the insertion was done
    Single<Long> or Maybe<Long> — where the value emitted on onSuccess is the row id of the item inserted
    Single<List<Long>> or Maybe<List<Long>> — where the value emitted on onSuccess is the list of row ids of the items inserted
    In case of error inserting the data, Completable, Single and Maybe will emit the exception in onError.

    Update/Delete
    The Room integration with RxJava allows the following corresponding return types for update/delete:
    Completable — where onComplete is called as soon as the update/delete was done
    Single<Integer> or Maybe<Integer> — where the value emitted on onSuccess is the number of rows affected by update/delete

    Query
    To get the user from the database, we could write the following query in the data access object class (UserDao):
    @Query(“SELECT * FROM Users WHERE id = :userId”)
    User getUserById(String userId);
    This approach has two disadvantages:
    It is a blocking, synchronous call
    We need to manually call this method every time our user data is modified
    Room provides the option of observing the data in the database and
    performing asynchronous queries with the help of RxJava Maybe, Single and Flowable objects.

    @Query(“SELECT * FROM Users WHERE id = :userId”)
    Maybe<User> getUserById(String userId);

    @Query(“SELECT * FROM Users WHERE id = :userId”)
    Single<User> getUserById(String userId);

    @Query(“SELECT * FROM Users WHERE id = :userId”)
    Flowable<User> getUserById(String userId);
    * */
}