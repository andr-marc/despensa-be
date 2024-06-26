package com.andremarc.pantry.controller;

import com.andremarc.pantry.entity.Category;
import com.andremarc.pantry.model.ApiResponse;
import com.andremarc.pantry.model.PaginatedData;
import com.andremarc.pantry.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> save(@RequestBody Category category){
        ApiResponse<Category> response = service.save(category);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> save(@PathVariable UUID id){
        ApiResponse<Category> response = service.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PaginatedData<Category>>> getAll(@PageableDefault() Pageable pageable){

        ApiResponse<PaginatedData<Category>> response = service.getAll(pageable);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Category>> update(@RequestBody Category category){
        ApiResponse<Category> response = service.update(category);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable UUID id){
        ApiResponse<?> response = service.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
