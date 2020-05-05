package tests;

import sokoban.Game;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sokoban.Direction;
import sokoban.Game;

class TestMovement {
	Game game;

	@BeforeEach
	void setUpBeforeClass() {
		// arrange 
		game = new Game();
		this.game.addLevel("Test1", 5, 6, "######" + "#+x+.#" + "#..w.#" + "#....#" + "######");
	}

	@Test
	void testMovement_moveLeft() {
		// act 
		this.game.move(Direction.LEFT);
		
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#.w..#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_moveRight() {
		// act 
		this.game.move(Direction.RIGHT);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#...w#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_moveUp() {
		// act 
		this.game.move(Direction.UP);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+xW.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_moveDown() {
		// act
		this.game.move(Direction.DOWN);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#....#" + "\n" + "#..w.#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_upIntoWall() {
		// act
		this.game.move(Direction.UP);
		this.game.move(Direction.UP);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+xW.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_downIntoWall() {
		// act
		this.game.move(Direction.DOWN);
		this.game.move(Direction.DOWN);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#....#" + "\n" + "#..w.#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_leftIntoWall() {
		// act
		this.game.move(Direction.LEFT);
		this.game.move(Direction.LEFT);
		this.game.move(Direction.LEFT);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#w...#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 3" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_rightIntoWall() {
		// act
		this.game.move(Direction.RIGHT);
		this.game.move(Direction.RIGHT);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#...w#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_ontoEmptyTarget() {
		// act
		this.game.move(Direction.UP);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+xW.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testMovement_intoCrateoOntoTarget() {
		// act
		this.game.move(Direction.UP);
		this.game.move(Direction.LEFT);
		// assert
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#Xw+.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 1 of 2" + "\n";
		String actualLevel = this.game.getCurrentLevel().toString();
		assertEquals(expectedLevel, actualLevel);
	}
}
