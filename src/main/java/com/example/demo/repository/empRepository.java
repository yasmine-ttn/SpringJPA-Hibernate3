package com.example.demo.repository;

import com.example.demo.entities.Emp;
import org.springframework.data.repository.CrudRepository;

public interface empRepository extends CrudRepository<Emp,Integer> {

}
