package com.example.application.kisan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HP on 09-03-2018.
 */

public interface NewsAPI {
    @GET("/v2/{endPoint}")
    public Call<MainResponse> getResponse(@Path("endPoint") String endPoint, @Query("country") String country,@Query("category") String category, @Query("apiKey") String apiKey);
}
