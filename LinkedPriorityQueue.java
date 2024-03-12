/**
 * Author: Michael Leong
 * Date: 10/19/22
 * Filename: Priority queue class type using linked lists
 */

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T>{

    /* Fields */
    private Node firstNode;
    private Node lastNode;
    private int numOfEntries;

    /* Constructor */
    public LinkedPriorityQueue(){
        firstNode = null;
        lastNode = null;
        numOfEntries = 0;
    }

    /* Implementing Methods */
    public void add(T newEntry){
        //Create a new node to store the entry data
        Node newNode = new Node(newEntry, null);
        //when the list is empty, the new node will be both the first and last node
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }
        //if the new node is the greatest
        else if(newEntry.compareTo(lastNode.getData()) < 0){
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        //if the new node is the least
        else if(newEntry.compareTo(firstNode.getData()) >= 0){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        //find a location in the list for the new node
        else{
            //track the node to compare to
            Node compareNode = firstNode;
            //while the node has not found a location yet
            while(!(compareNode.getNextNode() == newNode)){
                //if the node is greater than the current node but less than the next node
                if(newEntry.compareTo(compareNode.getNextNode().getData()) <= 0){
                    //set the new node between the current node and the next node
                    newNode.setNextNode(compareNode.getNextNode());
                    compareNode.setNextNode(newNode);
                }
                else{
                    //if the current
                    compareNode = compareNode.getNextNode();
                }
            }
        }
        numOfEntries++;
    }

    public T remove(){
        if(isEmpty()){
            throw new IllegalStateException("Tried to remove from empty list");
        }
        Node tempCopy = firstNode;
        firstNode = firstNode.getNextNode();
        numOfEntries--;
        return tempCopy.getData();
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        else {
            return firstNode.getData();
        }
    }

    public boolean isEmpty(){
        return firstNode == null && lastNode == null;
    }

    public int getSize(){
        return numOfEntries;
    }

    public void clear(){
        firstNode = null;
        lastNode = null;
        numOfEntries = 0;
    }

    /* Other Methods */
    public void view(){
        if(isEmpty()){
            System.out.println("Linked List is empty.");
        }
        else {
            Node currentNode = firstNode;
            while (!(currentNode.equals(lastNode))) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(lastNode.getData());
        }
    }

    public void remove(T anEntry){
        if(isEmpty()){
            throw new IllegalStateException("Tried to remove from empty list");
        }
        //edge cases
        if(firstNode.equals(lastNode) && firstNode.getData().equals(anEntry)){ //theres only one node
            firstNode = null;
            lastNode = null;
            numOfEntries = 0;
        }
        else if(firstNode.getData().equals(anEntry)){ //first node is the target entry
            firstNode = firstNode.getNextNode();
            numOfEntries--;
        }
        else {
            Node curr = firstNode;
            //until the end of the linked list
            while (!curr.getNextNode().equals(lastNode)) {
                if (curr.getNextNode().getData().equals(anEntry)) {
                    curr.setNextNode(curr.getNextNode().getNextNode());
                    numOfEntries--;
                    return;
                }
                //continue to next node if the desired entry was not found
                curr = curr.getNextNode();
            }
            if(lastNode.getData().equals(anEntry)){ //the last node being the target is also an edge case
                curr.setNextNode(null);
                lastNode = curr;
                numOfEntries--;
                return;
            }
            //throw new IllegalStateException("Entry was not found in the list");
        }
    }

    /*
    //if .equals is overloaded, this can get the actual obj using the data that the overloaded .equals checks
    public T getEntryOf(T entryData){
        if(isEmpty()){
            throw new IllegalStateException("Tried to retrieve from empty list");
        }
        Node curr = firstNode;
        //until the end of the linked list
        while(!curr.getNextNode().equals(lastNode)){
            //if using an overloaded .equals, say that compares a string field member, return the actual object
            if(curr.getNextNode().getData().equals(entryData)){
                return curr.getNextNode().getData();
            }
            //continue to next node if the desired entry was not found
            curr = curr.getNextNode();
        }
        throw new IllegalStateException("Entry was not found in the list");
    }
     */

    /* Copy-Pasted Node Class */
    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
}
