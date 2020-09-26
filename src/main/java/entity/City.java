package entity;

public class City {

    private int id;
    private String name;
    private double length; //широта
    private double width; //долгота
    private boolean hasAirport;
    private boolean hasSeaPort;

    public City(int id, String name, double length, double width, boolean hasAirport, boolean hasSeaPort) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
        this.hasAirport = hasAirport;
        this.hasSeaPort = hasSeaPort;
    }

    public City() {
    }

    public City(String name) {
        this.name = name;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public boolean isHasAirport() {
        return hasAirport;
    }

    public void setHasAirport(boolean hasAirport) {
        this.hasAirport = hasAirport;
    }

    public boolean isHasSeaPort() {
        return hasSeaPort;
    }

    public void setHasSeaPort(boolean hasSeaPort) {
        this.hasSeaPort = hasSeaPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", hasAirport=" + hasAirport +
                ", hasSeaPort=" + hasSeaPort +
                '}';
    }
}
