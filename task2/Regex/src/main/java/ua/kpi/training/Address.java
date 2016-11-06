package ua.kpi.training;

/**
 * Class which represents person's home address
 *
 * @author Yurii Krat
 * @version 1.0, 06.11.16
 */
public class Address {

    /**
     * Index of address
     */
    private int index;

    /**
     * Name of the city
     */
    private String city;

    /**
     * Name of the street
     */
    private String street;

    /**
     * Number of the house
     */
    private String houseNumber;

    /**
     * Number of the flat
     */
    private int flatNumber;

    public Address() {

    }

    public Address(int index, String city, String street, String houseNumber, int flatNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }
}
