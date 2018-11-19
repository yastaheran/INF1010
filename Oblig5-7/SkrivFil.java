import java.io.*;

class SkrivFil {
	private String filnavn;
	private PrintWriter pw;
	
	SkrivFil(String filnavn){
		this.filnavn = filnavn;
	}
	
	public String skrivFil(){ //metode for å skrive inn i "fil.txt"
		String temp;
		try {
			pw = new PrintWriter("fil.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not Found");
			return null;
		}
		 temp = pw.next();
		 return temp;
	}
}