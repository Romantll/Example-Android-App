package edu.utsa.cs3443.gjh148_lab3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.example_android_app.R;

import java.io.IOException;

import edu.utsa.cs3443.gjh148_lab3.model.CrewMember;
import edu.utsa.cs3443.gjh148_lab3.model.Fleet;
import edu.utsa.cs3443.gjh148_lab3.model.Starship;

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        TextView starshipInfoText = findViewById(R.id.starshipInfo);

        // Get registry from Intent
        String registry = getIntent().getStringExtra("registry");

        try {
            // Load data
            Fleet fleet = new Fleet();
            fleet.loadFromAssets(this); // This will load both fleet.csv and personnel.csv

            // Get the starship
            Starship starship = fleet.getStarshipByRegistry(registry);

            if (starship != null) {
                // Build display text
                StringBuilder sb = new StringBuilder();
                sb.append("Starship: ").append(starship.getName()).append("\n");
                sb.append("Registry: ").append(starship.getRegistry()).append("\n");
                sb.append("Class: ").append(starship.getShipClass()).append("\n\n");

                sb.append("Crew Members:\n\n");
                for (CrewMember cm : starship.getCrew()) {
                    sb.append(cm.toString()).append("\n");
                }

                starshipInfoText.setText(sb.toString());
            } else {
                starshipInfoText.setText(R.string.starship_not_found);
            }

        } catch (IOException e) {
            starshipInfoText.setText(R.string.error_loading);
            e.printStackTrace();
        }
    }
}
