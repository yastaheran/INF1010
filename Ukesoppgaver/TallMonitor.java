public class TallMonitor {
	int detMinste;
	int detStorste;

	public synchronized boolean settMinste(int m) {
		if(m < detStorste) {
			if(m < detMinste ) {
				detMinste = m;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public synchronized boolean settStorste(int s) {
		if(s > detMinste) {
			if(s > detStorste) {
				detStorste = s;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
}