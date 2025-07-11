package edu.utsa.cs3443.gjh148_lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fleet {
    private String name;
    private ArrayList<Starship> starshipGroup;

    public Fleet(String name) {
        this.name = name;
        this.starshipGroup = new ArrayList<>();
    }

    public int getSizeOfFleet() {
        return starshipGroup.size();
    }

    public void addStarship(Starship ship) {
        starshipGroup.add(ship);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<Starship> getStarships() {
        return new ArrayList<>(starshipGroup);
    }

    public void loadStarships(String directoryName) throws FileNotFoundException {
        File folder = new File(directoryName);
        File[] files = folder.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".csv")) {
                Scanner scanner = new Scanner(file);

                if (!scanner.hasNextLine()) {
                    scanner.close();
                    continue;
                }

                String headerLine = scanner.nextLine();
                String[] headerParts = headerLine.split(",");

                if (headerParts.length < 3) {
                    scanner.close();
                    continue;
                }

                String name = headerParts[0].trim();
                String registry = headerParts[1].trim();
                String starshipClass = headerParts[2].trim();

                Starship ship = new Starship(name, registry, starshipClass);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();

                    if (line.isEmpty()) continue;

                    String[] parts = line.split(",");

                    if (parts.length < 4) {
                        continue;
                    }

                    String crewName = parts[0].trim();
                    String position = parts[1].trim();
                    String rank = parts[2].trim();
                    String species = parts[3].trim();

                    CrewMember cm = new CrewMember(crewName, position, rank, species, registry);
                    ship.addCrewMember(cm);
                }

                addStarship(ship);
                scanner.close();
            }
        }
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------\n\n");
        sb.append(name).append("\n\n");
        sb.append("----------------------------\n\n");
        for (Starship ship : starshipGroup) {
            sb.append(ship.toString()).append("\n");
        }
        return sb.toString();
    }
}
