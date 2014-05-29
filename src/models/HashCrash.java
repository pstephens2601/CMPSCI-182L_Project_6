/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author Owner
 */
public class HashCrash extends Link {
    
    private int crashIndex;
    private int insertionIndex;
    private String key;
    
    public HashCrash() {
        
    }
    
    public HashCrash(int newCrashIndex, int newInsertionIndex, String newKey) {
        setCrashIndex(newCrashIndex);
        setInsertionIndex(newInsertionIndex);
        setKey(newKey);
    }
    
    public int getCrashIndex() {
        return crashIndex;
    }
    
    public int getInsertionIndex() {
        return insertionIndex;
    }
    
    public String getKey() {
        return key;
    }
    
    public final void setCrashIndex(int newCrashIndex) {
        crashIndex = newCrashIndex;
    }
    
    public final void setInsertionIndex(int newInsertionIndex) {
        insertionIndex = newInsertionIndex;
    }
    
    public final void setKey(String newKey) {
        key = newKey;
    }
}
