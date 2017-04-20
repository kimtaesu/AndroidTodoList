package com.hucet.todo.module.component

import com.hucet.todo.NewsFragment
import com.hucet.todo.module.NetworkModule
import com.hucet.todo.module.NewsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NewsModule::class, NetworkModule::class))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}