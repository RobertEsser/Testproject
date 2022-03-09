package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

//***************Vergleich Grösse Array nach ADD************
	@Test
	void Depot_add_test1() {
		var result = cut.size();
		cut.add(new EntityIBAN(1, "DE12345"));
		var result2 = cut.size();
		assertNotEquals(result, result2);
	}

	// ***************Vergleich Inhalt nach ADD************
	@Test
	void Depot_add_test2() throws OwnException {
		cut.add(new EntityIBAN(1, "DE12345"));
		assertSame(cut.get(0).getIban(), "DE12345");
	}

	// ***************Prüfung ob leer nach ADD************
	@Test
	void Depot_add_test3() throws OwnException {
		cut.add(new EntityIBAN(1, ""));
		assertTrue(cut.get(0).getIban().isEmpty());
	}

	// ***************Prüfung auf Exception nach zu grossem ADD************
	@Test
	void Depot_add_test5() {
		boolean thrownyn = false;
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12345"));
		cut.add(new EntityIBAN(3, "DE12345"));
		cut.add(new EntityIBAN(4, "DE12345"));
		cut.add(new EntityIBAN(5, "DE12345"));
		cut.add(new EntityIBAN(6, "DE12345"));
		cut.add(new EntityIBAN(7, "DE12345"));
		cut.add(new EntityIBAN(8, "DE12345"));
		cut.add(new EntityIBAN(9, "DE12345"));
		try {

			cut.add(new EntityIBAN(10, "DE12345"));

		} catch (IndexOutOfBoundsException e) {
			thrownyn = true;
		}
		assertTrue(thrownyn);
	}

	// ***************Prüfung Array-Groesse nach ADD************
	@Test
	void sizeTest1() {
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12346"));
		var result = cut.size();
		assertTrue(result == 2);

	}

	@Test
	void sizeTest2() {
		var result = cut.size();
		assertTrue(result == 0);
	}

	// ***************Prüfung Array-Inhalt mit GET************
	@Test
	void Depot_get_test1() throws OwnException {
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12346"));
		assertEquals(cut.get(1).getIban(), "DE12346");
	}

	@Test
	void Depot_get_test2() {
		boolean thrownyn = false;
		try {
			cut.add(new EntityIBAN(1, "DE12345"));
			cut.add(new EntityIBAN(2, "DE12346"));
			cut.get(-1);
		} catch (OwnException e) {
			thrownyn = true;
		}
		assertTrue(thrownyn);
	}

	// ***************Prüfung mit Lambda-Code Array-Inhalt mit GET(out of
	// Range)*********SpringApplication.run***
	@Test
	void Depot_get_test3() {
		cut.add(new EntityIBAN(1, "DE12345"));
		cut.add(new EntityIBAN(2, "DE12346"));
		assertThrows(OwnException.class, () -> {
			cut.get(3);
		});
	}

	// ***************Prüfung mit Lambda-Code Array-Inhalt mit GET(-1)************
	@Test
	void Depot_get_test4() {
		assertThrows(OwnException.class, () -> cut.get(-1));
	}

	@AfterEach
	void teardown() {
		cut = null;
	}
}
