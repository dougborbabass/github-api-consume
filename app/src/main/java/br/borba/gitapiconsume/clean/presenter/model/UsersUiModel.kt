package br.borba.gitapiconsume.clean.presenter.model

import br.borba.gitapiconsume.clean.domain.model.UsersListModel

class UsersUiModel(
    val name: String,
    val id: Int
)

fun UsersListModel.toUiModel() = UsersUiModel(
    name = this.name,
    id = this.id
)

