package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Physician;

@Repository
public interface PhyRepo extends CrudRepository<Physician, Long>{

}
