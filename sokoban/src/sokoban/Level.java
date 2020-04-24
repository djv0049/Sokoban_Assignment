package sokoban;

import java.util.ArrayList;
import java.util.List;



public class Level {
	private int height;
	private int width;
	private String name;
	private int moveCount;
	private ArrayList<ArrayList<Placeable>> placeablesList;
	private String levelString;
	private int CompletedCount;
	public int targetCount;
	
	// change the level list to use placables and create new instances of each one 
	
	public Level(String name, int height, int width, String levelString) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.CompletedCount = 0;
		this.moveCount = 0;
		initializeArrays(levelString);
		drawLevel();
		setTargetCount();
	}
	
	
	public String toString() {
		//" + "move 0" + "\n" + "completed 0 of 1" + "\n";
		String result = this.name + "\n" + this.levelString + "move " +  this.moveCount;
		result += "\ncompleted " + this.CompletedCount + " of " + this.targetCount + "\n";
		return result;
	}
	
	public void drawLevel() {
		// fix soon
		String tempString = ""; 
		for( int i = 0; i < placeablesList.size(); i++) {
			for(int j = 0; j < placeablesList.get(i).size(); j++) {
				tempString+= placeablesList.get(i).get(j).toString();
			}
			tempString += "\n";
		}
		this.levelString= tempString;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoveCount() {
		return moveCount;
	}

	public int getCompletedCount() {
		return CompletedCount;
	}
	
	public void initializeArrays(String levelString) {
		this.placeablesList = new  ArrayList<ArrayList<Placeable>>(this.height);
		for(int x = 0, i = 0; x < this.height; x++) {
			ArrayList<Placeable> pList = new ArrayList<Placeable>();
			for(int y = 0; y < this.width; y++, i++) {
				char c = levelString.charAt(i);
				Placeable p = createPlaceable(c,x,y);
				pList.add(p);
			}
			this.placeablesList.add(pList);
		}	
	}
	
	
	public void setTargetCount() {
		for(char c : this.levelString.toCharArray()) {
			if (c == '+') {
				this.targetCount++;
			}
		}
		
	}
	
	private Placeable createPlaceable(char s, int x, int y) {
		Placeable p;
		switch(s){
		case 'w':
			p = new Worker(x,y);
			break;
		case '#':
			p = new Wall(x,y);
			break;
		case '+':
			p = new Target(x, y);
			break;
		case 'x':
			p = new Crate(x, y);
			break;
		default:
			p = new Empty(x,y);
			break;
		}
		return p;
	}
}
