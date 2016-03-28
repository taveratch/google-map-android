package com.example.taweesoft.maptest2;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by TAWEESOFT on 2/18/16 AD.
 */
public class APIServiceFactory {
    private static APIService service = null;

    public static APIService getInstance(){
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://taweesoft.xyz:7070/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(APIService.class);

        }
        return service;
    }
}
