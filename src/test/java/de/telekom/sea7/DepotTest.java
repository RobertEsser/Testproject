package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepotTest {

	private Depot cut;

	@BeforeEach
	void setup() {
		cut = new Depot();
	}

	@Test
	void Depot_add_test() {
		var result = cut.size();
		cut.add(new EntityIBAN(1, "DE12345"));
		var result2 = cut.size();
		assertNotEquals(result, result2);
	}

	@Test
	void Depot_add_test2() {
		cut.add(new EntityIBAN(1, "DE12345"));
		assertSame(cut.get(0).getIban(), "DE12345");
	}

	@Test
	void Depot_add_test3() {
		cut.add(new EntityIBAN(1, ""));
		assertFalse(cut.get(0).getIban().isEmpty());
	}

	@Test
	void Depot_add_test5() {
		boolean thrown = false;
		try {
			cut.add(new EntityIBAN(1, "DE12345"));
			cut.add(new EntityIBAN(2, "DE12345"));
			cut.add(new EntityIBAN(3, "DE12345"));
			cut.add(new EntityIBAN(4, "DE12345"));
			cut.add(new EntityIBAN(5, "DE12345"));
			cut.add(new EntityIBAN(6, "DE12345"));
			cut.add(new EntityIBAN(7, "DE12345"));
			cut.add(new EntityIBAN(8, "DE12345"));
			cut.add(new EntityIBAN(9, "DE12345"));
			cut.add(new EntityIBAN(10, "DE12345"));
			cut.add(new EntityIBAN(11, "DE12345"));
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	void sizeTest() {
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12346"));
		var result = cut.size();
		assertTrue(result == 2);
	}

	@Test
	void Depot_get_test() {
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12346"));
		assertEquals(cut.get(1).getIban(), "DE12346");
	}

	@AfterEach
	void teardown() {
		cut = null;
	}
}
