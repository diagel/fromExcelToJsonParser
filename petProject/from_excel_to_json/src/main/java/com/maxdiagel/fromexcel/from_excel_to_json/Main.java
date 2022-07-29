package com.maxdiagel.fromexcel.from_excel_to_json;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> jsons = FacadeBigFromExcelToJsonListConverter.convert("carrets.xls");
        jsons.stream().forEach(System.out::println);

    }
}
