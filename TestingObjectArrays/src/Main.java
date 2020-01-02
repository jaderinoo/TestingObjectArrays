import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	static GridSpace [][] map = null;
	static int rows = 20;
	static int cols = 20;
	static String mapName;
	static String levelName = "";
	static String[] splitStats = null;
	static String leaderName = null;
	static int mapType = 0;
	
    //Initialize the main menu
    public static void main(String[] args) throws Exception{
    	String[] batch = inputToString("src\\test.txt");

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
		map = saveMap(data);
		printMap(map);
    }
    
	//Saves map as a local variable
	public static GridSpace[][] saveMap(String data){
		GridSpace [][] map = new GridSpace[rows][cols];
		int next = 0;
		double maxRow = 0;
		maxRow = Math.sqrt(data.length()/4);
		for (int y=0; y < maxRow; y++) {
		    for (int x=0; x < maxRow; x++) {
		    	char type = data.charAt(next++);
		    	char occupant = data.charAt(next++);
		    	int occupantInt = Character.getNumericValue((data.charAt(next++)));
		    	int objective = Character.getNumericValue((data.charAt(next++)));
		    	
		    	//System.out.println("[" + type + occupant + occupantInt + objective + "] " + x + "," + y);
		    	map[x][y] = new GridSpace(type,occupant,occupantInt,objective);
		    }
		}
		return map;
	}
	
	//Prints the map for the player
	public static void printMap(GridSpace[][] map) {
		//Print map
		for (int y=0; y < rows; y++) {
		    for (int x=0; x < cols; x++) {
		        System.out.print("[" + map[x][y].getType() + map[x][y].getOccupant() + map[x][y].getOccupantInt() + map[x][y].getObjective() +"]");
		    }
			System.out.println();
		}
	}
	
	public static String[] inputToString(String fileName)throws Exception 
	{ 
		//Initializes the buffered reader
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		//Reads the first lines of the input file so it isnt included in the string
		String mapName = reader.readLine(); 
		String mapStats = reader.readLine();
		String description = reader.readLine();
		String tileSet = reader.readLine();
		String leaderStats = reader.readLine();
		
		//Initialize the variables needed to read in the file
		String line = null;
		String data = null;
		StringBuffer stbuffer = new StringBuffer();
		//Reads in text line by line
		while((line = reader.readLine())!=null){
			stbuffer.append(line).append("\n");
		}
		
		//Sets the appended string to a string variable
		data = stbuffer.toString();
		//Remove all commas from string
		data = data.replace(",", "");
		//Remove all brackets from string
		data = data.replace("[", "");
		data = data.replace("]", "");
		//Remove all line breaks from string
		data = data.replace("\n", "").replace("\r", "");
		//Return all grabbed vars
		String batch[] = new String[6];
		
		//saves all items to batch[]
		batch[0] = mapName;
		batch[1] = mapStats;
		batch[2] = description;
		batch[3] = tileSet;
		batch[4] = leaderStats;
		batch[5] = data;
		
		reader.close();
		return batch;
	} 
}