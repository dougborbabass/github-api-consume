package br.borba.gitapiconsume.clean.data.api

import br.borba.gitapiconsume.clean.data.model.UsersListModel
import br.borba.gitapiconsume.network.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface GitHubApi {

    @GET("users")
    suspend fun getListUsers(): Response<BaseResponse<UsersListModel>>
}