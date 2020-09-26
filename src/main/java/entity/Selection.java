package entity;

public class Selection {

    private City cityFrom;
    private City cityTo;
    private int passengers;
    private int cargo;

    public Selection(City cityFrom, City cityTo, int passengers, int cargo) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.passengers = passengers;
        this.cargo = cargo;
    }

    public Selection() {
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "Selection{" +
                "cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", passengers=" + passengers +
                ", cargo=" + cargo +
                '}';
    }
}
