package by.bsu.hashtable.run;

import by.bsu.hashtable.linearcollizion.entity.HashTable;
import by.bsu.hashtable.generate.Generator;

import java.util.Scanner;

public class RunnerLineCollision {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add(1);
        hashTable.add(2);
        hashTable.add(114);
        hashTable.add(4);
        hashTable.add(117);
        hashTable.add(4);
        hashTable.remove(4);
        hashTable.remove(4);
        hashTable.remove(117);
        System.out.println(hashTable.toString());
        System.out.println(hashTable.find(114));
        Scanner scanner = new Scanner(System.in);
        while(true){
            hashTable.add(scanner.nextLong());
            System.out.println(hashTable.toString());
        }
    }
}
