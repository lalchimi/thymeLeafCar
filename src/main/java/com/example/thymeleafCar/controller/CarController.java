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

import com.example.thymeleafCar.model.Car;
import com.example.thymeleafCar.service.CarService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;
	
    @GetMapping("/list")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car/list"; 
    }
    
    @GetMapping("/add")
    public String addCarForm(Model model) {
    	model.addAttribute("isEditMode", false);
        model.addAttribute("car", new Car()); 
        return "car/form";
    }

    @GetMapping("/edit/{immatriculation}")
    public String editCarForm(@PathVariable("immatriculation") String immatriculation, Model model) {
        Car existingCar = carService.findByImmatriculation(immatriculation);
        if (existingCar == null) {
            // Au choix : redirection vers la liste ou affichage d'une erreur
            return "redirect:/car/list";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("car", existingCar);
        return "car/form";
    }

    @PostMapping("/save")
    public String saveCar(@Valid @ModelAttribute("car") Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", carService.findByImmatriculation(car.getImmatriculation()) != null);
            return "car/form";
        }
        carService.save(car);
        return "redirect:/car/list";
    }

    @GetMapping("/delete/{immatriculation}")
    public String deleteCar(@PathVariable("immatriculation") String immatriculation) {
        carService.deleteById(immatriculation);
        return "redirect:/car/list";
    }
    
}
