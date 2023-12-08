package classes.android.roomDataBase

import androidx.lifecycle.LiveData

/**
 * Instead of directly providing the data sources to viewModels,
 * we'll manage all our data sources in This repository,
 * so that if any changes are made in data sources,
 * we just need to change in one place that is repository.
 * and get rid of changing in all viewModels.
 *
 * Our Repository will provide the access of all the data sources to viewModelsx
 * */

class UserRepository(private val localDataSource: LocalDataSource) {
    /**
     * A repository class abstracts the access to multiple data sources.
     * A repository is not the part of architecture components libraries,
     * but is suggested best practice for code separation and architecture.
     * */
    companion object {

        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(
            localDataSource: LocalDataSource
        ): UserRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserRepository(localDataSource)
                    .also { INSTANCE = it }
            }
    }

    val readUsers: LiveData<List<UsersEntity>> = localDataSource.getUsers
    suspend fun insertUsers(users: List<UsersEntity>) {
        localDataSource.insertUsers(users)
    }


}