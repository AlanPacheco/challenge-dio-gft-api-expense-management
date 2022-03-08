package com.ph.expensemanagementchallenge.repositories;

import com.ph.expensemanagementchallenge.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
