package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Dto.ApiResponse;
import com.Employee.Dto.EmployeeDto;
import com.Employee.Service.ServiceI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private ServiceI employeeServiceI;

	@PostMapping("/employeesave")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto) {

		EmployeeDto saveEmployee = this.employeeServiceI.SaveEmployee(empDto);

		return new ResponseEntity<EmployeeDto>(saveEmployee, HttpStatus.CREATED);

	}

	@GetMapping("/getEmployee/{empId}")
	public ResponseEntity<EmployeeDto> getEmployee(@RequestBody EmployeeDto empDto, @PathVariable Long empId) {

		EmployeeDto getEmployee = this.employeeServiceI.getEmployee(empId);

		return new ResponseEntity<EmployeeDto>(getEmployee, HttpStatus.OK);

	}

	@GetMapping("/getall")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee() {

		List<EmployeeDto> allEmployee = this.employeeServiceI.getAllEmployee();

		return new ResponseEntity<List<EmployeeDto>>(allEmployee, HttpStatus.OK);

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<EmployeeDto> updateUser(@RequestBody EmployeeDto empDto, @PathVariable Long empId) {
		EmployeeDto updateEmployee = this.employeeServiceI.UpdateEmployee(empDto, empId);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long empId) {

		this.employeeServiceI.DeleteEmployee(empId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Delete successfully !!", true), HttpStatus.OK);

	}}
