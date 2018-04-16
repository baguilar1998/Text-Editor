import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class MenuEventHandler implements ActionListener {

	private JFrame frame;
	private Menu menu;
	
	public MenuEventHandler(JFrame frame, Menu menu) {
		this.frame = frame;
		this.menu = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String menuName = e.getActionCommand();
		if(menuName.equals("Open")) {
			   JFileChooser choose = new JFileChooser();
			   if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  FileReader reader = new FileReader(frame,choose.getSelectedFile());
				  reader.printFileToFrame();
			   }
			
		}
		
		if(menuName.equals("New")) {
			frame.setTitle("Untitled-TextEditor");
			((TextEditorGUI)frame).textArea.setText("");
		}
		
		
	}

}
