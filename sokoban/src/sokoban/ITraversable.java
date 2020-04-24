package sokoban;

import java.awt.Point;

public interface ITraversable {
	
	void addCrate(Crate c);
	void addWorker(Worker w);
	void removeCrate(Crate c);
	void removeWorker(Worker w);
	Worker getWorker();
	Crate getCrate();
	Point getPoint();
}
