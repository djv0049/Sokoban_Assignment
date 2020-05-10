package sokoban;

import java.awt.Point;

public abstract class Placeable {
	protected int x = 9999;
	protected int y = 9999;
	protected String symbol = "nothing yet";
	
	public Point getPoint() {
		Point p = new Point(this.x, this.y);
		return p;
	}
	
	public String toString() {
		return this.symbol;
	}
}
