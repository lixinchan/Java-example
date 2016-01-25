package com.java.core.param;

public class ParamTest {

    public static void main(String[] args) {

        // double precent = 10;
        // ParamTest.tripleValue(precent);
        // System.out.println(precent);

        // Employee staff = new Employee("Jack", 8000);
        // System.out.println("before: " + staff.getSalary());
        // ParamTest.tripleSalary(staff);
        // System.out.println("after: " + staff.getSalary());

        /*
         * Employee Jack = new Employee("Jack", 8000); Employee Rose = new
         * Employee("Rose", 8000); System.out.println("before: " +
         * Jack.toString() + "---" + Rose.toString()); ParamTest.swap(Jack,
         * Rose); System.out.println("after: " + Jack.toString() + "---" +
         * Rose.toString());
         */

        // while (true) {
        // Employee staff = new Employee("Jack", 8000);
        // System.out.println(staff.getId());
        // }
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of x = " + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(300);
        System.out.println("End of salary:" + x.getSalary());
    }

    public static void swap(Employee a, Employee b) {
        Employee temp = a;
        a = b;
        b = temp;
    }
}

class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    // public int getId() {
    // return this.id;
    // }

    public void raiseSalary(double byPrecent) {
        double raise = salary * byPrecent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }

    // static int nextID() {
    // int r = nextID;
    // nextID++;
    // return r;
    //
    // }
    //
    // private int id = nextID();
    // private static int nextID = 1;
}
