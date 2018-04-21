import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EditMenuEventHandler implements ActionListener{
	
	private TextEditorGUI frame;
	
	public EditMenuEventHandler(TextEditorGUI frame) {
		this.frame=frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String editMenuName = e.getActionCommand();
		
		if(editMenuName.equals("Copy")) {
			StringSelection selection = new StringSelection(frame.selectedText);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, null);
		}
		
		if(editMenuName.equals("Paste")) {
			Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable t = c.getContents(this);
			if(t == null) return;
			try {
				frame.textArea.append((String)t.getTransferData(DataFlavor.stringFlavor));
			}catch(Exception ex) {
				return;
			}
		}
		
		if(editMenuName.equals("Delete")) {
			if(frame.textArea.getSelectedText()!=null) {
				frame.textArea.setText(frame.textArea.getText().replace(frame.textArea.getSelectedText(), ""));
			}else {
				System.out.println("Nothing was selected");
			}
		}
	}


}
		

