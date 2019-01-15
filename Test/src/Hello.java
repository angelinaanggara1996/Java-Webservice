import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Hello extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel id = new JLabel ("Insert ID :");
	private JLabel name = new JLabel ("Insert Name :");
	private JTextField inId = new JTextField(20);
	private JTextField inName = new JTextField(20);
	
	private JButton buttn = new JButton("Submit");
	private JButton cncl = new JButton("Cancel");
	public Hello() {
	
		super("ID Test");
		JPanel jp = new JPanel(new GridBagLayout());
        
        GridBagConstraints cst = new GridBagConstraints();
        cst.anchor = GridBagConstraints.WEST;
        cst.insets = new Insets(10, 10, 10, 10);
        
        cst.gridx = 0;
        cst.gridy = 0;
        jp.add(id, cst);
        cst.gridx = 1;
        jp.add(inId,cst);
        cst.gridx = 0;
        cst.gridy = 1;
        jp.add(name, cst);
        cst.gridx = 1;
        jp.add(inName,cst);
        cst.gridx = 0;
        cst.gridy = 2;
        cst.gridwidth = 2;
        cst.anchor = GridBagConstraints.CENTER;
        jp.add(buttn,cst);
        cst.gridx = 1;
        cst.anchor = GridBagConstraints.EAST;
        jp.add(cncl,cst);
        setSize(500, 500);
        add(jp);
        buttn.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  String id = inId.getText();
        		  String name = inName.getText(); 
        		  //System.out.print(id);
        		  if(id.equals("")) {
        			  JOptionPane.showMessageDialog(null, "Please Input your ID");
        		  }
        		  else if(name.equals("")) {
        			  JOptionPane.showMessageDialog(null, "Please Input your Name");
        		  }
        		  else {
        			  new ShowId().getIdName(id,name);
        		  }
        	  } 
        	} 
        );
        cncl.addActionListener(new ActionListener() { 
      	  public void actionPerformed(ActionEvent e) { 
      		  dispose();
      	  } 
      	} 
        );
        inId.addKeyListener(new KeyListener()
        {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
	}
	public static void main(String[] args) {
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Hello().setVisible(true);
            }
        });
    }

}
