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
	SuperSocketMaster ssm;
	Timer thetimer;
	Timer thetimer2;
	JButton Play;
	JButton Help;
	JButton Settings;
	JButton Back1;
	JButton Back2;
	JButton Back3;
	JButton Confirm;
	JButton Client;
	JButton Host;
	JButton ChooseRed;
	JButton ChooseBlue;
	JButton ChooseMage;
	JButton ChoosePaladin;
	JButton ChooseKnight;
	JButton ChooseRogue;
	JButton Attack;
	JButton Block;
	JButton Heal;
	JTextField txtusername;
	int intHealth1; 
	int intHealth2;
	int intHealth3;
	int intHealth4;
	int intNum = 0;
	int intMenu = 1;
	String strusername;
	String strIP;
	boolean blnHost;
	boolean blnClient;
		
	
	//Methods

	public void actionPerformed(ActionEvent evt){
		
		//Main menu, unhide play help and settings buttons
		if(intMenu == 1){
			Play.setVisible(true);
			Help.setVisible(true);
			Settings.setVisible(true);
		
			if(evt.getSource() == this.Play){
				Play.setVisible(false);
				Help.setVisible(false);
				Settings.setVisible(false);
				intMenu = 4;
				
			}
			
			if(evt.getSource() == this.Help){		
				Play.setVisible(false);
				Help.setVisible(false);
				Settings.setVisible(false);
				intMenu = 2;

			}
			
			if(evt.getSource() == this.Settings){		
				Play.setVisible(false);
				Help.setVisible(false);
				Settings.setVisible(false);
				intMenu = 3;
			}
		
			if(evt.getSource()==thetimer){
				thepanel.repaint();
			}
			
		//Help Screen, unhide back1 button
		}else if(intMenu == 2){
			Back1.setVisible(true);
			if(evt.getSource() == this.Back1){
				intMenu = 1;
				Back1.setVisible(false);
			}
			
			
		//Settings Screen, unhide back2 button
		}else if(intMenu == 3){
			Back2.setVisible(true);
			if(evt.getSource() == this.Back2){
				intMenu = 1;
				Back2.setVisible(false);			
			}
		
		//Username Screen, unhide back3 button
		}else if(intMenu == 4){
			Back3.setVisible(true);
			Confirm.setVisible(true);
			txtusername.setVisible(true);
			if(evt.getSource() == this.Back3){
				intMenu = 1;
				Back3.setVisible(false);
				Confirm.setVisible(false);
				txtusername.setVisible(false);
			}else if(evt.getSource() == this.Confirm){
				intMenu = 5;
				txtusername.setVisible(false);
				Confirm.setVisible(false);
				Back3.setVisible(false);
				strusername = txtusername.getText();
				System.out.println("Username: " + strusername);
			}	
	
		//Client/Host choice Screen, unhide client and server buttons
		}else if(intMenu == 5){
			Host.setVisible(true);
			Confirm.setVisible(true);
			//Host
			if (evt.getSource() == Host) {
				System.out.println("Multiplayer: Host");
				blnHost = true;
				Host.setVisible(false); 
				Client.setVisible(false);
				ssm = new SuperSocketMaster(1337, this); 
				System.out.println(ssm.getMyAddress());
				strIP = ssm.getMyAddress(); // Convert IP Address into String strIP
				ssm.connect();
				intMenu = 6; // Change to HostMenu
			}
			//Client
			else if (evt.getSource() == Client) {
				System.out.println("Multiplayer: Guest");
				blnClient = true;
				Host.setVisible(false); 
				Client.setVisible(false);
				intMenu = 7; // Change to GuestMenu
			}
			
			
		//Host Screen
		}else if(intMenu == 6){	
		
		
		//Client Screen
		}else if(intMenu == 7){
		
		
		//Choose Team Screen
		}else if(intMenu == 8){
			
			
		
		//Character Selection Screen
		}else if(intMenu == 9){
		
		
		//Gameplay Screen
		}else if(intMenu == 10){
			
		
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
	




	//Constructors

	public kofc(){
		
		//Panel
		thepanel = new kofcPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this);
		thepanel.addMouseListener(this);
		
		//Frame
		theframe = new JFrame("Knights of Carnage");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
		theframe.setResizable(false);
		theframe.addKeyListener(this);
		theframe.addMouseListener(this);

		
		//Timer
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
		Play.setVisible(false);
		Play.addActionListener(this);
	
		
		//Help Button
		Help = new JButton("Help");
		Help.setSize(150, 50);
		Help.setLocation(565, 300);
		thepanel.add(Help);
		Help.setOpaque(false);
		Help.setContentAreaFilled(false);
		Help.setBorderPainted(false);
		Help.setVisible(false);
		Help.addActionListener(this);

		//Settings
		Settings = new JButton("Settings");
		Settings.setSize(150, 50);
		Settings.setLocation(565, 450);
		thepanel.add(Settings);
		Settings.setOpaque(false);
		Settings.setContentAreaFilled(false);
		Settings.setBorderPainted(false);
		Settings.setVisible(false);
		Settings.addActionListener(this);
		
		//Confirm Username
		Confirm = new JButton("Confirm");
		Confirm.setSize(150, 50);
		Confirm.setLocation(565, 300);
		thepanel.add(Confirm);
		Confirm.setOpaque(false);
		Confirm.setContentAreaFilled(false);
		Confirm.setBorderPainted(false);
		Confirm.setVisible(false);
		Confirm.addActionListener(this);
		
		//Back from help screen
		Back1 = new JButton("Back");
		Back1.setSize(200, 200);
		Back1.setLocation(0, 0);
		thepanel.add(Back1);
		Back1.setOpaque(false);
		Back1.setContentAreaFilled(false);
		Back1.setBorderPainted(false);
		Back1.setVisible(false);
		Back1.addActionListener(this);
		
		//Back from settings screen
		Back2 = new JButton("Back");
		Back2.setSize(200, 200);
		Back2.setLocation(0, 0);
		thepanel.add(Back2);
		Back2.setOpaque(false);
		Back2.setContentAreaFilled(false);
		Back2.setBorderPainted(false);
		Back2.setVisible(false);
		Back2.addActionListener(this);

		
		// Back from username screen
		Back3 = new JButton("Back");
		Back3.setSize(200, 200);
		Back3.setLocation(0, 0);
		thepanel.add(Back3);
		Back3.setOpaque(false);
		Back3.setContentAreaFilled(false);
		Back3.setBorderPainted(false);
		Back3.setVisible(false);
		Back3.addActionListener(this);

		//Textfield for username
		txtusername = new JTextField();
		txtusername.setOpaque(false); 
		txtusername.setSize(400, 35);
		txtusername.setLocation(440, 100);
		txtusername.addActionListener(this);
		thepanel.add(txtusername);
		txtusername.setVisible(false); 
		
		//Choose Host
		Host = new JButton("Host");
		Host.setSize(200, 200);
		Host.setLocation(400, 300);
		thepanel.add(Host);
		Host.setOpaque(false);
		Host.setContentAreaFilled(false);
		Host.setBorderPainted(false);
		Host.setVisible(false);
		Host.addActionListener(this);
		
		//Choose Client
		Client = new JButton("Client");
		Client.setSize(200, 200);
		Client.setLocation(600, 300);
		thepanel.add(Client);
		Client.setOpaque(false);
		Client.setContentAreaFilled(false);
		Client.setBorderPainted(false);
		Client.setVisible(false);
		Client.addActionListener(this);
		
		
		
	}
	
	
	// main method
	public static void main(String[] args){
		new kofc();
	}
}







