package streams;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// No changes are required for this class

public class XmlReader {
  private final String inputFileName;
  private XmlHandler myXmlHandler = null;
  private Device device;

  public XmlReader(String inputFileName) throws IOException,
      ParserConfigurationException, SAXException {
    this.inputFileName = inputFileName;

    // Declare a File object
    File inputFile = new File(inputFileName);

    // Create a SAX parser factory and parser
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();

    // Create an XML handler
    myXmlHandler = new XmlHandler();

    // Parse the file
    saxParser.parse(inputFile, myXmlHandler);
  }

  public HashMap<String,Device> getDevices() {
    // Get the Customers built by the XML handler
    return myXmlHandler.getDevices();
  }

  public ArrayList<Customer> getCustomers() {
    // Get the Customers built by the XML handler
    return myXmlHandler.getCustomers();
  }
}
