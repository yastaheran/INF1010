import java.util.*;
import java.io.*;
import java.lang.*;

public class Oblig8yast {	
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		Scanner fil = null;
		CommonObject co = new CommonObject();
        Finn f = new Finn();
		
		try {
			fil = new Scanner(new File("fil.txt"));
			/*while(leser.hasNextLine()) {
				String les = leser.nextLine();
				System.out.println(les);
			}*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error: File not Found");
		}
		
		String lest = fil.nextLine();
		
		/* System.out.println(lest);
		System.out.println("Onsket antall traader:");
		int traader = inn.nextInt();
		int lengdeArray = ((Integer.parseInt(lest)) % traader);
		System.out.println(lengdeArray); */
		
		String[] liste = new String[Integer.parseInt(lest)];
		//System.out.println(liste.length);
		
		while(fil.hasNextLine()) {
			for(int i = 0; i < liste.length; i++) {
				liste[i] = fil.next();
				Runnable r = new Thread(liste[i]);
				Thread t = new Thread(r);
				t.start();
			}
		}
	}
}

public class CommonObject {
	private final int k = 8;
	private String ord;
	private int teller = 0;
    
	synchronized void finnOrd(String ord) {
        this.ord = ord;
    }
    
	synchronized void ordTeller(int teller) {
        this.teller = teller;
    }
}

public class ordTraad implements Runnable {
    public void run() {
        try {
            
        } catch (InterruptedException e) {
            
        }
    }
}

/*
        Scanner inn = new Scanner(System.in);
        String ord = inn.nextLine();
        sjekkOrd(ord);
			int sjekkOrd(String sokeOrd) {
				int antall = 0;
				for(int i = 0; i < array.length; i++) {
					if (sokeOrd.equals(array[i])
						antall ++;
				}
				return antall;
			}

    }
}