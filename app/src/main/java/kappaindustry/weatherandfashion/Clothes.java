package kappaindustry.weatherandfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Clothes extends AppCompatActivity {
    private ImageView hat;
    private ImageView outerwear;
    private ImageView pants;
    private String age, gender, style;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes);

        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");
        style = getIntent().getStringExtra("Style");

        hat = findViewById(R.id.hat);
        outerwear = findViewById(R.id.outerwear);
        pants = findViewById(R.id.pants);

        setClothing();
    }

    public void setClothing() {
        hat.setImageResource(R.drawable.winterhat1);
        outerwear.setImageResource(R.drawable.wintercoat1);
        pants.setImageResource(R.drawable.winterpants1);
    }
}
