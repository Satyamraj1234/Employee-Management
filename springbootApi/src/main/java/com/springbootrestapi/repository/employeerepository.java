package com.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootrestapi.entity.employee;
@Repository
public interface employeerepository extends JpaRepository<employee, Long> {

}
