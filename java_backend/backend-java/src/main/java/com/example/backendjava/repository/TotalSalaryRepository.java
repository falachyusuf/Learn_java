package com.example.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendjava.models.TotalSalary;

@Repository
public interface TotalSalaryRepository extends JpaRepository<TotalSalary, Integer>{

}
