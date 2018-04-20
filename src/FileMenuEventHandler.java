import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FileMenuEventHandler implements ActionListener {

	private JFrame frame;
	private String dir;
	
	public FileMenuEventHandler(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String menuName = e.getActionCommand();
		
		if(menuName.equals("New")) {
			frame.setTitle("Untitled-TextEditor");
			((TextEditorGUI)frame).textArea.setText("");
		}
		
		if(menuName.equals("Open")) {
			   JFileChooser choose = new JFileChooser();
			   if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						File selectedFile = choose.getSelectedFile();
						dir=choose.getCurrentDirectory().toString();
						Scanner readFile = new Scanner(selectedFile);
						if(!((TextEditorGUI)frame).textArea.getText().isEmpty()) {
							((TextEditorGUI)frame).textArea.setText("");
						}
						while(readFile.hasNext()) {
							String currentLine = readFile.nextLine();
							((TextEditorGUI)frame).textArea.append(currentLine+"\n");
						}
						((TextEditorGUI)frame).setTitle(selectedFile.getName()+"-Text Editor");
						readFile.close();
					} catch (FileNotFoundException ex) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "File Not Found");
					}

			   }
			
		}
		
		if(menuName.equals("Save")) {
			String fileName="";
			if(((TextEditorGUI)frame).getTitle().charAt(0)=='*') {
				fileName=((TextEditorGUI)frame).getTitle().substring(1,((TextEditorGUI)frame).getTitle().indexOf("-"));
				((TextEditorGUI)frame).setTitle(((TextEditorGUI)frame).getTitle().substring(1));
			}else {
				fileName =((TextEditorGUI)frame).getTitle().substring(0,((TextEditorGUI)frame).getTitle().indexOf("-"));
				((TextEditorGUI)frame).setTitle(((TextEditorGUI)frame).getTitle());
			}

			File file = new File(dir+"\\"+fileName);
			if(file.exists()) {
				PrintWriter writer;
				try {
					writer = new PrintWriter(file);
					writer.write(((TextEditorGUI)frame).textArea.getText());
					writer.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}else {
				JFileChooser choose = new JFileChooser();
				if(choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					PrintWriter writer;
					try {
						writer = new PrintWriter(file);
						writer.write(((TextEditorGUI)frame).textArea.getText());
						writer.close();
						((TextEditorGUI)frame).setTitle(choose.getSelectedFile().getName()+"-Text Editor");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		if(menuName.equals("Save As")) {
			JFileChooser choose = new JFileChooser();
			if(choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
					dir=choose.getCurrentDirectory().toString();
					String fileName =dir+ "\\" + choose.getSelectedFile().getName();
				    File file = new File(fileName);
				    if(file.exists()) {
				    	int confirm = JOptionPane.showConfirmDialog(null, "File already exists. Do you want to overwrite it?","Choose one",JOptionPane.YES_NO_OPTION);
				    	if(confirm == JOptionPane.NO_OPTION)return;
				    }
					PrintWriter writer = new PrintWriter(file);
					writer.write(((TextEditorGUI)frame).textArea.getText());
					writer.close();
					((TextEditorGUI)frame).setTitle(choose.getSelectedFile().getName()+"-Text Editor");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

}
