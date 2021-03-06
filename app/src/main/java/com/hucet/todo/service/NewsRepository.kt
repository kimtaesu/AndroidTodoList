package com.hucet.todo.service

import com.droidcba.kedditbysteps.api.RedditNewsResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface NewsRepository {
    @POST("top.json")
    fun getRedditNews(@Query("before") before: String,
                      @Query("after") after: String,
                      @Query("limite") limite: String
    ): Observable<Response<RedditNewsResponse>>
}