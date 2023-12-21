package br.borba.gitapiconsume.di

import br.borba.gitapiconsume.clean.data.api.GitHubApi
import br.borba.gitapiconsume.clean.data.repository.MainRepository
import br.borba.gitapiconsume.clean.data.repository.MainRepositoryImpl
import br.borba.gitapiconsume.clean.domain.GetUsersList
import br.borba.gitapiconsume.clean.domain.GetUsersListUseCase
import br.borba.gitapiconsume.clean.presenter.viewmodel.UsersViewModel
import br.borba.gitapiconsume.network.ServiceGitHubApi
import org.koin.dsl.module

val gitApiServiceModule = module {
    single { ServiceGitHubApi().createService(GitHubApi::class.java) }
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<GetUsersListUseCase> {GetUsersList(get())}
    single { UsersViewModel(get()) }
}