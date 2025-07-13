package edu.utsa.cs3443.gjh148_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example_android_app.R;

public class MainActivity extends AppCompatActivity{
    Button btnEnterprise, btnVoyager, btnDefiant;
    //naming button

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning button variable using ID defined in activity_main.xml
        btnEnterprise = findViewById(R.id.btnEnterprise);
        btnVoyager = findViewById(R.id.btnVoyager);
        btnDefiant = findViewById(R.id.btnDefiant);

        //Button listener
        //Defines what the button does
        btnEnterprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens starship screen
                openStarshipScreen("NCC-1701-A");
            }
        });

        btnVoyager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStarshipScreen("NCC-74656");
            }
        });

        btnDefiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStarshipScreen("NX-74205");
            }
        });
    }
    private void openStarshipScreen(String registry) {
        Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
        intent.putExtra("registry", registry);
        startActivity(intent);
    }
}