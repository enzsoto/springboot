package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID")
	private User user;
		
}
