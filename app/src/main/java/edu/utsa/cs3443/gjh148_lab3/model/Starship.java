package edu.utsa.cs3443.gjh148_lab3.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Starship {
	private String name;
	private String registry;
	private String shipClass;
	private final ArrayList<CrewMember> crewMembers;

	public Starship(String name, String registry, String shipClass) {
		this.name = name;
		this.registry = registry;
		this.shipClass = shipClass;
		this.crewMembers = new ArrayList<>();
	}

	public void addCrewMember(CrewMember cm) {
		crewMembers.add(cm);
	}

	public String getName() {
		return name;
	}

	public String getRegistry() {
		return registry;
	}

	public String getShipClass() {
		return shipClass;
	}

	public ArrayList<CrewMember> getCrew() {
		return new ArrayList<>(crewMembers);
	}

	public int getNumberOfPersonnel() {
		return crewMembers.size();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}

	@NonNull
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" (").append(registry).append(")").append("\n");
		sb.append("Class: ").append(shipClass).append("\n");
		sb.append("Crew Members (").append(crewMembers.size()).append("):\n");
		for (CrewMember cm : crewMembers) {
			sb.append(cm.toString()).append("\n");
		}
		return sb.toString();
	}
}
