package com.practice.main.java.setType;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Factory {


    // Fields
    private final static String FACTORY_FORMAT_STRING = "Name Of Factory: %s;\t %-5d workshops";
    private String name;
    private Set<Workshop> workshops;


    // Constructors

    public Factory(String name, Comparator comparator) {
        this.name = name;
        this.workshops = new TreeSet<Workshop>(comparator);
    }

    public Factory(String name, Set set) {
        this.name = name;
        this.workshops = new TreeSet<Workshop>(set);
    }

    public Factory(String name) {
        this.name = name;
        workshops = new TreeSet<Workshop>();
    }

    public Factory() {
        name = "";
        workshops = new TreeSet<Workshop>();
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Workshop> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Set<Workshop> workshops) {
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
        Factory newWorkshops = new Factory(String.format("%s : Workshops with above middle salary - %.2f", name, getMiddleSalaryOfFactory()));
        for (var el : workshops) {
            if (el.getSalary() > getMiddleSalaryOfFactory()) newWorkshops.addWorkshop(el);
        }
        return newWorkshops;
    }

    public Factory getWorkshopsEmptyPositionsBetween(int a, int b) {
        Factory newWorkshops = new Factory(String.format("%s : Workshops empty positions between \"%d\" and \"%d\"", name, a, b));
        Iterator<Workshop> iterator = workshops.iterator();
        while (iterator.hasNext()) {
            Workshop el = iterator.next();
            if (el.getNumberOfPositions() >= a && el.getNumberOfPositions() <= b) newWorkshops.addWorkshop(el);
        }
        return newWorkshops;
    }

    @Override
    public String toString() {
        return String.format(FACTORY_FORMAT_STRING, name, getNumberOfWorkshops());
    }


    // Sorting
    public Factory sortBySalaryDesc() {
        Factory factory = new Factory(String.format("%s : Sort by salary desc",name), new ComparatorSalaryDesc());
        for(var el : workshops){
            factory.addWorkshop(el);
        }
        return factory;
    }

    public Factory sortBySalaryAsc() {
        Factory factory = new Factory(String.format("%s : Sort by salary Asc",name), new ComparatorSalaryAsc());
        for(var el : workshops){
            factory.addWorkshop(el);
        }
        return factory;
    }

    public Factory sortByNameAndSalary() {
        Factory factory = new Factory(String.format("%s : Sort by name and salary",name), new ComparatorTwoFields());
        for(var el : workshops){
            factory.addWorkshop(el);
        }
        return factory;
    }


    //Additional methods
    /*public Factory removeAllWorkshopsWithAboveAvgSalary(){
        var avg = getMiddleSalaryOfFactory();
        for(var el : workshops){
            if(avg < el.getSalary()) workshops.removeAll();
        }
    }*/


}
