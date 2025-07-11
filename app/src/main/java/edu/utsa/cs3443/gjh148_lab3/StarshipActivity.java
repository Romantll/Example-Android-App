package edu.utsa.cs3443.gjh148_lab3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example_android_app.R;

public class StarshipActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        String registry = getIntent().getStringExtra("registry");

        TextView textView = findViewById(R.id.starshipInfo);
        textView.setText("Selected Starship Registry" + registry);
    }
}