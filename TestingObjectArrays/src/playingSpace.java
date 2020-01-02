import java.util.ArrayList;

public class playingSpace {
	
	//Create a mobList for the current map
	static ArrayList<Mob1> mobList = new ArrayList<Mob1>();
	static int rows;
	static int cols;
	static String mapName;
	static String levelName = "";
	static String[] splitStats = null;
	static String leaderName = null;
	static int mapType = 0;
	static GridSpace [][] map = null;
	static int enemyCounter;
	
    //Initialize the main menu
    public static void init(ArrayList<Player> playerList) throws Exception{
    	
    	String[] batch = loadMap.inputToString("src\\test.txt");

		//Initialize vars
		levelName = batch[0];
		String [] mapDetails = batch[1].split(" ");
		String description = batch[2];
		String tileSet = batch[3];
		String leaderStats = batch[4];
		String data = batch[5];
		
		//Breakdown the Leader information
		splitStats = leaderStats.split(" ");
		leaderName = splitStats[0];

		//parses the size of the grid and places it into rows and cols
		int[] stats = new int[mapDetails.length];
		for (int i = 0; i < mapDetails.length; i++) {
			String numberAsString = mapDetails[i];
			stats[i] = Integer.parseInt(numberAsString);
		}
		
		rows = stats[0];
		cols = stats[1];
		mapType = stats[2];
		
		//Saves the initial map
		map = loadMap.saveMap(data,rows,cols);
		
		for(int i = 0; i != playerList.size(); i++) {
			System.out.println(playerList.get(i).getName() + " X: " + playerList.get(i).getMapX()
				+ "  Y: " + playerList.get(i).getMapY());
		}
		
		for(int i = 0; i != mobList.size(); i++) {
			System.out.println(mobList.get(i).getName() + " X: " + mobList.get(i).getMapX()
				+ "  Y: " + mobList.get(i).getMapY());
		}
		
		//We have the Map, mobList, playerList, mapDetails, tileSets, and all positions
		
		
		//Move onto game
		
		
		
    }
    

	
	public static void enemyCreate(int y, int x, char mobType, int level) {
		enemyCounter++;
		if(mobType == 'f') {
			mobList.add(new Mob1("FootSoldier" + enemyCounter, level*2, level*2, level*2, level*2, level*5, level*1, level*12, x, y, mobType));
			
		}
	}

}