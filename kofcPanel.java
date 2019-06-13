import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class kofcPanel extends JPanel{
	
	//Properties
	
	boolean blnMenu; 
	BufferedImage imgboard = null;
	BufferedImage imgmenu = null;
	BufferedImage imghelp = null;
	BufferedImage imgsettings = null;
	BufferedImage imgusername = null;
	BufferedImage imghostclient = null;
	BufferedImage imghost = null;
	BufferedImage imgclient = null;
	BufferedImage imgselection = null;
	BufferedImage imgattack = null;
	BufferedImage imgblock = null;
	BufferedImage imgheal = null;
	BufferedImage imgspecial = null;
	JButton Play;
	JPanel thepanel;
	int intMenu = 1;
	
	public kofcPanel(){
			try{
			imgsettings = ImageIO.read(new File("settings.png"));
			imgboard = ImageIO.read(new File("board.png"));
			imgmenu = ImageIO.read(new File("menu.png"));
			imghelp = ImageIO.read(new File("help.png"));
			imgusername = ImageIO.read(new File("username.png"));
			imghostclient = ImageIO.read(new File("hostclient"));
			imghost = ImageIO.read(new File("host"));
			imgclient = ImageIO.read(new File("client.png"));
			imgselection = ImageIO.read(new File("selection.png"));
			imgattack = ImageIO.read(new File("attack.png"));
			imgblock = ImageIO.read(new File("block.png"));
			imgheal = ImageIO.read(new File("heal.png"));
			imgspecial = ImageIO.read(new File("special.png"));
			
			
		}catch(IOException e){
			 System.out.println("Unable to load image"); // Output error message if image doesn't load. Classic try cath statement.
		}
	}
	
	//Methods
	
	public void paintComponent(Graphics g){
		
		//Main Menu
		if(blnMenu == true && intMenu == 1){
			g.drawImage(imgmenu, 0, 0, null);
		
		//Help
		}else if(blnMenu == true && intMenu == 2){
			g.drawImage(imghelp, 0, 0, null);
		
		//Settings
		}else if(blnMenu == true && intMenu == 3){
			g.drawImage(imgsettings, 0, 0, null);
			
		//Username	
		}else if(blnMenu == true && intMenu == 4){
			g.drawImage(imgusername, 0, 0, null);
			
		//Host/Client	
		}else if(blnMenu == true && intMenu == 5){
			g.drawImage(imghostclient, 0, 0, null);
			
		//Host	
		}else if(blnMenu == true && intMenu == 6){
			g.drawImage(imghost, 0, 0, null);
			
			
		//Client
		}else if(blnMenu == true && intMenu == 7){
			g.drawImage(imgclient, 0, 0, null);

			
		//Character Selection		
		}else if(blnMenu == true && intMenu == 8){
			g.drawImage(imgselection, 0, 0, null);
			
			
		//Gameplay
		}else if(blnMenu == true && intMenu == 9){
			g.drawImage(imgboard, 0, 0, null);
			g.drawImage(imgattack, 0, 0, null);
			g.drawImage(imgblock, 0, 0, null);
			g.drawImage(imgheal, 0, 0, null);
			g.drawImage(imgspecial, 0, 0, null);
			
		}
		
		
}
	
	
	
	//Constructor

	
		
	}





