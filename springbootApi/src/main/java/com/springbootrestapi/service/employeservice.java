package com.springbootrestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootrestapi.entity.employee;


public interface employeservice {
	employee saveemploye(employee employee);
	List<employee> getallEmployees();
	employee getemployeebyid(long id);
	employee  updatEmployee(employee employee,long id);
	void deletEmployee(long id);

}
