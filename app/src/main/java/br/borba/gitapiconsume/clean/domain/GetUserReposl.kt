package br.borba.gitapiconsume.clean.domain

import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.domain.model.UserRepoModel

class GetUserRepos(
    private val repository: MainRepository
) : GetUserReposUseCase {
    override suspend fun invoke(user: String): List<UserRepoModel> = try {
        repository.getUserRepos(user)
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetUserReposUseCase {
    suspend operator fun invoke(user: String): List<UserRepoModel>
}