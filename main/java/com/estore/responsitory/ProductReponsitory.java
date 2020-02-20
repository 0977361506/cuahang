package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.Product;


@Repository
public interface ProductReponsitory extends CrudRepository<Product, Integer> {

}
