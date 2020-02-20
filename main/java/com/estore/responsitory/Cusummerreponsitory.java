package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.Customer;



@Repository
public interface Cusummerreponsitory extends CrudRepository<Customer, String>{

}
