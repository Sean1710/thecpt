import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class kofc implements ActionListener, MouseMotionListener, KeyListener, MouseListener{

	//Properties
	
	JFrame theframe;
	kofcPanel thepanel;
	Timer thetimer;
	Timer thetimer2;
	JButton Play;
	JButton Help;
	JButton Settings;
	JButton Back1;
	JButton Back2;
	JButton Back3;
	JButton Client;
	JButton Server;
	JButton ChooseRed;
	JButton ChooseBlue;
	JButton ChooseMage;
	JButton ChoosePaladin;
	JButton ChooseKnight;
	JButton ChooseRogue;
	JButton Attack;
	JButton Block;
	JButton Heal;
	int intHealth1; 
	int intHealth2;
	int intHealth3;
	int intHealth4;
	String strName1;
	String strName2;
	String strName3;
	String strName4;
	int intNum = 0;
	int intMenu = 1;
		
	
	//Methods

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == this.Play){
			
			Play.setVisible(false);
			
			Back1 = new JButton("Back");
			Back1.setSize(200, 200);
			Back1.setLocation(0, 0);
			thepanel.add(Back1);
			Back1.setOpaque(false);
			Back1.setContentAreaFilled(false);
			Back1.setBorderPainted(false);
			Back1.setVisible(true);
	
		}
		
		if(evt.getSource() == this.Help){		
			thepanel.blnMenu = false;
			

		}
		
		if(evt.getSource() == this.Settings){		
			
		}
	
		if(evt.getSource()==thetimer){
			thepanel.repaint();
		}
		
		if(evt.getSource() == this.Back1){
			System.out.println("pressed");
			Back1.setVisible(false);
			Play.setVisible(true);
		}
	}
	public void keyTyped(KeyEvent evt){
		
	}
	
	public void keyReleased(KeyEvent evt){

	}
	
	public void mouseEntered(MouseEvent evt){
		
	}
	
	public void keyPressed(KeyEvent evt){

	}

	public void mouseReleased(MouseEvent evt){
		
	}
	public void mousePressed(MouseEvent evt){
		
	}
	public void mouseClicked(MouseEvent evt){
		
	}
	
	public void mouseMoved(MouseEvent evt){
		
	}
	
	public void mouseDragged(MouseEvent evt){

	}
	
	public void mouseExited(MouseEvent evt){
		
	}
	




	//Constructor


	public kofc(){
		//Screen
		thepanel = new kofcPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this);
		
		theframe = new JFrame("Knights of Carnage");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
		theframe.setResizable(false);
		thetimer = new Timer(1000/60, this);
		thetimer.start();
		
		//Play Button
		Play = new JButton("Play");
		Play.setSize(150, 50);
		Play.setLocation(565, 150);
		thepanel.add(Play);
		Play.setOpaque(false);
		Play.setContentAreaFilled(false);
		Play.setBorderPainted(false);
		Play.setVisible(true);
		
		Help = new JButton("Help");
		Help.setSize(150, 50);
		Help.setLocation(565, 300);
		thepanel.add(Help);
		Help.setOpaque(false);
		Help.setContentAreaFilled(false);
		Help.setBorderPainted(false);
		Help.setVisible(true);

		theframe.addKeyListener(this);
		thepanel.addMouseListener(this);
		Play.addActionListener(this);
		Help.addActionListener(this);

		
	}
	
	
	// main method
	public static void main(String[] args){
		new kofc();
	}
}







