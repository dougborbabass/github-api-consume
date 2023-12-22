package br.borba.gitapiconsume.clean.presenter.model

import android.os.Parcelable
import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import kotlinx.parcelize.Parcelize

@Parcelize
class UsersUiModel(
    val userName: String,
    val avatarUrl: String = "",
    val id: Int,
    val nameFull: String = "",
    val followers: Int = 0,
    val following: Int = 0,
    val publicRepos: Int = 0
) : Parcelable

fun UsersListModel.toUiModel() = UsersUiModel(
    userName = this.userName,
    id = this.id,
    avatarUrl = this.avatarUrl,
    nameFull = this.nameFull,
    followers = this.followers,
    following = this.following,
    publicRepos = this.publicRepos
)

