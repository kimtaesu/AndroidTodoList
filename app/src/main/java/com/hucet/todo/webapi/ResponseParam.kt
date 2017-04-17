package com.hucet.todo.webapi

data class NewsParent(
        val after: String,
        val before: String,
        val children: Array<NewsChildren>
) {
    data class NewsChildren(
            val data: NewsItem
    ) {
        data class NewsItem(
                val thumbnail: String,
                val author: String
        )
    }
}

data class NewsResponse(val data: NewsParent) {}

