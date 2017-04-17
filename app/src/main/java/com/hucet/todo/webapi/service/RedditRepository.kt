package com.hucet.web.service

import com.hucet.todo.webapi.NewsResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


interface RedditRepository {
    @POST("top.json")
    fun getRedditNews(@Query("before") before: String? = "",
                      @Query("after") after: String? = "",
                      @Query("limite") limite: Long? = 10
    ): Observable<Response<NewsResponse>>
}