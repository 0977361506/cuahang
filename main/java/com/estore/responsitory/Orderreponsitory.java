package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.Order;



@Repository
public interface Orderreponsitory extends CrudRepository<Order, Integer>{

}
