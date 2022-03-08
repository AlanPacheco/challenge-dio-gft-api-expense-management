package com.ph.expensemanagementchallenge.repositories;

import com.ph.expensemanagementchallenge.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
