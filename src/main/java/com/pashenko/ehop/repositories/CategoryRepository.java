package com.pashenko.ehop.repositories;

import com.pashenko.ehop.entities.productdata.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @EntityGraph(attributePaths = {"children"})
    Optional<List<Category>> getAllByParentIsNull();
}
