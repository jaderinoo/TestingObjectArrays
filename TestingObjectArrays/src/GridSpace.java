
public class GridSpace {
	char type;
	char occupant;
	int occupantInt;
	int objective;
	
	public GridSpace(char tempType, char tempOccupant, int occupantInt, int tempObjective) {
		this.type = tempType;
		this.occupant = tempOccupant;
		this.occupantInt = occupantInt;
		this.objective = tempObjective;
	}
	
	public void setType(char mapChar) {
		this.type = mapChar;
	}
	
	public char getType() {
		return this.type;
	}
	
	public void setOccupant(char tempOccupant) {
		this.occupant = tempOccupant;
	}
	
	public char getOccupant() {
		return this.occupant;
	}
	
	public void setOccupantInt(char tempOccupantInt) {
		this.occupantInt = tempOccupantInt;
	}
	
	public int getOccupantInt() {
		return this.occupantInt;
	}
	
	public void setObjective(int tempobjective) {
		this.objective = tempobjective;
	}
	
	public int getObjective() {
		return this.objective;
	}
}
