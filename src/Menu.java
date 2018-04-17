import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{

	private JFrame frame;
	private JMenu file,edit,format,view;
	private JMenuItem newFile,open,save,saveAs;
	private JMenuItem undo,cut,copy,paste,delete;
	private JMenuItem font;
	private JMenuItem statusbar;
	private FileMenuEventHandler meh;


	
	public Menu(JFrame frame) {
		this.frame = frame;
		meh = new FileMenuEventHandler(frame);
		setFileTab();
		setEditTab();
		setFormatTab();
		setViewTab();
	}
	
	private void setFileTab() {
		file = new JMenu("File");
		add(file);
		
		newFile = new JMenuItem("New");
		newFile.addActionListener(meh);
		file.add(newFile);
		
		open = new JMenuItem("Open");
		open.addActionListener(meh);
		file.add(open);
		
		save = new JMenuItem("Save");
		save.addActionListener(meh);
		file.add(save);
		
		saveAs = new JMenuItem("Save As");
		saveAs.addActionListener(meh);
		file.add(saveAs);
		
	}
	
	private void setEditTab() {
		edit = new JMenu("Edit");
		add(edit);
		
		undo = new JMenuItem("Undo");
		edit.add(undo);
		
		cut = new JMenuItem("Cut");
		edit.add(cut);
		
		copy = new JMenuItem("Copy");
		edit.add(copy);
		
		paste = new JMenuItem("Paste");
		edit.add(paste);
		
		delete = new JMenuItem("Delete");
		edit.add(delete);
	}
	
	private void setFormatTab() {
		format = new JMenu("Format");
		add(format);
		
		font = new JMenuItem("Font");
		format.add(font);
		
	}
	
	private void setViewTab() {
		view = new JMenu("View");
		add(view);
		
		statusbar = new JMenuItem("View Status Bar");
		view.add(statusbar);
	}
}
