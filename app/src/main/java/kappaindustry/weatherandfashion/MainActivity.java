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
    private TextView temp, loc;
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

        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            @Override
            public void processFinish(String output1, String output2, String output3) {
                loc.setText(output1);
                temp.setText(output2);
            }
        });
        asyncTask.execute("40.8448", "-73.8648"); //  asyncTask.execute("Latitude", "Longitude")

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Clothes.class);
                startActivity(intent);
            }
        });
    }
}