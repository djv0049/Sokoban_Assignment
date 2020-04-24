package sokoban;

import java.util.ArrayList;
import java.util.List;
import sokoban.Level;
public class Game {
	
	private Level currentLevel;
	private List<Level> allMyLevels = new ArrayList<Level>();
	private List<String> levelNames = new ArrayList<String>();
	private String currentLevelName = "no levels";
	private int levelCount;
	
	public Game() {
		
	}
	
	public void move() {
		
	}
	
	
	public int getLevelCount() {
		return this.levelCount;
	}

	public String getCurrentLevelName() {
		if(this.levelNames.size() <1) {
			return "no levels";
		}
		else return this.currentLevel.getName();
		
	}

	public List<String> getLevelNames() {
		return this.levelNames;
	}
	
	public String toString() {
		if(this.levelNames.size() <1) {
			return "no levels";
		}
		else {
			String result = "";
			for(String name : this.levelNames) {
				result += "\n" + this.currentLevel;
			}
			return result;
		}
		
	}

	public void addLevel(String name, int height, int width, String levelString) {
		Level level = new Level(name, height, width, levelString);
		this.allMyLevels.add(level);
		this.levelNames.add(level.getName());
		this.levelCount++;
		this.currentLevel = level;
	}
	
	public void move(Direction d) {
		
	}
	
}
