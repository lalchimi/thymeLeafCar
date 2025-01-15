package com.example.thymeleafCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleafCar.model.Contract;
import com.example.thymeleafCar.service.CarService;
import com.example.thymeleafCar.service.ClientService;
import com.example.thymeleafCar.service.ContractService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	CarService carService;
	
    @GetMapping("/list")
    public String listContracts(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "contract/list"; 
    }
    
    @GetMapping("/add")
    public String addContractForm(Model model) {
    	model.addAttribute("isEditMode", false);
        model.addAttribute("contract", new Contract());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "contract/form";
    }

    @GetMapping("/edit/{id}")
    public String editContractForm(@PathVariable("id") Long id, Model model) {
        Contract existingContract = contractService.findById(id);
        if (existingContract == null) {
            // Au choix : redirection vers la liste ou affichage d'une erreur
            return "redirect:/contract/list";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("contract", existingContract);
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "contract/form";
    }

    @PostMapping("/save")
    public String saveContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", contractService.findById(contract.getId()) != null);
            model.addAttribute("cars", carService.findAll());
            model.addAttribute("clients", clientService.findAll());
            return "contract/form";
        }
        contractService.save(contract);
        return "redirect:/contract/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable("id") Long id) {
        contractService.deleteById(id);
        return "redirect:/contract/list";
    }
    
}
