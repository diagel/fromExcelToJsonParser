package com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle;

public class CarriageFactory {
    public static Carriage getCarriage(String number, VehicleType type){
        Carriage carriage = null;

        switch (type){
            case CARRIAGE_OPEN:carriage = new CarriageOpen(number, type);
            break;
            case CARRIAGE_COVER:carriage = new CarriageCover(number, type);
            break;
            case CARRIAGE_PLATFORM:carriage = new CarriagePlatform(number, type);
        }

        return carriage;
    }
}
