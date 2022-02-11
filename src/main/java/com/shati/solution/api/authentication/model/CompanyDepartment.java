package com.shati.solution.api.authentication.model;

import javax.persistence.*;

@Entity
@Table(name = "company_department")
public class CompanyDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_department_sequence_id")
    @SequenceGenerator(name = "company_department_sequence_id", sequenceName = "company_department_sequence_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
