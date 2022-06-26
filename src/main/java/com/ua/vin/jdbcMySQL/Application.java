package com.ua.vin.jdbcMySQL;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

	

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, NoSuchMethodException, SecurityException,
			SQLException, InvocationTargetException {
		
	
		EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionUtils.openConnection());
		
		// READ-ALL from BD
		employeeDAO.readAll().stream().forEach(System.out::println);
		System.out.println();

		
		List<Employee> listOfEployee = new ArrayList<Employee>();
		listOfEployee.add(new Employee("Andriy", "Kushnir"));
		listOfEployee.add(new Employee("David", "Malievich"));
		listOfEployee.add(new Employee("Oleg", "Dub"));
		listOfEployee.add(new Employee("Olga", "Gorobets"));
		listOfEployee.add(new Employee("Larysa", "Ivanchenko"));

		// INSERT to BD
		listOfEployee.forEach(employee -> {
			try {
				employeeDAO.insert(employee);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		//READ-ALL from BD
		employeeDAO.readAll().stream().forEach(System.out::println);
		System.out.println();
		
		//READ-ById from BD
		Employee employeeFromBD = employeeDAO.read(5);
		System.out.println(employeeFromBD);
		
		//UPDATE-ByID
		employeeFromBD.setLastName(employeeFromBD.getLastName() + "-Green");
		employeeDAO.update(employeeFromBD);
		
		//DELETE ById
		employeeDAO.delete(4);
		
		//READ-ALL from BD
		employeeDAO.readAll().stream().forEach(System.out::println);
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// main

}
