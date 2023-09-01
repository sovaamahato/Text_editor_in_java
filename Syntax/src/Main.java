import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaSyntaxHighlighter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Java Syntax Highlighting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextPane textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.add(scrollPane);
        frame.setSize(800, 600);
        frame.setVisible(true);

        setupSyntaxHighlighting(textPane);

        // Sample Java code to insert
        String sampleCode = "public class HelloWorld {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello, World!\");\n" +
                "    }\n" +
                "}";
        textPane.setText(sampleCode);
    }

    private static void setupSyntaxHighlighting(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        addStylesToDocument(doc);

        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                highlightSyntax(doc, textPane.getText());
            }
        });

        // Initial highlighting
        highlightSyntax(doc, textPane.getText());
    }

    private static void addStylesToDocument(StyledDocument doc) {
        // Define the styles for various language elements
        Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setFontFamily(def, "Courier New");
        StyleConstants.setFontSize(def, 14);

        Style keyword = doc.addStyle("keyword", def);
        StyleConstants.setForeground(keyword, Color.BLUE);

        Style comment = doc.addStyle("comment", def);
        StyleConstants.setForeground(comment, Color.GREEN.darker());

        Style string = doc.addStyle("string", def);
        StyleConstants.setForeground(string, Color.RED);
    }

    private static void highlightSyntax(StyledDocument doc, String text) {
        // Define regular expressions to match Java keywords, comments, and strings
        String keywords = "\\b(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while)\\b";
        String comments = "//[^\n]*|/\\*(.|\\R)*?\\*/";
        String strings = "\"[^\"]*\"";

        Pattern pattern = Pattern.compile(keywords + "|" + comments + "|" + strings);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            AttributeSet style = null;

            if (group.matches(keywords)) {
                style = doc.getStyle("keyword");
            } else if (group.matches(comments)) {
                style = doc.getStyle("comment");
            } else if (group.matches(strings)) {
                style = doc.getStyle("string");
            }

            if (style != null) {
                doc.setCharacterAttributes(start, end - start, style, false);
            }
        }
    }
}
