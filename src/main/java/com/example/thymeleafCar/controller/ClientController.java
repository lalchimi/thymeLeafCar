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

import com.example.thymeleafCar.model.Client;
import com.example.thymeleafCar.service.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
    @GetMapping("/list")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "client/list"; 
    }
    
    @GetMapping("/add")
    public String addClientForm(Model model) {
    	model.addAttribute("isEditMode", false);
        model.addAttribute("client", new Client()); 
        return "client/form";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable("id") Long id, Model model) {
        Client existingClient = clientService.findById(id);
        if (existingClient == null) {
            // Au choix : redirection vers la liste ou affichage d'une erreur
            return "redirect:/client/list";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("client", existingClient);
        return "client/form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", clientService.findById(client.getId()) != null);
            return "client/form";
        }
        clientService.save(client);
        return "redirect:/client/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteById(id);
        return "redirect:/client/list";
    }
    
}
