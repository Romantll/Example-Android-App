package edu.utsa.cs3443.gjh148_lab3.model;

import androidx.annotation.NonNull;

public class CrewMember {

	private String fullName;
	private String position;
	private String rank;
	private String species;
	private String registry;  // Ship assignment

	public CrewMember(String fullName, String position, String rank, String species, String registry) {
		this.fullName = fullName;
		this.position = position;
		this.rank = rank;
		this.species = species;
		this.registry = registry;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPosition() {
		return position;
	}

	public String getRank() {
		return rank;
	}

	public String getSpecies() {
		return species;
	}

	public String getRegistry() {
		return registry;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	@NonNull
	@Override
	public String toString() {
		return rank + " " + fullName + " - " + position + " (" + species + ")";
	}
}
