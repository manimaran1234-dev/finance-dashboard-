package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    public Map<String, Double> summary() {

        Map<String, Double> map = new HashMap<>();
        map.put("income", service.totalIncome());
        map.put("expense", service.totalExpense());
        map.put("balance", service.balance());

        return map;
    }

    @GetMapping("/category")
    public Map<String, Double> category() {
        return service.categoryTotals();
    }
}