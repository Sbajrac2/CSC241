package streams.src;

import java.util.Random;

public class CustomerNode {
    //instance variables
    Customer customer;
    CustomerNode left,right;

    //constructors
    public CustomerNode(Customer customer){
        this.customer = customer;
        this.left = this.right = null;
    }

    //insert(Customer)
    public void insert(Customer c) {
        if(c.compareTo(customer)<=0){
            if(left == null){
                left = new CustomerNode(c);
            }else{
                left.insert(c);
            }
        } else{
            if(right == null){
                right = new CustomerNode(c);
            } else {
                right.insert(c);
            }
        }
    }

    public boolean contains(Customer c){
        if (c.compareTo(customer)==0){
            return true;
        } else if (c.compareTo(customer)<0){
            if(left == null){
                return false;
            }else{
                return left.contains(c);
            }
        }else{
            if(right == null){
                return false;
            }else{
                return right.contains(c);
            }
        }
    }

    //remove - remove value from tree
    public CustomerNode remove(Customer c){
        //check subtrees
        if(c.compareTo(customer) <0){
            //delegate to left child
            if(left != null){
                left = left.remove(c);
            }
        }else if(c.compareTo(customer) > 0){
            //delegate to right child
            if(right != null){
                right = right.remove(c);
            }
        }else{
            //root remove
            if(left == null && right == null){
                //case 1 -leaf node
                return null;
            }else if(left != null && right == null){
                //case 2 -node with only left child
                return left;
            }else if(left == null && right !=null){
                //case 3 -node with only right child
                return right;
            }else{
                //case 4 -2 children
                Random r = new Random(); //generate random value

                //1. identify new value
                //2. remove duplicate
                if(r.nextBoolean()){
                    //get max from left
                    customer = left.rightMost();
                    //remove duplicate from left
                    left = left.remove(customer);
                }else{
                    //get min from right
                    customer = right.leftMost();
                    //remove duplicate from right
                    right = right.remove(customer);
                }
            }
        }
        //return self reference
        return this;
    }

    protected Customer rightMost(){
        //return right most value
        if(right == null){
            //no more right children
            return customer;
        }else{
            return right.rightMost();
        }
    }

    protected Customer leftMost(){
        //return left most value
        if(left == null){
            //no left children
            return customer;
        }else{
            return left.leftMost();
        }
    }

    //Traversal

    //inOrder - left - visit - right
    public String inOrder(){
        String treeStr = ""; //initialized to empty string

        //go left
        if(left != null){ //there is left child
            treeStr = treeStr + left.inOrder();
        }

        //visit
        treeStr = treeStr + "[" + customer +  "]";

        //go right
        if(right != null) { //there is right child
            treeStr = treeStr + right.inOrder();
        }

        //return string
        return treeStr;
    }

    //preOrder - visit - left - right
    public String preOrder(){
        String treeStr = ""; //empty

        //visit
        treeStr = treeStr + "[" + customer + "]";

        //left
        if(left != null){
            treeStr = treeStr + left.preOrder();
        }

        //right
        if(right != null){
            treeStr = treeStr + right.preOrder();
        }

        //return string
        return treeStr;
    }

    //postOrder -  left - right - visit
    public String postOrder() {
        String treeStr = ""; //empty

        //left
        if (left != null) {
            treeStr = treeStr + left.postOrder();
        }

        //right
        if (right != null) {
            treeStr = treeStr + right.postOrder();
        }

        //visit
        treeStr = treeStr + "[" + customer + "]";


        //return string
        return treeStr;
    }
}
