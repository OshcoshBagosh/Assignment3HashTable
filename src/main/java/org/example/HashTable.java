package org.example;
import org.example.List.Node;

/**
 * This Class Implements a HashTable and contains methods to add and search Player Objects
 */
public class HashTable {
    private List[] buckets;
    private int numElements;
    private int numBuckets;
    private double loadFactor;

    /**
     * Default Constructor of org.example.HashTable Class
     */
    public HashTable(){
        this.buckets = new List[4];
        this.numElements = 0;
        this.numBuckets = 4;
        this.loadFactor = 0.0;
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new List();
        }
    }

    /**
     * Copy Constructor of org.example.HashTable Class
     * @param other
     */
    public HashTable(HashTable other){
        this.buckets = new List[other.numBuckets];
        this.numElements = other.numElements;
        this.numBuckets = other.numBuckets;
        this.loadFactor = other.loadFactor;
        for (int i = 0; i < this.numBuckets; i++) {
            this.buckets[i] = other.buckets[i].createClone();
        }
    }

    /**
     *
     * @return Clone HashTable of original HashTable
     */
    public HashTable createClone(){
        HashTable clone = new HashTable(this);
        return clone;

    }

    /**
     *
     * @param p
     * @return index for hashing based in Player name
     */
    private int hash(Player p){
        return p.hashCode() % numBuckets;
    }

    /**
     * Adds Player Object to HashTable
     * @param p
     */
    public void add(Player p){
        if (loadFactor > 0.75) //checks if load factor is greater than 0.75
            this.resize();
        int key = this.hash(p);
        buckets[key].add(p);
        numElements +=1;
        loadFactor = (double)numElements/numBuckets;
    }

    /**
     * Resizes the Hashtable array if the load factor is too high
     */
    private void resize(){
        int oldNum = numBuckets;
        this.numBuckets *= 2;
        numElements = 0;
        List[] newList = new List[numBuckets];
        List[] tempList = this.buckets;
        this.buckets = newList;
        loadFactor = (double) numElements / numBuckets;
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new List();
        }
        Node temp;

        for (int i = 0; i < oldNum; i++) {
            temp = tempList[i].getHead();
            while (temp != null){
                this.add(temp.data);
                temp = temp.next;
            }
        }
    }

    /**
     * Locates the index of array by hashing name
     * searches for name in the List of the index
     * @param name
     * @return Player if name matches Player name
     */
    public Player find(String name){
        Player p = new Player(name, 0);
        int key = hash(p);
        return buckets[key].find(name);
    }

    /**
     * Prints the buckets and lists of players in each bucket
     */
    public void show(){
        Node temp;
        for (int i = 0; i < numBuckets; i++) {
            temp = buckets[i].getHead();
            System.out.print("Bucket " + i + ": [");
            while (temp != null){
                System.out.print("(" + temp.data.getName() + ", " + temp.data.getScore() + ")");
                temp = temp.next;
            }
            System.out.println("]");

        }
    }
}
