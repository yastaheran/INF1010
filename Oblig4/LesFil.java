import java.util.*;
import java.io.*;

class LesFil {
	String filnavn;
	ArrayList<Bil> biler = new ArrayList<Bil>();
	Scanner leser;
	
	LesFil(String filnavn){
		this.filnavn = filnavn;
	}
	
	public String lesBilnr(){ //metode for å lese bilnr fra "biler.txt"
		String temp;
		try {
			leser = new Scanner(new File(this.filnavn));
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not Found");
			return null;
		}
		 temp = leser.next();
		 return temp;
	}
	
	public void settInnBiler() { //metode for aa sette inn bile inn i ArrayList biler
		while (leser.hasNextLine()) {
            String line = leser.nextLine();
            String[] details = line.split(" ");
	    	System.out.println(details[0]);
	    
            if (details[0].equals("BIL")) {
				Bil bil = new Bil();
		        bil.setBilnr(details[1]);
				biler.add(bil);
            } else if (details[0].equals("EL")) {	
				Elbil elbil = new Elbil();
		        elbil.setBilnr(details[1]);
				int batteristr = Integer.parseInt(details[2]);
	    	    elbil.setBatteri(batteristr);
				biler.add(elbil);
	    	} else if (details[0].equals("FOSSIL")) {	//Sjekker om det er en fossilbil
				Fossilbil fossilbil = new Fossilbil();
	        	fossilbil.setBilnr(details[1]);
				double utslipp = Double.parseDouble(details[2]);
		        fossilbil.setUtslipp(utslipp);
				biler.add(fossilbil);
	    	} else if (details[0].equals("LASTEBIL")) { //Sjekker om det er en lastebil
				Lastebil lastebil = new Lastebil();
				lastebil.setBilnr(details[1]);
				double utslipp = Double.parseDouble(details[2]);
				lastebil.setUtslipp(utslipp);
				double nyttevekt = Double.parseDouble(details[3]);
				lastebil.setVekt(nyttevekt);
        	    biler.add(lastebil);
		    } else if (details[0].equals("PERSONFOSSILBIL")) { //Sjekker om det er en personbil
				Personbil persbil = new Personbil();
				persbil.setBilnr(details[1]);
				double utslipp = Double.parseDouble(details[2]);
				persbil.setUtslipp(utslipp);
				int antPass = Integer.parseInt(details[3]);
				persbil.setAntPass(antPass);
	 			biler.add(persbil);
		    }
		}
	}
	
	public String hentFossilbiler() {
		for(Bil bil: biler){  
    		if(bil instanceof Fossilbil){
    			Fossilbil f = (Fossilbil) bil;
        		System.out.println(f.getBilnr() + " " + f.getUtslipp());
  		 	}
		}
	}
	
	public void hentFossilPersonbiler() {
		for(Bil bil: biler){  
    		if(bil instanceof Personbil){
    			Personbil p = (Personbil) bil;
       			System.out.println(p.getBilnr() + " " + p.getUtslipp() + " " + p.getAntPass());
    		}
		}
	}
	
	public String hentFossilLastebiler() {
		for(Bil bil: biler){  
    		if(bil instanceof Lastebil){
    			Lastebil l = (Lastebil) bil;
        		System.out.println(l.getBilnr()+ " " + l.getUtslipp+ " " + l.getVekt());
    		}
		}
	}
	
	public String hentElbiler() {
		for(Bil bil: biler){  
   			if(bil instanceof Elbil){
   				Elbil el = (Elbil) bil;
        		System.out.println(el.getBilnr() + " " + el.getBatteri());
    		}
		}	
	}
}