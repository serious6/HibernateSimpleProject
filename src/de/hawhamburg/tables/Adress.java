package de.hawhamburg.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

/**
 * The Class Adress.
 */
@Entity(name = "ADRESS")
@Table(appliesTo = "ADRESS")
public class Adress implements Serializable {
	private static final long serialVersionUID = -5389264390467984765L;

	@Id
	@GeneratedValue
	@GenericGenerator(name = "idGen", strategy = "increment")
	private Long id;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String number;

	@Column(nullable = false)
	private String postalCode;

	@Column(nullable = false)
	private String city;

	public Adress() {
		super();
	}

	public Adress(String street, String number, String postalCode, String city) {
		super();
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
