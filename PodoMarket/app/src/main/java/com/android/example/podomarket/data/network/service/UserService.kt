package com.android.example.podomarket.data.network.service

import com.android.example.podomarket.data.network.dto.UserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface UserService {
    @POST("api/v1/user")
    fun postUser(
        @Field("access_token") access_token: String,
        @Field("social") social: String
    ): Single<Response<UserDto>>

    @PUT("api/v1/user/me")
    fun putUserMe(
        @Field("full_name") full_name: String?,
        @Field("nickname") nickname: String?
    ): Single<Response<UserDto>>

    @GET("api/v1/user/{user_id}")
    fun getUserById(
        @Path("user_id") user_id: Int
    ): Single<Response<UserDto>>

    @DELETE("api/v1/user/me")
    fun deleteUserMe(): Single<Response<Void>>

}