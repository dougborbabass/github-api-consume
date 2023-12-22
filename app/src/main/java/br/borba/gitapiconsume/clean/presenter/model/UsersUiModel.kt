package br.borba.gitapiconsume.clean.presenter.model

import android.os.Parcelable
import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import kotlinx.parcelize.Parcelize

@Parcelize
class UsersUiModel(
    val userName: String,
    val avatarUrl: String = "",
    val id: Int,
    val nameFull: String? = "",
    val followers: Int = 0,
    val following: Int = 0,
    val publicRepos: Int = 0,
    val url: String = "",
    val forkCount: Int = 0,
    val starCount: Int = 0,
    val description: String? = "",
    val language: String? = ""
) : Parcelable

fun UsersListModel.toUiModel() = UsersUiModel(
    userName = this.userName,
    id = this.id,
    avatarUrl = this.avatarUrl,
    nameFull = this.nameFull,
    followers = this.followers,
    following = this.following,
    publicRepos = this.publicRepos,
    url = this.url,
    forkCount = this.forksCount,
    starCount = this.starsCount,
    description = this.description,
    language = this.language
)

