package com.hucet.web.creator

import com.hucet.todo.BuildConfig
import com.hucet.todo.extension.onDefaultThread
import com.hucet.todo.webapi.NewsResponse
import com.hucet.web.service.RedditRepository
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCreator {
    val server_url = "${BuildConfig.url}"


    fun getTodoApi(before: String? = "", after: String? = "", limite: Long? = 10): Observable<Response<NewsResponse>> {
        val redditRepository = createRetrofit().create(RedditRepository::class.java);
        return redditRepository.getRedditNews(before, after, limite).onDefaultThread()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(server_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}
