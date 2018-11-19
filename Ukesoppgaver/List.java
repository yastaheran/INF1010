class List {
	private Node start;
	//Node bak;
	
	public void settInn(String s) { //Setter inn nye elemter først i rekka
		Node ny = new Node;
		ny.data = s;
		
		if(start == null) {
			start = ny;
		} else {
			ny.nest = start;
			start = ny;
		}
	}
	
	public void skrivUtAlle() {
		System.out.println("Listen inneholder: ");
		
		if(start == null) {
			System.out.println(start.data);
			
			Node gjeldende = start;
			while(gjeldende.neste != null) {
				gjeldende = gjeldende.neste;
				System.out.println(gjeldende.data);
			}
		}
	}
	
	public String taUt() {
		return start.data;
	}
	
	public String taUt(int num) {
		if( num != null) {
			while(num.neste !=  null) {
				num = num.neste;
				num--; //når num = 0, stopper løkka
			}
		}
		if(num > 0) {
			return null;
		} else {
			return num;
		}
	}
	
	private class Node {
		Node neste;
		String data;
	}
	
	public String taUtSiste() { //tar ut siste node
		Node n = start;
		
		if(n != null) {
			while(n.netse != null) {
				n = n.neste;
			}
		}
		System.out.println(n.data);
		return;
	}
	
	public static void main(String [] args) {
		List lista = new List();
		lista.settInn("AlF");
		lista.settInn("Ronny");
		lista.settInn("Trude");
		liste.settInn("Zelda");
		lista.skrivUtAlle();
		String s = lista.taUt(2);
		System.out.println(s);
	}	
}