import java.io.BufferedReader;
import java.io.FileReader;

public class loadSpace {
    
	//Saves map as a local variable
	public static GridSpace[][] saveMap(String data, int rows, int cols){
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

		    	if(occupant == 'p') {
		    		Main.addPlayerLocation(x,y,occupantInt);
		    	}else if(occupant != 'n' && occupant != 'p') {
		    		Main.enemyCreate(y,x,occupant,occupantInt);
		    	}
		    	//System.out.println("[" + type + occupant + occupantInt + objective + "] " + x + "," + y);
		    	map[x][y] = new GridSpace(type,objective);
		    }
		}
		return map;
	}
	
	//Prints the map for the player
	public static void printMap(GridSpace[][] map, int rows, int cols) {
		//Print map
		for (int y=0; y < rows; y++) {
		    for (int x=0; x < cols; x++) {
		        System.out.print("[" + map[x][y].getType()+ map[x][y].getObjective() +"]");
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