import java.util.ArrayList;
public class TestTabell {
    public static void main(String[] args) {
    
        VanligLegemiddelMikstur paracet = new VanligLegemiddelMikstur("Paracet" , 20.5, 500);
        VanligLegemiddelPille ibux = new VanligLegemiddelPille("Ibux", 22, 500);
        NarkotiskLegemiddelPille morfin = new NarkotiskLegemiddelPille("Morfin", 49, 10,  7);
        VanedannendeLegemiddelPille valium = new VanedannendeLegemiddelPille("Valium", 86, 10, 5);
        
        Tabell<Legemidler> legemidler = new Tabell<Legemidler>(6);
        
        legemidler.settInn(4, paracet);
        legemidler.settInn(1, ibux);
        legemidler.settInn(2, morfin);
        legemidler.settInn(3, valium);
        
		System.out.println("_________________\nLEGEMIDLER:");
		for (Legemidler l: legemidler) {
			System.out.println(l);
		}
		
		Tabell<Personer> personer = new Tabell<Personer>(5);
		Personer hansen = new Personer("Hansen", "20068512345", "Tuterudveien 1", 2001);
		Personer grete = new Personer("Grete", "05109023456", "Granbergstubben 5", 1234); 
		
		personer.settInn(2, hansen);
		personer.settInn(1, grete);
		
		System.out.println("______________________________\n PERSONER:");
		for (Personer p: personer) {
			System.out.println(p);
		}
		
		System.out.println("______________________\n Tester Finn metode, Her skal Ibux ligge:");
		System.out.println(legemidler.finn(1));
	}
}


