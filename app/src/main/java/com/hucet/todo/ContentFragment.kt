package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hucet.web.creator.RetrofitCreator
import timber.log.Timber

class ContentFragment : Fragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requestNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun requestNews() {
        RetrofitCreator.getTodoApi(limite = 10)
                .map {
                    it.isSuccessful ?: throw RuntimeException("Fail to get any news [code : ${it.code()}]")
                    it
                }

                .subscribe({
                    Timber.e("성공  ${it}")
                }, {
                    Timber.e("실패  ${it}")
                })
    }
}