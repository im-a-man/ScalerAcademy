package classes.android.roomDataBase

import androidx.appcompat.app.AppCompatActivity
import androidx.room.RoomDatabase
import androidx.room.migration.Migration

class RoomDataBase : AppCompatActivity() {
    fun main() {
        val database: AppDatabase = AppDatabase.getInstance(this)
        database.usersDao().insertAll(
            listOf(
                Users(
                    primaryKey = 0,
                    userName = "Aman",
                    mobile = "8791344378",
                    email = "aman@gmail.com",
                    dateOfBirth = 1234567861
                )
            )
        )
    }

    //SQLiteDatabase uses Cursor and Content-Values

    //Room database is just an abstraction layer over the SQLiteDatabase,
    // or can say abstracted implementations of SQLiteDatabase,
    // using which we can write very little code to create a database
    //and then create Entities (Tables) or can say model classes
    //and then perform the actual operations using DAO methods


    /**
     * Allows Room to destructively recreate database tables if [Migration]s that would
     * migrate old database schemas to the latest schema version are not found.
     *
     * When the database version on the device does not match the latest schema version, Room
     * runs necessary [Migration]s on the database.
     *
     * If it cannot find the set of [Migration]s that will bring the database to the
     * current version, it will throw an [IllegalStateException].
     *
     * You can call this method to change this behavior to re-create the database instead of
     * crashing.
     *
     * If the database was create from an asset or a file then Room will try to use the same
     * file to re-create the database, otherwise this will delete all of the data in the
     * database tables managed by Room.
     *
     * To let Room fallback to destructive migration only during a schema downgrade then use
     * [fallbackToDestructiveMigrationOnDowngrade].
     *
     * @return This builder instance.
     */
    //fallbackToDestructiveMigration()//Auto migrate to new schema version, instead of crashing
    //fallbackToDestructiveMigrationOnDowngrade()//Auto migrate to old schema version, instead of crashing
    //fallbackToDestructiveMigrationFrom(1)//Auto migrate to new schema version, from started version

    // Create and pre-populate the database. See this article for more details:
    //addCallback(object : RoomDatabase.Callback() {}

    /**
     * If there are not enough migrations provided to move from the current version to the latest
     * version, Room will clear the database and recreate so even if you have no changes between 2
     * versions, you should still provide a Migration object to the builder.
     * */
    //addMigrations(MIGRATION_1_2)
}