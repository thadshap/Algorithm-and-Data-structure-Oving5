public class LinkedList {
    private Node root;
    private int size;

    // add function to insert elements into the linked list
    public void add(String data){
        size++;
        Node node = new Node(data);
        node.next = root;
        root = node;
    }

    // to print out the list
    public void printList(){
        Node temp = root;
        while (temp != null){
            System.out.print(temp.data + " ; ");
            temp = temp.next;
        }
    }

    // search method
    public boolean lookUp(String name){
        Node temp = root;
        while (temp != null){
            if (temp.data.equals(name)) return true;
            temp = temp.next;
        }
        return false;
    }

    // get the size of the linked list
    public int getSize() {
        return size;
    }

    //inner class Node
    private class Node{
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

}
