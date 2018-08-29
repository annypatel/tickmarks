package tickmarks.domain

/** A Use Case that takes an argument and returns a result. */
interface UseCase<in I, out R> {

    /** Executes this use case with given input. */
    fun execute(input: I): R
}

/** Invoke extension method on [UseCase] when there is no input parameter. */
fun <R> UseCase<Unit, R>.execute() = execute(Unit)