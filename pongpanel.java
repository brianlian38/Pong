import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Font.*;

public class pongpanel extends JPanel{
	// Properties
	int intP1Y = 310;
	int intP1X = 100;
	int intP2Y = 310;
	int intP2X = 1160;
	int intWidth = 25;
	int intHeight = 100;
	boolean blnP1Down = false;
	boolean blnP1Up = false;
	boolean blnP2Down = false;
	boolean blnP2Up = false;
	int intY = 40;
	int intC = 0;
	int intBallX = 630;
	int intBallY = 360;
	int vx = -5;
	int vy = 5;
	int intP1Score = 0;
	int intP2Score = 0;
	// Methods
	public void paintComponent(Graphics g){
		// Court
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 740);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1280, 20);
		g.fillRect(0, 720, 1280, 20);
		for(intC = 0; intC <= 36; intC++){
			g.fillRect(630, 20 + (intC * intY), 20, 20);
		}
		// Paddles
		g.setColor(Color.WHITE);
		g.fillRect(intP1X, intP1Y, intWidth, intHeight);
		g.fillRect(intP2X, intP2Y, intWidth, intHeight);
		// Paddle Movement
		if(blnP1Down && intP1Y != 620){ 
			intP1Y = intP1Y + 10;
		}
		if(blnP1Up && intP1Y != 20){
			intP1Y = intP1Y - 10;
		}
		if(blnP2Down){
			intP2Y = intP2Y + 10;
		}
		if(blnP2Up){
			intP2Y = intP2Y - 10;
		}
		// Ball
		g.fillOval(intBallX, intBallY, 20, 20);
		// Ball Movement
		intBallX = intBallX + vx;
		intBallY = intBallY + vy; 
		/*if(intBallX <= 0){
			vx = 5;
		}else if(intBallX >= 1280){
			vx = -5;
		}*/
		if(intBallY <= 20){
			vy = 5;
		}else if(intBallY >= 700){
			vy = -5;
		}
		// Paddle Interaction - Collision Detection
		if(intBallX >= intP1X&& intBallX <= intP1X+ intWidth){
			if(intBallY >= intP1Y && intBallY <= intP1Y + intHeight){
				System.out.println("HIT by P1");
				vx = -vx;
			}	
		}
		if(intBallX >= intP2X - 20&& intBallX <= intP2X){
			if(intBallY >= intP2Y && intBallY <= intP2Y + intHeight){
				System.out.println("HIT by P2");
				vx = -vx;
			}
		}
		// Scoreboard
		g.drawString("Score: "+intP1Score, 200, 50);
		g.drawString("Score: "+intP2Score, 1055, 50);
		if(intBallX <= 0){
			intBallX = 630;
			intBallY = 360;
			vx = 5;
			vy = 5;
			intP2Score = intP2Score + 1;
		}
		if(intBallX >= 1280){
			intBallX = 630;
			intBallY = 360;
			vx = -5;
			vy = 5;
			intP1Score = intP1Score + 1;
		}			
	}
	// Constructor
	public pongpanel(){
		super();
	}
}
