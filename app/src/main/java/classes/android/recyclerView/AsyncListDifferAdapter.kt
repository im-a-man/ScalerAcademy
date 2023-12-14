package classes.android.recyclerView

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * AsyncListDiffer=>
 * Helper for computing the difference between two lists via DiffUtil on a background thread.
 * It can be connected to a RecyclerView.Adapter, and will signal the adapter of changes between sumbitted lists.
 * The AsyncListDiffer can consume the values from a LiveData of List and present the data simply
 * for an adapter. It computes differences in list contents via DiffUtil on a background thread as
 * new Lists are received.
 * */

class AsyncListDifferAdapter : RecyclerView.Adapter<AsyncListDifferAdapter.ViewHolder>() {
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

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User?>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            // User properties may have changed if reloaded from the DB, but ID is fixed
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            // NOTE: if you use equals, your object must properly override Object#equals()
            // Incorrectly returning false here will result in too many animations.
            return oldItem.equals(newItem)
        }
    }

    private val mDiffer: AsyncListDiffer<User?> = AsyncListDiffer<User?>(this, DIFF_CALLBACK)

    fun submitList(newList: ArrayList<User?>) {
        mDiffer.submitList(newList)
    }

    override fun getItemCount(): Int = mDiffer.currentList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(View(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val string = mDiffer.currentList[position]
        holder.itemView.apply {

        }
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item)
}