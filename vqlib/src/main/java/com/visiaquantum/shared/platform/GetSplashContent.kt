package com.visiaquantum.shared.platform

import arrow.core.Either
import com.visiaquantum.UIUseCase
import com.visiaquantum.UseCase
import com.visiaquantum.shared.exception.Failure
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetSplashContent @Inject constructor() : UIUseCase<Unit, UseCase.None>() {

    override suspend fun run(params: UseCase.None): Either<Failure, Unit> {
        delay(3000L)
        return Either.Right(Unit)
    }
}
