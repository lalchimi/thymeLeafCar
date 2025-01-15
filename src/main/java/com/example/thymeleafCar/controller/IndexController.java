package com.example.thymeleafCar.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.thymeleafCar.model.Contract;
import com.example.thymeleafCar.service.CarService;
import com.example.thymeleafCar.service.ClientService;
import com.example.thymeleafCar.service.ContractService;

@Controller
public class IndexController {
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	CarService carService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Jérôme Labro");
		model.addAttribute("totalContract", contractService.findAll().size());
		model.addAttribute("totalClient", clientService.findAll().size());
		model.addAttribute("totalCar", carService.findAll().size());
		model.addAttribute("contracts", contractService.findAll());
		model.addAttribute("expiredContracts", contractService.GetExpiringContract(contractService.findAll()));
		return "index"; 
	}
}
