import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class kofcPanel extends JPanel{
	
	//Properties
	
	boolean blnMenu; 
	BufferedImage imgback = null; 
	BufferedImage imgboard = null;
	BufferedImage imgmenu = null;
	JButton Play;
	JPanel thepanel;
	int intMenu = 1;
	
	//Methods
	
	public void paintComponent(Graphics g){
		
		//Main Menu
		if(blnMenu == true && intMenu == 1){
			g.drawImage(imgmenu, 0, 0, null);
		
		//Help
		}else if(blnMenu == true && intMenu == 2){
		
		//Settings
		}else if(blnMenu == true && intMenu == 3){
			
			
		//Username	
		}else if(blnMenu == true && intMenu == 4){
			
			
		//Host/Client	
		}else if(blnMenu == true && intMenu == 5){
			
			
		//Host	
		}else if(blnMenu == true && intMenu == 6){
			g.drawImage(imgboard, 0, 0, null);
			
			
		//Client
		}else if(blnMenu == true && intMenu == 7){
			
			
			
		//Choose Team	
		}else if(blnMenu == true && intMenu == 8){
			
			
			
		//Character Selection		
		}else if(blnMenu == true && intMenu == 9){
			
			
			
		//Gameplay
		}else if(blnMenu == true && intMenu == 10){
			
			
		}
		
		
}
	
	
	
	//Constructor

	public kofcPanel(){
			super();
			try{
			imgback = ImageIO.read(new File("background.png"));
			imgboard = ImageIO.read(new File("board.png"));
			imgmenu = ImageIO.read(new File("menu.png"));
		}catch(IOException e){
		}
	}
		
	}





