package kappaindustry.weatherandfashion;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView pic;
    private TextView temp, loc, description, date;
    private Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        pic = findViewById(R.id.tempPic);
        temp = findViewById(R.id.temp);
        loc = findViewById(R.id.location);
        change = findViewById(R.id.change);
        description = findViewById(R.id.description);
        date = findViewById(R.id.date);

        Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
            @Override
            public void processFinish(String output1, String output2, String output3, String output4, String output5) {
                loc.setText(output1);
                description.setText(output2);
                iconChange(output2);
                double cel = java.lang.Double.parseDouble(output3);
                cel = Math.round(cel);
                temp.setText(celToFah(cel)+"\u00b0");
                date.setText("Last Updated " + output4);
            }
        });

        asyncTask.execute("40.8448", "-73.8648");

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Clothes.class);
                startActivity(intent);
            }
        });
    }

    private double celToFah(double temp){
        return temp * 1.8 + 32;
    }

    private void iconChange(String des){
        String weatherDes = des;
        Log.d("Work",weatherDes);
        if(weatherDes.indexOf("RAIN") != -1){
            Log.d("Weather","Rain");
            pic.setImageResource(R.drawable.raining);
        }
        else if (weatherDes.indexOf("SNOW") != -1){
            Log.d("Weather","Snow");
            pic.setImageResource(R.drawable.snowing);
        }
        else if(weatherDes.indexOf("CLEAR") != -1){
            Log.d("Weather","Sunny");
            pic.setImageResource(R.drawable.sunny);
        }
    }
}