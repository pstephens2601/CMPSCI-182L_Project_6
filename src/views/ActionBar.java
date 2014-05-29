/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.ProgramController;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ActionBar extends JPanel implements ActionListener {
    
    private ProgramController program;
    private JButton exit;
    private JButton create;
    private JTextField inputField;
    
    public ActionBar(ProgramController newProgram) {
        
        program = newProgram;
        setBackground(Color.BLACK);
        
        addButtons();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            program.buildHashTable(Integer.parseInt(inputField.getText()));    
            program.displayCrashes();
        }
    }
    
    private void addButtons() {
        inputField = new JTextField(5);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        
        create = new JButton("Create Hash");
        create.addActionListener(this);
        
        add(inputField);
        add(create);
        add(exit);
    }
}
