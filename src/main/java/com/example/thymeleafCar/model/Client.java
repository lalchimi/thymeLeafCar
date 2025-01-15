package com.example.thymeleafCar.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Client {

	@NotNull(message="ID obligatoire")
	private Long id;
	@NotBlank(message="Nom obligatoire")
	private String nom;
	@NotBlank(message="Prenom obligatoire")
	private String prenom;
	@NotBlank(message="Email obligatoire")
	private String mail;
	@NotBlank(message="Permis obligatoire")
	private String license;
	@NotNull(message="Date de naissance obligatoire")
	private LocalDate birthDate;
	@NotBlank(message="Genre obligatoire")
	private String gender;
	@NotNull(message="Statut obligatoire")
	private Boolean blocked;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(@NotNull(message = "ID obligatoire") Long id, @NotBlank(message = "Nom obligatoire") String nom,
			@NotBlank(message = "Prenom obligatoire") String prenom,
			@NotBlank(message = "Email obligatoire") String mail,
			@NotBlank(message = "Permis obligatoire") String license,
			@NotNull(message = "Date de naissance obligatoire") LocalDate birthDate,
			@NotBlank(message = "Genre obligatoire") String gender,
			@NotNull(message = "Statut obligatoire") Boolean blocked) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.license = license;
		this.birthDate = birthDate;
		this.gender = gender;
		this.blocked = blocked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
}
