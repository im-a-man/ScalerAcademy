package classes.android.recyclerView

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * DiffUtil=>
 * DiffUtil is a utility class that calculates the difference between two lists and outputs
 * a list of update operations that converts the first list into the second one.
 * It can be used to calculate updates for a RecyclerView Adapter.
 * See, AsyncListDiffer which can simplify the use of DiffUtil on a background thread.
 * */

class DiffUtilAdapter : RecyclerView.Adapter<DiffUtilAdapter.ViewHolder>() {
    class User(
        val id: String,
        val name: String,
        val email: String
    ) {
        override fun equals(other: Any?): Boolean {
            if (javaClass != other?.javaClass)
                return false
            (other as User)
            if (id != other?.id)
                return false
            if (name != other?.name)
                return false
            if (email != other?.email)
                return false
            return true
        }

        override fun toString(): String {
            return "User(id = $id, name = $name, email = $email)"
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + name.hashCode()
            result = 31 * result + email.hashCode()
            return result
        }
    }

    class ItemDifferenceCallback(private val oldList: List<User>, private val newList: List<User>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // User properties may have changed if reloaded from the DB, but ID is fixed
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // NOTE: if you use equals, your object must properly override Object#equals()
            // Incorrectly returning false here will result in too many animations.
            return oldList[oldItemPosition].equals(newList[newItemPosition])
        }
    }

    private var itemList: ArrayList<User> = arrayListOf()

    fun submitList(newList: ArrayList<User>) {
        val oldList = itemList
        val diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(ItemDifferenceCallback(oldList, newList))
        itemList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = itemList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(View(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val string = itemList[position]
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)
}