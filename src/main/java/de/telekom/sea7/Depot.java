package de.telekom.sea7;

public class Depot {

	private EntityIBAN[] depotArray = new EntityIBAN[9];
		
	private int size;

	public Depot() {
	}

	// Fügt eine Objektinstanz an die nächste freie Stelle des Arrays
	public void add(EntityIBAN entityiban) {
		depotArray[size++] = entityiban;

	}

	// Gibt das Objekt von der angegebenen Stelle (index) zurück
	public EntityIBAN get(int index) {
		return depotArray[index];
	}

	// Gibt die Anzahl der belegten Stellen des Arrays zurück
	public int size() {

		return size;
	}

}
