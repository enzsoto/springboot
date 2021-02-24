package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone {
	
	@Id
	@SequenceGenerator(name = "phone_sequence", sequenceName = "phone_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_sequence")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NUMBER")
	private Integer number;

	@Column(name = "COUNTRYCODE")
	private Integer countryCode;

	public Phone() {
		super();
	}

	public Phone(Long id, Integer number, Integer countryCode) {
		super();
		this.id = id;
		this.number = number;
		this.countryCode = countryCode;
	}

	public Phone(Integer number, Integer countryCode) {
		super();
		this.number = number;
		this.countryCode = countryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", countryCode=" + countryCode + "]";
	}
		
}
