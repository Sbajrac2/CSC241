package streams;

import java.time.LocalDateTime;

public class Reading implements Comparable<Reading> {
    //instance variables
    private Device Device;
    private String units;
    private double value;
    private LocalDateTime timestamp;

    // A constructor method that initializes the Device, units,
    // and value, and sets the timestamp to the current system time.
    // It should also add the new Reading to the specified Device. If
    // the Device parameter is undefined, it should throw an IllegalArgumentException
    public Reading(Device Device, String units, double value){
        if (Device == null){
            throw new IllegalArgumentException("Device parameter is undefined");
        }

        this.Device=Device;
        this.units=units;
        this.value=value;
        this.timestamp=LocalDateTime.now();
        Device.addReading(this);
    }

    // An additional constructor that accepts a `LocalDateTime` reference as the last
    // parameter. This should be used to initialize the time stamp in the object. The
    // constructor should still throw the appropriate exception if the `Device` parameter
    // is undefined.
    public Reading(Device Device, String units, double value, LocalDateTime timestamp){
        if (Device == null){
            throw new IllegalArgumentException("Device parameter is undefined");
        }

        this.Device=Device;
        this.units=units;
        this.value=value;
        this.timestamp=timestamp;
        Device.addReading(this);
    }
    // getDevice() - returns a reference to the Device that produced the reading
    public Device getDevice(){
        return Device;
    }
    // getUnits() - returns a String representing the units of measurement
    public String getUnits(){
        return units;
    }

    // getValue() - returns a double corresponding to the reading's value
    public double getValue(){
        return value;
    }
    // getTimestamp() - Returns a reference to LocalDateTime object that is the timestamp of the reading
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    // toString() - Returns a String representation of the reading
    public String toString() {
        return value + ":" + units + ":" + timestamp;
    }

    @Override
    public int compareTo(Reading o) {
        return this.getTimestamp().compareTo(o.getTimestamp());
    }
}

