package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressDialog extends JDialog {

	private JButton cancelButton;
	private JProgressBar progressBar;
	
	public ProgressDialog(Window parent) {
		super(parent, "Messages downloading...", ModalityType.APPLICATION_MODAL);
		
		cancelButton = new JButton("Cancel");
		progressBar = new JProgressBar();
		
		// progressBar.setIndeterminate(true);
		
		setLayout(new FlowLayout());
		
		Dimension size = cancelButton.getPreferredSize();
		size.width = 400;
		progressBar.setPreferredSize(size);
		
		add(progressBar);
		add(cancelButton);
		
		pack();
		
		setSize(600, 80);
		setLocationRelativeTo(parent);
	}
	
	public void setMaximum(int value) {
		progressBar.setMaximum(value);
	}
	
	public void setValue(int value) {
		progressBar.setValue(value);
	}

	@Override
	public void setVisible(final boolean visible) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				if(visible == false) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					progressBar.setValue(0);
				}
				
				ProgressDialog.super.setVisible(visible);
			}
		});
	}
}
