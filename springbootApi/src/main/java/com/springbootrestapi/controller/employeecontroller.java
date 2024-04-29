package com.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.entity.employee;
import com.springbootrestapi.service.employeservice;
@RestController
@RequestMapping("api/employee")
public class employeecontroller {
	//constructor dependency
	private employeservice employeservice;

	public employeecontroller(employeservice employeservice) {
		super();
		this.employeservice = employeservice;
	}
	//rest api
	@PostMapping()
	public ResponseEntity<employee> saveemploye(@RequestBody employee employee){
		 System.out.println("Received employee: " + employee);
		return new ResponseEntity<employee>(employeservice.saveemploye(employee),HttpStatus.CREATED);
	}
	@GetMapping
	public List<employee> getallEmployees(){
		return employeservice.getallEmployees();
	}
	@GetMapping("{id}")
	public ResponseEntity<employee> getemployeebyid(@PathVariable("id") long employeeid){
		return new ResponseEntity<employee>(employeservice.getemployeebyid(employeeid), HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<employee> updateemployee(@PathVariable ("id") long id,@RequestBody employee employee){
		return new ResponseEntity<employee>(employeservice.updatEmployee(employee, id), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        employeservice.deletEmployee(id);
        return new ResponseEntity<String>("Employee with id " + id + " deleted successfully.", HttpStatus.OK);
    }
}
