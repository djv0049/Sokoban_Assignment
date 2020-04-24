package sokoban;

public class Target extends Placeable {
	private Worker worker = null;
	private Crate crate = null;
	public Target(int x, int y) {
		this.x = x;
		this.y = y;
		this.symbol = "+";
		
	}

	public void addWorker(Worker worker) {
		this.symbol = "W";
		this.worker = worker;
	}
	
	public void removeWorker(Worker worker) {
		this.symbol = "+";
		this.worker = null;
	}
	
	public void addCrate(Crate crate) {
		this.crate = crate;
		this.symbol = "X";
		
	}
	
	public void removeCrate(Crate crate) {
		this.symbol = "+";
		this.worker = null;
	}
	
}
