package de.telekom.sea7;


	public class DepotImpl <T> {

		private T[] liste = ((T[])new Object[9]);
		private String message;

		//Konstruktor vorbelegung aller Felder mit aufsteigender integer Zahl beginnend bei null
		public DepotImpl() {
		//for (int i = 0; i < liste.length; i++) {
		//liste[i] = null; }
		}

		//ja
		public T getContent(int index) {

		checkIndex (index);
		//if (!checkIndex (index)) {
		//throw new RuntimeException (index + " liegt ausserhalb des definierten Wertebereichs 0 - " + (size()-1));
		//System.out.println("Ungültige Eingabe von " + index);
		//return 0;
		//} else {
		return liste[index];
		//}
		}

		public T[] getListe() {
		return liste;
		}

		public void setClear() {
		for (int i = 0; i < liste.length; i++) {
		liste[i] = null;
		}
		}

		public boolean isEmpty() {
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if (element != null)
		return false;
		}
		return true;
		}

		public boolean isFull() {
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if (element == null)
		return false;
		}
		return true;
		}

		public int size() {
		int counter = 0;
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if (element != null)
		counter++;
		}
		return counter;
		}

		public boolean contains(T object) {
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if ((element != null) && (element.equals(object)))
		return true;
		}
		return false;
		}
		// ja
		public void setListe(T element, int index){
		checkIndex (index);
		//if (!checkIndex (index)) {
		//throw new RuntimeException (index + " liegt ausserhalb des definierten Wertebereichs 0 - " + (size()-1));
		//System.out.println("Ungültige Eingabe von " + index);
		//return 0;
		//} else {
		this.liste[index] = element;
		//}
		}

		@Override
		public String toString() {
		String ausgabe = "";
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if (element == null)
		ausgabe = ausgabe + "null, ";
		else
		ausgabe += element.toString() + ", ";
		}
		return ausgabe;
		}

		public boolean checkIndex (int index){
		if ((index >= 0) && (index < liste.length)){
		return true;
		}else {
		throw new RuntimeException (index + " liegt ausserhalb des definierten Wertebereichs 0 - " + (size()-1));
		}
		//im 1. Versuch war eine RuntimeException drin
		//return (index >= 0) && (index < size());

		}


		public int indexOf(T object) {
		for (int i = 0; i < liste.length; i++) {
		var element = liste[i];
		if ((element != null) && (element.equals(object)))
		return i;
		}
		return -1;
		}
		public String getMessage() {
		return message;
		}

		public void setMessage(String message) {
		this.message = message;
		
		}
		


	
	
	
}
