package classes.android.roomDataBase

import androidx.lifecycle.LiveData

/**
 *Our DataSource will handle data only from one source of data.
 * so if any changes are made in data sources then we'll handle from here only.
 * */

class LocalDataSource(private val appDatabase: AppDatabase) {
    val getUsers: LiveData<List<UsersEntity>> = appDatabase.usersDao().getAll()

    fun insertUsers(users: List<UsersEntity>) = appDatabase.usersDao().insertAll(users)

    companion object {

        @Volatile
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(database: AppDatabase): LocalDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: LocalDataSource(database).also { INSTANCE = it }
            }
    }
}