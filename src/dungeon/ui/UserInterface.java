/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import dungeon.Dungeon;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;


/**
 *
 * @author ieva
 */
public class UserInterface implements Runnable {
    //unfinished attempt for UI window
    
    private JFrame frame;
    private Dungeon game;
    
    public UserInterface(Dungeon game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("Dungeon");
        int width = game.getLength()*50;
        int height = game.getHeight()*50;
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel text = new JLabel();
        container.add(text);
    }

    public JFrame getFrame() {
        return frame;
    }
}
