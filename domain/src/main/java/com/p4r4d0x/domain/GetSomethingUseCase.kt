package com.p4r4d0x.domain

import androidx.annotation.VisibleForTesting
import kotlinx.coroutines.*

abstract class BaseUseCaseResult<Result> {
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    abstract suspend fun run(): Result

    fun invoke(
        scope: CoroutineScope = GlobalScope,
        dispatcher: CoroutineDispatcher = Dispatchers.Default,
        resultCallback: (Result) -> Unit = {}
    ) {
        val job = scope.async(dispatcher) { run() }
        scope.launch(Dispatchers.Main) { resultCallback(job.await()) }
    }

}


class GetSomethingUseCase(private val repository: SomethingRepository):
    BaseUseCaseResult<Boolean>() {
    override suspend fun run(): Boolean {
        return repository.doSomething()
    }
}