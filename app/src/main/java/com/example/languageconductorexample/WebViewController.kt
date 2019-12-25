package com.example.languageconductorexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_web_view.view.*

class WebViewController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_web_view, container, false)

        view.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }

        view.webView.loadUrl("https://google.com")

        return view
    }
}