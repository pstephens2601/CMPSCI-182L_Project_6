/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import models.*;
import controllers.*;

public class Display extends JPanel {

    private ProgramController program;
    private Graphics2D g2d;
    
    public Display(ProgramController currentProgram) {
        setBackground(new Color(42,128,201));
        setPreferredSize(new Dimension(0, 2000));
        program = currentProgram;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D)g;
        
        Font font = new Font("Helvetica", Font.BOLD, 16);
        g.setFont(font);
        g.setColor(Color.WHITE);
        
        paintCrashList();
    }
    
    public void paintCrashList() {
        
        HashTable table;
        CrashList crashes;
        int yPosition = 100;
        
        
            if (program.getHashTable() != null) {
                table = program.getHashTable();
                crashes = table.getCrashes();
                HashCrash currentCrash = (HashCrash)crashes.getLast();
                
                if (!table.getTableOverflow()) {
                    g2d.drawString("The Crash Count is: " + table.getNumCrashes(), 20, 40);

                    while (currentCrash != null) {
                        String text = "Hash Crash on " + currentCrash.getKey() + " - attempted insertion at index ";
                        text += currentCrash.getCrashIndex() + " - ";
                        text += " inserted at index " + currentCrash.getInsertionIndex() + ".";

                        g2d.drawString(text, 20, yPosition);
                        currentCrash = (HashCrash)currentCrash.getPrevious();
                        yPosition += 30;
                    }
               }
               else {
                    g2d.drawString("Your hash table has run out of room! Please choose a larger size for your table.", 20, yPosition);
               }
          } 
    }
}
