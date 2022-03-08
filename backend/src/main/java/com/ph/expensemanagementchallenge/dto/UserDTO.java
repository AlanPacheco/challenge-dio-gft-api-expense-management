package com.ph.expensemanagementchallenge.dto;

import com.ph.expensemanagementchallenge.entities.Expense;
import com.ph.expensemanagementchallenge.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private List<ExpenseDTO> expensesDTO = new ArrayList<>();

    public UserDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDTO(User user, List<Expense> expense){
        this(user.getId(), user.getFirstName(), user.getLastName());
        expense.forEach(e -> {
            expensesDTO.add(new ExpenseDTO(e));
        });

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ExpenseDTO> getExpensesDTO() {
        return expensesDTO;
    }
}
