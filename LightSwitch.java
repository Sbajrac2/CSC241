package streams;

public class LightSwitch extends Device implements Toggling {
    public LightSwitch(String id, Room room, String location) {
        super(id, room, location);
    }

    @Override
    public void toggle() {
        if(getState()){
            setState(false);
        }else{
            setState(true);
        }
    }
}

