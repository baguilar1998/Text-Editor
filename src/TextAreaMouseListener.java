import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TextAreaMouseListener implements MouseListener{
	
	private TextEditorGUI frame;
	public TextAreaMouseListener(TextEditorGUI frame) {
		this.frame=frame;
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
			frame.selectedText = frame.textArea.getSelectedText();
		}else {
			return;
		}
		
	}
}
