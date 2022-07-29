package com.maxdiagel.fromexcel.from_excel_to_json.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Organizations {
    private static List<Organization> organizations;

    static {
        organizations = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("organizations"))){
            while (scanner.hasNext()){
                organizations.add(new Organization(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Organization get(String organizationString){

        Organization organization = new Organization(organizationString);

        if (organizations.contains(organization)){
            organization = organizations.get(organizations.indexOf(organization));
        }else {
            organizations.add(organization);
            try (PrintWriter printWriter = new PrintWriter(new FileWriter("organizations", true))){
                printWriter.println(organizationString);
            } catch (IOException e) {
                System.out.println("ERROR: wrong filename");;
            }
        }
        return organization;
    }
}
