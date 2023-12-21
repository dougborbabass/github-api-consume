package br.borba.gitapiconsume

import android.app.Application
import br.borba.gitapiconsume.di.gitApiServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(gitApiServiceModule))
        }
    }
}
