package com.luv2code.springboot.cruddemo.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Car;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public Car findCar(String thePinakida) {
		return employeeDAO.findCar(thePinakida);
	}

	@Override
	@Transactional
	public List<com.luv2code.springboot.cruddemo.entity.Service> findServises(String theId) {
		return employeeDAO.findServises(theId);
	}

	@Override
	@Transactional
	public int saveCar(Car theEmployee) {
		return employeeDAO.saveCar(theEmployee);
	}

	@Override
	@Transactional
	public int saveService(com.luv2code.springboot.cruddemo.entity.Service theId) {

		return employeeDAO.saveService(theId);
	}

	@Override
	@Transactional
	public int updateCar(Car theCar){
		return employeeDAO.updateCar(theCar);
	}

	@Override
	public int updateService (com.luv2code.springboot.cruddemo.entity.Service theService) {
		return employeeDAO.updateService(theService);
	}

}






