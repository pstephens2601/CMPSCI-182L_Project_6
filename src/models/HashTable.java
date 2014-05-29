/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

public class HashTable {
    
    private String [] hashTable;
    private CrashList crashes;
    private int arraySize;
    private int numElements = 0;
    private int numCrashes;
    private boolean tableOverflow = false;
    
    public HashTable(int size) {
        arraySize = size;
        hashTable = new String [size];
        crashes = new CrashList();
    }
    
    public int getNumCrashes() {
        return numCrashes;
    }
    
    public String crashesToString(){
        
        String crashList = "";
        
        if(numCrashes > 0) {
            HashCrash currentCrash = (HashCrash) crashes.getLast();
            
            while (currentCrash.getPrevious() != null) {
                crashList += "Hash Crash while inserting " + currentCrash.getKey() + " occured at index : ";
                crashList += currentCrash.getCrashIndex() + "\n";
                currentCrash = (HashCrash)currentCrash.getPrevious();
            }
        }

        return crashList;
    }
    
    public CrashList getCrashes() {
        return crashes;
    }
    
    public boolean getTableOverflow() {
        return tableOverflow;
    }
    
    public void insert(String key) {
        
        int index = hashFunc3(key);
        
        if (numElements < hashTable.length) {
            if (hashTable[index] == null) {
                hashTable[index] = key;
                numElements++;
            }
            else {
                HashCrash crash = new HashCrash();
                crash.setCrashIndex(index);
                crash.setKey(key);
                numCrashes++;
                while (hashTable[index] != null) {
                    if (index < hashTable.length - 1) {
                        index++;
                    }
                    else {
                        index = 0;
                    }
                }
                hashTable[index] = key;
                numElements++;
                crash.setInsertionIndex(index);

                crashes.insertFirst(crash);
            }
        }
        else {
            tableOverflow = true;
        }
    }
    
    public int hashFunc3(String key) {
        int hashVal = 0;
        
        for(int j = 0; j < key.length(); j++) {
            int letter = key.charAt(j) - 96;
            hashVal = (hashVal * 27 + letter) % arraySize;
        }
        return hashVal;
    }
}