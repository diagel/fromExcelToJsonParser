package com.maxdiagel.fromexcel.from_excel_to_json.entity;

import com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle.Vehicle;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle.VehicleType;
import com.maxdiagel.fromexcel.from_excel_to_json.entity.vehicle.VehicleFactory;

import java.io.Serializable;
import java.util.Objects;

public class Consignment implements Serializable {
    // inner data
    private int consignmentNumber;
    private long acceptDate;
    private long departureDate;

    // outer data
    private Address from;
    private Address to;
    private Vehicle vehicle;
    private Organization owner;
    private Organization recipient;

    private Consignment() {
    }

    // the pattern Builder is here
    public static class ConsignmentsBuilder{
        private Consignment consignment;
        public ConsignmentsBuilder() {
            consignment = new Consignment();
        }
        public ConsignmentsBuilder setConsignmentNumber(int number){
            consignment.consignmentNumber = number;
            return this;
        }
        public ConsignmentsBuilder setVehicle(String number, VehicleType type){
            consignment.vehicle = VehicleFactory.getVehicle(number, type);
            return this;
        }
        public ConsignmentsBuilder setFrom(String from){
            consignment.from = AddressMaker.getAddress(from);
            return this;
        }
        public ConsignmentsBuilder setTo(String to){
            consignment.to = AddressMaker.getAddress(to);
            return this;
        }
        public ConsignmentsBuilder setAcceptDate(Long date){
            consignment.acceptDate = date;
            return this;
        }
        public ConsignmentsBuilder setDepartureDate(Long date){
            consignment.departureDate = date;
            return this;
        }
        public ConsignmentsBuilder setOwner(Organization owner){
            consignment.owner = owner;
            return this;
        }
        public ConsignmentsBuilder setRecipient(Organization recipient){
            consignment.recipient = recipient;
            return this;
        }
        public Consignment get(){
            return consignment;
        }
    }

    public int getConsignmentNumber() {
        return consignmentNumber;
    }

    public void setConsignmentNumber(int consignmentNumber) {
        this.consignmentNumber = consignmentNumber;
    }

    public long getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(long acceptDate) {
        this.acceptDate = acceptDate;
    }

    public long getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(long departureDate) {
        this.departureDate = departureDate;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public Address getTo() {
        return to;
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Organization getOwner() {
        return owner;
    }

    public void setOwner(Organization owner) {
        this.owner = owner;
    }

    public Organization getRecipient() {
        return recipient;
    }

    public void setRecipient(Organization recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "Consignment{" +
                "consignmentNumber=" + consignmentNumber +
                ", acceptDate=" + acceptDate +
                ", departureDate=" + departureDate +
                ", from=" + from +
                ", to=" + to +
                ", vehicle=" + vehicle +
                ", owner=" + owner +
                ", recipient=" + recipient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consignment that = (Consignment) o;
        return consignmentNumber == that.consignmentNumber && acceptDate == that.acceptDate && departureDate == that.departureDate && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(vehicle, that.vehicle) && Objects.equals(owner, that.owner) && Objects.equals(recipient, that.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consignmentNumber, acceptDate, departureDate, from, to, vehicle, owner, recipient);
    }
}
