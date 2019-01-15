import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowId extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel lbl1 = new JLabel("");
	private JLabel lbl2 = new JLabel("");
	//private String myId = new String();
	public ShowId() {
		setVisible(true);
		setSize(300,200);
		JPanel jp = new JPanel(new GridBagLayout());
        
        GridBagConstraints cst = new GridBagConstraints();
        cst.anchor = GridBagConstraints.CENTER;
        cst.insets = new Insets(10, 10, 10, 10);
        
        cst.gridx = 1;
        cst.gridy = 1;
        jp.add(lbl1, cst);
        cst.gridy = 2;
        jp.add(lbl2, cst);
		add(jp);
	}
	public void getIdName(String id, String name) {
		lbl1.setText("My id is: " + id);
		lbl2.setText("My Name is: " + name);
	}
}
