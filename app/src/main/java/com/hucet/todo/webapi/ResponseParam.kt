package com.hucet.todo.webapi

interface AResponse

data class TodoCreateResponse(val title: String) : AResponse