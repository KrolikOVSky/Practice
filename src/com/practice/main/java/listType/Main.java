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
            workshop.setId(content[el]);
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

//        return content;
        return workshops;
    }

    public static void main(String[] args) {
        FactoryByList cars = new FactoryByList("Cars", fileToList("cars"));
        FactoryByList phones = new FactoryByList("Cars", fileToList("phones"));

        System.out.println("Workshops without sorting");
        cars.print();

        System.out.printf("Trying add workshop: \n\t id = %s\n\t name = %s\n\t numberOfPositions = %s\n\t numberOfWorkers = %s\n\t salary = %s\n\t adding is %s\n\n", "8", "\"Lights\"", 44, 56, 25000.0, cars.addWorkshop(new Workshop("8", "Lights", 44, 56, 25000.0)));

        System.out.println("Workshops with simple sorting");
        cars.sortById().print();

        System.out.println("Workshops with sorting by salary from small to big");
        cars.getWorkshopsWithAboveMiddleSalary().sortBySalarySmallToBig().print();

        System.out.println("Workshops with sorting by salary from big to small");
        cars.getWorkshopsEmptyPositionsBetween(15, 30).sortBySalaryBigToSmall().print();


    }
}
