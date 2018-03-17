package com.example.application.kisan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by HP on 09-03-2018.
 */

public class news extends AppCompatActivity {

    private Context context;
    private List<ArticleList> list;
    private RecyclerView recyclerView;
    private MainResponse newsResponse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        context = this;
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.my_recycler_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        NewsAPI api = retrofit.create(NewsAPI.class);
        String endPoint  = "top-headlines";
        Call<MainResponse> call = api.getResponse(endPoint,"us","business","2d6c402685614597a694651302b6073b");
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, retrofit2.Response<MainResponse> response) {
                if(response.body()!=null) {
                    Toast.makeText(getApplicationContext(),"AAgaya response",Toast.LENGTH_SHORT).show();
                    newsResponse = response.body();
                    list = newsResponse.getArticles();
                    setData();
                }
                else {
                    //bakcodi
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
    void setData() {

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(new NewsAdapter(list,context));

    }
}
