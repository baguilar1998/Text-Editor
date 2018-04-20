import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TextEditorGUI extends JFrame {
	
	protected JTextArea textArea;
	private JScrollPane scrollPane;
	private Menu menu;
	
	
	public TextEditorGUI() {
		setTitle("Untitled-TextEditor");
		setSize(700,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setDefaults();
		menu = new Menu(this);
		setJMenuBar(menu);
		setVisible(true);
	}
	
	private void setDefaults() {
		setLayout(new GridLayout(1,1));
		
		textArea = new JTextArea();
		textArea.setFont(textArea.getFont().deriveFont(22f));
		textArea.addMouseListener(new EditMenuEventHandler(this));
		textArea.getDocument().addDocumentListener(new TextEditorEventHandler(this));
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		addWindowListener(new ExitEventHandler(this));
		
	}
	
}
