package com.maxdiagel.fromexcel.from_excel_to_json;

import com.maxdiagel.fromexcel.from_excel_to_json.entity.Consignment;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.ConsignmentConverter;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.Organization;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.Organizations;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle.VehicleType;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FacadeBigFromExcelToJsonListConverter {
    //1
    public static List<String> convert(String url) throws IOException {
        List<Consignment> consignments = getConsignments(url);
        List<String> jsons = ConsignmentConverter.convertConsignmentsToStrings(consignments);
        return jsons;
    }

    public static List<Consignment> getConsignments(String url) throws IOException {
        List<Consignment> list = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(url);
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();


        while (rowIterator.hasNext()) {
            String tempString = "";
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case _NONE:
                        tempString += "\t";
                        break;
                    case BOOLEAN:
                        tempString += cell.getBooleanCellValue();
                        tempString += "\t";
                        break;
                    case BLANK:
                        tempString += "\t";
                        break;
                    case FORMULA:
                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        tempString += cell.getCellFormula() + "\t";
                        tempString += evaluator.evaluate(cell).getNumberValue();
                        break;
                    case NUMERIC:
                        String string = cell.getNumericCellValue() + "";
                        if (string.equals("")) string = "unknown value";
                        tempString += string + "\t";
                        break;
                    case STRING:
                        String string2 = cell.getStringCellValue();
                        if (string2.equals("")) string = "unknown value";
                        tempString += cell.getStringCellValue() + "\t";
                        break;
                    case ERROR:
                        tempString += "!\t";
                        break;
                }
            }
            list.add(getConsignmentFromString(tempString));
        }
        return list;
    }

    public static Consignment getConsignmentFromString(String string) {
        Consignment.ConsignmentsBuilder consignmentsBuilder = new Consignment.ConsignmentsBuilder();

        String[] strings = string.split("\t");

        VehicleType vehicleType = strings[2].equals("платформа")? VehicleType.CARRIAGE_PLATFORM : strings[2].equals("крытый") ? VehicleType.CARRIAGE_COVER : VehicleType.CARRIAGE_OPEN;

        consignmentsBuilder.setConsignmentNumber((int)Double.parseDouble(strings[0]))
                .setVehicle(strings[1], vehicleType)
                .setFrom(strings[3])
                .setAcceptDate((long)Double.parseDouble(strings[4]))
                .setDepartureDate((long)Double.parseDouble(strings[5]))
                .setOwner(Organizations.get(strings[6]))
                .setRecipient(Organizations.get(strings[8]))
                .setTo(strings[7]);

        return consignmentsBuilder.get();
    }
}
