import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class kofcPanel extends JPanel{
	
	//Properties
	
	BufferedImage imgback = null; 
	BufferedImage imgboard = null;
	BufferedImage imgmenu = null;
	boolean blnMenu = true;
	JButton Play;
	JPanel thepanel;
	int intMenu = 1;
	
	//Methods
	
	public void paintComponent(Graphics g){
		if(blnMenu == true && intMenu == 1){
			g.drawImage(imgback, 0, 0, null);
		
		}else if(blnMenu == true && intMenu == 2){
			g.drawImage(imgmenu, 0, 0, null);
		
		}else if(blnMenu == true && intMenu == 3){
		
				
		}else if(blnMenu == true && intMenu == 4){
			
		}else if(blnMenu == true && intMenu == 5){
			
		}else if(blnMenu == true && intMenu == 6){
			
		}else if(blnMenu == true && intMenu == 7){
			g.drawImage(imgboard, 0, 0, null);
		}	
		
		if(blnMenu == false){
		
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





