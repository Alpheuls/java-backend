package com.shati.solution.api.authentication.repository;

import com.shati.solution.api.authentication.model.CompanyDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDepartmentRepository extends JpaRepository<CompanyDepartment, Long> {
}
