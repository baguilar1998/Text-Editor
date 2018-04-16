import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class FileReader {
	
	private Scanner readFile;
	private JFrame frame;
	
	public FileReader(JFrame frame,File file) {
		this.frame=frame;
		try {
			readFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File Not Found");
		}
	}
	
	public void printFileToFrame() {
		if(!((TextEditorGUI)frame).textArea.getText().isEmpty()) {
			((TextEditorGUI)frame).textArea.setText("");
		}
		while(readFile.hasNext()) {
			String currentLine = readFile.nextLine();
			((TextEditorGUI)frame).textArea.append(currentLine+"\n");
		}
		
	}

}
