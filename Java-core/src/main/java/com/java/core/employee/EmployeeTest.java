package com.java.core.employee;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Jack", 8000, 2014, 8, 8);
        staff[1] = new Employee("Rose", 7000, 2014, 8, 8);
        staff[2] = new Employee("Brian", 9000, 2014, 8, 8);

        for (Employee e : staff) {
            e.raiseSalary(15);
        }

        for (Employee emp : staff) {
            System.out.println("name:" + emp.getName() + " salary:"
                    + emp.getSalary() + " hireDate:" + emp.getHireDate());
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private Date hireDate;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDate = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return (Date) hireDate.clone();
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }
}