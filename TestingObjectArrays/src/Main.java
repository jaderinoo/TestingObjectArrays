import java.util.ArrayList;

//Adventure class
public class Main {
	static ArrayList<Player> playerList = new ArrayList<Player>();
    public static void main(String[] args) throws Exception{
    	
    	playerList.add(new Player("name1"));
    	playerList.add(new Player("name2"));
    	
    	
    	mapInitialization.init(playerList, "test");
    	
    	
    }
    
	public static void addPlayerLocation(int x, int y, int occupantInt) {
		playerList.get(occupantInt).setMapX(x);
		playerList.get(occupantInt).setMapY(y);
	}

}