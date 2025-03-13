package org.example;

import java.util.Objects;

/**
 * This class contains methods and attributes for the Player Object
 */
public class Player {

    /**
     * Score of Player
     */
    private int score;

    /**
     * Name of Player
     */
    private String name;

    /**
     * Default Construct of Player object
     */
    public Player(){
        this.name = "";
        this.score = 0;
    }

    /**
     * Overloads default constructor allowing name and score to be set
     * @param name
     * @param score
     */
    public Player(String name, int score){
        this.name =  name;
        this.score = score;
    }

    /**
     * Copy Constructor of Player Object
     * @param other
     */
    public Player(Player other){ //Copy constructor
        this.name = other.name;
        this.score = other.score;
    }

    /**
     * Sets name of Player
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Name of Player
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets score of Player
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return Score of Player
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return Deep copy Player of original Player
     */
    public Player createClone(){
        Player clone = new Player(this);
        return clone;
    }

    /**
     * overrides equals() method so Players with the same name are equal
     * @param o
     * @return True or False
     */
    @Override
    public boolean equals(Object o){
        Player player = (Player)o; //casts Object to Player
        if (this.name.equals(player.name)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name);
    }


}
