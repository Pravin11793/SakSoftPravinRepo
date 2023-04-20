package com.Employee.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Dto.EmployeeDto;
import com.Employee.Exception.ResourceNotFoundException;
import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;
import com.Employee.Service.ServiceI;


@Service
public class ServiseImpl implements ServiceI {
		
	@Autowired
	private  EmployeeRepository  employeeRepo;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public EmployeeDto SaveEmployee(EmployeeDto empDto) {
		Employee employee = this.mapper.map(empDto, Employee.class);
		Employee save = this.employeeRepo.save(employee);
		return this.mapper.map(save, EmployeeDto.class) ;
	}
	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> all = this.employeeRepo.findAll();
		List<EmployeeDto> list = all.stream().map((allE)-> this.mapper.map(allE, EmployeeDto.class)).collect(Collectors.toList());
		return list;
	}
	@Override
	public EmployeeDto getEmployee(Long empId) {
		Employee getEmployee = this.employeeRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("EmpId", "EmpId" ,empId));
		return this.mapper.map(getEmployee, EmployeeDto.class);
	}
	@Override
	public EmployeeDto UpdateEmployee(EmployeeDto empDto, Long empId) {
		Employee updateEmp = this.employeeRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("EmpId", "EmpId" ,empId));
		
		updateEmp.setEmpFName(empDto.getEmpFName());
		updateEmp.setEmpLName(empDto.getEmpLName());
		updateEmp.setEmpEmail(empDto.getEmpEmail());
		updateEmp.setEmpAge(empDto.getEmpAge());
		
		Employee save = this.employeeRepo.save(updateEmp);
		return this.mapper.map(save, EmployeeDto.class) ;
	}
	@Override
	public void DeleteEmployee(Long empId) {
		Employee delEmployee = this.employeeRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("EmpId", "EmpId" ,empId));
		this.employeeRepo.delete(delEmployee);
		
	}
	
	
	

	

	

}
