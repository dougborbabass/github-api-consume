package br.borba.gitapiconsume.clean.data.api

import br.borba.gitapiconsume.clean.data.model.UserRepoItemResponse
import br.borba.gitapiconsume.clean.data.model.UsersDetailResponse
import br.borba.gitapiconsume.clean.data.model.UsersListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("users")
    suspend fun getListUsers(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<List<UsersListResponse>>

    @GET("/users/{user}")
    suspend fun getDetail(@Path("user") user: String): Response<UsersDetailResponse>

    @GET("/users/{user}/repos")
    suspend fun getRepos(@Path("user") user: String): Response<List<UserRepoItemResponse>>

}