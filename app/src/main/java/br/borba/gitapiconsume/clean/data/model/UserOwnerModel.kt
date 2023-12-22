package br.borba.gitapiconsume.clean.data.model

import android.os.Parcelable
import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserOwnerModel(
    @SerializedName("login")
    val userName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("avatar_url")
    val avatarUrl: String = ""
): Parcelable

fun UserOwnerModel.toFinalUsersList() = UsersListModel(
    userName = this.userName,
    id = this.id,
    avatarUrl = this.avatarUrl
)
