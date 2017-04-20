package com.hucet.todo.service

import android.util.Log
import com.droidcba.kedditbysteps.api.RedditNewsResponse
import com.hucet.todo.extension.onDefaultThread
import com.hucet.todo.model.RedditNews
import com.hucet.todo.model.RedditNewsItem
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    fun getNews(before: String? = "", after: String? = "", limit: String? = "10"): Observable<List<RedditNewsItem>> {
        return api.getNews(before!!, after!!, limit!!)
                .onDefaultThread()
//               assert response code successful
                .map {
                    res ->
                    if (!res.isSuccessful)
                        throw RuntimeException("뉴스 정보를 얻어오는데 실패하였습니다. [code : ${res.code()}, reason : ${res.message()}]")
                    res
                }
//                aggregate new items
                .map { res ->
                    res.body().data.children.map { item ->
                        RedditNewsItem(item.data)
                    }
                }
    }
}