package streams;

public class CommercialBuilding extends Building{
    // Add instance variables
    private String contactInfo;

    // Constructor
    public CommercialBuilding(String Name, double Longitude, double Latitude, Customer Customer, String contactInfo) {
        super(Name, Longitude, Latitude, Customer);
        this.contactInfo =contactInfo;
    }




    // getContactInfo - Returns a String that is the contact info
    public String getContactInfo(){
        return this.contactInfo;
    }
}