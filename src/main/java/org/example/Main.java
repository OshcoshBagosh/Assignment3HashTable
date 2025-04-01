package org.example;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This Main class tests the HashTable Class using Player dataset
 */
public class Main {

    /**
     * Reads Player file to test HashTable
     * @param args
     */
    public static void main(String[] args) {
        try {
            HashTable ht = new HashTable();
            FileReader fr = new FileReader("players.txt");
            Scanner infile = new Scanner(fr);
            String line;
            String line2;
            int score;
            Player[] pList = new Player[1000];
            int i = 0;

            while (infile.hasNextLine()) {
                line = infile.nextLine();
                line2 = infile.nextLine();
                score = Integer.parseInt(line2);
                Player player = new Player(line, score);
                pList[i] = player;
                i++;
                ht.add(player);
            }

            ht.show();
            System.out.println(ht.find("Sara Rogers").getScore()); //Uses the find method to print score of Player name

            HashTable clone1 = new HashTable(ht);
            System.out.println();
            System.out.println("Clone1:");
            clone1.add(new Player("Oscar Guerrero", 4));
            clone1.show();

            HashTable clone2 = clone1.createClone();
            System.out.println(clone2.find("Oscar Guerrero").getScore());

        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}