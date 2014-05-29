/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import views.*;
import models.*;

public class ProgramController {
    
    private Window mainWindow;
    private String[] names = { "fred" , "barney", "tom", "jerry", "larry", "moe","curly", 
        "betty" , "wilma", "bart", "homer", "marge", "maggie", "lisa", 
        "pebbles" , "bambam", "smithers", "burns", "milhouse", "george", "astro", 
        "dino" , "mickey", "minnie", "pluto", "goofy", "donald", "huey", 
        "louie" , "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy", 
        "dopey" , "sleepy", "bambi", "belle", "gaston", "tarzan", "jane", 
        "simba" , "scar", "mufasa", "ariel", "flounder", "bugs", "daffy", 
        "elmer" , "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby", 
        "peggy" , "spot", "pongo", "perdy", "buzz", "potatohead", "woody", 
        "chuckie" , "tommy", "phil", "lil", "angelica", "dill", "spike", 
        "pepe" , "speedy", "yosemite", "sam", "tweety", "sylvester", "granny", 
        "spiderman" , "batman", "superman", "supergirl", "robin", "jimmy","olsen", 
        "thing" , "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman" 
    };
    private HashTable hashTable;
            
    ProgramController() {
        mainWindow = new Window(this);
    }
    
    public HashTable getHashTable() {
        return hashTable;
    }
    
    public void buildHashTable(int size) {
        
        hashTable = new HashTable(size);
        
        for (int i = 0; i < names.length; i++) {
            if (!hashTable.getTableOverflow()) {
                hashTable.insert(names[i]);
            }
        }
    }
    
    public void displayCrashes() {
        mainWindow.repaint();
    }
}
