package com.ph.expensemanagementchallenge.services;

import com.ph.expensemanagementchallenge.dto.ExpenseDTO;
import com.ph.expensemanagementchallenge.entities.Category;
import com.ph.expensemanagementchallenge.entities.Expense;
import com.ph.expensemanagementchallenge.entities.Payment;
import com.ph.expensemanagementchallenge.entities.User;
import com.ph.expensemanagementchallenge.repositories.ExpenseRepository;
import com.ph.expensemanagementchallenge.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public Page<ExpenseDTO> findAll(Pageable pageable){
        Page<Expense> page = expenseRepository.findAll(pageable);
        return page.map(expense -> new ExpenseDTO(expense));
    }

    @Transactional(readOnly = true)
    public ExpenseDTO findById(Long id){
        Optional<Expense> optional = expenseRepository.findById(id);
        Expense expense = optional.orElseThrow(() -> new IllegalArgumentException("Id not found: " + id));
        return new ExpenseDTO(expense);
    }

    @Transactional
    public ExpenseDTO insert(@RequestBody ExpenseDTO expenseDTO){
        Expense expense = new Expense();
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setMoment(expenseDTO.getMoment());
        expense.setUser(new User(expenseDTO.getUserId(), null, null));
        List<Payment> payments = expense.getPayments();

        expenseDTO.getPaymentsDTO().forEach((dto) -> {
            Payment payment = new Payment(dto.getId(), dto.getPaymentType(), dto.getAmount());
            payments.add(payment);
        });
        expense.setCategory(new Category(expenseDTO.getCategoryDTO().getId(),
                expenseDTO.getCategoryDTO().getName()));
        expense = expenseRepository.save(expense);
        Long expenseId = expense.getId();
        payments.forEach(e-> {
            e.setExpense(new Expense(expenseId, null, null, null));
            paymentRepository.save(e);
        });
        return new ExpenseDTO(expense);
    }

}
