package com.maxdiagel.fromexcel.from_excel_to_json.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConsignmentConverter {



    public static String convertSingleStringToJson(Consignment consignment){
        ObjectMapper objectMapper = new ObjectMapper();
        String returnedString = null;
        try {
            returnedString = objectMapper.writeValueAsString(consignment);
        } catch (JsonProcessingException e) {
            System.out.println("broken data in consignment # " + consignment.getConsignmentNumber());
        }
        return returnedString;
    }

    public static List<String> convertConsignmentsToStrings(List<Consignment> consignments){
        List<String> jsonStrings = new ArrayList<>();

        for (Consignment c: consignments){
            jsonStrings.add(convertSingleStringToJson(c));
        }

        return jsonStrings;
    }
}
