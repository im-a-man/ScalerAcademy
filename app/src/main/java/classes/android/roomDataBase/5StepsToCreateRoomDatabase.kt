package classes.android.roomDataBase

fun main() {
    /**
     * 5StepsToCreateRoomDatabase.kt
     *
    A step by step guide on how to migrate your app to Room
    Room is a persistence library, part of the Android Architecture Components.
    It makes it easier to work with SQLiteDatabase objects in your app,
    decreasing the amount of boilerplate code and verifying SQL queries at compile time.

    Step 1 — Update the gradle dependencies
    Step 2 — Update model classes to entities
    Step 3 — Create Data Access Objects (DAOs)
    Step 4 — Create the database
    Step 5 — Update the Repository to use Room
    * */

    /**
     * 7 Pro-tips for Room=> https://medium.com/androiddevelopers/7-pro-tips-for-room-fbadea4bfbd1#4785
     *
     * 1. Pre-populate the database
     * Room.databaseBuilder(context.applicationContext,
     *         DataDatabase::class.java, "Sample.db")
     *         // prepopulate the database after onCreate was called
     *         .addCallback(object : Callback() {
     *             override fun onCreate(db: SupportSQLiteDatabase) {
     *                 super.onCreate(db)
     *                 // moving to a new thread
     *                 ioThread {
     *                     getInstance(context).dataDao()
     *                                         .insert(PREPOPULATE_DATA)
     *                 }
     *             }
     *         })
     *         .build()
     *
     *
     * 2. Use DAO’s inheritance capability
     * interface BaseDao<T> {
     *     @Insert
     *     fun insert(vararg obj: T)
     * }
     * @Dao
     * abstract class DataDao : BaseDao<Data>() {
     *     @Query("SELECT * FROM Data")
     *     abstract fun getData(): List<Data>
     * }
     *
     *
     * 3. Execute queries in transactions with minimal boilerplate code
     * @Dao
     * abstract class UserDao {
     *
     *     @Transaction
     *     open fun updateData(users: List<User>) {
     *         deleteAllUsers()
     *         insertAll(users)
     *     }
     *     @Insert
     *     abstract fun insertAll(users: List<User>)
     *     @Query("DELETE FROM Users")
     *     abstract fun deleteAllUsers()
     * }
     *
     *
     * 4. Read only what you need
     *
     * 5. Enforce constraints between entities with foreign keys
     *@Entity(tableName = "pets",
     *         foreignKeys = arrayOf(
     *             ForeignKey(entity = User::class,
     *                        parentColumns = arrayOf("userId"),
     *                        childColumns = arrayOf("owner"))))
     * data class Pet(@PrimaryKey val petId: String,
     *               val name: String,
     *               val owner: String)
     *
     *
     * 6. Simplify one-to-many queries via @Relation
     * data class UserAndAllPets (val user: User,
     *                            val pets: List<Pet> = ArrayList())
     * @Query(“SELECT * FROM Users”)
     * public List<User> getUsers();
     * @Query(“SELECT * FROM Pets where owner = :userId”)
     * public List<Pet> getPetsForUser(String userId);
     *
     * to
     *
     * class UserAndAllPets {
     *    @Embedded
     *    var user: User? = null
     *    @Relation(parentColumn = “userId”,
     *              entityColumn = “owner”)
     *    var pets: List<Pet> = ArrayList()
     * }
     *
     * @Transaction
     * @Query(“SELECT * FROM Users”)
     * List<UserAndAllPets> getUsers();
     *
     *
     * 7. Avoid false positive notifications for observable queries
    * */
}