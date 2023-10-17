package com.example.travelsupport.module.screen.homescreen.placesearch


import android.location.Location
import retrofit2.http.GET
import retrofit2.http.Query


public interface TripadvisorApiService {
    @GET("api/v1/location/search")
    suspend fun searchLocations(
        @Query("key") apiKey: String,
        @Query("searchQuery") searchQuery: String,
//        @Query("category") category: String?,
//        @Query("phone") phone: String?,
        @Query("address") address: String?,
//        @Query("latLong") latLong: String?,
//        @Query("radius") radius: Number?,
//        @Query("radiusUnit") radiusUnit: String?,
        @Query("language") ngonngu: String
    ): ApiResponse
}
public data class ApiResponse(val data: List<diadiem>)
public data class diadiem(val location_id: String, val name: String?, val address_obj: Address?)

public data class Address(val street1: String?, val street2: String?, val address_string: String?, val city: String?, val state: String?, val country: String?, val postalcode: String?)



