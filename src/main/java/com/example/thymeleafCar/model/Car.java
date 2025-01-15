package com.example.thymeleafCar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Car {

	@NotBlank(message="Immatriculation obligatoire")
	private String immatriculation;
	@NotBlank(message="Modèle obligatoire")
	private String model;
	@NotBlank(message="Marque obligatoire")
	private String marque;
	@NotBlank(message="Catéforie obligatoire")
	private String category;
	@NotNull(message="Disponibilité obligatoire")
	private Boolean available;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(@NotBlank(message = "Immatriculation obligatoire") String immatriculation,
			@NotBlank(message = "Modèle obligatoire") String model,
			@NotBlank(message = "Marque obligatoire") String marque,
			@NotBlank(message = "Catéforie obligatoire") String category,
			@NotNull(message = "Disponibilité obligatoire") Boolean available) {
		super();
		this.immatriculation = immatriculation;
		this.model = model;
		this.marque = marque;
		this.category = category;
		this.available = available;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
