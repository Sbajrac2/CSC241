package streams;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

  // NOTE: The handler is getting increasingly complicated.
  // Use your debugger to verify the correct values are being read!

  // Instances created from input
  Customer currentCustomer = null; // Reference to the current Customer
  Building currentBuilding = null; // Reference to the current Building
  Room currentRoom = null; // Reference to the current Room
  Device currentDevice = null;  // Reference to the current Device
  Reading currentReading = null; // Reference to the current Reading
  ArrayList<Customer> customerList = new ArrayList<>(); // List of customers
  HashMap<String, Device> devices = new HashMap<>(); // HashMap of devices

  @Override
  public void startElement(String uri, String localName, String qName,
                           Attributes attributes) throws SAXException {
    if(qName.equals("customer")){
      String lastName = attributes.getValue("lastName");
      String firstName = attributes.getValue("firstName");
      currentCustomer = new Customer(lastName,firstName);
    }else if(qName.equals("building")){
      String name = attributes.getValue("name");
      String latitude = attributes.getValue("latitude");
      String longitude = attributes.getValue("longitude");
      String type = attributes.getValue("type");
      if (type == null) {
        currentBuilding = new Residence(name, Double.parseDouble(latitude), Double.parseDouble(longitude), currentCustomer);
      }else{
        currentBuilding = new CommercialBuilding(name, Double.parseDouble(latitude),Double.parseDouble(longitude),currentCustomer,type);
      }
    } else if (qName.equals("room")) {
      String floor = attributes.getValue("floor");
      String name = attributes.getValue("name");
      currentRoom = new Room(name, floor, currentBuilding);
    } else if (qName.equals("device")) {
      // If so, store each of the device attribute values
      String type = attributes.getValue("type");
      String id = attributes.getValue("id");
      String location = attributes.getValue("location");
      // Determine type of device and instantiate accordingly
      if(type.equals("thermostat")) {
        currentDevice = new Thermostat(id, currentRoom, location);// cannot instantiate abstract class device
      }
      else if (type.equals("lightSwitch")){
        currentDevice = new LightSwitch(id, currentRoom,location);
      } else{
        int timeout = Integer.parseInt(attributes.getValue("timeout"));
        currentDevice = new Motion(id,currentRoom,location,timeout);
      }
    }
    // If not a device, check for a reading
    else if(qName.equals("reading")){
      // If the tag is for a reading, store the attrributes and
      String units = attributes.getValue("units");
      String value = attributes.getValue("value");
      String timestamp = attributes.getValue("timestamp");
      // instantiate the current Reading
      currentReading = new Reading(currentDevice ,units,Double.parseDouble(value), LocalDateTime.parse(timestamp));
      currentDevice.addReading(currentReading);
    }
  }


  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if(qName.equals("device")){
      devices.put(currentDevice.getId(), currentDevice);
    }
    if(qName.equals("customer")){
      customerList.add(currentCustomer);
    }

  }

  // Return Device HashMap
  public HashMap<String,Device> getDevices() {
    return devices;
  }

  // Return Customer list
  public ArrayList<Customer> getCustomers() {
    return customerList;
  }
}


