package com.ph.expensemanagementchallenge.dto;

import com.ph.expensemanagementchallenge.entities.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private List<ExpenseDTO> expensesDTO = new ArrayList<>();

    public CategoryDTO(){
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category category){
        this(category.getId(), category.getName());
       // this.expensesDTO = category.getExpenses().stream().map(e -> new ExpenseDTO(e)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
