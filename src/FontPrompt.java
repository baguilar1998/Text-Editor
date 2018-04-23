import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FontPrompt {
	
	private static Font currentFont;
	private static float fontSize;
	private static Color fontColor;
	
	private JTextField fontSizeInput;
	
	public FontPrompt() {
		currentFont=Font.getFont("Serif");
		fontSize=22;
		fontColor = Color.BLACK;
	}
	
	public static Font getCurrentFont() {
		return currentFont;
	}
	
	public static float getFontSize() {
		return fontSize;
	}
	
	public static Color getFontColor() {
		return fontColor;
	}
	
	public void setCurrentFont(Font newFont) {
		currentFont=newFont;
	}
	
	public void setFontSize(float fontSize) {
		FontPrompt.fontSize=fontSize;
	}
	
	public void setFontColor(Color fontColor) {
		FontPrompt.fontColor = fontColor;
	}
    
	public void displayPrompt() {
        int confirm =JOptionPane.showConfirmDialog(null,customJOptionPane(),"Font",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(confirm == JOptionPane.OK_OPTION) {
        	try {
        		setFontSize(Float.parseFloat(fontSizeInput.getText()));
        	}catch(Exception e) {
        		JOptionPane.showMessageDialog(null, "Invalid Inputs. No changes were made.");
        	}
        }else {
        	return;
        }
    }

    private JPanel customJOptionPane() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        JLabel fontSizeLabel = new JLabel("Font Size");
        fontSizeInput = new JTextField(3);
        panel.add(fontSizeLabel);
        panel.add(fontSizeInput);

        return panel;
    }

}
