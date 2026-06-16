package org.miswah;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Company comp = new Company();

        comp.add(new Employee(1, "Jhon", "HR"));
        comp.add(new Employee(2, "Alice", "IT"));
        comp.add(new Employee(3, "Bob", "HR"));
        comp.add(new Employee(4, "Charlie", "Sales"));
        comp.add(new Employee(5, "David", "IT"));


        for(Employee emp : comp){
            System.out.println("All emp -> "+ emp.name());
        }

        Iterator<Employee> hrIterator = comp.hrIterator();

        while(hrIterator.hasNext()){
            System.out.println("HR Only -> "+ hrIterator.next().name());
        }

        Iterator<Employee> itIterator = comp.itIterator();

        while(itIterator.hasNext()){
            System.out.println("IT Only -> "+ itIterator.next().name());
        }


        Iterator<Employee> salesIterator = comp.salesIterator();

        while(salesIterator.hasNext()){
            System.out.println("Sales Only -> "+ salesIterator.next().name());
        }
    }
}
