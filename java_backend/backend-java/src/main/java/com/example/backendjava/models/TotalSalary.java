package com.example.backendjava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tr_total_salary")
public class TotalSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total_salary")
    private Integer totalSalary;
    // Relation to table salary
    @ManyToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;
    // Relation to table employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    // Constructor
    public TotalSalary() {
    }
    public TotalSalary(Integer id, Integer totalSalary) {
        this.id = id;
        this.totalSalary = totalSalary;
    }
    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(Integer totalSalary) {
        this.totalSalary = totalSalary;
    }
    public Salary getSalary() {
        return salary;
    }
    public void setSalary(Salary salary) {
        this.salary = salary;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    

}
