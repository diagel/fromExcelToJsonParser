package com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle;

import java.lang.reflect.Field;

public abstract class Carriage implements Vehicle{
    private String number;
    private VehicleType type;

    public Carriage(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    @Override
    public Field[] getData() {
        return this.getClass().getDeclaredFields();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
