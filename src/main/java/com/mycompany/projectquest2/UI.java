/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectquest2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class UI {
    GameManager gm;
    
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[]= new JPanel[10];
    public JLabel bgLabel[]= new JLabel[10];
    
    public UI(GameManager gm){
        this.gm = gm;
        
        createMainField();
        generateScreen();
        
        window.setVisible(true);
    }
    
    public void createMainField(){
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        messageText = new JTextArea("SMaple texuto");
        messageText.setBounds(50,400,700,150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN,26));
        window.add(messageText);
    }
    
    public void createBackground(int bgNum,String bgFileName){
        bgPanel[bgNum]= new JPanel();
        bgPanel[bgNum].setBounds(50,50,700,350);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[1]);
        
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,700,350);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);
        
        //bgPanel[1].add(bgLabel[1]); need to switch the order so that the background is below the object
        
    }
    public void createObject(int bgNum,int objx,int objy,int objWidth,int objHeight,String objFileName,
            String choice1Name,String choice2Name,String choice3Name){
        
        JPopupMenu popMenu = new JPopupMenu();
        
        JMenuItem menuItem[] = new JMenuItem[4]; //use [1] [2] and [3] dont use [0]
        
        menuItem[1] = new JMenuItem(choice1Name);
        popMenu.add(menuItem[1]);
        
        menuItem[2] = new JMenuItem(choice2Name);
        popMenu.add(menuItem[2]);
        
        menuItem[3] = new JMenuItem(choice3Name);
        popMenu.add(menuItem[3]);
        
        
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objWidth,objHeight);
        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
        objectLabel.setIcon(objectIcon);
        
        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        
        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }
    public void generateScreen(){
        //screen 1
        createBackground(1,"greenbg700x350.jpeg");
        createObject(1,440,140,200,200,"hut 200x200.png","Look","Talk","Rest");
        createObject(1,90,195,150,150,"guard 150x150.png","Sarvesh bhosadiwala","Talk","Attack");
        createObject(1,320,280,70,70,"chest 70x70.png","Look","Talk","Open");
    }
}
