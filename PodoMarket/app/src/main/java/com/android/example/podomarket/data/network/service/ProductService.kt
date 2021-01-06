package com.android.example.podomarket.data.network.service

import com.android.example.podomarket.data.network.dto.DistanceRange
import com.android.example.podomarket.data.network.dto.Product
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface ProductService {

    @POST("api/v1/product")
    fun postProduct(
        @Field("name") name: String,
        @Field("category") category: Int,
        @Field("price") price: Int,
        @Field("allow_suggest") allow_suggest: Boolean,
        @Field("distance/range") distance_range: DistanceRange,
        @Field("city_id") city_id: Int,
        @Field("seller") seller: Int
    ): Single<Response<Product>>

    @GET("api/v1/product")
    fun getProductList(): Single<Response<List<Product>>>

    @GET("api/v1/product/{product_id}")
    fun getProduct(
        @Path("product_id") product_id: Int
    )

}