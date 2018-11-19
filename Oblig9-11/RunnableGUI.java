import javax.swing.*;
import java.awt.*;

class RunnableGUI implements Runnable {
protected MenyPanel mp;
	@Override
    public void run() {
    	try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
	    } catch (InstantiationException ex) {
            System.out.println("InstantationExcpetion");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException");
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("UnsupportedLookAndFeelException");
        }
        JFrame ramme = new JFrame();
        ramme.setSize(400,400);
        ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramme.setLayout(new BorderLayout());
        ramme.add(mp = new MenyPanel(), BorderLayout.AFTER_LINE_ENDS);
        ramme.pack();
        ramme.setVisible(true);
    }
}