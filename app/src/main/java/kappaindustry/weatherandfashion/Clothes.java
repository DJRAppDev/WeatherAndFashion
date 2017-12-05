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
    private String age, gender, style, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes);

        age = getIntent().getStringExtra("Age");
        gender = getIntent().getStringExtra("Gender");
        style = getIntent().getStringExtra("Style");
        temp = getIntent().getStringExtra("Temp");

        hat = findViewById(R.id.hat);
        outerwear = findViewById(R.id.outerwear);
        pants = findViewById(R.id.pants);

        setImage("none","formaljacket","none");
    }

    private void setImage(String hatname, String out, String pantsname){
        if(hatname.equals("none") == false){
            int hatID = this.getResources().getIdentifier(hatname, "drawable", this.getPackageName());
            hat.setImageResource(hatID);
        }
        else {
            hat.setImageResource(R.drawable.white);
        }

        int outID = this.getResources().getIdentifier(out, "drawable", this.getPackageName());
        outerwear.setImageResource(outID);

        if(pantsname.equals("none") == false){
            int pantsID = this.getResources().getIdentifier(pantsname, "drawable", this.getPackageName());
            pants.setImageResource(pantsID);
        }
        else{
            pants.setImageResource(R.drawable.white);
        }
    }
}
