package com.android.example.podomarket.data.network.service

import com.android.example.podomarket.data.network.dto.*
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ProductService {

    @GET("api/v1/user/product/")
    fun getMyProductList(
        @Query("page") page: Int
    ): Single<Response<PaginationResponse>>

    @GET("api/v1/product/")
    fun getProductList(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("order") order: String?,
        @Query("max_price") max_price: Int?,
        @Query("city") city: Int?,
        @Query("category") category: Int?
    ): Single<Response<PaginationResponse>>

    @Multipart
    @POST("api/v1/product/")
    fun postProduct(
        @Part("name") name: String,
        @Part("category") category: String,
        @Part("price") price: Int,
        @Part("allow_suggest") allow_suggest: Boolean,
        @Part("city") city: Int,
        @Part("seller") seller: Int,
        @Part("img-file") image: MultipartBody.Part
    ): Single<Response<ProductDto>>

    @GET("api/v1/product/{product_id}/")
    fun getProductById(
        @Path("product_id") product_id: Int
    ) : Single<Response<ProductDto>>

    @DELETE("api/v1/product/{product_id}/")
    fun deleteMyProduct(
        @Path("product_id") product_id: Int
    ): Single<Response<ProductDto>>

    @FormUrlEncoded
    @PUT("api/v1/user/likeproduct/")
    fun putLikeProduct(
        @Field("product") product_id: Int
    ): Single<Response<LikeProductDto>>

    @GET("api/v1/user/likeproduct/")
    fun getMyLikeProductList(): Single<Response<List<LikeProductDto>>>

    @FormUrlEncoded
    @POST("api/v1/product/{product_id}/suggestprice/")
    fun postSuggestPrice(
        @Path("product_id") product_id: Int,
        @Field("suggest_price") suggest_price: Int,
        @Field("will_buyer") will_buyer: Int
    ): Single<Response<SuggestPriceDto>>

    @PUT("api/v1/product/{product_id}/suggestprice/")
    fun putSuggestPrice(
        @Path("product_id") product_id: Int
    ): Single<Response<SuggestPriceDto>>

    @DELETE("api/v1/product/{product_id}/suggestprice/")
    fun deleteSuggestPrice(
        @Path("product_id") product_id: Int
    ): Single<Response<SuggestPriceDto>>

    @FormUrlEncoded
    @POST("api/v1/chatroom")
    fun postChatRoom(
        @Field("product") product_id: Int,
        @Field("will_buyer") will_buyer: Int
    ): Single<Response<ChatRoomDto>>

    @GET("api/v1/chatroom")
    fun getChatRoomList(): Single<Response<List<ChatRoomDto>>>

    @GET("api/v1/chatroom/{chatroom_id}")
    fun getChatRoomById(
        @Path("chatroom_id") chatroom_id: Int
    ): Single<Response<ChatRoomDto>>

    @DELETE("api/v1/chatroom/{chatroom_id}")
    fun deleteChatRoom(
        @Path("chatroom_id") chatroom_id: Int
    ): Single<Response<ChatRoomDto>>

    @POST("api/v1/chatroom/{chatroom_id}/transaction")
    fun postTransaction(
        @Path("chatroom_id") chatroom_id: Int
    ): Single<Response<TransactionDto>>

    @FormUrlEncoded
    @PUT("api/v1/chatroom/{chatroom_id}/transaction")
    fun putTransaction(
        @Path("chatroom_id") chatroom_id: Int,
        @Field("review") review: Int
    ): Single<Response<TransactionDto>>

}