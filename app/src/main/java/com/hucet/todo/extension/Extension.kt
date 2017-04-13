package com.hucet.todo.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

fun main() {
    val test = Test()
    test.subject = "제목 초기화"
    println("subject ${test.subject}")
}

class Test {
    lateinit var subject: String
}
fun <T> Observable<Response<T>>.onDefaultThread() {
    this
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
}

fun <T> T.basicToString() : String {  // extension function
    return ""
}

