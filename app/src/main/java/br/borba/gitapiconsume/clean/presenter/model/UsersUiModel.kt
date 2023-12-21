package br.borba.gitapiconsume.clean.presenter.model

import android.os.Parcelable
import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import kotlinx.parcelize.Parcelize

@Parcelize
class UsersUiModel(
    val userName: String,
    val avatarUrl: String = "",
    val id: Int
): Parcelable

fun UsersListModel.toUiModel() = UsersUiModel(
    userName = this.userName,
    id = this.id,
    avatarUrl = this.avatarUrl
)

