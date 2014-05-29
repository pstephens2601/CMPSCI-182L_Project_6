/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import controllers.ProgramController;
import models.*;

public class Window extends JFrame {
   
    private ActionBar buttonBar;
    private Display outputDisplay;
    
    public Window(ProgramController program) {
        setSize(1026, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        buttonBar = new ActionBar(program);
        add(buttonBar, BorderLayout.NORTH);
        
        outputDisplay = new Display(program);
        
        JScrollPane scrollPane = new JScrollPane(outputDisplay);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scrollPane, BorderLayout.CENTER);
        
        setTitle("Hash Crashes");
        setVisible(true);
    }
}
