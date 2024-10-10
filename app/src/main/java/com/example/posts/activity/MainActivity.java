package com.example.posts.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.posts.R;
import com.example.posts.model.Noticia;
import com.example.posts.my_interface.GetNoticiaDataService;

private ArrayAdapter arrayAdapter;
private ListView list;
private ArrayList<String> titles = new ArrayList<>();
private static final String url = "https://jsonplaceholder.typicode.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        list = findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        getPosts();
        });

    private void getPosts(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetNoticiaDataService postsService = retrofit.create(GetNoticiaDataService.class);
        Call<List<Noticia>> call=postsService.getPost();

        call.enqueue(new Callback<List<Noticia>>() {
                         @Override
                         public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response)
                for(
                         Noticia post : response.body())

                         {
                             titles.add(post.getTitle());
                         }
                    arrayAdapter.notifyDataSetChanged();
                     }
                     @Override
                        public void onFailure(Call<List<Noticia>> call, Throwable t) {}
        );
    }
}