

package simplejavatexteditor;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class About {

    private final JFrame frame;
    private final JPanel panel;
    private String contentText;
    private final JLabel text;

    public About(UI ui) {
        panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        frame = new JFrame();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });


        frame.setVisible(true);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(ui);
        text = new JLabel();
    }

    public void me() {
        frame.setTitle("About Us - " + SimpleJavaTextEditor.NAME);

        contentText =
        "<html><body><p>" +
        "A simple text editor application"+
    
        "<br /><br />"+
        "Contact us at: " +
        "<br /><br />" +
        "<a href='" + SimpleJavaTextEditor.AUTHOR_EMAIL1 + 
        "?subject=About Hamro NotePad  Software'>" + 
        SimpleJavaTextEditor.AUTHOR_EMAIL1 + "</a>" +
                "<br /><br />" +


                "<a href='" + SimpleJavaTextEditor.AUTHOR_EMAIL2 + 
        "?subject=About Hamro NotePad  Software'>" + 
        SimpleJavaTextEditor.AUTHOR_EMAIL2 + "</a>" +
        "<br /><br />" +

        "<a href='" + SimpleJavaTextEditor.AUTHOR_EMAIL3 + 
        "?subject=About Hamro NotePad  Software'>" + 
        SimpleJavaTextEditor.AUTHOR_EMAIL3 + "</a>" +
                "<br /><br />" +
                 
               
                
                
                // "Contact me at: <a href='" + 
                // SimpleJavaTextEditor.EDITOR_EMAIL + 
                // "?subject=About Hamro NotePad PH Software'>" + 
                // SimpleJavaTextEditor.EDITOR_EMAIL + "</a>" +
        "</p></body></html>";

        text.setText(contentText);
        panel.add(text);
        frame.add(panel);
    }

    public void software() {
        frame.setTitle("About - " + SimpleJavaTextEditor.NAME);

        contentText =
        "<html><body><p>" +
        "Name: " + SimpleJavaTextEditor.NAME + "<br /> <br/>" +
        "Hamro Notepad is a  software application that allows users to create,"+"<br />" +
        " edit, and manipulate plain text files. It's a fundamental tool which can be  "+ "<br />" +  
        " used by programmers,writers and anyone who works with text-based content. "+
       
        "</p></body></html>";

        text.setText(contentText);
        panel.add(text);
        frame.add(panel);
    }

}