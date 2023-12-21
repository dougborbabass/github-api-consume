package br.borba.gitapiconsume.clean.presenter.model

import br.borba.gitapiconsume.clean.domain.model.UsersListModel

class UsersUiModel(
    val userName: String,
    val id: Int
)

fun UsersListModel.toUiModel() = UsersUiModel(
    userName = this.userName,
    id = this.id
)

