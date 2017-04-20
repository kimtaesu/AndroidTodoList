package com.hucet.todo.module

import com.hucet.todo.service.NewsRepository
import com.hucet.todo.service.NewsAPI
import com.hucet.todo.service.NewsApiImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {


    @Provides
    @Singleton
    fun provideNewsAPI(newsApi: NewsRepository): NewsAPI {
        return NewsApiImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsApiImpl(retrofit: Retrofit): NewsRepository {
        return retrofit.create(NewsRepository::class.java)
    }

    /**
     * NewsManager is automatically provided by Dagger as we set the @Inject annotation in the
     * constructor, so we can avoid adding a 'provider method' here.
     */
}