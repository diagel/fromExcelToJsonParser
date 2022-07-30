package com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(String number, VehicleType type){
        Vehicle vehicle = null;

        switch (type){
            case TRACK:vehicle = new Track(number, type);
                break;
            default:vehicle = CarriageFactory.getCarriage(number, type);
        }

        return vehicle;
    }
}
