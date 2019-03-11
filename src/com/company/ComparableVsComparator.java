package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.age - emp.age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class EmployeeSortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class ComparableVsComparator {
    static List<Employee> populateEmployee(){
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(1, "aa", 21));
        empList.add(new Employee(2, "bb", 27));
        empList.add(new Employee(3, "aa", 24));
        empList.add(new Employee(4, "cc", 19));
        empList.add(new Employee(5, "dd", 30));

        return empList;
    }

    private static void printList(List<Employee> list) {
        System.out.println("EmpId\tName\tAge");
        for (Employee e: list) {
            System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getAge());
        }
    }



    public static void main(String[] args) {
        List<Employee> emp = populateEmployee();
//        Collections.sort(emp);
        Collections.sort(emp, new EmployeeSortByName());
        printList(emp);
    }
}
