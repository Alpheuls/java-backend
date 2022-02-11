package com.shati.solution.api.authentication.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_id")
    @SequenceGenerator(name = "user_sequence_id", sequenceName = "user_sequence_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String userId;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "company_dep")
    private CompanyDepartment companyDepartment;
    @ManyToOne
    @JoinColumn(name = "position")
    private DepartmentPosition position;
    @Column
    private String status;
    @Column
    private String privilege;
    @OneToOne
    @JoinColumn
    private Address address;
    @Column
    private LocalDateTime createDate;
    @Column
    private LocalDateTime updateDate;
    @Column
    private LocalDateTime deleteDate;
    @Column
    private LocalDateTime activityDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyDepartment getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(CompanyDepartment companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public DepartmentPosition getPosition() {
        return position;
    }

    public void setPosition(DepartmentPosition position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public LocalDateTime getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDateTime activityDate) {
        this.activityDate = activityDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(String userId, String name, String lastName, String email, String password, Company company, CompanyDepartment companyDepartment, DepartmentPosition position, String status, String privilege, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate, LocalDateTime activityDate, Address address) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.company = company;
        this.companyDepartment = companyDepartment;
        this.position = position;
        this.status = status;
        this.privilege = privilege;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
        this.activityDate = activityDate;
        this.address = address;
    }
}
