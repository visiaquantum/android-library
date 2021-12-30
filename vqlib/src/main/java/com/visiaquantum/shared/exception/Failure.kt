package com.visiaquantum.shared.exception

sealed class Failure {

    object NetworkConnection : Failure()
    object ServerError : Failure()
    object InternalServerError : Failure()
    object GeneralError : Failure()
    object SessionExpired : Failure()
    object Unauthorized : Failure()

    sealed class FeatureFailure : Failure() {

        object InvalidEmail : FeatureFailure()
        object LoginError : FeatureFailure()
        object EmailIsRequired : FeatureFailure()
        object InvalidPasswordLength : FeatureFailure()
        object PasswordIsRequired : FeatureFailure()

        object InvalidCredentials : FeatureFailure()
        object Ambiguos : FeatureFailure()
        object FailedDependency : FeatureFailure()
        object NotModified : FeatureFailure()

        object GPSIsDisabled : Failure.FeatureFailure()
        object CouldNotRetrieveLocationInfo : Failure.FeatureFailure()

        object ImageToHeavy : FeatureFailure()

        object SerialNotExist : FeatureFailure()
        object DeviceAlreadyInstalled : FeatureFailure()
        object WrongSecretKey : FeatureFailure()

    }
}