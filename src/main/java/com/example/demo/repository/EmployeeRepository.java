package com.example.demo.repository;

import com.example.demo.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer>
{
@Query("from Employee")
List<Employee> findAllEmployees();
@Query("select firstName,lastName from Employee where salary>(select avg(salary) from Employee) order by age,salary desc")
List<Object[]> findAllSortedEmployees();

@Modifying
    @Query(value="select id,empFirstName,empAge from employee where empLastName like '%Singh'",nativeQuery = true)
    List<Object[]> findAllFilteredEmployees();

@Modifying
@Query(value="delete from employee where empSalary=(select min(empSalary) from (select * from employee) AS e2)",nativeQuery = true)
    void deleteEmployeeByMinSalary();

@Modifying
@Query(value="delete from employee where empAge>:empAge",nativeQuery = true)
    void deleteEmployeeWithAge(@Param("empAge") int empAge);

//@Modifying
//@Query(value="update employee set empSalary=:empSalary where empSalary<(select min(empSalary) from (select * from employee) AS e2)")
//    void updateEmployeeBySalary(@Param("empSalary") double salary);
}
