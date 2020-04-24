package sokoban;

public abstract class Placeable {
	protected int x = 9999;
	protected int y = 9999;
	protected String symbol = "nothing yet";
	
	public Placeable() {
		
	}
	
	public String toString() {
		return this.symbol;
	}
}
