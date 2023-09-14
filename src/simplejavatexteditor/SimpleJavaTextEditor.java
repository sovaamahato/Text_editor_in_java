

package simplejavatexteditor;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SimpleJavaTextEditor extends JTextPane {

    private static final long serialVersionUID = 1L;
    public final static String AUTHOR_EMAIL1 = "mahatosova618@gmail.com";
    public final static String AUTHOR_EMAIL2 = "sijapatirinjha123@gmail.com";
    public final static String AUTHOR_EMAIL3 = "adhikaridipesh345@gmail.com";
    public final static String NAME = "HamroNotePad";
    public final static String EDITOR_EMAIL = "contactus@gmail.com";
    public final static double VERSION = 3.0;


    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
    		e.printStackTrace();
    	}
    	
        new UI().setVisible(true);
    }

}
