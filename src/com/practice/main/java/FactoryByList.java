package com.practice.main.java;

import java.util.List;

public class FactoryByList {

    private String name;
    private List<Workshop> workshops;

    public FactoryByList(String name, List<Workshop> workshops) {
        this.name = name;
        this.workshops = workshops;
    }

    public FactoryByList() {
        name = null;
        workshops = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Workshop> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<Workshop> workshops) {
        this.workshops = workshops;
    }

    public Workshop getWorkshopById(String id) {
        for (var el : workshops) {
            if (el.getId() == id) return el;
        }
        return null;
    }

    public int getNumberOfWorkshops() {
        if (workshops == null) return -1;
        int i = 0;
        for (var el : workshops) {
            i++;
        }
        return i;
    }

    public boolean addWorkshop(String id, String name, int numbersOfPositions, int numberOfWorkers, double salary) {
        if (workshops == null || getWorkshopById(id) == null) return false;
        return workshops.add(new Workshop(id, name, numbersOfPositions, numberOfWorkers, salary));
    }

    public boolean removeWorkshop(String id) {
        if (workshops == null || getWorkshopById(id) == null) return false;

        return workshops.remove(getWorkshopById(id));
    }

    public double getMiddleSalaryOfFactory() {
        if (workshops == null) return -1;
        int i = 0;
        double middleSalary = 0;
        for (var el : workshops) {
            middleSalary += el.getSalary();
        }
        return middleSalary / i;
    }

    public List<Workshop> getWorkshopsWithAboveMiddleSalary() {
        if (workshops == null) return null;
        List<Workshop> newWorkshops = null;
        for (var el : workshops) {
            if (el.getSalary() > getMiddleSalaryOfFactory()) newWorkshops.add(el);
        }
        return newWorkshops;
    }

    public List<Workshop> getWorkshopsEmptyPositionsBetween(int a, int b) {
        List<Workshop> newWorkshops = null;
        for (var el : workshops) {
            if (el.getNumberOfPositions() >= a && el.getNumberOfPositions() <= b) newWorkshops.add(el);
        }
        return newWorkshops;
    }

    // End of programming
    public List<Workshop> sortById() {
        List<Workshop> newWorkshops = null;
        newWorkshops.add(workshops.get(1));
        return newWorkshops;
    }
}
