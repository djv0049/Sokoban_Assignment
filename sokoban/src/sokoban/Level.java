package sokoban;

import java.awt.Point;
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
	
	public Level(String name, int height, int width, String levelString) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.CompletedCount = 0;
		this.moveCount = 0;
		initializeArrays(levelString);
		drawLevel();
	}
	public Worker getWorker(){
		Worker result = null;
		for(int x = 0;x < height; x++) {
			for(int y = 0; y < width; y++){
				Placeable p = getPlaceabelAt(new Point(x,y));
				if(p.symbol == "w" || p.symbol == "W") {
					return ((ITraversable) p).getWorker();
				}
			}
		}
		return result;
	}
	
	public void moveWorker(Direction d) {
		
		
		Worker worker = getWorker();
		Point direction = d.getPoint();
		Point workerPos = worker.getPoint();
		Placeable p = getPlaceabelAt(workerPos);
		ITraversable origin = (ITraversable) p;
		int x = workerPos.x + direction.x;
		int y = workerPos.y + direction.y;
		Placeable dest = getPlaceabelAt(new Point(x,y));
		this.addMove();
		if(dest instanceof ITraversable) {
			ITraversable destination = (ITraversable) dest;
			if(destination.getCrate() != null) {
				if(!pushCrate(destination,d)) {
					return;
				}
			}
			origin.removeWorker(worker);
			worker.x = destination.getPoint().x;
			worker.y = destination.getPoint().y;
			destination.addWorker(worker);
			
		}
	}
	
	public boolean pushCrate(ITraversable crateOrigin, Direction d) {
		boolean result = false;
		Crate crate = crateOrigin.getCrate();
		int x = crateOrigin.getPoint().x + d.getPoint().x;
		int y = crateOrigin.getPoint().y + d.getPoint().y;
		Placeable dest = getPlaceabelAt(new Point(x,y));
		if(dest instanceof ITraversable) {
			boolean destIsTarget = dest instanceof Target;
			boolean originIsTarget = crateOrigin instanceof Target;
			result = true;
			ITraversable destination = (ITraversable) dest;
			crateOrigin.removeCrate(crate);
			crate.x = destination.getPoint().x;
			crate.y = destination.getPoint().y;
			destination.addCrate(crate);
			int doneTargets = 0;
			doneTargets += destIsTarget ? 1:0;
			doneTargets -= originIsTarget? 1:0;
			addCompleted(doneTargets);
		}
		return result;
	}
	
	public void addCompleted(int number) {
		this.CompletedCount += number;
	}
	
	public void addMove() {
		this.moveCount++;
	}
	
	public Placeable getPlaceabelAt(Point p) {
		return this.placeablesList.get(p.x).get(p.y);
	}
	
	public String toString() {
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
	
	

	
	private Placeable createPlaceable(char s, int x, int y) {
		Placeable p;
		switch(s){
		case 'W':
			Worker worker = new Worker(x,y);
			Target target = new Target(x,y);
			target.addWorker(worker);
			p = target;
			break;
		case 'w':
			Worker w = new Worker(x,y);
			Empty e = new Empty(x,y);
			e.addWorker(w);
			p = e;
			break;
		case '#':
			p = new Wall(x,y);
			break;
		case '+':
			p = new Target(x, y);
			this.targetCount++;
			break;
		case 'x':
			Empty empty = new Empty(x,y);
			Crate crate = new Crate(x, y);
			empty.addCrate(crate);
			p = empty;
			break;
		case 'X':
			Target t = new Target(x,y);
			Crate c = new Crate(x,y);
			t.addCrate(c);
			p = t;
			break;
		default:
			p = new Empty(x,y);
			break;
		}
		return p;
	}
}
