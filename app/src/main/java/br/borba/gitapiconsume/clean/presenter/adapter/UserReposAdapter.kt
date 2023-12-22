package br.borba.gitapiconsume.clean.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.borba.cleanmvvm.databinding.ItemReposBinding
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.util.NumberFormatter
import coil.load

class UserReposAdapter(
    private val userRepos: List<UsersUiModel>,
    private val itemClick: (item: UsersUiModel) -> Unit
) : RecyclerView.Adapter<UserReposAdapter.CategoriesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserReposAdapter.CategoriesViewHolder {
        val itemView =
            ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserReposAdapter.CategoriesViewHolder, position: Int) {
        val repos = userRepos[position]

        with(holder) {
            with(binding) {
                tvUserName.text = repos.userName
                ivUserPic.load(repos.avatarUrl)
                tvRepoDesc.setVisibleIf(repos.description?.isNotEmpty() ?: false)
                tvRepoStarCount.text = NumberFormatter.formatWithSuffix(repos.starCount)
                tvRepoForkCount.text = NumberFormatter.formatWithSuffix(repos.forkCount)
                tvRepoLanguage.text = repos.language
                tvRepoLanguage.setVisibleIf(repos.language?.isNotEmpty() ?: false)
            }
        }
    }

    override fun getItemCount() = userRepos.size

    inner class CategoriesViewHolder(val binding: ItemReposBinding) :
        RecyclerView.ViewHolder(binding.root)

    private fun View.setVisibleIf(predicate: Boolean) {
        visibility = if (predicate) View.VISIBLE else View.GONE
    }

}