package com.codefider.design.patterns.strategyPaymentapp.repository;

import com.codefider.design.patterns.strategyPaymentapp.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
