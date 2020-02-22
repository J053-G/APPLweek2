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
import javax.swing.*;
public class CurrencyConverter{
    public static void main (String[] args){
        JFrame frame = new JFrame ("Currency Converter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        RatePanel ratePanel = new RatePanel ();
        frame.getContentPane().add(ratePanel);
        frame.pack();
        //frame.setSize(400,300);
        frame.setVisible(true);
    }
}
