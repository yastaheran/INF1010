public class Oppover extends Thread {
	private TallMonitor monitor;
	int start = Integer.MIN_VALUE;
	
	public void run() {
		monitor = new TallMonitor();
		while(monitor.settMinste(start) == true) {
			monitor.settMinste(start);
			start--;
		}
		System.out.println(start + " kunne ikke plasseres");
	}
	
}