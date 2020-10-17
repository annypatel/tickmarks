package tickmarks.base.domain.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import tickmarks.base.domain.UseCase

/** A Use Case that returns a result as Flowable. */
interface FlowableUseCase<I, R> : UseCase<I, Flowable<R>>

/** A Use Case that returns a result as Observable. */
interface ObservableUseCase<I, R> : UseCase<I, Observable<R>>

/** A Use Case that returns a result as Single. */
interface SingleUseCase<I, R> : UseCase<I, Single<R>>

/** A Use Case that returns a result as Maybe. */
interface MaybeUseCase<I, R> : UseCase<I, Maybe<R>>

/** A Use Case that returns a result as Completable. */
interface CompletableUseCase<I> : UseCase<I, Completable>
