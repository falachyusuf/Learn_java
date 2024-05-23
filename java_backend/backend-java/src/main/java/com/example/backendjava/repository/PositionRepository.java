package com.example.backendjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendjava.models.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

}
