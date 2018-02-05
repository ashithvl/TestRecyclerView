package com.freshlancers.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<StarWars> listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView=findViewById(R.id.recyclerview);
        listing=new ArrayList<>();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://swapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APiService service=retrofit.create(APiService.class);
        Call<Result> call=service.getdetails();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                List<StarWars> arrayList = response.body().getResults();
//                Log.e("a",arrayList.get(0).getName());
                Log.e("ag","asdf"+response.body());

                RecyclerStringAdapter adapter = new RecyclerStringAdapter(arrayList);
                RecyclerView.LayoutManager recyc = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(recyc);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e("err","error"+t.getMessage());

            }
        });


    }

}
