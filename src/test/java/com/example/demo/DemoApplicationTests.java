package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class DemoApplicationTests {
@Autowired
EmployeeRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testEmployeeCreate()
	{
		Employee employee=new Employee();

		employee.setFirstName("Roger");
		employee.setLastName("Kendrik");
		employee.setAge(50);
		employee.setSalary(50000.00);
		repository.save(employee);

		Employee employee1=new Employee();

		employee1.setFirstName("Pumba");
		employee1.setLastName("Mufasa");
		employee1.setAge(55);
		employee1.setSalary(2000.00);
		repository.save(employee1);
	}
@Test
	public void testFindAllEmployees()
{
	System.out.println(repository.findAllEmployees());
}
	@Test
	public void testFindAllSortedEmployees()
	{
		List<Object[]> partData=repository.findAllSortedEmployees();
		for(Object[] objects:partData)
		{
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}
	@Test
	public void testFindAllFilteredEmployees()
	{
		List<Object[]> partData=repository.findAllFilteredEmployees();
		for(Object[] objects:partData)
		{
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeByMinSalary()
	{
		repository.deleteEmployeeByMinSalary();
	}

//		@Test
//	@Transactional
//		@Rollback(value = false)
//		public void testUpdateEmployeeBySalary()
//	{
//		repository.updateEmployeeBySalary(50000.00);
//	}

		@Test
	@Transactional
		@Rollback(value = false)
		public void testDeleteEmployeeWithAge()
	{
		repository.deleteEmployeeWithAge(45);
	}
}
