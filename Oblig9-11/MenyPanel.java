import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MenyPanel extends JPanel {
	private KontrollFil k;
	public MenyPanel() {
    	setBorder(new EmptyBorder(4, 4, 4, 4));
    	setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
    	gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton losning = new JButton("Løsning");
        JButton velgFil = new JButton("Velg Fil"); 
        
       losning.addActionListener(trykket);
      /*{
        	public void actionPerformed(ActionEvent e) {
        			k.losOppgave();					//kaller på losOppgave-metoden i KontrollFil
        	}
        });
        
        
        */
        velgFil.addActionListener(trykket);
        /*new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		k.sporOmOgSjekkFil();			//kaller på sporOmOgSjekkFil-metoden
        		if(k.sporOmOgSjekkFil() == true ) {
        			k.lesFil();				//kaller på lesFil-metoden hvis filformatet er godkjent
        		}
        	}
        }); */
        
        ActionListener trykket = new ActionListener() {	//sjekker om knappen er trykket
      		public void actionPerformed(ActionEvent actionEvent) {

          		System.out.println(actionEvent.getActionCommand());
      		}
    	};
    	
        add(losning, gbc);
        gbc.gridy++; 	
        add(velgFil, gbc);	
  	}
  	
  	 ActionListener trykket = new ActionListener() {	//sjekker om knappen er trykket
      	public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getActionCommand().equals("Velg Fil")) {
				k.losOppgave();					//kaller på losOppgave-metoden i KontrollFil
			} else if (e.getActionCommand().equals("Save Puzzle")) {
				k.sporOmOgSjekkFil();			//kaller på sporOmOgSjekkFil-metoden
        		if(k.sporOmOgSjekkFil() == true ) {
        			k.lesFil();				//kaller på lesFil-metoden hvis filformatet er godkjent
        		}
			}
      	}
    };
}
