package com.curso.coches.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="COCHES")
@NamedQueries({
    @NamedQuery(name = "Coche.findAll", 
    		    query = "SELECT c FROM Coche c"),
    @NamedQuery(name = "Coche.findByMarca", 
    		query = "SELECT c FROM Coche c WHERE c.marca = :marca")
})
public class Coche implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Size(min=9,max=9)
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private double precio;
	private int anio;
	private int Stock;
	
	public Coche(String matricula, String marca, String modelo, String color, int anio, double precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anio = anio;
		this.precio = precio; 
		this.Stock = 1;
		}

	public Coche() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Coche :" + matricula + ", marca: " + marca + ", modelo: " + modelo + ", precio: " + precio;
	}
	
	
	
	
	
	

}
