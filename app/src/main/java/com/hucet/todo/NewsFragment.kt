package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hucet.todo.service.NewsManager
import kotlinx.android.synthetic.main.fragment_content.*
import javax.inject.Inject

class NewsFragment : Fragment() {
    @Inject lateinit var newsManager: NewsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.newsComponent.inject(this)
        var i = 10
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            //Layout Setting
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout

            //Adapter Setting
//            if (news_list.adapter == null)
//                news_list.adapter = NewsAdapter<NewsItem>(dataset)
            requestNews()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun requestNews() {
        newsManager.getNews()
                .subscribe({
                    Log.i("!!!!!!!!!!", "sss")
                }, {
                    Log.i("!!!!!!!!!!", "aaa")
                })
    }
}

