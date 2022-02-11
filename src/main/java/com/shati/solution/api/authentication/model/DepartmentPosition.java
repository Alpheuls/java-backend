package com.shati.solution.api.authentication.model;

import javax.persistence.*;

@Entity
@Table(name = "department_position")
public class DepartmentPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_position_sequence_id")
    @SequenceGenerator(name = "department_position_sequence_id", sequenceName = "department_position_sequence_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_department_id")
    private CompanyDepartment companyDepartmentId;
    @Column
    private String position;
    @Column
    private char privilege;

    public CompanyDepartment getCompanyDepartmentId() {
        return companyDepartmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyDepartmentId(CompanyDepartment companyDepartmentId) {
        this.companyDepartmentId = companyDepartmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public char getPrivilege() {
        return privilege;
    }

    public void setPrivilege(char privilege) {
        this.privilege = privilege;
    }
}
