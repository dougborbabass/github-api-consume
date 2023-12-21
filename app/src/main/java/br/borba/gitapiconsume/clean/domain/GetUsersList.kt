package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.domain.model.UsersListModel

class GetUsersList(
    private val repository: MainRepository
) : GetUsersListUseCase {
    override suspend fun invoke(): List<UsersListModel> = try {
        repository.getListUsers()
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetUsersListUseCase {
    suspend operator fun invoke(): List<UsersListModel>
}