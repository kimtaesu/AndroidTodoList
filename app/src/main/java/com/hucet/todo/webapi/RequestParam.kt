package com.hucet.todo.webapi

interface RequestBody

data class TodoCreateRequestParam(val title: String, val description: String) : RequestBody

data class RequestOptions(val body: RequestBody? = null, val headers: MutableMap<String, String>? = null)