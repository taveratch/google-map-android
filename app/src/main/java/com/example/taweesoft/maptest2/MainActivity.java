package com.example.taweesoft.maptest2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    private MapFragment map;
    private EditText longitude_txt , latitude_txt;
    private Button mark_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = (MapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        longitude_txt = (EditText) findViewById(R.id.longitude_txt);
        latitude_txt = (EditText) findViewById(R.id.latitude_txt);
        mark_btn = (Button)findViewById(R.id.mark_btn);
        initialData();
        mark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double longitude = Double.parseDouble(longitude_txt.getText().toString());
                double latitude = Double.parseDouble(latitude_txt.getText().toString());
                LatLng latLng = new LatLng(latitude,longitude);
                map.onMapClick(latLng);
            }
        });
    }

    @Override
    public void update(Observable observable, Object data) {
        List<MyPlace> myPlaces = (List<MyPlace>)data;
        for(MyPlace place : myPlaces){
            LatLng latLng = new LatLng(place.getLatitude(),place.getLongitude());
            map.onMapClick(latLng,place.getName());
        }
    }

    public void initialData(){
        map.clearMap();
        Load load = new Load();
        load.addObserver(this);
        load.loadLocation();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_button_value,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_refresh){
            initialData();
        }
        return super.onOptionsItemSelected(item);
    }
}
