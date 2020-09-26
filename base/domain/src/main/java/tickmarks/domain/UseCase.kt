package tickmarks.domain

/** A Use Case that takes an argument and returns a result. */
interface UseCase<in I, out R> {

    /** Executes this use case with given input. */
    operator fun invoke(input: I): R
}

/** Invoke extension method on [UseCase] when there is no input parameter. */
operator fun <R> UseCase<Unit, R>.invoke() = invoke(Unit)
