package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.domain.model.UsersListModel

object UsersFactory {

    val users = listOf(
        UsersListModel(
            id = 0,
            userName = "Douglas",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"
        ),
        UsersListModel(
            id = 1,
            userName = "Borba",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4"
        )
    )
}