package sokoban;

import java.awt.Point;
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
		// possible constructor
	}
	
	public void move(Direction d) {
		Worker currentWorker = this.currentLevel.getWorker();
		// get direction 
		Point dp = d.getPoint();	
		// get worker coords, 
		Point wp = currentWorker.getPoint();
		// add point coords;
		Point newP = new Point(dp.x + wp.x, dp.y + wp.y);
		// check if placeable at sumCoords is instance of traversable
		Placeable destination = currentLevel.getPlaceabelAt(newP);
		//if true, remove player from current placeable
		if(destination instanceof ITraversable) {
			((ITraversable) this.currentLevel.getPlaceabelAt(wp)).removeWorker(currentWorker);
			currentWorker.x = destination.getPoint().x;
			currentWorker.y = destination.getPoint().y;
			((ITraversable) destination).addWorker(currentWorker);
			this.currentLevel.addMove();
		}
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
	
}
