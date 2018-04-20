import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;


public class EditMenuEventHandler implements ActionListener,MouseListener{
	
	private JFrame frame;
	private String selectedText;
	
	public EditMenuEventHandler(JFrame frame) {
		this.frame=frame;
		selectedText = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String editMenuName = e.getActionCommand();
		
		if(editMenuName.equals("Copy")) {
			StringSelection selection = new StringSelection(selectedText);
			try {
				System.out.println(selection.getTransferData(DataFlavor.stringFlavor));
			} catch (UnsupportedFlavorException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(((TextEditorGUI)frame).textArea.getSelectedText()!=null) {
			selectedText = ((TextEditorGUI)frame).textArea.getSelectedText();
			System.out.println(selectedText);
		}else {
			System.out.println("Fix this");
		}
		
	}
}
		

