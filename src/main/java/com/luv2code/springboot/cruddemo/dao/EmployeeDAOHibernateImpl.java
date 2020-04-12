package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.luv2code.springboot.cruddemo.entity.Service;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Car;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	private static Connection con;

	//UPDATE table_name SET field1 = new-value1, field2 = new-value2

	public static void connectToDb(){
		{
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kogas?useUnicode=yes&characterEncoding=UTF-8","root","root");
				//?useUnicode=yes&characterEncoding=UTF-8
				//?useSSL=false&serverTimezone=UTC
				System.out.println("Connected to DB");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int saveCar(Car theCar) {


		connectToDb();

		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO kogas.car (name, lastName, plaisio, pinakida, kibika, aloga, kodikosKinitira, xronologia, marka, modelo) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?)");

			stmt.setString(1,theCar.getName());
			stmt.setString(2,theCar.getLastName());
			stmt.setString(3,theCar.getPlaisio());
			stmt.setString(4,theCar.getPinakida());
			stmt.setString(5,theCar.getKibika());
			stmt.setString(6,theCar.getAloga());
			stmt.setString(7,theCar.getKodikosKinitira());
			stmt.setString(8,theCar.getXronologia());
			stmt.setString(9,theCar.getMarka());
			stmt.setString(10,theCar.getModelo());



			int i=stmt.executeUpdate();
			System.out.println(i+" records inserted");
			System.out.println("to modelo ine "+theCar.getModelo());
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	@Override
	public int updateCar(Car theCar) {

		connectToDb();
		//UPDATE car SET name = ?, lastName= ?, plaisio= ?, kibika= ?, aloga=?, kodikosKinitira=?,xronologia=?, marka= ?, modelo=? WHERE pinakida = ?;
		try {
			PreparedStatement stmt=con.prepareStatement("UPDATE car SET name = ?, lastName= ?, plaisio= ?, aloga=?,kibika= ?, kodikosKinitira=?,xronologia=?, marka= ?, modelo=? WHERE pinakida = ?");

			stmt.setString(1,theCar.getName());
			stmt.setString(2,theCar.getLastName());
			stmt.setString(3,theCar.getPlaisio());
			stmt.setString(9,theCar.getModelo());
			stmt.setString(5,theCar.getKibika());
			stmt.setString(4,theCar.getAloga());
			stmt.setString(6,theCar.getKodikosKinitira());
			stmt.setString(7,theCar.getXronologia());
			stmt.setString(8,theCar.getMarka());
			stmt.setString(10,theCar.getPinakida());




			int i=stmt.executeUpdate();
			System.out.println(i+" records inserted");
			System.out.println("to plaisio ine "+theCar.getPlaisio());
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	@Override
	public Car findCar(String thePinakida) {

		connectToDb();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Car tempCar = new Car();
		try {
			stmt=con.prepareStatement("select * from kogas.car where pinakida = ?");


			stmt.setString(1,thePinakida);

			rs=stmt.executeQuery();
			//System.out.println(i+" records inserted");
		} catch (Exception e) {
			e.printStackTrace();
			return tempCar;
		}


		try {
			while (rs.next()) {
				tempCar.setName(rs.getString("name"));
				tempCar.setLastName(rs.getString("lastName"));
				tempCar.setPlaisio(rs.getString("plaisio"));
				tempCar.setKibika(rs.getString("kibika"));
				tempCar.setAloga(rs.getString("aloga"));
				tempCar.setKodikosKinitira(rs.getString("kodikosKinitira"));
				tempCar.setXronologia(rs.getString("xronologia"));
				tempCar.setMarka(rs.getString("marka"));
				tempCar.setModelo(rs.getString("modelo"));



			}
		} catch (SQLException e) {
			e.printStackTrace();
		}



		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tempCar;
	}

	@Override
	public List<Service>  findServises(String thePinakida)  {

		List<Service> myList = new ArrayList();
		connectToDb();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement("select * from kogas.service where pinakida = ? ORDER BY id DESC");


			stmt.setString(1,thePinakida);

			rs=stmt.executeQuery();
			//System.out.println(i+" records inserted");
		} catch (Exception e) {
			e.printStackTrace();
			return myList;
		}


			try {
				while (rs.next()) {
					Service service = new Service();
					service.setPinakida(rs.getString("pinakida"));
					service.setSxolia(rs.getString("sxolia"));
					service.setXml1(rs.getString("xlm1"));
					service.setXlm2(rs.getString("xlm2"));
					service.setId(rs.getString("id"));
					myList.add(service);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}



		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return myList;


	}


	@Override
	public int saveService(Service theService) {

		connectToDb();
		try {
			PreparedStatement stmt=con.prepareStatement("INSERT INTO kogas.service (pinakida, xlm1, xlm2, sxolia) VALUES(?,?,?,?)");

			stmt.setString(1,theService.getPinakida());
			stmt.setString(2,theService.getXml1());
			stmt.setString(3,theService.getXlm2());
			stmt.setString(4,theService.getSxolia());


			System.out.println("ta sxolia ine " + stmt);


			int i=stmt.executeUpdate();
			System.out.println(i+" records inserted");
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

}







