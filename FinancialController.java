package com.example.finance_dashboard.controller;

import com.example.finance_dashboard.model.FinancialRecord;
import com.example.finance_dashboard.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@CrossOrigin
public class FinancialController {

    @Autowired
    private FinancialService service;


    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return service.create(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id,
                                  @RequestBody FinancialRecord record) {

        FinancialRecord existing = service.getById(id);

        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        existing.setType(record.getType());

        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filter")
    public List<FinancialRecord> filter(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type) {

        if (category != null) {
            return service.getByCategory(category);
        }

        if (type != null) {
            return service.getByType(type);
        }

        return service.getAll();
    }
}