package com.hucet.web.service

import com.hucet.todo.webapi.AResponse
import com.hucet.todo.webapi.RequestBody
import com.hucet.todo.webapi.RequestOptions
import com.hucet.todo.webapi.TodoCreateRequestParam
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface TodoService {
    @POST("create")
    fun createTodo(@Body item: TodoCreateRequestParam): Observable<Response<Long>>
}