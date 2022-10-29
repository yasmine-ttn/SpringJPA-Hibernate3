package com.example.demo;


import com.example.demo.entities.*;
import com.example.demo.repository.empRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpTesting {
    @Autowired
    empRepository repository;
    @Test
    public void testCreateEmployee()
    {
        Emp employee=new Emp();
        employee.setId(100);
        employee.setFirstName("Marie");
        employee.setLastName("Cooper");
        employee.setAge(45);
        Salary salary=new Salary();
        salary.setBasicSalary(100000.00);
        salary.setBonusSalary(50000.00);
        salary.setTaxAmount(25000.00);
        salary.setSpecialAllowanceSalary(10000.00);
        employee.setSalary(salary);
     repository.save(employee);
    }

}
