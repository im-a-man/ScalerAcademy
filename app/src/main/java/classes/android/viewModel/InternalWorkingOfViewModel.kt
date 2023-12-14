package classes.android.viewModel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner


class DemoViewModel : ViewModel() {

}

class InternalWorkingOfViewModel : androidx.activity.ComponentActivity() {
    //ComponentActivity implements the ViewModelStoreOwner and HasDefaultViewModelProviderFactory
    //for providing viewModel when configuration changes happens
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val demoViewModel = ViewModelProvider(this).get(DemoViewModel::class.java)
        //Here, get(DemoViewModel::class.java) this method does everything,
        //It calls another get method which returns the ViewModel
    }
}


/**
 * A scope that owns [ViewModelStore].
 *
 * A responsibility of an implementation of this interface is to retain owned ViewModelStore
 * during the configuration changes and call [ViewModelStore.clear], when this scope is
 * going to be destroyed.
 *
 * @see ViewTreeViewModelStoreOwner
 */
interface ViewModelStoreOwner {
    val viewModelStore: ViewModelStore
}

/**
 * Interface that marks a [ViewModelStoreOwner] as having a default
 * [ViewModelProvider.Factory] for use with [ViewModelProvider].
 */
interface HasDefaultViewModelProviderFactory {
    val defaultViewModelProviderFactory: ViewModelProvider.Factory
}


