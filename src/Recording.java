package streams.src;

public interface Recording {
    int MAX_READINGS = 10; //has to be assigned to constant

    public double getMaxValue();
    public double getMinValue();
    public double getAverageValue();

}

