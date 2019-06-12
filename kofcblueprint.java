public class kofcblueprint{

	//Properties
	public String strplayerName;
	public String strplayerName2;
    public int intplayerhp;
    public int intmaxhp;
    public int intplayerdmg;
    public int intspeed;
    public int intplayer2dmg;
    public int intplayer2hp;
    public int intmaxhp2;
    public int intspeed2;

    //globals for player stats & enemy stats
	
	public void Stats(){
		
			
	
		
	}
	//Knight stats
	public void theKnight(){
		intmaxhp = 15;
		intplayerhp = 15; 
		intspeed = 20;
		if (Math.random() < 0.5){
			intplayerdmg = 2;
		}else{
			intplayerdmg = 3;
		}
	}
	
	//Mage stats
	public void theMage(){
		intmaxhp = 12;
		intplayerhp = 15;
		intspeed = 30;
		if(Math.random() < 0.5){
			intplayerdmg = 1;
		
		}else{
			intplayerdmg = 2;
		}
	}
	
	//Paladin stats
	public void thePaladin(){
		intmaxhp = 20;
		intplayerhp = 20;
		intspeed = 10;
		if(Math.random() < 0.25){
			intplayerdmg = 1;
		}else{
			intplayerdmg = 4;
		}
	}
	
	//Rogue stats
	public void theRogue(){
		intmaxhp = 12;
		intplayerhp = 12;
		intspeed = 40;
		if (Math.random() < 0.5){
			intplayerdmg = 1;
		}else{
			intplayerdmg = 3;
		}
		
	}
	
	
	//Knight2 stats
	public void theKnight2(){
		intmaxhp2 = 15;
		intplayer2hp = 15; 
		intspeed2 = 20;
		if (Math.random() < 0.5){
			intplayer2dmg = 2;
		}else{
			intplayer2dmg = 3;
		}
	}
	
	//Mage2 stats
	public void theMage2(){
		intmaxhp2 = 12;
		intplayer2hp = 15;
		intspeed2 = 30;
		if(Math.random() < 0.5){
			intplayer2dmg = 1;
		
		}else{
			intplayer2dmg = 2;
		}
	}
	
	//Paladin2 stats
	public void thePaladin2(){
		intmaxhp2 = 20;
		intplayer2hp = 20;
		intspeed2 = 10;
		if(Math.random() < 0.5){
			intplayer2dmg = 1;
		}else{
			intplayer2dmg = 4;
		}
	}
	
	//Rogue2 stats
	public void theRogue2(){
		intmaxhp2 = 12;
		intplayer2hp = 12;
		intspeed2 = 40;
		if (Math.random() < 0.5){
			intplayer2dmg = 1;
		}else{
			intplayer2dmg = 3;
		}
		
	}
	
	
	//Healing
	public void heal(int intheal2){
        intplayerhp = intplayerhp + 4;
    }
	
	//Take damage
	 public void losehealth(int intlosehealth2){
        intplayerhp = intplayerhp - intplayer2dmg;
    }
	
	//Block
	public void block(int intblock){
		intplayer2dmg = intplayer2dmg - 2;
		intspeed = intspeed + 100;
	}	
	
	
	//Healing p2
	public void heal2(int intheal2){
        intplayer2hp = intplayer2hp + 4;
    }
    
	
	//Take damage p2
	 public void losehealth2(int intlosehealth2){
        intplayer2hp = intplayer2hp - intplayerdmg;
    }
    
	
	//Block p2
	public void block2(int intblock2){
		intplayerdmg = intplayerdmg - 2;
		intspeed2 = intspeed2 + 100;
	}	
	
	public kofcblueprint(int intplayerhp, int intmaxhp, int intplayerdmg, int intspeed, int intplayer2hp,int intmaxhp2, int intplayer2dmg, int intspeed2){
		this.intplayerhp = intplayerhp;
		this.intmaxhp = intmaxhp;
		this.intplayerdmg = intplayerdmg;
		this.intspeed = intspeed;
		this.intplayer2hp = intplayer2hp;
		this.intmaxhp2 = intmaxhp2;
		this.intplayer2dmg = intplayer2dmg;
		this.intspeed2 = intspeed2;
		
	}
}





























