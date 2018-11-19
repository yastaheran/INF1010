import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FilVelger extends JPanel implements ActionListener {
    static private final String nylinje = "\n";
    JButton openKnp;
    JTextArea log;
    JFileChooser filVelger;
    File fil;
    
    public FilVelger() {
        super(new BorderLayout());

        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        filVelger = new JFileChooser();
	//	FileNameExtensionFilter filter = new FilNameExtensionFilter("TEKST FILER", "txt");

	//	filVelger.setFileFilter(filter);
        filVelger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        openKnp = new JButton("Åpne fil");
        openKnp.addActionListener(this);

        JPanel knappPanel = new JPanel();
    	knappPanel.add(openKnp);

        add(knappPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        int returnVal = filVelger.showOpenDialog(FilVelger.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fil = filVelger.getSelectedFile();
            log.append("Åpner: " + fil.getName() + "." + nylinje);
        } else {
            log.append("Kommanda kansellert av bruker." + nylinje);
        }
        log.setCaretPosition(log.getDocument().getLength());
    }
    
    public String hentFilnavn() {
    	return fil.getName();
    }

    static void lagOgVisGUI() {
        JFrame frame = new JFrame("Fil Valg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new FilVelger();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

/*    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                lagOgVisGUI();
            }
        });
    } */
}