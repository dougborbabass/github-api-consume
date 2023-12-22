package br.borba.gitapiconsume.clean.domain.model

data class UsersListModel(
    val id: Int = 0,
    val userName: String = "",
    val avatarUrl: String = "",
    val nameFull: String = "",
    val followers: Int = 0,
    val following: Int = 0,
    val publicRepos: Int = 0
)