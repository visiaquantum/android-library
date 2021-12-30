package com.visiaquantum.shared.validator

import arrow.core.Either
import com.visiaquantum.UseCase
import com.visiaquantum.shared.exception.Failure
import java.util.regex.Pattern
import javax.inject.Inject

class ValidateEmail @Inject constructor() : UseCase<Unit, ValidateEmail.Params>() {

    class Params(val email: String? = null)

    override suspend fun run(params: Params): Either<Failure, Unit> {
        val email = params.email ?: return Either.Left(Failure.FeatureFailure.InvalidEmail)

        if (email.isEmpty()) {
            return Either.Left(Failure.FeatureFailure.EmailIsRequired)
        }

        val emailFormatIsValid = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        ).matcher(email).matches()
        if (emailFormatIsValid) {
            return Either.Right(Unit)
        }

        return Either.Left(Failure.FeatureFailure.InvalidEmail)
    }
}
