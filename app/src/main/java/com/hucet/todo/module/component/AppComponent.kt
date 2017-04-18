package com.hucet.todo.module.component

import com.hucet.todo.NewsFragment
import com.hucet.todo.module.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(newsFragment: NewsFragment)
}