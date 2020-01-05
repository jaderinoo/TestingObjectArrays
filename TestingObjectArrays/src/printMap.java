import java.util.ArrayList;

public class printMap {

	public static void printMap(GridSpace[][] map, int rows, int cols, ArrayList<Player> playerList,ArrayList<Mob1> mobList) {
		//Print map
		for (int y=0; y < rows; y++) {
		    for (int x=0; x < cols; x++) {
		        System.out.print("[");
		        for(int i = 0; i != playerList.size(); i++) {
		        	if(playerList.get(i).getMapX() == x && playerList.get(i).getMapY() == y) {
		        		System.out.print(playerList.get(i).getImage());
		        	}
		        }
		        for(int i = 0; i != mobList.size(); i++) {
		        	if(mobList.get(i).getMapX() == x && mobList.get(i).getMapY() == y) {
		        		System.out.print(mobList.get(i).getType());
		        	}
		        	
		        }
		        System.out.print("]");
		    }
			System.out.println();
		}
	}
}
