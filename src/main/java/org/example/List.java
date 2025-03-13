package org.example;
public class List {
    /**
     * The Node class will hold the Player data in the list
     */
    public class Node{
        private Player data;
        private Node next;

        /**
         * Default constructor of Node class
         */
        public Node(){
            this.data = null;
            this.next = null;
        }

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
        while (temp.next != null){
            if (temp.data.getName().equals(name))
                return temp.data;
            temp = temp.next;
        }
        return null;
    }
}
