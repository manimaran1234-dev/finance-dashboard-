package com.example.finance_dashboard.repository;

import com.example.finance_dashboard.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FinancialRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(Type type);

    List<FinancialRecord> findByCategory(String category);
}