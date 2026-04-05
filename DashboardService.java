package com.example.finance_dashboard.service;

import com.example.finance_dashboard.model.*;
import com.example.finance_dashboard.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private FinancialRepository repo;

    public double totalIncome() {
        return repo.findByType(Type.INCOME)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double totalExpense() {
        return repo.findByType(Type.EXPENSE)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double balance() {
        return totalIncome() - totalExpense();
    }

    public Map<String, Double> categoryTotals() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(
                        FinancialRecord::getCategory,
                        Collectors.summingDouble(FinancialRecord::getAmount)
                ));
    }
}