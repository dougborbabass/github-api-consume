package br.borba.cleanmvvm.domain

import br.borba.gitapiconsume.clean.data.model.UsersListResponse
import br.borba.gitapiconsume.clean.domain.model.UsersListModel

object UsersFactory {

    val users = listOf(
        UsersListModel(
            id = 0,
            name = "Douglas"
        ),
        UsersListModel(
            id = 1,
            name = "Borba"
        )
    )
}