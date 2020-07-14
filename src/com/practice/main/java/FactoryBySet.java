package com.practice.main.java;

public class FactoryBySet implements IFactory{


    private String name;
    private Workshop[] workshops;

    public FactoryBySet(String name, Workshop[] workshops) {
        this.name = name;
        this.workshops = workshops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workshop[] getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Workshop[] workshops) {
        this.workshops = workshops;
    }

    public Workshop getWorkshopById(String id){
        return this.workshops[Integer.parseInt(id)];
    }

    public int getNumberOfWorkshops(){
        return this.workshops.length;
    }



}
