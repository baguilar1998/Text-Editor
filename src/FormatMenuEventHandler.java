import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class FormatMenuEventHandler implements ActionListener {

	private TextEditorGUI frame;
	private FontPrompt fontPrompt;
	
	public FormatMenuEventHandler(TextEditorGUI frame) {
		this.frame = frame;
		fontPrompt = new FontPrompt();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String formatMenuName = e.getActionCommand();
		
		if(formatMenuName.equals("Font")) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	try {
	            		fontPrompt.displayPrompt();
	            	}finally {
	            		frame.textArea.setFont(frame.textArea.getFont().deriveFont(fontPrompt.getFontSize()));
	            	}
	            }
	        });
		}
	}
}