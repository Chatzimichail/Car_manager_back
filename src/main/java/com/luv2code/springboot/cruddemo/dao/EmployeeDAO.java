package com.luv2code.springboot.cruddemo.dao;

import java.sql.ResultSet;
import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Car;
import com.luv2code.springboot.cruddemo.entity.Service;

public interface EmployeeDAO {


	public Car findCar(String thePinakida);
	public int saveCar(Car theEmployee);
	public int saveService(Service theService) ;
	public List<Service> findServises(String thePinakida);
	public int updateCar(Car theCar);
	public int updateService (Service theService);

}
