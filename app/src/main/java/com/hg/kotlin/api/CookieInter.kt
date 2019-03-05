package com.hg.kotlin.api

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import java.util.*

class CookieInter:CookieJar {
    internal var cookieStore = HashMap<HttpUrl, List<Cookie>>()
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cookieStore[url] = cookies//保存cookie
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val cookies = cookieStore[url]//取出cookie
        return cookies ?: ArrayList()
    }
}