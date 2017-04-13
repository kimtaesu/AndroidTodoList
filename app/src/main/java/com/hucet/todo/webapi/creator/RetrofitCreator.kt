package com.hucet.web.creator

import com.hucet.todo.BuildConfig
import com.hucet.todo.extension.onDefaultThread
import com.hucet.web.service.TodoItem
import com.hucet.web.service.TodoService
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCreator {
    val server_url = "http://${BuildConfig.host}:${BuildConfig.port}"

    enum class API {
        CREATE_TODO
    }

    fun getTodoApi(api: API): () -> Int = when (api) {
        API.CREATE_TODO -> {
            val todoService = createRetrofit().create(TodoService::class.java)
            todoService.createTodo(null).onDefaultThread()
        }
        else -> throw IllegalArgumentException("Invalid color param value")

    }


    fun <T>createTodo(todoItem: TodoItem?): () -> Observable<Response<T>> {

    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(server_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}
