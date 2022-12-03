package org.example;

import org.Entities.Employee;
import org.Services.EmployeeService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.Services.EmployeeService.PopulateEmployees;

public class Main {
    public static void main(String[] args) {


            List<Integer> marks = Arrays.asList(43,44,89,292992,19292,299);
        List<String> names = Arrays.asList("Noor Nabi","Moiz","Athar","Niaz");
        //Filter , used to apply predicate fucntion on the collection of data,
        // 1-
         /*marks.stream().filter(x-> x > 50)
                 .collect(Collectors.toList())
                 .forEach(x-> System.out.println("X : "+x));
*/
        //making a reservation of 4 players

        //Given a stream containing some elements, the task is to get the first element of the Stream
        //using reduce
        int firstElement =    marks.stream().reduce((x,y)->x).orElse(0);

      //using first
        firstElement = marks.stream().findFirst().orElse(-1);

        // Given a stream containing some elements, the task is to get the last element of the Stream in Java.
        int lastElement = marks.stream().reduce((x,y)-> y).orElse(0);

        //using skip

        lastElement = marks.stream().skip(marks.size()-1).findFirst().get();


        //Given a string and a character, the task is to make a function which counts the occurrence of the given character in the string using


        String text = "Noornabinoornannanaa";
        Character ch = 'a';
        long occuranceTotal = text.chars().filter(x -> ch == x).count();

        List<Employee> employees =  EmployeeService.PopulateEmployees();
        Map<String,List<Employee>> employeesHashMap =  EmployeeService.GroupByEmployeesByTitle(employees);

       for(String title : employeesHashMap.keySet())
       {
           System.out.println("Title : "+title + " :");
           for(Employee e : employeesHashMap.get(title))
           {
               System.out.println(e.getEmployeeName());
           }
       }

      Stream<Employee> employeesListStream =  employees.stream();

        //get only software engineer employees name from list of employees object

      List<String> softwareEngineers =  employeesListStream.filter(x -> { return x.getTitle() == "Software Engineer"; }).
                            map(x-> { return  x.getEmployeeName(); }).
                            toList();
        System.out.println(softwareEngineers.size());
        softwareEngineers.forEach(x-> System.out.println(x));

        //Stream iterate
       Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
       streamIterated.forEach(x-> System.out.println(x));



        System.out.println(occuranceTotal);

    }


}