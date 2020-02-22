/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnhancingaMovableCircle;

/**
 *
 * @author Asus
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private JButton right,left,up,down;
    private Color c;
    private int width;
    private int height;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height){
       this.width=width;
       this.height=height;
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        left = new JButton("Left");
        left.setMnemonic('l');
        left.setToolTipText("The Circle Move to the left by 20");
        
        right = new JButton("Right");
        right.setMnemonic('r');
        right.setToolTipText("The Circle Move to the right by 20");
        
        up = new JButton("Up");
        up.setMnemonic('u');
        up.setToolTipText("The Circle Move to the up by 20");
        
        down = new JButton("Down");
        down.setMnemonic('d');
        down.setToolTipText("The Circle Move to the down by 20");
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    @Override
    public void paintComponent(Graphics page){
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener{
            private int dx;
            private int dy;


        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy){
            this.dx = dx;
            this.dy = dy;

        }
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        @Override
        public void actionPerformed(ActionEvent e){
            if(x+dx+75> width){
                right.setEnabled(false);
            }else{
                right.setEnabled(true);
            }
            if(x+dx+CIRCLE_SIZE<(CIRCLE_SIZE)){
                left.setEnabled(false);
            }else{
                left.setEnabled(true);
            }
            
            if(y+dy+CIRCLE_SIZE> (CIRCLE_SIZE)){
                down.setEnabled(false);
            }else{
                down.setEnabled(true);
            }
            if(y+dy+CIRCLE_SIZE<(CIRCLE_SIZE)){
                up.setEnabled(false);
            }else{
                up.setEnabled(true);
            }
         
            
            if(y+dy+CIRCLE_SIZE+85> height){
                down.setEnabled(false);
            }else{
                down.setEnabled(true);
            }
            x += dx;
            y += dy;
            repaint();
        }
    }
 
}
