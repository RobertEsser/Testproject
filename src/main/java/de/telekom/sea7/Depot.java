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
//	public EntityIBAN get(int index) {
//		return depotArray[index];
//	}
	public EntityIBAN get(int index) throws OwnException {
		if (index > size) {
			throw new OwnException("Index muss kleiner Size sein");
		}
		if (index < 0) {
			throw new OwnException();
		}
//		if (depotArray[index].getIban() == null) {
//			throw new OwnException();
//		}
		if (index == 0 && size == 0) {
			throw new OwnException();
		}

		else {
			return depotArray[index];
		}
	}

	// Gibt die Anzahl der belegten Stellen des Arrays zurück
	public int size() {

		return size;
	}

}
