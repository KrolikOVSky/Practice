package com.practice.main.java;

public class Workshop implements Comparable<Workshop>{

    private String id;
    private String name;
    private int numberOfPositions;
    private int numberOfWorkers;
    private double salary;

    public Workshop(String id, String name, int numberOfPositions, int numberOfWorkers, double salary) {
        this.id = id;
        this.name = name;
        this.numberOfPositions = numberOfPositions;
        this.numberOfWorkers = numberOfWorkers;
        this.salary = salary;
    }

    public Workshop() {
        this.id = null;
        this.name = null;
        this.numberOfPositions = -1;
        this.numberOfWorkers = -1;
        this.salary = -1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(int numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Workshop workshop) {
        return 0;
    }
}
