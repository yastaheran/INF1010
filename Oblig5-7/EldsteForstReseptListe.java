public class EldsteForstReseptListe extends EnkelReseptListe {
	public void settInnResept(int reseptnr) { 
	//setter inn yngre resept etter eldste
		if (tom()) {
			forste.data = reseptnr;
		} else { 
			temp = forste;
			while( temp != null) {
				if(temp.data == null){
					temp.data = reseptnr;
				} else {
					temp = temp.neste;
				}
			}
		}
	}
}
