package com.example.retrofit_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView textView;
ProgressBar progressBar;
Button button,button2;
RetrofitService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        button=findViewById(R.id.getBtn);
        button2=findViewById(R.id.postBtn);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(RetrofitService.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                service.getData().enqueue(new Callback<List<Source>>() {
                    @Override
                    public void onResponse(Call<List<Source>> call, Response<List<Source>> response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        List<Source> sources=response.body();
                        for(Source source:sources)
                        {
                            textView.append(source.getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Source>> call, Throwable t) {

                    }
                });
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                PostsModel postsModel=new PostsModel("John","Data Analyst",2);
                service.sendData(postsModel).enqueue(new Callback<PostsModel>() {
                    @Override
                    public void onResponse(Call<PostsModel> call, Response<PostsModel> response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        textView.setText(response.body().getTitle());
                    }

                    @Override
                    public void onFailure(Call<PostsModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failed to send data!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}