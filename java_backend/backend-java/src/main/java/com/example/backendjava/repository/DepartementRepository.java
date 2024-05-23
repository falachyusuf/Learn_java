package com.example.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendjava.models.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer>{

}
