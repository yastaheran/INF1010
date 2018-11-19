public class Nedover extends Thread {
	private TallMonitor monitor;
	private int start = Integer.MAX_VALUE;
	
	public void run() {
		monitor = new TallMonitor();
		while(monitor.settStorste(start) == true) {
			monitor.settStorste(start);
			start--;
		}
		System.out.println(start + " kunne ikke plasseres");
	}
	
}