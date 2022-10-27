package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
@Autowired
	EmployeeRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate()
	{
		Employee employee=new Employee();
		employee.setId(5);
		employee.setName("Kenny");
		employee.setAge(20);
		employee.setLoc("U Block");
		repository.save(employee);
	}
	@Test
	public void testRead()
	{
		Employee employee=repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Kenny",employee.getName());
		System.out.println(employee.getName()+" "+employee.getAge()+" "+employee.getLoc());
	}
	@Test
	public void testUpdate()
	{
		Employee employee=repository.findById(1).get();
		employee.setLoc("A Block");
		repository.save(employee);
	}
	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting an employee");
			repository.deleteById(1);
		}
	}
	@Test
	public void testCount()
	{
		System.out.println("Total number of employees: "+repository.count());
	}
	@Test
	public void testFindByNameLike()
	{
		List<Employee> employeeList=repository.findByNameLike("A%");
		employeeList.forEach(p-> System.out.println(p.getName()));
	}
	@Test
	public void testFindAgeBetween()
	{
		List<Employee> employeeList=repository.findByAgeBetween(28,32);
		employeeList.forEach(p-> System.out.println(p.getName()));
	}
//	@Test
//	public void testFindAllPaging()
//	{
//		Pageable pageable= PageRequest.of(0, 3, Sort.by("age"));
//		Page<Employee> results=repository.findAll(pageable);
//		results.forEach((p-> System.out.println(p.getAge())));
//
//	}
@Test
public void testFindByName()
{
  List<Employee> employeeList=	repository.findByName("Penny");
  employeeList.forEach(e-> System.out.println(e.getAge()));
}

}
