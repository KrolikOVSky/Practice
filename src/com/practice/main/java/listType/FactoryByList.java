package com.practice.main.java.listType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FactoryByList {


    // Fields
    private final static String FACTORY_FORMAT_STRING = "Name Of Factory: %s;\t %-5d workshops";
    private String name;
    private List<Workshop> workshops;


    // Constructors
    public FactoryByList(String name, List list) {
        this.name = name;
        this.workshops = new ArrayList<Workshop>(list);
    }

    public FactoryByList(String name) {
        this.name = name;
        workshops = new ArrayList<Workshop>();
    }

    public FactoryByList() {
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
        for (var el : workshops) {
            System.out.println(el.toString());
        }
        System.out.println();
    }

    public Workshop getWorkshopById(String id) {
        for (var el : workshops) {
            if (el.getId().equals(id)) return el;
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
        return middleSalary / getNumberOfWorkshops();
    }

    public FactoryByList getWorkshopsWithAboveMiddleSalary() {
        if (workshops == null) return null;
        FactoryByList newWorkshops = new FactoryByList();
        for (var el : workshops) {
            if (el.getSalary() > getMiddleSalaryOfFactory()) newWorkshops.addWorkshop(el);
        }
        return newWorkshops;
    }

    public FactoryByList getWorkshopsEmptyPositionsBetween(int a, int b) {
        FactoryByList newWorkshops = new FactoryByList();
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
    public FactoryByList sortById() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getId);
        FactoryByList list = new FactoryByList(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public FactoryByList sortBySalaryBigToSmall() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getSalary).reversed();
        FactoryByList list = new FactoryByList(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public FactoryByList sortBySalarySmallToBig() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getSalary);
        FactoryByList list = new FactoryByList(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }

    public FactoryByList sortByNameAndId() {
        Comparator<Workshop> comparator = Comparator.comparing(Workshop::getName).thenComparing(Workshop::getId);
        FactoryByList list = new FactoryByList(name, workshops);
        list.workshops.sort(comparator);
        return list;
    }


}
