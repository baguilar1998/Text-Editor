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
	private EditMenuEventHandler eeh;


	/*
	 * Default constructor for the menu
	 * @param the JFrame the menu will be placed in
	 */
	public Menu(JFrame frame) {
		this.frame = frame;
		meh = new FileMenuEventHandler(frame);
		eeh = new EditMenuEventHandler(frame);
		setFileTab();
		setEditTab();
		setFormatTab();
		setViewTab();
	}
	
	/*
	 * A helper method to set up the File Menu
	 */
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
	
	/*
	 * A helper method to set up the Edit Menu
	 */
	private void setEditTab() {
		edit = new JMenu("Edit");
		add(edit);
		
		undo = new JMenuItem("Undo");
		edit.add(undo);
		
		cut = new JMenuItem("Cut");
		edit.add(cut);
		
		copy = new JMenuItem("Copy");
		copy.addActionListener(eeh);
		edit.add(copy);
		
		paste = new JMenuItem("Paste");
		edit.add(paste);
		
		delete = new JMenuItem("Delete");
		edit.addActionListener(eeh);
		edit.add(delete);
	}
	
	/*
	 * A helper method to set up the Format Menu
	 */
	private void setFormatTab() {
		format = new JMenu("Format");
		add(format);
		
		font = new JMenuItem("Font");
		format.add(font);
		
	}
	
	/*
	 * A helper method to set up the View Menu
	 */
	private void setViewTab() {
		view = new JMenu("View");
		add(view);
		
		statusbar = new JMenuItem("View Status Bar");
		view.add(statusbar);
	}
}
