package com.example.android4thassignment.API;

import com.example.android4thassignment.model.ImageResponse;
import com.example.android4thassignment.model.ItemModel;
import com.example.android4thassignment.model.LoginSignupResponse;
import com.example.android4thassignment.model.UserModel;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserAPI {

    @FormUrlEncoded
    @POST("users/register")
    Call<LoginSignupResponse> RegisterUser(@Field("userFname")String userFname, @Field("userLname")String userlname
            , @Field("userName")String userName, @Field("password")String password);

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginSignupResponse> CheckUser(@Field("userName")String userName,@Field("password")String password);

    @Multipart
    @POST("image")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part myImage);

    @GET("items")
    Call<List<ItemModel>> getAllItems();

    @FormUrlEncoded
    @POST("items")
    Call<Void> addHero(@Field("itemName") String name,@Field("itemPrice") String price,@Field("itemImageName") String  filename,@Field("itemDescription") String des) ;

}

