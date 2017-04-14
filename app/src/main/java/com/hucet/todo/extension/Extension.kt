package com.hucet.todo.extension

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


fun <T> Observable<Response<T>>.onDefaultThread() {
    this
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
}

