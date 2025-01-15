package com.example.thymeleafCar.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class Contract {
	
	@NotNull(message="Id obligatoire")
	private Long id;
	@NotNull(message="Voiture obligatoire")
	private String immatriculation;
	@NotNull(message="Client obligatoire")
	private Long clientId;
	@NotNull(message="Date obligatoire")
	private LocalDate startingDate;
	@NotNull(message="Date obligatoire")
	private LocalDate endingDate;
	@NotNull(message="Prix obligatoire")
	private Double totalPrice;
	@NotNull(message="Progres obligatoire")
	private Boolean progress;
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(@NotNull(message = "Id obligatoire") Long id,
			@NotNull(message = "Voiture obligatoire") String immatriculation,
			@NotNull(message = "Client obligatoire") Long clientId,
			@NotNull(message = "Date obligatoire") LocalDate startingDate,
			@NotNull(message = "Date obligatoire") LocalDate endingDate,
			@NotNull(message = "Prix obligatoire") Double totalPrice,
			@NotNull(message = "Progres obligatoire") Boolean progress) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.clientId = clientId;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.totalPrice = totalPrice;
		this.progress = progress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getProgress() {
		return progress;
	}

	public void setProgress(Boolean progress) {
		this.progress = progress;
	}


}
