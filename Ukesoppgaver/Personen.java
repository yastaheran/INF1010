public class Personen {
	private Node start, slutt;

	Personen(String navn, String gjenstand) {
		if(start ==  null) {
			start = new Node(navn, gjenstand);
			slutt = start;
			System.out.println("Person er satt inn i kø");
		} else {
			start.neste = new Node(navn, gjenstand);
			slutt = start;
			System.out.println("Person er satt inn i kø");
		}
	}

	private class Node {
		Node neste;
		String data, dataNavn;
		Node(String n, String g) {
			data = (n + " har kjøpt " + g);
			dataNavn = n;
		}
	}

	String taUtPersonForan() {
			if(start != null && slutt != null) {
				return null;
			}
			Node ut = start;
			start = start.neste;
			return ut.dataNavn;
	}
}
