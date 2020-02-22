/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurencyConverter;

/**
 *
 * @author Asus
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RatePanel extends JPanel{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JComboBox currencylist;
    private JLabel result;
    private JTextField field;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel (){
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        field = new JTextField("0");
        field.setColumns(10);
        field.setAlignmentX (Component.CENTER_ALIGNMENT);
        currencylist = new JComboBox<>(currencyName);
        currencylist.addActionListener(new ComboListener());
        currencylist.setAlignmentX (Component.CENTER_ALIGNMENT);
        
        
        rate = new double [] {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};
        result = new JLabel (" ------------ ");
        add (Box.createRigidArea(new Dimension(0,5)));
        add(title);
        add (Box.createRigidArea(new Dimension(0,5)));
        add(field);
        add (Box.createRigidArea(new Dimension(0,5)));
        add(currencylist);
        add (Box.createRigidArea(new Dimension(0,5)));
        add (result);
    }
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener{
        
        
    // --------------------------------------------------
    // Determines which currency has been selected and
    // the value in that currency then computes and
    // displays the value in U.S. Dollars.
    // --------------------------------------------------
        @Override
        public void actionPerformed (ActionEvent event){
            try{
                int data = Integer.parseInt(field.getText());
                int index = currencylist.getSelectedIndex();
                double count= data*rate[index];
                result.setText (data + " " + currencyName[index] +
                " = " + count + " U.S. Dollars");
            }catch(NumberFormatException ex){
                result.setText("Invalid data input");
                JOptionPane.showMessageDialog(null, "Number too much");
            }
        }
    } 
}
