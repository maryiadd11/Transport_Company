package entity;

import entity.type.TransportType;

public class Transport {

    private int id;
    private String name;
    private int speed;
    private int seatCapacity;
    private int cargoCapacity;
    private String type;
    private int pricePerKM;

    public Transport(int id, String name, int speed, int seatCapacity, int cargoCapacity, String type, int pricePerKM) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.seatCapacity = seatCapacity;
        this.cargoCapacity = cargoCapacity;
        this.type = type;
        this.pricePerKM = pricePerKM;
    }

    public Transport(int id, String name, int speed, int seatCapacity, int cargoCapacity, int pricePerKM) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.seatCapacity = seatCapacity;
        this.cargoCapacity = cargoCapacity;
        this.pricePerKM = pricePerKM;
    }

    public Transport(int id) {
        this.id = id;
    }

    public Transport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPricePerKM() {
        return pricePerKM;
    }

    public void setPricePerKM(int pricePerKM) {
        this.pricePerKM = pricePerKM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        return id == transport.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", seatCapacity=" + seatCapacity +
                ", cargoCapacity=" + cargoCapacity +
                ", type=" + type +
                ", pricePerKM=" + pricePerKM +
                '}';
    }
}
