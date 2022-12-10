package com.example.gb_libraries.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_libraries.databinding.FragmentUserListItemBinding

interface ItemView {
    var position: Int?
}

interface UserItemView : ItemView {
    fun setLogin(userLogin: String)
}

interface ListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface UserListAdapterPresenter : ListPresenter<UserItemView>

class UserListAdapter(
    private val presenter: UserListAdapterPresenter
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) =
        ViewHolder(
            FragmentUserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply {
            this.position = position
        }
        )

    inner class ViewHolder(
        private val binding: FragmentUserListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root),
        UserItemView {
        override var position: Int? = -1
        override fun setLogin(userLogin: String) {
            binding.userLoginTextView.text = userLogin
        }
    }
}