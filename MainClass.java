/*
 * Flusher v1
 * To do later: Optimize, make the code more secure
 * 
 */


package flusher1;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainClass {

	private static void deleteDir(File file) {
	    File[] contents = file.listFiles();
	    if (contents != null) {
	        for (File f : contents) {
	            deleteDir(f);
	        }
	    }
	    file.delete();
	}
	
	private static void createAndShowGUI() {

		//the frame
		final JFrame frame = new JFrame("Flusher v1 : Antivirus");
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(1, 1));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		//layered pane
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(BorderFactory.createTitledBorder("Settings"));

		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel1.setLayout(new GridLayout(1, 1, 5, 10));
		panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		tabbedPane.addTab("System", panel1);		
		panel1.add(layeredPane);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel2.setLayout(new GridLayout(1, 1, 5, 10));
		panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		
		
		
		frame.getContentPane().add(tabbedPane);
		tabbedPane.addTab("Networking", panel2);
		
		
		JCheckBox checkBox = new JCheckBox("Restore the system integrity");	
		checkBox.setBounds(15, 25, 400, 20);		
		layeredPane.add(checkBox, new Integer(1));

		JCheckBox checkBox2 = new JCheckBox("Restore the registry");	
		checkBox2.setBounds(15, 50, 400, 20);		
		layeredPane.add(checkBox2, new Integer(1));
		
		JCheckBox checkBox3 = new JCheckBox("Restore the browser settings");	
		checkBox3.setBounds(15, 75, 400, 20);		
		layeredPane.add(checkBox3, new Integer(1));		
		
		JCheckBox checkBox4 = new JCheckBox("Restore the default launch programs");	
		checkBox4.setBounds(15, 100, 400, 20);		
		layeredPane.add(checkBox4, new Integer(1));			
		
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(15, 180, 90, 20);
		layeredPane.add(startButton);
		
		startButton.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent ae){
		    	   //use an array with a for loop or something later
		    	   
		    	   if (checkBox.isSelected()){
		    		   try {
		    			   final Process p = Runtime.getRuntime().exec("sfc /scannow");
		    		   }catch (IOException e) {
		    			   e.printStackTrace();
		    		   }
		    	   }
		    	   
		    	   if (checkBox2.isSelected()){
		    		   
		    		   
		    		   
		    	   }
		    	   
		    	   if (checkBox3.isSelected()){
		    		   
		    	   }
		    	   
		    	   if (checkBox4.isSelected()){
		    		   
		    	   }
		       } 
		    });
		

		JLayeredPane layeredPane2 = new JLayeredPane();
		layeredPane2.setBorder(BorderFactory.createTitledBorder("Settings"));
		panel2.add(layeredPane2);
		
		
		JCheckBox checkBox5 = new JCheckBox("Flush the DNS cache");	
		checkBox5.setBounds(15, 25, 400, 20);		
		layeredPane2.add(checkBox5, new Integer(1));

		
		JCheckBox checkBox6 = new JCheckBox("Flush the ARP cache");	
		checkBox6.setBounds(15, 50, 400, 20);		
		layeredPane2.add(checkBox6, new Integer(1));
		
		
		JButton startButton2 = new JButton("Start");
		startButton2.setBounds(15, 180, 90, 20);
		startButton2.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent ae){
		    	   if (checkBox5.isSelected()){
	    			   try {
						final Process p = Runtime.getRuntime().exec("ipconfig /flushdns");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		    	   
		    	   }
		    	   
		    	   if (checkBox6.isSelected()){
	    			   try {
	    				   final Process p = Runtime.getRuntime().exec("arp -d -a");
						} catch (IOException e) {
							e.printStackTrace();
						}
		    	   }
		       }
		});		
		
		layeredPane2.add(startButton2);		
		
	}

	public static void main(String[] args) {

  //Schedule a job for the event-dispatching thread:

  //creating and showing this application's GUI.

  javax.swing.SwingUtilities.invokeLater(new Runnable() {

public void run() {

    createAndShowGUI(); 

}

  });
    }

}