package com.practice.main.java.listType;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Workshop> fileToList(String fileName) {
        String[] content = new String[0];
        try {
            content = Files
                    .readString(Paths.get("src/resources/" + fileName + ".txt"))
                    .replaceAll("\r\n", "")
                    .replaceAll("\n", "")
                    .replaceAll("\r", "")
                    .split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Workshop> workshops = new ArrayList<Workshop>();
        var el = 0;
        for (var i = 0; i < content.length / 5; i++) {
            Workshop workshop = new Workshop();
            workshop.setId(Long.parseLong(content[el]));
            el++;
            workshop.setName(content[el]);
            el++;
            workshop.setNumberOfPositions(Integer.parseInt(content[el]));
            el++;
            workshop.setNumberOfWorkers(Integer.parseInt(content[el]));
            el++;
            workshop.setSalary(Double.parseDouble(content[el]));
            el++;
            workshops.add(workshop);
        }
        return workshops;
    }

    public static void main(String[] args) {
        Factory cars = new Factory("Cars", fileToList("cars"));
        Factory phones = new Factory("Phones", fileToList("phones"));

        System.out.println("***************Factory list without sorting***************");
        cars.print();

        System.out.printf("Trying add workshop: \n\t id = %s\n\t name = %s\n\t numberOfPositions = %s\n\t numberOfWorkers = %s\n\t salary = %s\n\t adding is ", "8", "\"Lights\"", 44, 56, 25000.0);
        System.out.printf("%s\n\n", cars.addWorkshop(new Workshop(8, "Lights", 44, 56, 25000.0)));
        System.out.println("***************After adding new workshop***************\n");
        System.out.println("********Factory list with simple sorting********");
        cars.sortById().print();
        System.out.println("********Factory list with sorting by salary from small to big********");
        cars.getWorkshopsWithAboveMiddleSalary().sort(new ComparatorSalaryAsc()).print();
        System.out.println("********Factory list with sorting by salary from big to small********");
        cars.getWorkshopsEmptyPositionsBetween(15, 30).sort(new ComparatorSalaryDesc()).print();

        System.out.print("Removing workshop by id 3: ");
        System.out.printf("%s\n", cars.removeWorkshop(3));
        System.out.println("****************After removing workshop****************\n");
        System.out.println("********Factory list with simple sorting********");
        cars.sortById().print();

        System.out.println("****************Factory list of phones****************\n");
        phones.print();
        System.out.println("********Factory list with sorting by salary and name********");
        phones.sortBySalaryAndName().print();
        System.out.println("********Factory list with sorting by salary from small to big********");
        phones.getWorkshopsWithAboveMiddleSalary().sort(new ComparatorSalaryAsc()).print();
        System.out.println("********Factory list with sorting by salary from big to small********");
        phones.getWorkshopsEmptyPositionsBetween(10, 25).sort(new ComparatorSalaryDesc()).print();

        var n = 10;
        Workshop workshop = cars.getWorkshopById(n);
        if (workshop == null) System.out.printf("At factory %s don't have workshop with id %d\n\n", cars.getName(), n);
        else System.out.println(cars);

        n = 13;
        workshop = cars.getWorkshopById(n);
        if (workshop == null) System.out.printf("At factory %s don't have workshop with id %d\n\n", cars.getName(), n);
        else System.out.println(cars);

        n = 10;
        workshop = phones.getWorkshopById(n);
        if (workshop == null)
            System.out.printf("At factory %s don't have workshop with id %d\n\n", phones.getName(), n);
        else System.out.println(phones);
    }
}
