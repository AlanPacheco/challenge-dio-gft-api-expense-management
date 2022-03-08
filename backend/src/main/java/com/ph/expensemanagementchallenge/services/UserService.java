package com.ph.expensemanagementchallenge.services;

import com.ph.expensemanagementchallenge.dto.UserDTO;
import com.ph.expensemanagementchallenge.entities.Expense;
import com.ph.expensemanagementchallenge.entities.Payment;
import com.ph.expensemanagementchallenge.entities.User;
import com.ph.expensemanagementchallenge.repositories.ExpenseRepository;
import com.ph.expensemanagementchallenge.repositories.PaymentRepository;
import com.ph.expensemanagementchallenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable){
        Page<User> userPage = userRepository.findAll(pageable);
        Page<UserDTO> userDTOPage = userPage.map(user ->
                new UserDTO(user, user.getExpenses()));
        return userDTOPage;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(
                () -> new IllegalArgumentException("Entity not found: " + id));
        return new UserDTO(user, user.getExpenses());
    }
}
