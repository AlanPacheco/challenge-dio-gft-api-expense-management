package com.ph.expensemanagementchallenge.dto;

import com.ph.expensemanagementchallenge.entities.Expense;

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

    private UserDTO userDTO;

    private List<PaymentDTO> paymentsDTO = new ArrayList<>();

    private CategoryDTO categoryDTO;

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
        this.userDTO = new UserDTO(expense.getUser());
        this.categoryDTO = new CategoryDTO(expense.getCategory());
        this.paymentsDTO = expense.getPayments().stream().map(e -> new PaymentDTO(e)).collect(Collectors.toList());
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
