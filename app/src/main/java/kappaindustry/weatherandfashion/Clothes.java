package kappaindustry.weatherandfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Clothes extends AppCompatActivity {
    private ImageView hat;
    private ImageView outerwear;
    private ImageView pants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes);
        hat = findViewById(R.id.hat);
        outerwear = findViewById(R.id.outerwear);
        pants = findViewById(R.id.pants);
        setClothing();
    }

    public void setClothing() {
        hat.setImageResource(R.drawable.winterCoat);
        outerwear.setImageResource(R.drawable.winterCoat);
        pants.setImageResource(R.drawable.winterCoat);
    }
}
