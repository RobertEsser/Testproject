package de.telekom.sea7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityIBANTest {

	private EntityIBAN cut;

	@BeforeEach
	void setup() {
		cut = new EntityIBAN();
	}

	@Test
	void getIBAN_test() {
		cut.setIban("DE99999");
		var result = cut.getIban();
		assertEquals("DE99999", result);
	}
	@Test
	void setIBAN_test() {
		cut.setIban("DE99999");
		var result = cut.getIban();
		assertNotNull(result);
	}
	@Test
	void getIBAN_test2() {
		cut.setIban("DE99999");
		var result = cut.getIban();
		assertSame("DE99999", result);
	}

	@AfterEach
	void teardown() {
		cut = null;
	}
}
