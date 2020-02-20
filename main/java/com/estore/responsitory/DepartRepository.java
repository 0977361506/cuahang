package com.estore.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estore.models.Depart;

@Repository
public interface DepartRepository extends CrudRepository<Depart, Integer>{
  
}
