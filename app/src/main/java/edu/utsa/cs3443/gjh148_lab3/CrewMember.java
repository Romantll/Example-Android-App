package edu.utsa.cs3443.gjh148_lab3;

public class CrewMember {
	private String name, position, rank, species, assignment;
	
	CrewMember(String name, String position, String rank, String species, String assignment){
		this.name = name;
		this.position = position;
		this.rank = rank;
		this.species = species;
		this.assignment = assignment;
	}
	
	CrewMember(String name, String rank, String species){
		this.name = name;
		this.rank = rank;
		this.species = species;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	
	public String getAssignment() {
		return assignment;
	}
	
	
	@Override
	public String toString() {
	    return " - " + name + " (" + rank + ") - " + position + " [" + species + "]";
	}

}
