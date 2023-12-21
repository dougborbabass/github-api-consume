package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.domain.model.UsersListModel

class GetUserDetail(
    private val repository: MainRepository
) : GetUserDetailUseCase {
    override suspend fun invoke(): UsersListModel = try {
        repository.getUserDetail("torvalds")
    } catch (ex: Exception) {
        throw Exception("error parse Detail")
    }
}

interface GetUserDetailUseCase {
    suspend operator fun invoke(): UsersListModel
}