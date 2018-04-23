import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorGUI extends JFrame {
	
	private ImageIcon img;
	protected JTextArea textArea;
	private JScrollPane scrollPane;
	private Menu menu;
	protected String selectedText,originalText;
	
	public TextEditorGUI() {
		setTitle("Untitled-TextEditor");
		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		selectedText="";
		setDefaults();
		menu = new Menu(this);
		setJMenuBar(menu);
		setVisible(true);
	}
	
	private void setDefaults() {
		setLayout(new GridLayout(1,1));
		
		img = new ImageIcon("icon.png");
		setIconImage(img.getImage());
		

		textArea = new JTextArea();
		textArea.setFont(textArea.getFont().deriveFont(22f));
		textArea.addMouseListener(new TextAreaMouseListener(this));
		textArea.getDocument().addDocumentListener(new TextEditorEventHandler(this));

		
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		originalText=textArea.getText();
		addWindowListener(new ExitEventHandler(this));
		
	}
	
}
