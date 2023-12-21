package br.borba.gitapiconsume.clean.data.api

import br.borba.gitapiconsume.clean.data.model.UsersListResponse
import br.borba.gitapiconsume.network.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("users")
    suspend fun getListUsers(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<List<UsersListResponse>>
}