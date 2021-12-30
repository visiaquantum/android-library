package com.visiaquantum.shared.validator

import arrow.core.Either
import com.visiaquantum.UseCase
import com.visiaquantum.shared.exception.Failure
import javax.inject.Inject

class ValidatePassword @Inject constructor() : UseCase<Unit, ValidatePassword.Params>() {

    class Params(val password: String? = null)

    override suspend fun run(params: Params): Either<Failure, Unit> {

        val password =
            params.password ?: return Either.Left(Failure.FeatureFailure.PasswordIsRequired)

        if (password.isEmpty()) {
            return Either.Left(Failure.FeatureFailure.PasswordIsRequired)
        }

        if (password.length < 3) {
            return Either.Left(Failure.FeatureFailure.InvalidPasswordLength)
        }

        return Either.Right(Unit)
    }
}
