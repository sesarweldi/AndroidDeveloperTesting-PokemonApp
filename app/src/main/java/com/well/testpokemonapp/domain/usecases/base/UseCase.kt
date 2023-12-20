package com.well.testpokemonapp.domain.usecases.base

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out T : Any, Params>(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
    mainDispatcher: CoroutineDispatcher = Dispatchers.Main
) {

    private var parentJob = SupervisorJob()
    private val localScope = CoroutineScope(mainDispatcher + parentJob)

    abstract suspend fun executeOnBackground(param: Params): T

    private suspend fun executeCatchError(param: Params): Result<T> =
        withContext(defaultDispatcher) {
            try {
                Success(executeOnBackground(param))
            } catch (throwable: Throwable) {
                Fail(throwable)
            }
        }

    fun execute(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit, param: Params) {
        localScope.launchCatchError(block = {
            when (val result = executeCatchError(param)) {
                is Success -> onSuccess(result.data)
                is Fail -> onError(result.throwable)
            }
        }) {
            if (it !is CancellationException)
                onError(it)
        }
    }

    private fun CoroutineScope.launchCatchError(
        context: CoroutineContext = coroutineContext,
        block: suspend (() -> Unit),
        onError: suspend (Throwable) -> Unit
    ) =
        launch(context) {
            try {
                block()
            } catch (t: Throwable) {
                try {
                    onError(t)
                } catch (_: Throwable) {

                }
            }
        }
}