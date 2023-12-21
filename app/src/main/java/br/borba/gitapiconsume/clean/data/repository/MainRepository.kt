package br.borba.gitapiconsume.clean.data.repository

import br.borba.gitapiconsume.clean.data.api.GitHubApi
import br.borba.gitapiconsume.clean.data.model.toFinalUsersList
import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import br.borba.gitapiconsume.network.Output
import br.borba.gitapiconsume.network.parseResponse

class MainRepositoryImpl(
    private val service: GitHubApi
) : MainRepository {

    override suspend fun getListUsers(): List<UsersListModel> {

        val result = service.getListUsers().parseResponse()

        return when (result) {
            is Output.Success -> {
                val listUsersResult = result.value.usersList

                listUsersResult.map {
                    it.toFinalUsersList()
                }

            }

            is Output.Failure -> throw GetUsersException()
        }
    }
}

interface MainRepository {
    suspend fun getListUsers(): List<UsersListModel>
}

class GetUsersException : Exception()