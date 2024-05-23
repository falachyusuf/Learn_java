package com.example.backendjava.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "base_salary")
    private Integer baseSalary;
    private Integer bonus;
    // Relation to table total salary
    @OneToMany(mappedBy = "salary")
    private List<TotalSalary> totalSalary;
    // Constructor
    public Salary() {
    }
    public Salary(Integer id, Integer baseSalary) {
        this.id = id;
        this.baseSalary = baseSalary;
    }
    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }
    public List<TotalSalary> getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(List<TotalSalary> totalSalary) {
        this.totalSalary = totalSalary;
    }
    public Integer getBonus() {
        return bonus;
    }
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
    

}
