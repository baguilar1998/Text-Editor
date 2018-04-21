import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitEventHandler implements WindowListener{

	private TextEditorGUI frame;
	
	public ExitEventHandler(TextEditorGUI frame) {
		this.frame=frame;
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		String fileName =frame.getTitle().substring(1,frame.getTitle().indexOf("-"));
		if(frame.getTitle().charAt(0)=='*') {
			int saveConfirm = JOptionPane.showConfirmDialog(null, "Do you want to save changes to "+fileName+"?");
			if(saveConfirm == JOptionPane.YES_OPTION) {
				if(fileName.equals("Untitled")) {
					JFileChooser choose = new JFileChooser();
					if(choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
							String newFileName =choose.getCurrentDirectory().toString()+ "\\" + choose.getSelectedFile().getName();
						    File file = new File(newFileName);
						    if(file.exists()) {
						    	int confirm = JOptionPane.showConfirmDialog(null, "File already exists. Do you want to overwrite it?","Choose one",JOptionPane.YES_NO_OPTION);
						    	if(confirm == JOptionPane.NO_OPTION)return;
						    }
							PrintWriter writer = new PrintWriter(file);
							writer.write(frame.textArea.getText());
							writer.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else {
					System.out.println("Still has to be implemented");
				}
			}else {
				frame.dispose();
			}
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}

}
