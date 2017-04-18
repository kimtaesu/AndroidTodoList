package com.hucet.todo

import android.app.Application
import com.hucet.todo.module.AppModule
import com.hucet.todo.module.component.AppComponent
import com.hucet.todo.module.component.DaggerAppComponent
import timber.log.Timber

class MyApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return "${super.createStackElementTag(element)} [Thread:${Thread.currentThread()}]"
                }
            })
        }
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}
