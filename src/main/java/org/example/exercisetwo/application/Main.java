package org.example.exercisetwo.application;

import org.example.exercisetwo.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            List<Employee> list = new ArrayList<>();


            String line = br.readLine();
            while(line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                String email = fields[1];
                Double employeeSalary = Double.parseDouble(fields[2]);

                list.add(new Employee(name, email, employeeSalary));
                line = br.readLine();
            }

            Comparator<Employee> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());


            System.out.println("Email of people whose salary is more than " + salary + ": ");
            list.stream().filter(p -> p.getSalary() > salary).sorted(comp).map(Employee::getEmail).forEach(System.out::println);

            Double sum = list.stream().filter(p -> p.getName().startsWith("M")).map(Employee::getSalary).reduce(0.0, (Double::sum));

            System.out.println("Sum of salary of people whose name start with 'M': " + sum);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }



        sc.close();
    }
}
