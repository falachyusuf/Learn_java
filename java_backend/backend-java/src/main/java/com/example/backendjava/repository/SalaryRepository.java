package com.example.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendjava.models.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
