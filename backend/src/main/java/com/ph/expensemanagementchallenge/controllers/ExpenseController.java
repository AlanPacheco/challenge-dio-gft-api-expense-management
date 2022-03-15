package com.ph.expensemanagementchallenge.controllers;

import com.ph.expensemanagementchallenge.dto.ExpenseDTO;
import com.ph.expensemanagementchallenge.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<Page<ExpenseDTO>> findAll(Pageable pageable){
        Page<ExpenseDTO> page = expenseService.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExpenseDTO> findById(@PathVariable Long id){
        ExpenseDTO expenseDTO = expenseService.findById(id);
        return ResponseEntity.ok().body(expenseDTO);
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> insert(@RequestBody ExpenseDTO expenseDTO){
        expenseDTO = expenseService.insert(expenseDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(expenseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(expenseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
