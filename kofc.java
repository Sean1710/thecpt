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
	JButton HostContinue;
	JButton Hoststart;
	JButton ClientConnect;
	JButton ClientContinue;
	JButton Redteam;
	JButton Blueteam;
	JButton ChooseMage;
	JButton ChoosePaladin;
	JButton ChooseKnight;
	JButton ChooseRogue;
	JButton Attack;
	JButton Block;
	JButton Heal;
	JTextField txtusername;
	JTextField txtchat;
	JTextField txtip;
	JTextArea areachat;
	JScrollPane scrollchat;
	int intPlayer = 1;
	int intHealth1; 
	int intHealth2;
	int intHealth3;
	int intHealth4;
	int intNum = 0;
	int intMenu = 1;
	int intselect = 0;
	String strChat;
	String strusername;
	String strIP;
	String strConnectionStatus;
	boolean blnMenu = true;
	boolean blnHost = false; //Player 1
	boolean blnClient = false;  //Player 2
	boolean blnRed = false;
	boolean blnBlue = false;
	boolean blnKnight = false;
	boolean blnMage = false;
	boolean blnPaladin = false;
	boolean blnRogue = false;
	
		
	
	//Methods

	public void actionPerformed(ActionEvent evt){
		
		if(evt.getSource() == thetimer){
			thepanel.repaint();
		}
		
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
			Client.setVisible(true);
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
			HostContinue.setVisible(true);  
			// [Host Continue Button]
			if (evt.getSource() == HostContinue) {
				HostContinue.setVisible(false); 
				intMenu = 9; 
				ssm.sendText("characterselectionmenu"); 
			}
			// Connection Check (Only allow Host to continue if it's connected with Client)
			else if (evt.getSource() == ssm) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("connect")) {
					ssm.sendText("connected");
					intPlayer = intPlayer + 1; 
					areachat.setVisible(true); 
					scrollchat.setVisible(true);
					txtchat.setVisible(true);
					ssm.sendText("You have joined " + strusername + "'s game. \n"); 
					HostContinue.setEnabled(true);
				}
			}
		
		
		//Client Screen
		}else if(intMenu == 7){
			ClientConnect.setVisible(true); 
			txtip.setVisible(true);
			// [Guest Connect Button]
			if (evt.getSource() == ClientConnect) {
				strIP = txtip.getText();
				ssm = new SuperSocketMaster(strIP, 1337, this); 
				ssm.connect();
				ssm.sendText("connect");
				ssm.sendText(strusername + " has joined the game. \n"); 
				ClientConnect.setVisible(false); 
				txtip.setVisible(false);
			}
			// Connection Check (Only allow Client to continue if it's connected with Host)
			else if (evt.getSource() == ssm) {
				strConnectionStatus = ssm.readText();
				if (strConnectionStatus.equals("connected")) {
					areachat.setVisible(true); 
					scrollchat.setVisible(true);
					txtchat.setVisible(true);
					ClientContinue.setEnabled(true);
					ClientConnect.setEnabled(false);
					txtip.setEnabled(false);

				}
				// Go to CharacterSelectionMenu only if the host allows
				else if (strConnectionStatus.equals("teamselection")) {
					ClientContinue.setVisible(false); 
					ClientConnect.setVisible(false);
					txtip.setVisible(false);
					ClientContinue.setEnabled(false);
					ClientConnect.setEnabled(false);
					txtip.setEnabled(false);
					intMenu = 8; 
				}
			}
		
			
		//Character Selection Screen
		}else if(intMenu == 8){
			System.out.println("CharacterSelectionMenu");
			ChooseKnight.setVisible(true);
			ChooseMage.setVisible(true);
			ChooseRogue.setVisible(true);
			ChoosePaladin.setVisible(true);
			
			if(evt.getSource() == ChooseKnight){
				ChooseKnight.setVisible(false);
				ChooseMage.setVisible(false);
				ChooseRogue.setVisible(false);
				ChoosePaladin.setVisible(false);
				blnKnight = true;
				intselect = intselect + 1;
			
			}else if(evt.getSource() == ChooseMage){
				ChooseKnight.setVisible(false);
				ChooseMage.setVisible(false);
				ChooseRogue.setVisible(false);
				ChoosePaladin.setVisible(false);
				blnMage = true;
				intselect = intselect + 1;
			
			}else if(evt.getSource() == ChooseRogue){
				ChooseKnight.setVisible(false);
				ChooseMage.setVisible(false);
				ChooseRogue.setVisible(false);
				ChoosePaladin.setVisible(false);
				blnRogue = true;
				intselect = intselect + 1;
				
			}else if(evt.getSource() == ChoosePaladin){
				ChooseKnight.setVisible(false);
				ChooseMage.setVisible(false);
				ChooseRogue.setVisible(false);
				ChoosePaladin.setVisible(false);
				blnPaladin = true;
				intselect = intselect + 1;
				
			}	
			
			if (blnHost == true && intselect == intPlayer) {
				Hoststart.setVisible(true); // Display start game button only if everyone has selected their character
			
			}
			// [Client] Check if Host clicked Start Game
			if(evt.getSource() == Hoststart){
				Hoststart.setVisible(false);
				intMenu = 9;
				blnMenu = false;
				thetimer.start();
				
				if(blnClient == true){
					strConnectionStatus = ssm.readText();
					if (strConnectionStatus.equals("startgame1")) {
					Hoststart.setVisible(false);
					intMenu = 9;
					blnMenu = false;
					thetimer.start();
					theframe.requestFocus();
					
				}	
	
			}
		
			// In-Game Chat (Receive)
			if (evt.getSource() == ssm) {
				strChat = ssm.readText();
				// Block SSM data so they it doesn't show in chat
				if (!strChat.equals("connect") && !strChat.equals("startgame1")){
					areachat.append(strChat + "\n");
					theframe.requestFocus();
					areachat.setCaretPosition(areachat.getDocument().getLength()); // Auto scroll down as new message pops up
				}
			}

			// In-Game Chat (Send) 
			if (evt.getSource() == txtchat) {
				System.out.println(strusername + ": " + txtchat.getText());
				ssm.sendText(strusername + ": " + txtchat.getText());
				areachat.append(strusername + ": " + txtchat.getText() + "\n");
				txtchat.setText("");
				theframe.requestFocus();
				areachat.setCaretPosition(txtchat.getDocument().getLength()); // Auto scroll down as new message pops up
			}
			
		}
		
		//Gameplay Screen
		}else if(intMenu == 9){
	
				
				
				
			
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
		
		//Host's Continue 
		HostContinue = new JButton("Continue");
		HostContinue.setSize(200, 200);
		HostContinue.setLocation(600, 300);
		thepanel.add(HostContinue);
		HostContinue.setOpaque(false);
		HostContinue.setContentAreaFilled(false);
		HostContinue.setBorderPainted(false);
		HostContinue.setVisible(false);
		HostContinue.addActionListener(this);
		
		//Client's connect to host
		ClientConnect = new JButton("Connect");
		ClientConnect.setSize(200, 200);
		ClientConnect.setLocation(600, 300);
		thepanel.add(ClientConnect);
		ClientConnect.setOpaque(false);
		ClientConnect.setContentAreaFilled(false);
		ClientConnect.setBorderPainted(false);
		ClientConnect.setVisible(false);
		ClientConnect.addActionListener(this);
		
		//Client's continue
		ClientContinue = new JButton("Continue");
		ClientContinue.setSize(200, 200);
		ClientContinue.setLocation(600, 300);
		thepanel.add(ClientContinue);
		ClientContinue.setOpaque(false);
		ClientContinue.setContentAreaFilled(false);
		ClientContinue.setBorderPainted(false);
		ClientContinue.setVisible(false);
		ClientContinue.addActionListener(this);
		
		//Chat Textfield
		txtchat = new JTextField();
		txtchat.setOpaque(false); 
		txtchat.setSize(400, 35);
		txtchat.setLocation(440, 100);
		txtchat.addActionListener(this);
		thepanel.add(txtchat);
		txtchat.setVisible(false); 
		
		//IP textfield
		txtip = new JTextField();
		txtip.setOpaque(false); 
		txtip.setSize(400, 35);
		txtip.setLocation(440, 100);
		txtchat.addActionListener(this);
		thepanel.add(txtip);
		txtip.setVisible(false); 
		
		
		//Text area chat
		areachat = new JTextArea();
		areachat.setOpaque(false);
		areachat.setForeground(Color.WHITE); 
		areachat.setVisible(false);
		areachat.setEnabled(false);
		
		//Scroll for chat
		scrollchat = new JScrollPane(txtchat);
		scrollchat.getViewport().setOpaque(false);
		scrollchat.setOpaque(false);
		scrollchat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
		scrollchat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollchat.setSize(350, 200);
		scrollchat.setLocation(930, 485);
		thepanel.add(scrollchat);
		scrollchat.setVisible(false);
		
		Redteam = new JButton("Red");
		Redteam.setSize(200, 200);
		Redteam.setLocation(400, 300);
		thepanel.add(Redteam);
		Redteam.setOpaque(false);
		Redteam.setContentAreaFilled(false);
		Redteam.setBorderPainted(false);
		Redteam.setVisible(false);
		Redteam.addActionListener(this);
		
		
		Blueteam = new JButton("Blue");
		Blueteam.setSize(200, 200);
		Blueteam.setLocation(800, 300);
		thepanel.add(Blueteam);
		Blueteam.setOpaque(false);
		Blueteam.setContentAreaFilled(false);
		Blueteam.setBorderPainted(false);
		Blueteam.setVisible(false);
		Blueteam.addActionListener(this);
		
		//Knight button
		ChooseKnight = new JButton("Knight");
		ChooseKnight.setSize(200, 200);
		ChooseKnight.setLocation(500, 300);
		thepanel.add(ChooseKnight);
		ChooseKnight.setOpaque(false);
		ChooseKnight.setContentAreaFilled(false);
		ChooseKnight.setBorderPainted(false);
		ChooseKnight.setVisible(false);
		ChooseKnight.addActionListener(this);
		
		//Mage button
		ChooseMage = new JButton("Mage");
		ChooseMage.setSize(200, 200);
		ChooseMage.setLocation(800, 300);
		thepanel.add(ChooseMage);
		ChooseMage.setOpaque(false);
		ChooseMage.setContentAreaFilled(false);
		ChooseMage.setBorderPainted(false);
		ChooseMage.setVisible(false);
		ChooseMage.addActionListener(this);
		
		//Rogue button
		ChooseRogue = new JButton("Rogue");
		ChooseRogue.setSize(200, 200);
		ChooseRogue.setLocation(500, 500);
		thepanel.add(ChooseRogue);
		ChooseRogue.setOpaque(false);
		ChooseRogue.setContentAreaFilled(false);
		ChooseRogue.setBorderPainted(false);
		ChooseRogue.setVisible(false);
		ChooseRogue.addActionListener(this);
		
		//Paladin button
		ChoosePaladin = new JButton("Paladin");
		ChoosePaladin.setSize(200, 200);
		ChoosePaladin.setLocation(800, 500);
		thepanel.add(ChoosePaladin);
		ChoosePaladin.setOpaque(false);
		ChoosePaladin.setContentAreaFilled(false);
		ChoosePaladin.setBorderPainted(false);
		ChoosePaladin.setVisible(false);
		ChoosePaladin.addActionListener(this);
		
		//Host start
		Hoststart = new JButton("Start");
		Hoststart.setSize(200, 200);
		Hoststart.setLocation(800, 100);
		thepanel.add(Hoststart);
		Hoststart.setOpaque(false);
		Hoststart.setContentAreaFilled(false);
		Hoststart.setBorderPainted(false);
		Hoststart.setVisible(false);
		Hoststart.addActionListener(this);
		
		
		
		
	}
	
	
	// main method
	public static void main(String[] args){
		new kofc();
	}
}







