package sokoban;

public class Empty extends Placeable {
	private Worker worker;
	private Crate crate;
	public Empty(int x, int y) {
		this.x = x;
		this.y = y;
		this.symbol = ".";
	}

	public void addWorker(Worker worker) {
		this.symbol = "w";
		this.worker = worker;
	}
	
	public void removeWorker(Worker worker) {
		this.symbol = ".";
		this.worker = null;
	}
	
	public void addCrate(Crate crate) {
		this.crate = crate;
		this.symbol = "x";
		
	}
	
	public void removeCrate(Crate crate) {
		this.symbol = ".";
		this.worker = null;
	}
}
