package com.visiaquantum

import arrow.core.Either
import com.visiaquantum.shared.exception.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class UIUseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        GlobalScope.launch(Dispatchers.Main) {
            val run = run(params)
            onResult(run)
        }
    }
}
