package com.hucet.todo

import android.app.Application
import com.hucet.todo.module.NetworkModule
import com.hucet.todo.module.NewsModule
import com.hucet.todo.module.component.DaggerNewsComponent
import com.hucet.todo.module.component.NewsComponent
import timber.log.Timber

class MyApplication : Application() {
    companion object {
        lateinit var newsComponent: NewsComponent
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
        newsComponent = DaggerNewsComponent.builder()
                .newsModule(NewsModule())
                .networkModule(NetworkModule())
                .build()
    }
}
