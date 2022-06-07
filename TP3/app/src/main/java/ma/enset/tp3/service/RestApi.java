package ma.enset.tp3.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ma.enset.tp3.models.NewsListResponse;


public interface RestApi {

    @GET("everything")
    Call<NewsListResponse> listUsersByKey(@Query("q") String q, @Query("from") String from, @Query("apiKey") String apiKey);
}