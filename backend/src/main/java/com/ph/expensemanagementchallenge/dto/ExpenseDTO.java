package com.ph.expensemanagementchallenge.dto;

import com.ph.expensemanagementchallenge.entities.Category;
import com.ph.expensemanagementchallenge.entities.Expense;
import com.ph.expensemanagementchallenge.entities.Payment;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Double amount;
    private String description;

    private Instant moment;

    private Long userId;

    private CategoryDTO categoryDTO;

    private List<PaymentDTO> paymentsDTO = new ArrayList<>();

    public ExpenseDTO(){
    }

    public ExpenseDTO(Long id, Double amount, String description, Instant moment) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.moment = moment;
    }

    public ExpenseDTO(Expense expense){
        this(expense.getId(),expense.getAmount(), expense.getDescription(), expense.getMoment());

        this.categoryDTO = new CategoryDTO(expense.getCategory());

        this.userId = expense.getUser().getId();

        expense.getPayments().forEach(e->
                paymentsDTO.add(new PaymentDTO(e)));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<PaymentDTO> getPaymentsDTO() {
        return paymentsDTO;
    }
}
