package com.luv2code.springboot.cruddemo.service;

import java.sql.ResultSet;
import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Car;
import com.luv2code.springboot.cruddemo.entity.Service;

public interface EmployeeService {

	public Car findCar(String thePinakida);
	public List<Service> findServises(String theId);
	public int saveCar(Car theEmployee);
	public int saveService(com.luv2code.springboot.cruddemo.entity.Service theId);
	public int updateCar(Car theCar);
}
