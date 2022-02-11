package com.shati.solution.api.authentication.repository;

import com.shati.solution.api.authentication.model.DepartmentPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentPositionRepository extends JpaRepository<DepartmentPosition, Long> {
}
