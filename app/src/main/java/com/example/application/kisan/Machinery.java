package com.example.application.kisan;

import android.content.Context;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.HashMap;

import javax.crypto.Mac;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by HP on 06-02-2018.
 */

public class Machinery extends AppCompatActivity  {

    HashMap<String,String> machineData;
    private CarouselView carausal;
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machinery);

        context = this;

        machineData = new HashMap<>();
        carausal = findViewById(R.id.carouselView);
        getData();
        setCarausal();
    }

    void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        String endPoint = "/kisan/get_company_with_machinery?company_id=1";

        MachineyAPI api = retrofit.create(MachineyAPI.class);
        Call<Response> call = api.getData(endPoint);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.body()!=null) {
                    Toast.makeText(context, "Data Recieved", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(context, "Nope Some error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setCarausal() {
        carausal.setViewListener(new ViewListener() {
            @Override
            public View setViewForPosition(int position) {
                View view = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.simple,null);
                ImageView imageView = view.findViewById(R.id.simple_image);
                if(position == 0) {
                    imageView.setImageResource(R.drawable.vill2);
                }
                else if(position == 1) {
                    imageView.setImageResource(R.drawable.vill1);
                }
                return view;
            }
        });
        carausal.setPageCount(2);
    }
}

