public class YngsteForstReseptListe extends EnkelReseptListe {
	public void settInnReseptYngst(int reseptnr) {
		if (tom()) {
			forste.data = reseptnr;
		}
		else { 
			temp = siste;
			while( temp != null) {
				if(temp.data == 0){
					temp.data = reseptnr;
				} 
				else {
					temp = temp.forrige;
				}
			}
		}
	}
}