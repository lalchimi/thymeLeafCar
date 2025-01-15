package com.example.thymeleafCar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.thymeleafCar.model.Client;



@Service
public class ClientService {
    private static final List<Client> clientList = new ArrayList<>();

    static {
        clientList.add(new Client(1L, "Lalchi", "Mist", "mail@mail.fr", "25ED", LocalDate.of(1994, 01, 19), "male", false));
    }
    
    public List<Client> findAll() {
        return clientList;
    }

    public Client findById(Long id) {
        return clientList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Client client) {
        Client existingClient = findById(client.getId());
        if (existingClient != null) {
            existingClient.setPrenom(client.getPrenom());
            existingClient.setNom(client.getNom());
            existingClient.setMail(client.getMail());
            existingClient.setLicense(client.getLicense());
            existingClient.setGender(client.getGender());
            existingClient.setBlocked(client.getBlocked());
            existingClient.setBirthDate(client.getBirthDate());
            
        } else {
            clientList.add(client);
        }
    }

    public void deleteById(Long id) {
        clientList.removeIf(p -> p.getId().equals(id));
    }
}
