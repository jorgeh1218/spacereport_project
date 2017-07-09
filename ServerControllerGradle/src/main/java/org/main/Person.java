package org.main;

import javax.persistence.Entity;
import javax.persistence.Id;

// Clase Persona

@Entity
public class Person
{
	// Atributos de la clase
	@Id
	private String ci;		// Este atributo es la ID al ser almacenado el objeto 
	private String  sol;		// en la BD
	private String name;
	
	// Constructores
	
	public Person() {
	}

	public Person(String name, String ci, String sol) {
		this.name = name;
		this.ci = ci;
		this.sol = sol;
	}
	
	// Getters y Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSol() {
		return sol;
	}

	public void setSol(String sol) {
		this.sol = sol;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}
}
