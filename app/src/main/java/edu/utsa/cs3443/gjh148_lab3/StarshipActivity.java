package edu.utsa.cs3443.gjh148_lab3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example_android_app.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;


import java.io.IOException;

import edu.utsa.cs3443.gjh148_lab3.model.CrewMember;
import edu.utsa.cs3443.gjh148_lab3.model.Fleet;
import edu.utsa.cs3443.gjh148_lab3.model.Starship;

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get registry from Intent
        String registry = getIntent().getStringExtra("registry");

        try {
            // Load data
            Fleet fleet = new Fleet();
            fleet.loadFromAssets(this); // This will load both fleet.csv and personnel.csv

            // Get the starship
            Starship starship = fleet.getStarshipByRegistry(registry);

            if (starship != null) {
                CrewAdapter adapter = new CrewAdapter(this, starship.getCrew());
                recyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(this, "Starship not found", Toast.LENGTH_SHORT).show();
            }


        } catch (IOException e) {
            Toast.makeText(this, R.string.error_loading, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
