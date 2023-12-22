package streams.src;

public class ReadingNode {
    //instance variables
    Reading reading;
    ReadingNode next; // this is reference to next list item

    //constructor
    public ReadingNode(Reading reading, ReadingNode next){
        this.reading = reading;
        this.next = next;
    }

    // add
    public void add(Reading a) {
        //base case
        if (next == null) { //i.e. last node
            next = new ReadingNode(a,null); //create Node
        }else{ //pass to the next node
            next.add(a);
        }
    }

    //size
    public int size(){
        //base case
        if (next == null){
            return 1; //since last node
        }else{
            return 1 + next.size();
        }
    }


    //max value
    public Double maxValue(){
        double maxValue = reading.getValue();
        if(next!= null){
            if (maxValue < next.maxValue()){
                maxValue = next.maxValue();
            }
        }
        return maxValue;
    }

    //minValue()
    public Double minValue(){
        double minValue = reading.getValue();
        if (next!= null){
            if (minValue > next.minValue()) {
                minValue = next.minValue();
            }
        }
        return minValue;
    }

    //toString
    public String toString() {
        if (next == null) {
            return reading.toString();
        } else {
            return reading.toString() +"\nnex"+ next.toString();
        }
    }
}
