package streams;

import java.util.ArrayList;

public class Room {
    // Add instance variables
    private String RoomName;
    private String Floor;
    private Building Building;
    //private Device device;
    private Device[] Devices;
    private ArrayList<Device> devices = new ArrayList<>();

    // A constructor that initializes the name, floor, and Building. It
    // should also associate the new Room object to the given Building. If the
    // Building parameter is not defined, it should throw an IllegalArgumentException
    public Room(String RoomName, String Floor, Building Building){
        this.RoomName = RoomName;
        this.Floor = Floor;
        this.Building = Building;
        if(Building == null){
            throw new IllegalArgumentException("building parameter is undefined");
        }
        Building.addRoom(this);
        Devices = new Device[0];
    }
    // getName() - Returns a String that is the room name
    public String getName(){
        return RoomName;
    }
    // getFloor() - Returns a String that is the room's floor within the building
    public String getFloor(){
        return Floor;
    }
    // getBuilding() - Returns a reference to the associated Building object
    public Building getBuilding(){
        return Building;
    }
    // addDevice(Device) - Add a Device to this room
    public void addDevice(Device device){
        //devices = new Device[]{device};
        devices.add(device);
    }
    // getDevices() - Returns an array of Device object references
    public Device[] getDevices(){
        Devices = new Device[devices.size()];
        Devices = devices.toArray(Devices);
        return Devices;
    }

}