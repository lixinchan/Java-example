package org.java.core.inheritance;

public class Manager extends Employee {

    private double bouns;

    public Manager(double bouns) {
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    protected double getSalary(double salary, double bouns) {
        return salary + bouns;
    }

}
