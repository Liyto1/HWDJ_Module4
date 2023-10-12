package org.example;

public class MaxSalaryCountWorker {
    private int id;
    private String name;
    private int salary;

    public MaxSalaryCountWorker(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
