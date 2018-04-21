import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextEditorEventHandler implements DocumentListener {
	
	private TextEditorGUI frame;

	
	/*
	 * Default constructor to TextEditorEventHandler
	 * @param frame the current frame 
	 */
	public TextEditorEventHandler(TextEditorGUI frame) {
		this.frame = frame;
		//originalText = frame.textArea.getText();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {}
	
	/*
	 * Updates the current save state of the GUI every 
	 * time the user types in something new. 
	 * @param e an update to the document
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		if(frame.textArea.getText().equals(frame.originalText)) {
			if(frame.getTitle().charAt(0) == '*')frame.setTitle(frame.getTitle().substring(1));
			else frame.setTitle(frame.getTitle());
		}else if(frame.getTitle().charAt(0) == '*') {return;}
		else frame.setTitle("*"+frame.getTitle());
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

		if(frame.textArea.getText().equals(frame.originalText)) {
			if(frame.getTitle().charAt(0) == '*')frame.setTitle(frame.getTitle().substring(1));
			else frame.setTitle(frame.getTitle());
		}else if(frame.getTitle().charAt(0) == '*') {return;}
		else frame.setTitle("*"+frame.getTitle());
		//if(((TextEditorGUI)frame).getTitle().charAt(0) == '*')return;
		//else ((TextEditorGUI)frame).setTitle("*"+((TextEditorGUI)frame).getTitle());
	}

}
