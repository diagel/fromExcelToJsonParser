package com.maxdiagel.fromexcel.from_excel_to_json.entity;

import java.util.Objects;

public class Organization {
    private String inn;
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(inn, that.inn) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn, name);
    }
}
