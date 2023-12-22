package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.domain.model.UsersListModel

object UserDetailFactory {

    val usersDetail =
        UsersListModel(
            id = 0,
            userName = "Douglas",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            followers = 10,
            following = 10

        )
}