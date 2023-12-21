package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.domain.model.UsersListModel

class GetUserDetail(
    private val repository: MainRepository
) : GetUserDetailUseCase {
    override suspend fun invoke(user: String): UsersListModel = try {
        repository.getUserDetail(user)
    } catch (ex: Exception) {
        throw Exception("error parse Detail")
    }
}

interface GetUserDetailUseCase {
    suspend operator fun invoke(user: String): UsersListModel
}