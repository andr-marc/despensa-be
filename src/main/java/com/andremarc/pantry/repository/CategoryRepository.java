package com.andremarc.pantry.repository;

import com.andremarc.pantry.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CategoryRepository  extends JpaRepository<Category, UUID>, JpaSpecificationExecutor<Category> {
}
