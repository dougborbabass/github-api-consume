package br.borba.gitapiconsume.clean.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.borba.cleanmvvm.databinding.ItemUsersBinding
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import coil.load

class UsersListAdapter(
    private val usersList: List<UsersUiModel>
) : RecyclerView.Adapter<UsersListAdapter.CategoriesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersListAdapter.CategoriesViewHolder {
        val itemView =
            ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsersListAdapter.CategoriesViewHolder, position: Int) {
        val users = usersList[position]

        with(holder) {
            binding.tvUserName.text = users.userName
            binding.ivUsers.load(users.avatarUrl)
        }
    }

    override fun getItemCount() = usersList.size

    inner class CategoriesViewHolder(val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root)

}