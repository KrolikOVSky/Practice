package com.practice.main.java.setType;

public class Workshop implements Comparable<Workshop>{

    private final static String WORKSHOP_STRING_FORMAT = "Workshop: %5s      |           %-10s     | %13s               |%17s              |%13.2f     |";
    private long id;
    private String name;
    private int numberOfPositions;
    private int numberOfWorkers;
    private double salary;

    public Workshop(long id, String name, int numberOfPositions, int numberOfWorkers, double salary) {
        this.id = id;
        this.name = name;
        this.numberOfPositions = numberOfPositions;
        this.numberOfWorkers = numberOfWorkers;
        this.salary = salary;
    }

    public Workshop() {
        this.id = -1;
        this.name = null;
        this.numberOfPositions = -1;
        this.numberOfWorkers = -1;
        this.salary = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return 7 * (Long.valueOf(id)).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Workshop workshop = (Workshop) obj;
        return id == workshop.id;
    }

    @Override
    public String toString() {
        return String.format(WORKSHOP_STRING_FORMAT, id, name, numberOfPositions, numberOfWorkers, salary);
    }


    @Override
    public int compareTo(Workshop o) {
        if(id < o.id)return -1;
        else if(id == o.id)return 0;
        else return 1;
    }
}
