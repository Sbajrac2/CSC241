package streams;

public class Thermostat extends Device implements Recording {
//This class should now implement the Recording interface. Make the following changes:
    //Modify the constructor so that the number of readings is bounded by MAX_READINGS
    //Implement the methods defined by the interface

    public Thermostat(String id, Room room, String location) {
        super(id, room, location);
        this.State = true;
        this.max_reading = MAX_READINGS;
    }

    @Override
    public double getMaxValue() {

        double x = Integer.MIN_VALUE;
        Reading[] readings = this.getReadings();
        for (Reading r: readings) {
            if (r.getValue() > x) {
                x = r.getValue();
            }
        }
        return x;
    }

    @Override
    public double getMinValue() {
        double x = Integer.MAX_VALUE;
        Reading[] readings = this.getReadings();
        for (Reading r: readings) {
            if (r.getValue() < x) {
                x = r.getValue();
            }
        }
        return x;

    }

    @Override
    public double getAverageValue() {
        double x = 0;
        Reading[] readings = this.getReadings();
        for (Reading r: readings) {
            x += r.getValue();
        }
        double average = x * (1.0/readings.length);
        return average;
    }
    public Reading getCurrentReading(){
        return readings.get(this.readings.size()-1);
    }

}