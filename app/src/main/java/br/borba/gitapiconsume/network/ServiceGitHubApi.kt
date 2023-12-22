package br.borba.gitapiconsume.network

import br.borba.gitapiconsume.util.NullableTypeAdapterFactor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.github.com/"

class ServiceGitHubApi {

    private val gson = GsonBuilder()
        .setLenient()
        .registerTypeAdapterFactory(NullableTypeAdapterFactor.NullableTypAdapterFactory()).create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().addInterceptor(logInterceptor()).build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }

    fun logInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}