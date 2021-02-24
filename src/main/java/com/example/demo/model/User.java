package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CORRID")
	private UUID corrId;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CREATED")
	private LocalDate created;
	
	@Column(name = "MODIFIED")
	private LocalDate modified;
	
	@Column(name = "LASTMODIFIED")
	private LocalDate lastModified;
	
	@Column(name = "ISACTIVE")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "USER", cascade = CascadeType.ALL)
	private List<Phone> phones;

	public User() {
		super();
	}

	public User(Long id, UUID corrId, String email, String password, LocalDate created, LocalDate modified,
			LocalDate lastModified, Boolean isActive, List<Phone> phones) {
		super();
		this.id = id;
		this.corrId = corrId;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.lastModified = lastModified;
		this.isActive = isActive;
		this.phones = phones;
	}

	public User(String email, String password, LocalDate created, LocalDate modified, LocalDate lastModified,
			Boolean isActive, List<Phone> phones) {
		super();
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.lastModified = lastModified;
		this.isActive = isActive;
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getCorrId() {
		return corrId;
	}

	public void setCorrId(UUID corrId) {
		this.corrId = corrId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", corrId=" + corrId + ", email=" + email + ", password=" + password + ", created="
				+ created + ", modified=" + modified + ", lastModified=" + lastModified + ", isActive=" + isActive
				+ ", phones=" + phones + "]";
	}

}
