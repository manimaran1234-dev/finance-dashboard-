package com.example.finance_dashboard.service;

import com.example.finance_dashboard.model.*;
import com.example.finance_dashboard.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialRepository repo;

    public FinancialRecord create(FinancialRecord record) {

        if (record.getAmount() <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        if (record.getDate() == null) {
            record.setDate(java.time.LocalDate.now());
        }

        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public FinancialRecord getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public FinancialRecord save(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<FinancialRecord> getByType(String type) {
        return repo.findByType(Type.valueOf(type));
    }
}