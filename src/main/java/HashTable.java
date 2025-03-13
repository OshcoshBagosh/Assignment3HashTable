import org.example.List;
import org.example.Player;

public class HashTable {
    private List[] buckets;
    private int numElements;
    private int numBuckets;
    private double loadFactor;

    /**
     * Default Constructor of HashTable Class
     */
    public HashTable(){
        this.buckets = new List[4];
        this.numElements = 0;
        this.numBuckets = 4;
        this.loadFactor = 0.0;
    }

    /**
     * Copy Constructor of HashTable Class
     * @param other
     */
    public HashTable(HashTable other){

    }

    public void add(Player p){
        if (loadFactor > .75)
            this.resize();
        int hash = p.hashCode() % numBuckets;
        buckets[hash].add(p);
        numElements++;
        loadFactor = numElements/numBuckets;
    }

    private void resize(){
        List[] newList = new List[numBuckets*2];
    }
}
