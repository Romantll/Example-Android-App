package edu.utsa.cs3443.gjh148_lab3;

import java.util.ArrayList;

public class Starship {
	String name, registry, starship;
	private ArrayList<CrewMember> crewMembers;
	
	Starship(String name, String registry, String starship){
		this.name = name;
		this.registry = registry;
		this.starship = starship;
		this.crewMembers = new ArrayList<>();
	}
	
	public void addCrewMember(CrewMember cm) {
	    crewMembers.add(cm);
	}

	
	public int getNumberOfPersonnel() {
		return crewMembers.size();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	
	public String getRegistry(){
		return registry;
	}
	
	public void setStarship(String starship) {
		this.starship = starship;
	}
	
	//Skipping the setter for the array list to not cause errors
	
	public ArrayList<CrewMember> getCrewMembers(){
		return new ArrayList<>(crewMembers);
	}
	

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append(name).append(", ").append(starship).append(". Registry: ").append(registry).append("\n");
	    sb.append(crewMembers.size()).append(" crew members assigned.\n");

	    for (CrewMember cm : crewMembers) {
	        sb.append(cm.toString()).append("\n");
	    }

	    return sb.toString();
	}

}
