package com.luv2code.springboot.cruddemo.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.entity.Service;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.cruddemo.entity.Car;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}


	@PostMapping("/newcar")
	public int newCar(@RequestParam String pinakida, @RequestParam String name, @RequestParam String lastName, @RequestParam String plasio,
						 @RequestParam String kibika, @RequestParam String aloga, @RequestParam String kodikosKinitira,
						 @RequestParam String xronoligia, @RequestParam String marka, @RequestParam String modelo) {

		Car newCar = new Car(pinakida,name,lastName,plasio,kibika,aloga,kodikosKinitira,xronoligia,marka,modelo);

		int i = employeeService.saveCar(newCar);

		return i;
	}

	@PostMapping("/service")
	public int newService(@RequestParam String pinakida, @RequestParam String xml1, @RequestParam String xml2, @RequestParam String sxolia) {

		Service newService = new Service(pinakida,xml1,xml2,sxolia);



		return employeeService.saveService(newService);
	}

	@PostMapping("/car")
	public Car getCar(@RequestParam String pinakida) {

		Car theCar = employeeService.findCar(pinakida);

		return theCar;
	}

	@PostMapping("/updatecar")
	public int updateCar(@RequestParam String pinakida, @RequestParam String name, @RequestParam String lastName, @RequestParam String plaisio,
					  @RequestParam String kibika, @RequestParam String aloga, @RequestParam String kodikosKinitira,
					  @RequestParam String xronoligia, @RequestParam String marka, @RequestParam String modelo) {

		Car newCar = new Car(pinakida,name,lastName,plaisio,kibika,aloga,kodikosKinitira,xronoligia,marka,modelo);

		int i = employeeService.updateCar(newCar);

		return i;
	}
	
	// expose "/employees" and return list of employees
	@PostMapping("/services")
	public List<Service>  getServices(@RequestParam String pinakida) {
		List<Service> myList = employeeService.findServises(pinakida);





		return myList;
	}

	// add mapping for GET /employees/{employeeId}
	
//	@GetMapping("/employees/{employeeId}")
//	public Car getEmployee(@PathVariable int employeeId) {
//
//		Car theEmployee = employeeService.findById(employeeId);
//
//		if (theEmployee == null) {
//			throw new RuntimeException("Employee id not found - " + employeeId);
//		}
//
//		return theEmployee;
//	}
//
//	// add mapping for POST /employees - add new employee
//
//	@PostMapping("/employees")
//	public Car addEmployee(@RequestBody Car theEmployee) {
//
//		// also just in case they pass an id in JSON ... set id to 0
//		// this is to force a save of new item ... instead of update
//
//		//theEmployee.setId(0);
//
//		employeeService.save(theEmployee);
//
//		return theEmployee;
//	}
//
//	// add mapping for PUT /employees - update existing employee
//
//	@PutMapping("/employees")
//	public Car updateEmployee(@RequestBody Car theEmployee) {
//
//		employeeService.save(theEmployee);
//
//		return theEmployee;
//	}
//
//	// add mapping for DELETE /employees/{employeeId} - delete employee
//
//	@DeleteMapping("/employees/{employeeId}")
//	public String deleteEmployee(@PathVariable int employeeId) {
//
//		Car tempEmployee = employeeService.findById(employeeId);
//
//		// throw exception if null
//
//		if (tempEmployee == null) {
//			throw new RuntimeException("Employee id not found - " + employeeId);
//		}
//
//		employeeService.deleteById(employeeId);
//
//		return "Deleted employee id - " + employeeId;
//	}
	
}










