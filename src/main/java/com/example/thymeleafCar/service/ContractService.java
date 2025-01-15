package com.example.thymeleafCar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.thymeleafCar.model.Contract;

@Service
public class ContractService {
    private static final List<Contract> contractList = new ArrayList<>();

    static {
        contractList.add(new Contract(1L, "12DF12", 1L, LocalDate.of(2022, 01, 01), LocalDate.of(2025, 03, 01), 120.00, true));
    }
    
    public List<Contract> findAll() {
        return contractList;
    }

    public Contract findById(Long id) {
        return contractList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Contract contract) {
        Contract existingContract = findById(contract.getId());
        if (existingContract != null) {
            existingContract.setImmatriculation(contract.getImmatriculation());
            existingContract.setClientId(contract.getClientId());
            existingContract.setStartingDate(contract.getStartingDate());
            existingContract.setEndingDate(contract.getEndingDate());
            existingContract.setTotalPrice(contract.getTotalPrice());
            existingContract.setProgress(contract.getProgress());
        } else {
            contractList.add(contract);
        }
    }

    public void deleteById(Long id) {
        contractList.removeIf(p -> p.getId().equals(id));
    }
    
	public List<Contract> GetExpiringContract(List<Contract> contracts) {
		
		List<Contract> returningList = new ArrayList<>();
		LocalDate today = LocalDate.now();
	
		if(!contracts.isEmpty()) {
			for (Contract contract : contracts) {
				LocalDate expiringDate = contract.getEndingDate().minusMonths(3L);
				if(expiringDate.isBefore(today)) {
					returningList.add(contract);
				}
			}
		}
		
		return returningList;
	}
}
