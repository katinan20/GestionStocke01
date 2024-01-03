package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoriesByCode(String code);
}
