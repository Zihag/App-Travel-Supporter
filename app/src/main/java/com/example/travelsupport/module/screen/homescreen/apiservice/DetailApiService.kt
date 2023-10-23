package com.example.travelsupport.module.screen.homescreen.apiservice

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TripAdvisorApi {
    @GET("api/v1/location/{locationId}/details")
    suspend fun getLocationDetails(
        @Path("locationId") locationId: Int,
        @Query("key") apiKey: String
    ): TripAdvisorLocationDetailResponse
}

data class TripAdvisorLocationDetailResponse(
    val location_id: Int,
    val name: String,
    val description: String?,
    val address_obj: Address1?,
    val latitude: Double?,
    val longitude: Double?,
    val email: String?,
    val phone: String?,
    val website: String?,
    val hours: weekday_text1?,
    // Các thông tin khác cần thiết
)

data class weekday_text1(
    val weekday: String?
)

data class Address1(
    val street1: String?,
    val street2: String?,
    val city: String?,
    val state: String?,
    val country: String?,
    val postalcode: String?,
    val address_string: String?
)
