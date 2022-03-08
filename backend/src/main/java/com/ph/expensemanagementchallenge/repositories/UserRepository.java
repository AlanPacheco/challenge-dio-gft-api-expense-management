package com.ph.expensemanagementchallenge.repositories;

import com.ph.expensemanagementchallenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
