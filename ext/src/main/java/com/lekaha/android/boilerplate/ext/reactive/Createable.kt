@file:Suppress("NOTHING_TO_INLINE")

package com.lekaha.android.boilerplate.ext.reactive

import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.internal.operators.completable.CompletableCreate
import io.reactivex.internal.operators.flowable.FlowableCreate
import io.reactivex.internal.operators.maybe.MaybeCreate
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.internal.operators.single.SingleCreate
import io.reactivex.subjects.PublishSubject

inline fun <T> observable(crossinline body: (ObservableEmitter<T>) -> Unit): Observable<T> =
    ObservableCreate { body(it) }

inline fun <T> flowable(
    strategy: BackpressureStrategy = BackpressureStrategy.BUFFER,
    crossinline body: (FlowableEmitter<T>) -> Unit
): Flowable<T> = FlowableCreate({ body(it) }, strategy)

inline fun <T> single(crossinline body: (SingleEmitter<T>) -> Unit): Single<T> = SingleCreate { body(it) }

inline fun <T> single(obj: T): Single<T> = single { it.onSuccess(obj) }

inline fun <T> maybe(crossinline body: (MaybeEmitter<T>) -> Unit): Maybe<T> = MaybeCreate { body(it) }

inline fun <T> maybeYes(obj: T): Maybe<T> = maybe { it.onSuccess(obj) }

inline fun <T> maybeNo(): Maybe<T> = maybe { it.onComplete() }

inline fun completable(crossinline body: (CompletableEmitter) -> Unit) = CompletableCreate { body(it) }

inline fun completable(): Completable = completable { it.onComplete() }

inline fun <T> publishSubject(crossinline body: (ObservableEmitter<T>) -> Unit) =
    PublishSubject.create<T> { body(it) }