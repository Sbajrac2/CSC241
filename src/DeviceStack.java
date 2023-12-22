package streams.src;

public class DeviceStack {
    //instance variables
    DeviceNode top;

    //constructors
    public DeviceStack(){
        this.top = null;
    }

    //push(Device d)- places node on top of stack
    public void push(Device d){
        DeviceNode temp = new DeviceNode(d,null);
        temp.next = top;
        top = temp;
    }

    //pop() - remove top element
    public Device pop(){
        if (top != null){
            //stack isnt empty
            DeviceNode temp = top;
            top = top.next;
            return temp.device;
        }else{
            //stack is empty
            return null;
        }
    }

    //peek() - return top element if present
    public Device peek(){
        if (top == null){
            //stack is empty
            return null;
        }else{
            //return first value
            return top.device;
        }
    }
}
