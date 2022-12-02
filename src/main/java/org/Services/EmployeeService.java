package org.Services;

import org.Entities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {


    public static List<Employee> PopulateEmployees()
    {
        List<Employee> employeeList  = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < 200; i++)
        {
          Employee  e = new Employee();
          e.setEmployeeId(i);
          e.setEmployeeName("Employee "+i);
          e.setDepartment("Department "+i);
          e.setTitle(e.JobTitles[random.nextInt(5)]);
          employeeList.add(e);
        }
       return employeeList;
    }

    //by using traditional for loop approach to group by employees by Title
    public static Map<String,List<Employee>> GroupByEmployeesByTitle(List<Employee> employeeList)
    {
        Map<String,List<Employee>> groupByEmployees = new HashMap<String,List<Employee>>();
        for(Employee emp : employeeList) {
         List<Employee> employees = groupByEmployees.getOrDefault(emp.getTitle(),new ArrayList<>());
         employees.add(emp);
         groupByEmployees.put(emp.getTitle(),employees);
        }
        return  groupByEmployees;
    }

    //by using stream api to group by Employees by Title

    public  static Map<String,List<Employee>> GroupByEmployeesByTitleStream(List<Employee> employeeList)
    {
      return employeeList.stream().collect(Collectors.groupingBy(Employee :: getTitle));
    }
}
