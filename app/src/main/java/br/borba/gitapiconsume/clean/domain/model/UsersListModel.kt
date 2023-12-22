package br.borba.gitapiconsume.clean.domain.model

import br.borba.gitapiconsume.clean.data.model.UserOwnerModel

data class UsersListModel(
    val id: Int = 0,
    val userName: String = "",
    val avatarUrl: String = "",
    val nameFull: String = "",
    val followers: Int = 0,
    val following: Int = 0,
    val publicRepos: Int = 0,
    val createdAt: String = "",
    val description: String? = "",
    val forks: Int = 0,
    val forksCount: Int = 0,
    val fullName: String = "",
    val gitUrl: String = "",
    val htmlUrl: String = "",
    val language: String? = "",
    val name: String = "",
    val owner: UserOwnerModel,
    val starsCount: Int = 0,
    val updateAt: String? = "",
    val url: String = ""
)