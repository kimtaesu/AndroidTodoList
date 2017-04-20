package com.hucet.todo.service

import com.droidcba.kedditbysteps.api.RedditNewsResponse
import com.hucet.todo.service.NewsRepository
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

interface NewsAPI {
    fun getNews(before: String, after: String, limit: String): Observable<Response<RedditNewsResponse>>
}

class NewsApiImpl @Inject constructor(private val newsApi: NewsRepository) : NewsAPI {
    override fun getNews(before: String, after: String, limit: String): Observable<Response<RedditNewsResponse>> {
        return newsApi.getRedditNews(before, after, limit)
    }
}