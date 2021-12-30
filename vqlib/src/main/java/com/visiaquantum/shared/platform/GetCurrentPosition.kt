package com.visiaquantum.shared.platform

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import arrow.core.Either
import com.visiaquantum.UIUseCase
import com.visiaquantum.shared.exception.Failure
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GetCurrentPosition @Inject constructor() :
    UIUseCase<GetCurrentPosition.Response, GetCurrentPosition.Params>() {
    class Params(val context: Context)
    open class Response(val latitude: Double, val longitude: Double)
    class ResponseError(val failure: Failure.FeatureFailure) : Response(0.0, 0.0)

    @SuppressLint("MissingPermission")
    override suspend fun run(params: Params): Either<Failure, Response> {

        val mLocationManager =
            params.context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // no need to even try if provider is disabled
        if (!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return Either.Left(Failure.FeatureFailure.GPSIsDisabled)
        }

        val location = suspendCoroutine<Response> { continuation ->

            mLocationManager.requestSingleUpdate(
                LocationManager.GPS_PROVIDER,
                object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        location.let {
                            continuation.resume(Response(it.latitude, it.longitude))
                        }
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                    }

                    override fun onProviderEnabled(provider: String) {
                    }

                    override fun onProviderDisabled(provider: String) {
                        continuation.resume(ResponseError(failure = Failure.FeatureFailure.GPSIsDisabled))
                    }
                },
                null
            )
        }

        if (location is ResponseError) {
            return Either.Left(location.failure)
        }

        return Either.Right(location)
    }
}
