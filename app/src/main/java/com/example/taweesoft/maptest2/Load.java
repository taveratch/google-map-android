package com.example.taweesoft.maptest2;

import android.os.AsyncTask;

import com.example.taweesoft.maptest2.Database;
import com.example.taweesoft.maptest2.MyPlace;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

/**
 * Created by TAWEESOFT on 2/23/16 AD.
 */
public class Load extends Observable{

    public void loadLocation(){
        AsyncTask<Void,Void,List<MyPlace>> task = new AsyncTask<Void, Void, List<MyPlace>>() {
            @Override
            protected List<MyPlace> doInBackground(Void... params) {
                Database database = new Database();
                try {
                    return database.loadLocation();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<MyPlace> myPlaces) {
                setChanged();
                notifyObservers(myPlaces);
            }
        };
        task.execute();
    }
}
