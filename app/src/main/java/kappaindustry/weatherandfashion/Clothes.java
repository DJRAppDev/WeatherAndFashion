package kappaindustry.weatherandfashion;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

public class Clothes extends AppCompatActivity {
    private ImageView hat;
    private ImageView outerwear;
    private ImageView pants;
    private String age, gender, style, temp, range;
    private AppDatabase db;
    private Clothing clothing;

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

        range = toRangeTemp(temp);
        Log.d("TEMPRANGE",range);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "clothing.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        clothing = db.clothingDao().getClothing(range,gender,style);

        setImage(clothing.getHat(),clothing.getOuterwear(),clothing.getPants());
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

    private String toRangeTemp(String tempString){
        double tempDouble = java.lang.Double.parseDouble(tempString);
        String range = "";
        if(tempDouble > -1000.0 && tempDouble <= 40.0){
            range = "-1000 - 40";
        }
        else if(tempDouble > 40.0 && tempDouble <= 60.0){
            range = "40 - 60";
        }
        else if(tempDouble > 60.0 && tempDouble <= 1000.0){
            range = "60 - 1000";
        }
        return range;
    }
}
