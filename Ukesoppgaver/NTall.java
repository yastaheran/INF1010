class NTall extends Thread { //8.2 B
	int start, n, max;
	NTallMonitor monitor;
	
	NTall(int start, int n, int max) {
		this.start = start;
		this.n = n;
		this.max = max;
	}
	
	public void run() {
		try {
			for(int i = start; i <= max; i += n) {
				//System.out.println(i);
				monitor.printUt(i); //8.2 D
			}
		} catch (Exception e) {
			System.out.println("Expetion Found");
		}
	}
}