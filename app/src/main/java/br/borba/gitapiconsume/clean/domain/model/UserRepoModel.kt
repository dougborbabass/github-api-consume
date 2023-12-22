package br.borba.gitapiconsume.clean.domain.model

import br.borba.gitapiconsume.clean.data.model.UserOwnerModel

data class UserRepoModel(
    val description: String? = "",
    val forksCount: Int = 0,
    val fullName: String = "",
    val gitUrl: String = "",
    val htmlUrl: String = "",
    val id: Int = 0,
    val language: String? = "",
    val name: String = "",
    val owner: UserOwnerModel = UserOwnerModel(),
    val starsCount: Int = 0,
    val updateAt: String? = "",
    val url: String = ""
)