package sokoban;

import java.awt.Point;

public enum Direction {
	up (0,-1),
	down (0,1),
	left (-1,0),
	right (1,0);
	
	private final Point p;
	
	private Direction(int y, int x) {
		p = new Point (x,y);
	}
	
	public Point offset() {
		return p;
	}
	public Point getPoint() {
		return p;
	}
	
}
