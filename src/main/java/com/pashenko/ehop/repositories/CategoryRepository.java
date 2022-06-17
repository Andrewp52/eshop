package com.pashenko.ehop.repositories;

import com.pashenko.ehop.entities.productdata.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
