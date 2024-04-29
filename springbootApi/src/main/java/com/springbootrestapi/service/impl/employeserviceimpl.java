
package com.springbootrestapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootrestapi.entity.employee;
import com.springbootrestapi.exception.resourcenotfoundexception;
import com.springbootrestapi.repository.employeerepository;
import com.springbootrestapi.service.employeservice;

@Service
public class employeserviceimpl implements employeservice {
	// dependency constructor based dependencyinjection for repository
    private employeerepository employeerepository;

    @Autowired
    public employeserviceimpl(employeerepository employeerepository) {
        super();
        this.employeerepository = employeerepository;
    }

    @Override
    public employee saveemploye(employee employee) {
        // TODO Auto-generated method stub
        return employeerepository.save(employee);
    }


	@Override
	public List<employee> getallEmployees() {
		// TODO Auto-generated method stub
		return employeerepository.findAll();
	}

	@Override
	public employee getemployeebyid(long id) {
		// TODO Auto-generated method stub
	Optional<employee>	employee= employeerepository.findById(id);
	if(employee.isPresent()) {
		return employee.get();
	}else {
		throw new  resourcenotfoundexception("employee","id",id);
	}
	}

//	@Override
//	public employee updatEmployee(employee employee, long id) {
//		// TODO Auto-generated method stub
//	 Optional<employee>	 existingEmployee = employeerepository.findById(id);
//	 if (existingEmployee.isPresent()) {
//		 
//	 existingEmployee.setFirstname(employee.getFirstname());
//		 
//		
//	}
//		return null;
//	}
	@Override
	public employee updatEmployee(employee updatedEmployee, long id) {
	    Optional<employee> existingEmployeeOptional = employeerepository.findById(id);

	    if (existingEmployeeOptional.isPresent()) {
	        employee existingEmployee = existingEmployeeOptional.get();
	        
	        existingEmployee.setFirstname(updatedEmployee.getFirstname());
	        existingEmployee.setLastname(updatedEmployee.getLastname());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        // Update other properties as needed

	        return employeerepository.save(existingEmployee); // Save the updated employee
	    } else {
	        throw new resourcenotfoundexception("employee", "id", id);
	    }
	}



	@Override
	public void deletEmployee(long id) {
		// TODO Auto-generated method stub
		Optional<employee> existingEmployeeOptional = employeerepository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            employeerepository.deleteById(id);
        } else {
            throw new resourcenotfoundexception("employee", "id", id);
        }
	}

}
