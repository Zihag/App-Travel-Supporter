package com.example.travelsupport.module.screen.homescreen.apiservice


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


public interface TripadvisorApiService {
    @GET("api/v1/location/search")
    suspend fun searchLocations(
        @Query("key") apiKey: String,
        @Query("searchQuery") searchQuery: String,

        @Query("address") address: String?,
        @Query("language") ngonngu: String
    ): ApiResponse

    @GET("api/v1/location/{locationId}/details")
    suspend fun getLocationDetails(
        @Path("locationId") locationId: Int,
        @Query("key") apiKey: String
    ): LocationDetailResponse
}

public data class LocationDetailResponse(
    val info: Info
)
public data class Info(
    val location_id: String,
    val name: String,
    val description: String,
    val web_url: String,
    val address_obj: Address,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val website: String
)
public data class ApiResponse(val data: List<diadiem>)

public data class diadiem(val location_id: String,
                          val name: String?,
                          val address_obj: Address?)

public data class Address(
    val street1: String?,
    val street2: String?,
    val address_string: String?,
    val city: String?,
    val state: String?,
    val country: String?,
    val postalcode: String?
)


//        @Query("category") category: String?,
//        @Query("phone") phone: String?,
//        @Query("latLong") latLong: String?,
//        @Query("radius") radius: Number?,
//        @Query("radiusUnit") radiusUnit: String?,