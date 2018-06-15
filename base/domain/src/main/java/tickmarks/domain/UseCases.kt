package tickmarks.domain

/** A Use Case that takes 0 arguments and return a result. */
interface UseCase0<out R> {

    /** Executes this use case. */
    fun execute(): R
}

/** A Use Case that takes 1 arguments and returns a result. */
interface UseCase1<in I, out R> {

    /** Executes this use case with given input. */
    fun execute(input: I): R
}