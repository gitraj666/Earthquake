package com.example.prithviraj.earthquake;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        /*
        final ArrayList<Earthquake> Earthquakes = new ArrayList<Earthquake>();
        Earthquake w = new Earthquake("7.2","San Francisco","Feb 2,2016");
        Earthquakes.add(w);
        Earthquake w1 = new Earthquake("6.1","London","July 20,2015");
        Earthquakes.add(w1);
        Earthquake w2 = new Earthquake("3.9","Tokyo","July 10,2014");
        Earthquakes.add(w2);
        Earthquake w3 = new Earthquake("5.4","Mexico","May 3,2014");
        Earthquakes.add(w3);
        Earthquake w4 = new Earthquake("8.4","Moscow","Feb 17,2016");
        Earthquakes.add(w4);
        Earthquake w5 = new Earthquake("1.2","Rio","Dec 19,2013");
        Earthquakes.add(w5);
        Earthquake w6 = new Earthquake("5.9","Paris","Mar 28,2016");
        Earthquakes.add(w6);
        */

        // Create a fake list of earthquakes.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();


        ListView earthquakelistview = (ListView)findViewById(R.id.activity_earthquake);

        EarthquakeAdapter itemsAdapter  = new EarthquakeAdapter(this, earthquakes);

        earthquakelistview.setAdapter(itemsAdapter);

    }

}
