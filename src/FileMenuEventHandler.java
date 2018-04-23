import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileMenuEventHandler implements ActionListener {

	private TextEditorGUI frame;
	private String dir;
	
	/*
	 * Default constructor for FileMenuEventHandler
	 * @param frame the current frame
	 */
	public FileMenuEventHandler(TextEditorGUI frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String menuName = e.getActionCommand();
		
		if(menuName.equals("New")) {
			saveBeforeChange();
			frame.textArea.setText("");
			frame.originalText=frame.textArea.getText();
			frame.setTitle("Untitled-TextEditor");
		}
		
		if(menuName.equals("Open")) {
			saveBeforeChange();
			openFile();
		}
		
		if(menuName.equals("Save")) {
			String fileName="";
			if(frame.getTitle().charAt(0)=='*') {
				fileName=frame.getTitle().substring(1,frame.getTitle().indexOf("-"));
				frame.setTitle(frame.getTitle().substring(1));
			}else {
				fileName =frame.getTitle().substring(0,frame.getTitle().indexOf("-"));
				frame.setTitle(frame.getTitle());
			}

			File file = new File(dir+"\\"+fileName);
			if(file.exists()) {
				saveCurrentFile(file);
			}else {
				saveNewFile();
			}
		}

		if(menuName.equals("Save As")) {
			saveNewFile();
		}
		
	}
	
	/*
	 * A function that allows the user to save
	 * a new file that they have created
	 */
	public void saveNewFile() {
		JFileChooser choose = new JFileChooser();
		if(choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		try {
				dir=choose.getCurrentDirectory().toString();
				String fileName =dir+ "\\" + choose.getSelectedFile().getName();
			    File file = new File(fileName);
			    if(file.exists()) {
			    	int confirm = JOptionPane.showConfirmDialog(null, 
			    			"File already exists. Do you want to overwrite it?",
			    			"Choose one",JOptionPane.YES_NO_OPTION);
			    	if(confirm == JOptionPane.NO_OPTION)return;
			    }
				PrintWriter writer = new PrintWriter(file);
				writer.write(frame.textArea.getText());
				writer.close();
				frame.setTitle(choose.getSelectedFile().getName()+"-Text Editor");
				frame.originalText=frame.textArea.getText();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/*
	 * A function that saves the current file that
	 * the user is editing
	 * @param file the current file
	 */
	public void saveCurrentFile(File file) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.write(frame.textArea.getText());
			frame.originalText=frame.textArea.getText();
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	/*
	 * A function that allows the user to open up
	 * a text file that the user wants to edit
	 */
	public void openFile() {
		JFileChooser choose = new JFileChooser();
		   if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					File selectedFile = choose.getSelectedFile();
					dir=choose.getCurrentDirectory().toString();
					Scanner readFile = new Scanner(selectedFile);
					if(!frame.textArea.getText().isEmpty()) {
						frame.textArea.setText("");
					}
					while(readFile.hasNext()) {
						String currentLine = readFile.nextLine();
						frame.textArea.append(currentLine+"\n");
					}
					frame.setTitle(selectedFile.getName()+"-Text Editor");
					frame.originalText=frame.textArea.getText();
					readFile.close();
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "File Not Found");
				}

		   }
	}
	
	public void saveBeforeChange() {
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
							e1.printStackTrace();
						}
					}
				}else {
					if(frame.getTitle().charAt(0)=='*') {
						fileName=frame.getTitle().substring(1,frame.getTitle().indexOf("-"));
						frame.setTitle(frame.getTitle().substring(1));
					}else {
						fileName =frame.getTitle().substring(0,frame.getTitle().indexOf("-"));
						frame.setTitle(frame.getTitle());
					}

					File file = new File(dir+"\\"+fileName);
					if(file.exists()) {
						saveCurrentFile(file);
					}else {
						saveNewFile();
					}
				}
			}else {
				return;
			}
		}
	}

}
