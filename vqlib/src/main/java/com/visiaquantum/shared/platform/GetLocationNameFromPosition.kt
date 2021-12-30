package com.visiaquantum.shared.platform

import android.content.Context
import android.location.Geocoder
import android.location.Location
import arrow.core.Either
import com.visiaquantum.UseCase
import com.visiaquantum.shared.exception.Failure
import java.io.IOException
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GetLocationNameFromPosition @Inject constructor() :
    UseCase<GetLocationNameFromPosition.Response, GetLocationNameFromPosition.Params>() {
    class Params(val context: Context, val location: Location?)
    open class Response(val cityName: String)
    class ResponseError(val failure: Failure.FeatureFailure) : Response("")

    override suspend fun run(params: Params): Either<Failure, Response> {

        if (null == params.location || params.location.latitude == 0.0 || params.location.longitude == 0.0) {
            return Either.Right(Response(""))
        }

        val location = suspendCoroutine<Response> { continuation ->
            try {
                val addressList = Geocoder(params.context, Locale.getDefault())
                    .getFromLocation(params.location.latitude, params.location.longitude, 1)
                if (addressList.size > 0) {
                    val locality = addressList[0].locality
                    locality?.let {
                        continuation.resume(Response(locality))
                    }
                }
            } catch (e: IOException) {
                continuation.resume(ResponseError(failure = Failure.FeatureFailure.CouldNotRetrieveLocationInfo))
            }
        }

        if (location is ResponseError) {
            return Either.Left(location.failure)
        }

        return Either.Right(location)
    }
}
