package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.Category;



@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
