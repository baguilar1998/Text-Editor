import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.text.Highlighter.Highlight;

public class EditMenuEventHandler implements ActionListener{
	
	private JFrame frame;
	
	public EditMenuEventHandler(JFrame frame) {
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String editMenuName = e.getActionCommand();
		
		if(editMenuName.equals("Delete")) {
			String selectedText = ((TextEditorGUI)frame).textArea.getSelectedText();
			System.out.println(selectedText);
			String deletedText=((TextEditorGUI)frame).textArea.getText().replace(selectedText,"");
			((TextEditorGUI)frame).textArea.setText(deletedText);
		}
	}
}
		

