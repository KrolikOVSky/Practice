package com.practice.main.java.listType;

public interface IFactory{
    public String getName();
    public Workshop[] getWorkshops();
    public Workshop getWorkshopById(String id);
    public int getNumberOfWorkshops();
    public void setName(String name);
    public void setWorkshops(Workshop[] workshops);
}
