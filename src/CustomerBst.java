package streams.src;

public class CustomerBst {
    //instance variables
    CustomerNode root;

    //constructors
    public CustomerBst(){
        this.root = null;
    }

    //insert
    public void insert(Customer c){
        if (root == null){
            root = new CustomerNode(c);
        } else {
            root.insert(c);
        }
    }

    //contains-look for value
    public boolean contains(Customer c){
        if (root == null ){
            return false;
        }else {
            return root.contains(c);
        }
    }

    //remove - remove a customer
    public void remove(Customer c){
        if(root != null){
            root = root.remove(c);
        }
    }

    //inOrder
    public String inOrder(){
        if(root != null){
            return root.inOrder();
        }else{
            return "";
        }
    }

    //preOrder
    public String preOrder(){
        if(root != null){
            return root.preOrder();
        }else{
            return "";
        }
    }

    //postOrder
    public String postOrder(){
        if(root != null){
            return root.postOrder();
        }else{
            return "";
        }
    }
}
