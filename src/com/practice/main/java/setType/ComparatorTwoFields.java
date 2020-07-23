package com.practice.main.java.setType;


import java.util.Comparator;

public class ComparatorTwoFields implements Comparator<Workshop> {
    @Override
    public int compare(Workshop workshop1, Workshop workshop2) {
        if(workshop1.getName().compareTo(workshop2.getName()) < 0) return -1;
        else if(workshop1.getName().compareTo(workshop2.getName()) > 0) return 1;
        else if(workshop1.getSalary() < workshop2.getSalary())return 1;
        else if(workshop1.getSalary() == workshop2.getSalary())return 0;
        else return -1;
    }
}
