package br.borba.gitapiconsume.clean.data.model



import br.borba.gitapiconsume.clean.domain.model.UsersListModel
import com.google.gson.annotations.SerializedName

data class UserRepoItemResponse (
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("forks")
    val forks: Int = 0,
    @SerializedName("forks_count")
    val forksCount: Int = 0,
    @SerializedName("full_name")
    val fullName: String = "",
    @SerializedName("git_url")
    val gitUrl: String = "",
    @SerializedName("html_url")
    val htmlUrl: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("languages_url")
    val name: String = "",
    @SerializedName("owner")
    val owner: UserOwnerModel = UserOwnerModel(),
    @SerializedName("stargazers_count")
    val stargazersCount: Int = 0,
    @SerializedName("updated_at")
    val updatedAt: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("watchers")
    val watchers: Int = 0
)
fun UserRepoItemResponse.toFinalUsersList() = UsersListModel(
    createdAt = this.createdAt,
    description = this.description,
    forks = this.forks,
    forksCount = this.forksCount,
    fullName = this.fullName,
    gitUrl = this.gitUrl,
    htmlUrl = this.htmlUrl,
    id = this.id,
    language = this.language,
    name = this.name,
    owner = this.owner,
    starsCount = this.stargazersCount,
    updateAt = this.updatedAt,
    url = this.url,
)