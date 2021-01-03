package com.android.example.podomarket.data.network.service

import com.android.example.podomarket.data.network.dto.CityDto
import com.android.example.podomarket.data.network.dto.PutCityResponse
import com.android.example.podomarket.data.network.dto.DistanceRange
import com.android.example.podomarket.data.network.dto.Product
import com.android.example.podomarket.data.network.dto.UserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @FormUrlEncoded
    @POST("api/v1/user/")
    fun postUser(
        @Field("access_token") access_token: String,
        @Field("social") social: String
    ): Single<Response<UserDto>>

    @PUT("api/v1/user/me/")
    fun putUserMe(
        @Field("full_name") full_name: String?,
        @Field("nickname") nickname: String?
    ): Single<Response<UserDto>>

    @GET("api/v1/user/me/")
    fun getUserMe(): Single<Response<UserDto>>

    @GET("api/v1/user/{user_id}/")
    fun getUserById(
        @Path("user_id") user_id: Int
    ): Single<Response<UserDto>>

    @DELETE("api/v1/user/me/")
    fun deleteUserMe(): Single<Response<Void>>

    @GET("api/v1/user/me/product")
    fun getMyProductList(): Single<Response<List<Product>>>

    @PUT("api/v1/user/me/{product_id}")
    fun putMyProduct(
        @Path("product_id") product_id: Int,
        @Field("name") name: String?,
        @Field("category") category: Int?,
        @Field("price") price: Int?,
        @Field("allow_suggest") allow_suggest: Boolean?,
        @Field("distance/range") distance_range: DistanceRange?,
        @Field("city_id") city_id: Int?,
    ): Single<Response<Void>>

    @GET("api/v1/user/me/{product_id}")
    fun getMyProduct(
        @Path("product_id") product_id: Int
    ): Single<Response<Product>>

    @DELETE("api/v1/user/me/{product_id}")
    fun deleteUserMe(
        @Path("product_id") product_id: Int
    ): Single<Response<Void>>

    @PUT("api/v1/user/city")
    fun putCity(
        @Field("city_id_1") city_id_1: Int,
        @Field("city_id_2") city_id_2: Int
    ) : Single<Response<PutCityResponse>>

    @GET("api/v1/user/city")
    fun getCityList(): Single<Response<List<CityDto>>>

}