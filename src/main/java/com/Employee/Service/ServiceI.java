package com.Employee.Service;

import java.util.List;

import com.Employee.Dto.EmployeeDto;


	public interface ServiceI {

		public EmployeeDto SaveEmployee(EmployeeDto empDto);
		
		public List<EmployeeDto> getAllEmployee();
		
		public EmployeeDto getEmployee(Long empId);
		
		public EmployeeDto UpdateEmployee(EmployeeDto  empDto,Long empId );
		
		public void  DeleteEmployee (Long empId );
		
	}

