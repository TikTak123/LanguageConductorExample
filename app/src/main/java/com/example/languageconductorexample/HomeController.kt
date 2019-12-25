package com.example.languageconductorexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.yariksoffice.lingver.Lingver
import kotlinx.android.synthetic.main.controller_home.view.*

class HomeController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_home, container, false)

        view.btnEnglish.setOnClickListener {
            Lingver.getInstance().setLocale(view.context, "en")
            activity?.recreate()
        }

        view.btnRussian.setOnClickListener {
            Lingver.getInstance().setLocale(view.context, "uk")
            activity?.recreate()
        }

        view.btnOpenWebView.setOnClickListener {
            router.pushController(RouterTransaction.with(WebViewController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }

        return view
    }
}