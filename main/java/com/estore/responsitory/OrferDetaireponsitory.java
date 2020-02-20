package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.OrderDetail;

@Repository
public interface OrferDetaireponsitory extends CrudRepository<OrderDetail, Integer>{

}
