import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextEditorEventHandler implements DocumentListener {
	
	private JFrame frame;
	
	/*
	 * Default constructor to TextEditorEventHandler
	 * @param frame the current JFrame 
	 */
	public TextEditorEventHandler(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Updates the current save state of the GUI every 
	 * time the user types in something new. 
	 * @param e an update to the document
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(((TextEditorGUI)frame).getTitle().charAt(0) == '*')return;
		else ((TextEditorGUI)frame).setTitle("*"+((TextEditorGUI)frame).getTitle());
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

		//if(((TextEditorGUI)frame).getTitle().charAt(0) == '*')return;
		//else ((TextEditorGUI)frame).setTitle("*"+((TextEditorGUI)frame).getTitle());
	}

}
