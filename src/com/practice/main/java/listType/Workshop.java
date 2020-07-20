package com.practice.main.java.listType;

public class Workshop {

    private final static String WORKSHOP_STRING_FORMAT = "Workshop: %-7s | %-10s | %-10s |  %-10s | %-8.2f |";
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
        return 7 * (Integer.valueOf(id).hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Workshop workshop = (Workshop) obj;
        return id.equals(workshop.id);
    }

    @Override
    public String toString() {
        return String.format(WORKSHOP_STRING_FORMAT, getId(), getName(), getNumberOfPositions(), getNumberOfWorkers(), getSalary());
    }


}
