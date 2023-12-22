package streams;

public class Customer implements Comparable<Customer> {
    // Add instance variables
    private String LastName;
    private String FirstName;
    private Building building;

    // A constructor that initializes the last name and first name
    public Customer(String LastName, String FirstName) {
        this.LastName = LastName;
        this.FirstName = FirstName;
    }
    // getLastName() - Returns a String that is the customer’s last name
    public String getLastName() {
        return LastName;
    }

    // getFirstName() - Returns a String that is the customer’s first name
    public String getFirstName() {
        return FirstName;
    }

    //getFullName() - Returns a String containing "lastname, firstname"
    public String getFullName(){return LastName +", " +FirstName;}

    // getBuilding() - Returns a reference to the Building object associated with this customer
    public Building getBuilding() {
        return building;
    }

    // setBuilding(Building) - Sets the Building for this customer
    public void setBuilding(Building building) {
        this.building = building;
    }

    public String toString() {
        return LastName + ", " + FirstName;
    }

    public int compareTo(Customer o){
        if(this.LastName.compareTo(o.LastName) != 0){
            return this.LastName.compareTo(o.LastName);
        }else if (this.LastName.compareTo(o.LastName) == 0){
            if (this.FirstName.compareTo(o.FirstName) != 0){
                return this.FirstName.compareTo(o.FirstName);
            }else if(this.FirstName.compareTo(o.FirstName) == 0){
                return this.getBuilding().getName().compareTo(o.getBuilding().getName());
            }
        }
        return 0;
    }
}
