package ma.enset.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ma.enset.tp3.models.Article;
import ma.enset.tp3.models.NewsListAdapter;
import ma.enset.tp3.models.NewsListResponse;
import ma.enset.tp3.service.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText keywordsInput;
    private Button searchBtn;
    private ListView listViewNews;
    private List<Article> data;
    private Retrofit retrofit;
    private NewsListAdapter adapter;
    private RestApi serviceAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        keywordsInput = findViewById( R.id.textInputEditText);
        searchBtn = findViewById( R.id.button2);
        listViewNews = findViewById( R.id.listviewnews);

        data = new ArrayList<>();
        adapter = new NewsListAdapter( this,R.layout.news_view, data);
        listViewNews.setAdapter(adapter);

        retrofit=new Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        serviceAPI = retrofit.create( RestApi.class);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchListener();
            }
        });
        searchListener();
    }



    private void searchListener(){

        String keywords = keywordsInput.getText().toString();
        if( keywords.trim().length()==0 ) {
            Toast.makeText(getApplicationContext(), " You have to enter some searching keywords !! ",Toast.LENGTH_LONG).show();
            return;
        }
        Call<NewsListResponse> newsListResponseCall;
        newsListResponseCall = serviceAPI.listUsersByKey(keywords,"2022-06-06","e1a5037e88754d08ab963f06addd2c83");
        newsListResponseCall.enqueue(new Callback<NewsListResponse>() {
            @Override
            public void onResponse(Call<NewsListResponse> call, Response<NewsListResponse> response) {
                NewsListResponse articlesList=response.body();

                if( articlesList==null ){
                    Toast.makeText( getApplicationContext(), " Nothing found ! ", Toast.LENGTH_LONG).show();
                    return;
                }
                for ( Article article: articlesList.getArticles()) {
                    data.add(article);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<NewsListResponse> call, Throwable t) {
                Toast.makeText( getApplicationContext(), " Network error ! ", Toast.LENGTH_LONG).show();

            }
        });
    }

}