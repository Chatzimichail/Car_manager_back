package com.luv2code.springboot.cruddemo.entity;

import org.springframework.data.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pinakida")
	private String pinakida;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="plaisio")
	private String plasio;

	@Column(name="kibika")
	private String kibika;

	@Column(name="aloga")
	private String aloga;

	@Column(name="kodikosKinitira")
	private String kodikosKinitira;

	@Column(name="xronologia")
	private String xronologia;

	@Column(name="marka")
	private String marka;

	@Column(name="modelo")
	private String modelo;


	// define constructors
	
	public Car() {
		
	}

	public Car(String pinakida, String name, String lastName, String plasio, String kibika, String aloga, String kodikosKinitira, String xronologia, String marka, String modelo) {
		this.pinakida = pinakida;
		this.name = name;
		this.lastName = lastName;
		this.plasio = plasio;
		this.kibika = kibika;
		this.aloga = aloga;
		this.kodikosKinitira = kodikosKinitira;
		this.xronologia = xronologia;
		this.marka = marka;
		this.modelo = modelo;
	}

	// define getter/setter

	public String getPinakida() {
		return pinakida;
	}

	public void setPinakida(String pinakida) {
		this.pinakida = pinakida;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlaisio() {
		return plasio;
	}

	public void setPlaisio(String plasio) {
		this.plasio = plasio;
	}

	public String getKibika() {
		return kibika;
	}

	public void setKibika(String kibika) {
		this.kibika = kibika;
	}

	public String getAloga() {
		return aloga;
	}

	public void setAloga(String aloga) {
		this.aloga = aloga;
	}

	public String getKodikosKinitira() {
		return kodikosKinitira;
	}

	public void setKodikosKinitira(String kodikosKinitira) {
		this.kodikosKinitira = kodikosKinitira;
	}

	public String getXronologia() {
		return xronologia;
	}

	public void setXronologia(String xronologia) {
		this.xronologia = xronologia;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	// define tostring

	@Override
	public String toString() {
		return ", lastName=" + lastName  ;
	}
		
}











