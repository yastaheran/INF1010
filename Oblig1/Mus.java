public class Mus {
	private int vekt = 50;
	private boolean syk = false;
	private boolean lever = true;
	
	public Mus (int v, boolean s) {
		vekt = v;
		syk = s;
	}
	
	public boolean syk() {
		return syk;
	}
	
	public int vekt() {
		return vekt;
	}
	
	public boolean lever() {
		return lever;
	}
	
	public void bliBitt(){
		if(syk) {
			 lever = false;
		} else {
			syk = true;
		}
	}

	public void sjekktilstand (String testid, String navn, boolean syk, int vekt, boolean lever) {
        System.out.println("********* Test av musobjekt, testid: " + testid + " ***");
        System.out.println("** navn: " + navn + ", OK");
        
        System.out.print("** syk: " + this.syk + ", ");
        if (this.syk == syk) {
        	System.out.println("OK.");
        } else {
            System.out.println("FEIL");
		}

		System.out.print("** vekt: " + this.vekt + ", ");
        if (this.vekt == vekt) {
    		System.out.println("OK.");
        } else {
            System.out.println("FEIL");
		}

		System.out.print("** lever: " + this.lever+ ", ");
        if (this.lever == lever) {
        	System.out.println("OK.");
        } else {
        	System.out.println("FEIL");
		}
    }
    
    public void infoOmTilstand(String tilstand) {
    	System.out.println("---  " + tilstand + "  --- Info om mus: vekt:" + vekt + ", syk:" + syk + ", lever:" + lever);
    }
}