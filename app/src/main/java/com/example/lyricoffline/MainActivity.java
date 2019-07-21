package com.example.lyricoffline;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;
    private RecyclerView recyclerView;
    private LyricAdapter adapter;
    private LyricList lyricList;

    FloatingActionButton btnCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animation Background
        relativeLayout = findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        //end of Animation Background

        //read data api findViewById(R.id.recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<LyricList> call = service.getLyrics();

        call.enqueue(new Callback<LyricList>() {
            @Override
            public void onResponse(Call<LyricList> call, Response<LyricList> response) {
                adapter = new LyricAdapter(response.body().getLyricsList(), getApplicationContext());
                recyclerView.setAdapter(adapter);
//                Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<LyricList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
            }
        });
        //end of read data api


        //Intent when click floating action button
        btnCreate = findViewById(R.id.fab);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateLyric.class);
                startActivity(intent);


            }
        });
        //end intent when click floating action button

    }

}
