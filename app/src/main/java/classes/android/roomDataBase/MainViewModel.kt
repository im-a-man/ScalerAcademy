package classes.android.roomDataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * Instead of directly interacting with Data sources,
     * our viewModel will interact with the Repository only,
     * because, if any changes are made in any data sources,
     * We do not need to do anything in viewModel,
     * so this way our viewModel will follow solid principle.
     * */

    private val repository: UserRepository
    private val readUsers: LiveData<List<UsersEntity>>

    init {
        val database: AppDatabase = AppDatabase.getInstance(application)
        val localDataSource: LocalDataSource = LocalDataSource.getInstance(database)
        repository = UserRepository.getInstance(localDataSource)
        readUsers = repository.readUsers
    }

    fun insertUsers(users: List<UsersEntity>) {
        viewModelScope.launch {
            readUsers.value?.let { repository.insertUsers(it) }
        }
    }
}