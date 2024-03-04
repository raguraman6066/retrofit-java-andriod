package com.example.retrofit_java;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {
    @GET("posts")
    Call<List<Source>> getData();

    @POST("posts")
    Call<PostsModel> sendData(@Body PostsModel postsModel);
}
