package com.example.backendjava.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_user")
public class User {
    @Id
    private Integer id;
    private String email;
    private String password;
    // Relation to table employee
    @OneToOne
    @JoinColumn(name = "id")
    private Employee employee;
    // Non parameter constructor
    public User() {

    }
    // Constructor
    public User(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    

}
