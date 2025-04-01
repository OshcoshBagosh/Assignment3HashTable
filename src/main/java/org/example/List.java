package org.example;

/**
 * This Class implements the properties of a singly Linked List
 */
public class List {
    /**
     * The Node class will hold the Player data in the list
     */
    public class Node{
        public Player data;
        public Node next;

        /**
         * Default constructor of Node class
         */
        public Node(){
            this.data = null;
            this.next = null;
        }

        /**
         * Constructor that takes Player as data
         * @param p
         */
        public Node(Player p){
            this.data = p;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    /**
     * Default Constructor of List class
     */
    public List(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Copy Constructor of List class
     * @param other
     */
    public List(List other){
        Node temp = other.head;
        while (temp != null){
            this.add(temp.data.createClone());
            temp = temp.next;
        }
    }

    /**
     *
     * @return Deep copy of original clone
     */
    public List createClone(){
        List clone = new List(this);
        return clone;
    }

    /**
     *
     * @return head of List
     */
    public Node getHead(){
        return this.head;
    }

    /**
     * Adds a player object to Singly Linked List
     * @param p
     */
    public void add(Player p){
        Node node = new Node(p);
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            Node temp;
            temp = head;
            head = node;
            head.next = temp;
        }
        size++;
    }

    /**
     * Finds and returns player that has the same name
     * @param name
     * @return Player with the same name
     */
    public Player find(String name){
        Node temp = head;
        while (temp != null){
            if (temp.data.getName().equals(name))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }
}
