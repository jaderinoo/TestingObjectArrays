import java.util.ArrayList;

public class Main {
	static ArrayList<Player> playerList = new ArrayList<Player>();
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
    public static void main(String[] args) throws Exception{
    	
    	playerList.add(new Player("playerName1"));
    	playerList.add(new Player("playerName2"));
    	playerList.add(new Player("playerName3"));
    	
    	String[] batch = loadSpace.inputToString("src\\test.txt");

		//Initialize vars
		levelName = batch[0];
		String [] secondLine = batch[1].split(" ");
		String leaderStats = batch[3];
		String data = batch[5];
		
		//Breakdown the Leader information
		splitStats = leaderStats.split(" ");
		leaderName = splitStats[0];

		//parses the size of the grid and places it into rows and cols
		int[] stats = new int[secondLine.length];
		for (int i = 0; i < secondLine.length; i++) {
			String numberAsString = secondLine[i];
			stats[i] = Integer.parseInt(numberAsString);
		}
		
		rows = stats[0];
		cols = stats[1];
		mapType = stats[2];
		
		//Saves the initial map
		map = loadSpace.saveMap(data,rows,cols);
		loadSpace.printMap(map,rows,cols);
		
		for(int i = 0; i != playerList.size(); i++) {
			System.out.println(playerList.get(i).getName() + " X: " + playerList.get(i).getMapX()
				+ "  Y: " + playerList.get(i).getMapY());
		}
		
		for(int i = 0; i != mobList.size(); i++) {
			System.out.println(mobList.get(i).getName() + " X: " + mobList.get(i).getMapX()
				+ "  Y: " + mobList.get(i).getMapY());
		}
    }
    
	public static void addPlayerLocation(int x, int y, int occupantInt) {
		playerList.get(occupantInt).setMapX(x);
		playerList.get(occupantInt).setMapY(y);
	}
	
	public static void enemyCreate(int y, int x, char mobType, int level) {
		enemyCounter++;
		if(mobType == 'f') {
			mobList.add(new Mob1("FootSoldier" + enemyCounter, level*2, level*2, level*2, level*2, level*5, level*1, level*12, x, y, mobType));
			
		}
	}
}