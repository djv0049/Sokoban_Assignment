package sokoban;


import java.util.ArrayList;
import java.util.List;
import sokoban.Level;
public class Game {
	
	private Level currentLevel;
	private List<Level> allMyLevels = new ArrayList<Level>();
	private List<String> levelNames = new ArrayList<String>();
	private int levelCount;
	
	public Game() {
		this.levelCount = 0;
	}
	
	public void move(Direction d) {
		this.currentLevel.moveWorker(d);
		this.currentLevel.drawLevel();
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
	
	public Level getCurrentLevel() {
		return this.currentLevel;
	}

	public List<String> getLevelNames() {
		List<String> testVar = this.levelNames;
		return testVar;
		
	}
	
	public String toString() {
		if(this.levelNames.size() <1) {
			return "no levels";
		}
		else {
			
			return this.currentLevel.getName();
		}
	}

	public void addLevel(String name, int height, int width, String levelString) {
		Level level = new Level(name, height, width, levelString);
		this.allMyLevels.add(level);
		this.levelNames.add(level.getName());
		this.levelCount++;
		this.currentLevel = level;
	}
	
}
