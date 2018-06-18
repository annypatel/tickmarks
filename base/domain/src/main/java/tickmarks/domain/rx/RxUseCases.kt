package tickmarks.domain.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import tickmarks.domain.UseCase0
import tickmarks.domain.UseCase1

/** A Use Case that takes 0 arguments and return a result as Flowable. */
interface FlowableUseCase0<R> : UseCase0<Flowable<R>>

/** A Use Case that takes 1 arguments and return a result as Flowable. */
interface FlowableUseCase1<I, R> : UseCase1<I, Flowable<R>>

/** A Use Case that takes 0 arguments and return a result as Observable. */
interface ObservableUseCase0<R> : UseCase0<Observable<R>>

/** A Use Case that takes 1 arguments and return a result as Observable. */
interface ObservableUseCase1<I, R> : UseCase1<I, Observable<R>>

/** A Use Case that takes 0 arguments and return a result as Single. */
interface SingleUseCase0<R> : UseCase0<Single<R>>

/** A Use Case that takes 1 arguments and return a result as Single. */
interface SingleUseCase1<I, R> : UseCase1<I, Single<R>>

/** A Use Case that takes 0 arguments and return a result as Maybe. */
interface MaybeUseCase0<R> : UseCase0<Maybe<R>>

/** A Use Case that takes 1 arguments and return a result as Maybe. */
interface MaybeUseCase1<I, R> : UseCase1<I, Maybe<R>>

/** A Use Case that takes 0 arguments and return a result as Completable. */
interface CompletableUseCase0 : UseCase0<Completable>

/** A Use Case that takes 1 arguments and return a result as Completable. */
interface CompletableUseCase1<I> : UseCase1<I, Completable>