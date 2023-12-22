package br.borba.gitapiconsume.clean.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.borba.cleanmvvm.databinding.ItemReposBinding
import br.borba.gitapiconsume.clean.presenter.model.UserRepoUiModel
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.util.NumberFormatter
import coil.load
import coil.transform.RoundedCornersTransformation

class UserReposAdapter(
    private val userRepos: List<UserRepoUiModel>,
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
                tvUserName.text = repos.owner.userName
                ivUserPic.load(repos.owner.avatarUrl) {
                    crossfade(true)
                    transformations(RoundedCornersTransformation(8f))
                }
                tvRepoDesc.text = repos.description
                tvRepoDesc.setVisibleIf(repos.description?.isNotEmpty() ?: false)
                tvRepoStarCount.text = NumberFormatter.formatWithSuffix(repos.starsCount)
                tvRepoForkCount.text = NumberFormatter.formatWithSuffix(repos.forksCount)
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