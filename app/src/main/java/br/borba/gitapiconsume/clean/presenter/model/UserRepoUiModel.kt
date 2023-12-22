package br.borba.gitapiconsume.clean.presenter.model

import android.os.Parcelable
import br.borba.gitapiconsume.clean.data.model.UserOwnerModel
import br.borba.gitapiconsume.clean.domain.model.UserRepoModel
import kotlinx.parcelize.Parcelize

@Parcelize
class UserRepoUiModel(
    val description: String? = "",
    val forksCount: Int = 0,
    val fullName: String = "",
    val gitUrl: String = "",
    val htmlUrl: String = "",
    val id: Int = 0,
    val language: String? = "",
    val name: String = "",
    val starsCount: Int = 0,
    val updateAt: String? = "",
    val url: String = "",
    val owner: UserOwnerModel = UserOwnerModel()
) : Parcelable

fun UserRepoModel.toUiModel() = UserRepoUiModel(
    description = this.description,
    forksCount = this.forksCount,
    fullName = this.fullName,
    gitUrl = this.gitUrl,
    htmlUrl = this.htmlUrl,
    id = this.id,
    language = this.language,
    name = this.name,
    starsCount = this.starsCount,
    updateAt = this.updateAt,
    url = this.url,
    owner = this.owner
)

