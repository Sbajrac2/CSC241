package streams.src;

import java.util.ArrayList;

public abstract class Device {
    // Add instance variables
    protected String id;
    //protected String type;
    protected Room room;
    protected String location;
    protected Reading reading;
    protected ArrayList<Reading> readings = new ArrayList<>();
    protected boolean State;
    protected int max_reading;

    // The constructor uses parameters to initialize id, room, and location. The
    // initial state should be set to false (off), and the initial Readings collection
    // should be empty. It should also add the device
    // to the specified room. If the Room parameter is not defined, it should
    // throw an IllegalArgumentException.
    public Device(String id, Room room, String location){
        if (room == null){
            throw new IllegalArgumentException("Room parameter is undefined");
        }
        this.id = id;
        this.room = room;
        this.location = location;
        this.State = false;
        room.addDevice(this);
    }

    //Add a new parameter to the constructor that accepts and stores the maximum number of readings
    public Device(String id, Room room, String location,int max_reading){
        if (room == null){
            throw new IllegalArgumentException("Room parameter is undefined");
        }
        this.id = id;
        this.room = room;
        this.location = location;
        this.State = false;
        room.addDevice(this);
        this.max_reading = max_reading;
    }

    // getId() - Returns a String that is the sensor devices's identifier
    public String getId(){
        return id;
    }
    // getRoom() - Returns a reference to the Room where the sensor is located
    public Room getRoom(){
        return room;
    }
    // getLocation() - Returns a String indicating where in the Room the device was placed
    public String getLocation(){
        return location;
    }
    // getState() - Returns a boolean that is the state of the device
    public boolean getState(){
        return State;
    }
    // setState() - Updates the state of the device
    public void setState(boolean State){
        this.State=State;
    }

    // getReadings() - Returns an array of readings
    public Reading[] getReadings(){

        Reading[] read=new Reading[readings.size()]; // making new array with specific length after adding list in arraylist
        read=readings.toArray(read); //toArray means converting arraylist to array. and put value in new array called "read"
        return read;
    }
    // addReading() - This method adds a new reading to the collection. If the
    // collection has reached the 5 readings, remove the oldest
    // reading before adding the new one
    public void addReading(Reading r) {
        if(max_reading == 0){
            return;
        }
        if(readings.size() >= max_reading) {
            readings.remove(0);
        }
        readings.add(r);

    }
    public String toString(){
        return "{" + id + ":" + location + ":" + State + "}";
    }

}

