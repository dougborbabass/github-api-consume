package br.borba.cleanmvvm.domain

import br.borba.gitapiconsume.clean.data.model.UsersListResponse

object UsersFactory {

    val users = listOf(
        UsersListResponse(
            id = 0,
            name = "Douglas"
        ),
        UsersListResponse(
            id = 1,
            name = "Borba"
        )
    )
}