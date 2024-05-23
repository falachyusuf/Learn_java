package com.example.backendjava.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "identity_number")
    private String identityNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String gender;
    @Column(name = "employee_status")
    private String employeeStatus;
    // Relation to table user
    @OneToOne(mappedBy = "employee")
    private User user;
    // Relation to table total salary
    @OneToMany(mappedBy = "employee")
    private List<TotalSalary> totalSalary;
    // Relation to table departement
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    // Relation to table employee
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    // Constructor
    public Employee() {
    }

    public Employee(Integer id, String name, String identityNumber, String phoneNumber, String address, String gender,
            String employeeStatus, User user, List<TotalSalary> totalSalary, Departement departement,
            Position position) {
        this.id = id;
        this.name = name;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.employeeStatus = employeeStatus;
        this.user = user;
        this.totalSalary = totalSalary;
        this.departement = departement;
        this.position = position;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmployeeStatus() {
        return employeeStatus;
    }
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<TotalSalary> getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(List<TotalSalary> totalSalary) {
        this.totalSalary = totalSalary;
    }
    public Departement getDepartement() {
        return departement;
    }
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }



}
