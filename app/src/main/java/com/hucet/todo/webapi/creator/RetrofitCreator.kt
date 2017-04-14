package com.hucet.web.creator

import com.hucet.todo.BuildConfig
import com.hucet.todo.webapi.RequestOptions
import com.hucet.todo.webapi.TodoCreateRequestParam
import com.hucet.web.service.TodoService
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitCreator {
    val server_url = "http://${BuildConfig.host}:${BuildConfig.port}"

    enum class API {
        CREATE_TODO
    }


    fun getTodoApi1(api: API, requestOptions: RequestOptions? = null) = when (api) {
        API.CREATE_TODO -> {
            val todoService = createRetrofit().create(TodoService::class.java);
            requestOptions?.body ?: throw IllegalArgumentException("Invalid a request param")
            todoService.createTodo(requestOptions.body as TodoCreateRequestParam)
                    .subscribeOn(Schedulers.newThread())
        }
        else -> throw IllegalArgumentException("Invalid a todo api")
    }

//    fun <R : AResponse> getTodoApi(api: API, requestOptions: RequestOptions? = null): Observable<Response<R>> = when (api) {
//        API.CREATE_TODO -> {
//            val todoService = createRetrofit().create(TodoService::class.java);
//            requestOptions?.body ?: throw IllegalArgumentException("Invalid a request param")
//            todoService.createTodo(requestOptions.body)
//        }
//        else -> throw IllegalArgumentException("Invalid a todo api")
//    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(server_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}
