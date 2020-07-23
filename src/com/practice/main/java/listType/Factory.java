package com.practice.main.java.listType;

import java.util.*;

public class Factory {


    // Fields
    private final static String FACTORY_FORMAT_STRING = "Name Of Factory: %s;\t %-5d workshops";
    private String name;
    private List<Workshop> workshops;


    // Constructors
    public Factory(String name, List list) {
        this.name = name;
        this.workshops = new ArrayList<Workshop>(list);
    }

    public Factory(String name) {
        this.name = name;
        workshops = new ArrayList<Workshop>();
    }

    public Factory() {
        name = "";
        workshops = new ArrayList<Workshop>();
    }


    // Getters and setters
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


    // Some useful methods
    public void print() {
        System.out.printf("---%s---\n%15s      |%15s           |%23s      |%25s      |%12s      |\n", name, "ID", "Name", "Number of workers", "Number of positions", "Salary");//   |%7s   |%20s   |%22s   |%9s
        for (var el : workshops) {
            System.out.println(el.toString());
        }
        System.out.println();
    }

    public Workshop getWorkshopById(long id) {
        for (var el : workshops) {
            if (el.getId() == id) return el;
        }
        return null;
    }

    public int getNumberOfWorkshops() {
        /*if (workshops == null) return -1;
        int i = 0;
        for (var el : workshops) {
            i++;
        }*/
        return workshops.size();
    }

    public boolean addWorkshop(Workshop workshop) {
        if (getWorkshopById(workshop.getId()) != null) return false;
        return workshops.add(workshop);
    }

    public boolean removeWorkshop(long id) {
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
        return middleSalary / getNumberOfWorkshops();
    }

    public Factory getWorkshopsWithAboveMiddleSalary() {
        if (workshops == null) return null;
        Factory newWorkshops = new Factory(name);
        for (var el : workshops) {
            if (el.getSalary() > getMiddleSalaryOfFactory()) newWorkshops.addWorkshop(el);
        }
        return newWorkshops;
    }

    public Factory getWorkshopsEmptyPositionsBetween(int a, int b) {
        Factory newWorkshops = new Factory(name);
        for (var el : workshops) {
            if (el.getNumberOfPositions() >= a && el.getNumberOfPositions() <= b) newWorkshops.addWorkshop(el);
        }
        return newWorkshops;
    }

    @Override
    public String toString() {
        return String.format(FACTORY_FORMAT_STRING, name, getNumberOfWorkshops());
    }


    // Sorting
    public Factory sort(Comparator comparator){
        Factory factory = new Factory(name, workshops);
        factory.workshops.sort(comparator);
        return factory;
    }

    public Factory sortById() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getId);
        Factory list = new Factory(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public Factory sortBySalaryDesc() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getSalary).reversed();
        Factory list = new Factory(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public Factory sortBySalaryAsc() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getSalary);
        Factory list = new Factory(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public Factory sortBySalaryAndName() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getSalary).thenComparing(Workshop::getName);
        Factory list = new Factory(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }


}
