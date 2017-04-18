package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content.*
import javax.inject.Inject

class NewsFragment : Fragment() {
//    @Inject lateinit var newsManager: NewsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        MyApplication.appComponent.inject(this)
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun requestNews() {
//        RetrofitCreator.getTodoApi(limite = 10)
////               200 >= response code < 400 성공 여부 검사
//                .map {
//                    it.isSuccessful ?: throw RuntimeException("Fail to get any news [code : ${it.code()}]")
//                    currentRes = it.body()
//                    it.body()
//                }
////               Aggregate Items
//                .map {
//                    dataset += it.data?.children?.toList()
//                }
//                .subscribe(
//                        {
//                            Timber.e("성공  ${it}")
//                        },
//                        {
//                            Timber.e("실패  ${it}")
//                        })
    }
}

