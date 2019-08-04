package com.example.core.java.basic;

public class StaticTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Jack", 8000);
        staff[1] = new Employee("Rose", 8000);
        staff[2] = new Employee("brian", 8000);

        for (Employee emp : staff) {
            emp.setId();
            System.out.println("id:" + emp.getId() + " name:" + emp.getName()
                    + " salary:" + emp.getSalary());
        }

        int nextId = Employee.getNextId();
        System.out.println(nextId);
    }
}

class Employee {
    private String name;
    private double salary;
    private int id;
    private static int nextId = 1;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = getNextId();
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }
}
