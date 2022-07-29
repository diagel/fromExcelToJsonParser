package com.maxdiagel.fromexcel.from_excel_to_json.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressMaker {
    // the pattern flyweight is here
    private static List<Address> addresses;
    static {
        addresses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("addresses"))) {
            while (scanner.hasNext()){
                addresses.add(new Address(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Address getAddress(String addressString){
        Address address = new Address(addressString);

        if (addresses.contains(address)){
            address = addresses.get(addresses.indexOf(address));
        }else {
            addresses.add(address);
            try (PrintWriter printWriter = new PrintWriter(new FileWriter("addresses", true))){
                printWriter.println(addressString);
            } catch (IOException e) {
                System.out.println("ERROR: wrong filename");;
            }
        }

        return address;
    }
}
