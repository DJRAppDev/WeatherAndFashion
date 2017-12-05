package kappaindustry.weatherandfashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Info extends AppCompatActivity {

    private EditText age;
    private Spinner genderSpinner, styleSpinner;
    private Button submit;
    private String temp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        temp = getIntent().getStringExtra("Temp");

        setSpinner();
        btEventListener();
    }

    private void setSpinner(){
        genderSpinner = findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        styleSpinner = findViewById(R.id.spinnerStyle);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.fashionstyle, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        styleSpinner.setAdapter(adapter2);
    }

    private void btEventListener(){
        genderSpinner = findViewById(R.id.spinnerGender);
        styleSpinner = findViewById(R.id.spinnerStyle);
        age = findViewById(R.id.ageEdit);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info.this, Clothes.class);
                intent.putExtra("Age", age.getText().toString());
                intent.putExtra("Gender", genderSpinner.getSelectedItem().toString());
                intent.putExtra("Style", styleSpinner.getSelectedItem().toString());
                intent.putExtra("Temp",temp+"");
                startActivity(intent);
            }
        });

    }
}
