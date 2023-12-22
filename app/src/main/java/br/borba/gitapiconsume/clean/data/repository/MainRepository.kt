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
        val result = service.getListUsers(20,1).parseResponse()
        return when (result) {
            is Output.Success -> {
                val listUsersResult = result.value

                listUsersResult.map {
                    it.toFinalUsersList()
                }
            }
            is Output.Failure -> throw GetUsersException()
        }
    }

    override suspend fun getUserDetail(user: String): UsersListModel {
        val result = service.getDetail(user).parseResponse()
        return when (result) {
            is Output.Success -> {
                val listUsersResult = result.value
                listUsersResult.toFinalUsersList()
            }
            is Output.Failure -> throw GetUsersException()
        }
    }

    override suspend fun getUserRepos(user: String): List<UsersListModel> {
        val result = service.getRepos(user).parseResponse()
        return when (result) {
            is Output.Success -> {
                val listReposResult = result.value

                listReposResult.map {
                    it.toFinalUsersList()
                }
            }
            is Output.Failure -> throw GetUsersException()
        }
    }
}

interface MainRepository {
    suspend fun getListUsers(): List<UsersListModel>
    suspend fun getUserDetail(user: String): UsersListModel
    suspend fun getUserRepos(user: String): List<UsersListModel>
}

class GetUsersException : Exception()