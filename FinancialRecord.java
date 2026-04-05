package com.example.finance_dashboard.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class FinancialRecord {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String category;

    private LocalDate date;

    private String description;
}
