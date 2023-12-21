package br.borba.gitapiconsume.di

import br.borba.gitapiconsume.clean.presenter.viewmodel.UsersViewModel
import org.koin.dsl.module

val gitApiServiceModule = module {
    single { UsersViewModel() }
}