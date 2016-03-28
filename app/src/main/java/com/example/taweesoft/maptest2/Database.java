package com.example.taweesoft.maptest2;

import java.io.IOException;
import java.util.List;

import retrofit.Call;

/**
 * Created by TAWEESOFT on 2/23/16 AD.
 */
public class Database {

    public List<MyPlace> loadLocation() throws IOException {
        APIService service = APIServiceFactory.getInstance();
        Call<List<MyPlace>> data = service.loadLocation();

        return data.execute().body();
    }
}
