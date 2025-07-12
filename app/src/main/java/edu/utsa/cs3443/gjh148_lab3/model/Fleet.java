package edu.utsa.cs3443.gjh148_lab3.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Fleet {
    private final ArrayList<Starship> starshipGroup;

    public Fleet(){
        this.starshipGroup = new ArrayList<>();
    }

    public ArrayList<Starship> getStaships(){
        return starshipGroup;
    }

    public void addStarship(Starship ship){
        starshipGroup.add(ship);
    }

    public Starship getStarshipByRegistry(String registry){
        for (Starship ship: starshipGroup){
            if(ship.getRegistry().equals(registry)){
                return ship;
            }
        }
        return null;
    }

    public void loadFromAssets(Context context) throws IOException {
        // Load fleet.csv
        InputStream is = context.getAssets().open("fleet.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                String registry = parts[1].trim();
                String shipClass = parts[2].trim();
                Starship ship = new Starship(name, registry, shipClass);
                addStarship(ship);
            }
        }
        reader.close();

        // Load personnel.csv
        is = context.getAssets().open("personnel.csv");
        reader = new BufferedReader(new InputStreamReader(is));

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 5) {
                String fullName = parts[0].trim();
                String position = parts[1].trim();
                String rank = parts[2].trim();
                String registry = parts[3].trim();
                String species = parts[4].trim();

                CrewMember cm = new CrewMember(fullName, position, rank, species, registry);

                // Assign to correct ship
                for (Starship ship : starshipGroup) {
                    if (ship.getRegistry().equals(registry)) {
                        ship.addCrewMember(cm);
                        break;
                    }
                }
            }
        }
        reader.close();
    }
}
