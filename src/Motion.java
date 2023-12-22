package streams.src;

import java.time.Duration;

public class Motion extends Device {
    private int timeout;
    public Motion(String id, Room room, String location,int timeout) {
        super(id, room, location);
        this.timeout = timeout;
    }

    public Duration getTimeout(){
        return Duration.ofSeconds(timeout);
    }

    public double getMaxValue(){
        return 0;
    }
    public double getMinValue(){
        return 0;
    }
    public double getAverageValue(){
        return 0;
    }
}

