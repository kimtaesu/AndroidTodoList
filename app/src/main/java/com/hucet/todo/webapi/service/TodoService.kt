package com.hucet.web.service

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


data class TodoItem(val title: String, val desc: String)

interface TodoService {
    @POST("create")
    fun createTodo(@Body item: TodoItem): Observable<Response<Long>>
}