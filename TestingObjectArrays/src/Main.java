import java.util.ArrayList;

public class Main {
	static ArrayList<Player> playerList = new ArrayList<Player>();
	static int rows;
	static int cols;
	static String mapName;
	static String levelName = "";
	static String[] splitStats = null;
	static String leaderName = null;
	static int mapType = 0;
	static GridSpace [][] map = null;
	
    //Initialize the main menu
    public static void main(String[] args) throws Exception{
    	
    	playerList.add(new Player("playerName"));
    	
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
		
		System.out.println("Player X: " + playerList.get(0).getMapX()
				+ " Player Y: " + playerList.get(0).getMapY());
    }
    
	
	public static void addPlayerLocation(int x, int y, int occupantInt) {
		playerList.get(occupantInt).setMapX(x);
		playerList.get(occupantInt).setMapY(y);
	}
    
}