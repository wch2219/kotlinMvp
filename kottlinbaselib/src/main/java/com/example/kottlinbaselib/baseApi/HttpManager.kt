package com.example.kottlinbaselib.baseApi

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class HttpManager {
   private var mHttpManager: HttpManager? = null

    private var retrofit:Retrofit.Builder ?= null
    private var retrofits:Retrofit ?= null
    fun getInstance(): HttpManager? {

        if (mHttpManager == null) {

            synchronized(HttpManager::class.java) {
                mHttpManager = HttpManager()
            }

        }

        return mHttpManager
    }


    fun init(context: Context) {
        var filecache = File(context.getExternalCacheDir(), "OkHttpCache")
        var cache = Cache(filecache, 10 * 1024 * 1024)
        var httpClient = OkHttpClient.Builder()
            //.sslSocketFactory(HttpsUtils.getSSLCertifcation(context),HttpsUtils.UnSafeTrustManager)
//            .addInterceptor(OkHttpInterce.getLog())
//            .addInterceptor(OkHttpInterce.getRequestHeader())
//            .addInterceptor(OkHttpInterce.getErrorCode())
//            .cookieJar(CookieInter ())
            .addNetworkInterceptor(HttpLoggingInterceptor ().setLevel(HttpLoggingInterceptor.Level.BODY))
            .cache(cache)
            .build()

        retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl("")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
        retrofits = retrofit?.build()


    }


}