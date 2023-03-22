package org.internship;

import org.internship.model.City;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String FILE_PATH = "src/main/resources/Задача ВС Java Сбер.csv";

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while(scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(";");

                String name = fields[1];
                String region = fields[2];
                String district = fields[3];
                int population = Integer.parseInt(fields[4]);
                String foundation = "";

                if(fields.length > 5) {
                    foundation = fields[5];
                }

                City city = new City(name, region, district, population, foundation);
                cities.add(city);
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        cities.forEach(System.out::println);

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for(int i = 0; i < cities.size(); i++) {
            City curCity = cities.get(i);

            if(curCity.getPopulation() > max) {
                max = curCity.getPopulation();
                maxIndex = i;
            }
        }

        System.out.printf("[%s] = %s", maxIndex, max);
    }
}
