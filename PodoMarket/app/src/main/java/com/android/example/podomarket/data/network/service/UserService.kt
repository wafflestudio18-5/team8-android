package com.android.example.podomarket.data.network.service

import com.android.example.podomarket.data.network.dto.CityDto
import com.android.example.podomarket.data.network.dto.PutCityResponse
import com.android.example.podomarket.data.network.dto.DistanceRange
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.data.network.dto.UserDto
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @FormUrlEncoded
    @POST("api/v1/user/")
    fun postUser(
        @Field("access_token") access_token: String,
        @Field("social") social: String
    ): Single<Response<UserDto>>

    @Multipart
    @PUT("api/v1/user/me/")
    fun putUserMe(
        @Part("full_name") full_name: String?,
        @Part("nickname") nickname: String?,
        @Part image: MultipartBody.Part
    ): Single<Response<UserDto>>

    @GET("api/v1/user/me/")
    fun getUserMe(): Single<Response<UserDto>>

    @DELETE("api/v1/user/me/")
    fun deleteUserMe(): Single<Response<Void>>

    @GET("api/v1/user/{user_id}/")
    fun getUserById(
        @Path("user_id") user_id: Int
    ): Single<Response<UserDto>>

    @POST("api/v1/user/logout")
    fun logout(): Single<Response<Void>>

    @PUT("api/v1/user/city")
    fun putCity(
        @Field("city_id_1") city_id_1: Int,
        @Field("city_id_2") city_id_2: Int
    ) : Single<Response<PutCityResponse>>

    @GET("api/v1/user/city")
    fun getCityList(): Single<Response<List<CityDto>>>

    @GET("api/v1/user/product")
    fun getMyProductList(
        
    ): Single<Response<List<ProductDto>>>

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
    ): Single<Response<ProductDto>>

    @DELETE("api/v1/user/me/{product_id}")
    fun deleteMyProduct(
        @Path("product_id") product_id: Int
    ): Single<Response<Void>>

}