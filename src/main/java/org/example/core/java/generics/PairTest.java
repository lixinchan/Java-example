package org.example.core.java.generics;

import java.util.Date;
import java.util.GregorianCalendar;

public class PairTest {

    public static void main(String[] args) {
    
    }
    
    public static void printBouns(Pair<? extends Employee> pair) {
        pair.getFirst();
        pair.getSecond();
    }
    
    public static void minmaxBouns(Manager[] man, Pair<? super Employee> pair) {
        PairSwap.swapHelper(pair);
    }
}

class PairSwap{
    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }
    
    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }
    
    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
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
        this.hireDate = calendar.getTime();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", hireDate="
                + hireDate + "]";
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Manager extends Employee {
    
    private double bouns;
    
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bouns = 0;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
    
    @Override
    public double getSalary() {
        return super.getSalary() + bouns;
    }
}
