public class TiendeTall extends Thread { //8.2 A
	int min, max;
	
	TiendeTall(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public void run() {
		try {
			for(int m = min; m <= max; m += 10) {
				System.out.println(m);
			}
		} catch (Exception e) {
			System.out.println("Expetion Found");
		}
	}
}
