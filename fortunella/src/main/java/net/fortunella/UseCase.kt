package net.fortunella

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<in P, out R>  {

    abstract suspend fun run(params: P): R

    operator fun invoke(params: P, onResult: (Result<R>) -> Unit = {}) {
        val job = GlobalScope.async { run(params) }
        GlobalScope.launch {
            try {
                onResult(Success(job.await()))
            } catch (e: Exception) {
                onResult(Failure(e))
            }
        }
    }
}