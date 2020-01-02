import java.util.concurrent.ThreadLocalRandom;

public class Player {

	    int strength;
		int agility;
		int armor;
		int maxHp;
		int special;
		int level;
		int exp;
		int currentHp;
		int mapX;
		int mapY;
		char image;
		String name;

		public Player(String name) {
	    	
	    	//Use this as a ledger for player.txt 
	    	this.name = name;
	    	this.image = 'p';
	   }
		
		public String getName() {
	        return name;
	    }
		
		public char getImage() {
	        return image;
	    }

		public int setMapX(int x) {
			this.mapX = x;
			return this.mapX;
		}
		
		public int setMapY(int y) {
			this.mapY = y;
			return this.mapY;
		}
		
		//get map locations
		public int getMapX() {
			return this.mapX;
		}
		
		public int getMapY() {
			return this.mapY;
		}
}

