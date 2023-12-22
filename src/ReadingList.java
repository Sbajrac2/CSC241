package streams.src;

public class ReadingList {
    //instance variables
    ReadingNode head;

    //constructor
    public ReadingList(){
        this.head = null;
    }

    //add
    public void add(Reading a){
        if(head == null){
            head = new ReadingNode(a,null); //first node in list
        }else{
            head.add(a); //list already has nodes, so add new ones
        }
    }

    //size
    public int size(){
        if (head == null){
            return 0; //empty
        }else{
            return head.size();
        }
    }

    //maxValue()
    public Double maxValue() {
        if (head == null) {
            return null;
        } else {
            return head.maxValue();
        }
    }
    //minValue()
    public Double minValue(){
        if (head == null) {
            return null;
        } else {
            return head.minValue();
        }
    }

    //toString
    public String toString() {
        if (head == null) {
            return ""; //empty
        } else {
            return head.toString();
        }
    }

}
