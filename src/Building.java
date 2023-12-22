package streams.src;

import java.util.ArrayList;

public abstract class Building {
    //instance variables
    private String Name;
    private double Longitude;
    private double Latitude;
    private Customer customer;
    private Room[] Rooms;
    private ArrayList<Room> rooms = new ArrayList<>();

    //constructors
    // A constructor that initializes the name, longitude, latitude, and Customer. It
    // should associate the new Building to the given Customer. If the Customer
    // parameter is not defined, it should throw an IllegalArgumentException
    public Building(String Name, double Longitude, double Latitude, Customer customer){
        if (customer == null){
            throw new IllegalArgumentException("Customer is undefined");
        }else {
            this.Name = Name;
            this.Longitude = Longitude;
            this.Latitude = Latitude;
            this.customer = customer;  //let customer know it's connected to new building
            customer.setBuilding(this); //(this) reference to current object
            Rooms = new Room[0];
        }
    }
    // getName() - returns a String that is the name of the building
    public String getName(){
        return Name;
    }
    // getLongitude() - returns a double that is the building's longitude
    public double getLongitude(){
        return Longitude;
    }
    // getLatitude() - returns a double that is the building's latitude
    public double getLatitude(){
        return Latitude;
    }
    // getCustomer() - Returns a reference to the Customer object associated with this building
    public Customer getCustomer(){
        return customer;
    }
    // addRoom(Room) - Adds a Room object reference to a building
    public void addRoom(Room room) {

        //Rooms = new Room[]{room}; //sets room
        rooms.add(room);

    }
    // getRooms() - Returns an array of Room objects associated with a building
    public Room[] getRooms(){
        Rooms = new Room[rooms.size()];
        Rooms = rooms.toArray(Rooms);
        return Rooms;
    }
}