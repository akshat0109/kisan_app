package com.example.application.kisan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HP on 06-02-2018.
 */

public interface MachineyAPI {
    @GET("{endPoint}")
    public Call<Response> getData(@Path("endPoint") String endPoint);
}
