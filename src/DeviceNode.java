package streams.src;

public class DeviceNode {
    //instance variable
    Device device;
    DeviceNode next;

    //constructors
    public DeviceNode(Device device, DeviceNode next){
        this.device = device;
        this.next = next;
    }
}
