package com.hg.kotlin.api.download

import io.reactivex.Observable
import io.reactivex.disposables.Disposable

abstract class BaseDownloadObserver<T>: Observable<T>() {

    abstract  fun onSubscribe(d: Disposable)

    fun onNext(t: T) {
        onDownloadSuccess(t)
    }

     fun onError(e: Throwable) {
        onDownloadError(e)
    }

     fun onComplete() {

    }

    protected abstract fun onDownloadSuccess(t: T)

    protected abstract fun onDownloadError(e: Throwable)
}