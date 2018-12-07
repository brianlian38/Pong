//My first swing animation game
//Using KeyListener, MouseMotionListener
//Created by BLian
//Created on Dec 7

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pongprogram implements ActionListener, KeyListener, MouseMotionListener{
	//Properties
	JFrame court;
	pongpanel panel;
	Timer timer;
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == timer){
			panel.repaint();
		}
	}
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == 38){ 
			panel.blnP1Up = false; 
		}else if(evt.getKeyCode() == 40){ 
			panel.blnP1Down = false;
		}
	}
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyCode() == 38){ 
			panel.blnP1Up = true; 
		}else if(evt.getKeyCode() == 40){ 
			panel.blnP1Down = true;
		}
	}
	public void keyTyped(KeyEvent evt){
		
	}
	
	
	//This is a overridden method for MouseMotionListener
	public void mouseMoved(MouseEvent evt){
		int R = evt.getY();
		if(R >= 20 && R <= 620){
			panel.intP2Y = evt.getY();
		}		
	}
	public void mouseDragged(MouseEvent evt){
	}
	
	//Constructor
	public pongprogram(){
		court = new JFrame("Pong");
		panel = new pongpanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1280, 740));
		panel.addMouseMotionListener(this);
		
		court.addKeyListener(this);
		court.setContentPane(panel);
		court.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		court.pack();
		court.setVisible(true);
		
		timer = new Timer(1000/60, this);
		timer.start();
	}
	
	//Main Method
	public static void main(String[] args){
		new pongprogram();
	}
}
		
