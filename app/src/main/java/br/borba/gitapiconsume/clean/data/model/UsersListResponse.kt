package br.borba.gitapiconsume.clean.data.model

import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import com.google.gson.annotations.SerializedName

data class UsersListResponse(
    @SerializedName("login")
    val userName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("avatar_url")
    val avatarUrl: String
)

fun UsersListResponse.toFinalUsersList() = UsersListModel(
    userName = this.userName,
    id = this.id,
    avatarUrl = this.avatarUrl
)
