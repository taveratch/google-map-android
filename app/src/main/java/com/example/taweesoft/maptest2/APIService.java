package com.example.taweesoft.maptest2;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by TAWEESOFT on 2/23/16 AD.
 */
public interface APIService {

    @GET("location")
    Call<List<MyPlace>> loadLocation();
}
