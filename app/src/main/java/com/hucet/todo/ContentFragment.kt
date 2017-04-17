package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hucet.todo.view.NewsAdapter
import com.hucet.todo.webapi.NewsItem
import com.hucet.todo.webapi.NewsParent
import com.hucet.todo.webapi.NewsResponse
import com.hucet.web.creator.RetrofitCreator
import kotlinx.android.synthetic.main.fragment_content.*
import timber.log.Timber

class ContentFragment : Fragment() {

    val dataset: List<NewsParent.NewsChildren.NewsItem> = ArrayList()
    lateinit var currentRes: NewsResponse
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
            if (news_list.adapter == null)
                news_list.adapter = NewsAdapter<NewsItem>(dataset)
        }
        requestNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun requestNews() {
        RetrofitCreator.getTodoApi(limite = 10)
//               200 >= response code < 400 성공 여부 검사
                .map {
                    it.isSuccessful ?: throw RuntimeException("Fail to get any news [code : ${it.code()}]")
                    currentRes = it.body()
                    it.body()
                }
//               Aggregate Items
                .map {
                }
                .subscribe(
                        {
                            Timber.e("성공  ${it}")
                        },
                        {
                            Timber.e("실패  ${it}")
                        })
    }
}

