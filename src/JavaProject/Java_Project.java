package JavaProject;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;  
import java.util.regex.Pattern;
import java.applet.*;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Java_Project {
	public Java_Project(){
		
		final JTextField textResult = new JTextField(40); 
	       textResult.setEditable(false);
	        
	       JPanel panelDose = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2)); 
	       final JTextField txtDose = new JTextField(8); 
	       JLabel lebel2 = new JLabel("mg/dL");
	       txtDose.setToolTipText("Insert Dose Level");
	       panelDose.add(txtDose);
	       panelDose.add(lebel2);
	       panelDose.setBorder(new TitledBorder("Dose Amount"));
	       
	       JPanel panelOpMode = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
	       JButton buttonBegin = new JButton("Begin");
	       JButton buttonClear = new JButton("Clear");
	   
	       
	       buttonBegin.addActionListener(new ActionListener() {
	       
	       public void actionPerformed(ActionEvent e)
	            {
	                int chk, val = 0;
	                chk = 0;
	                String valueTxt = txtDose.getText();
	                try{
	                    val = Integer.parseInt(valueTxt);
	                }
	                catch (NumberFormatException ex)
	                        {
	                            chk = 1;
	                            textResult.setText("Input Should be a Number");
	                            textResult.setBackground(Color.white);
	                        }
	                if (chk == 0)
	                {		
	                   if (val<=0)   {
	                       textResult.setText("Negetive input !!!!! not accepted");
	                       textResult.setBackground(Color.white);
	                   }
	                   else if (val>=1 && val<=100) {
	                       textResult.setText("Normal Level: Please Eat Foods As You Like");
	                       textResult.setBackground(Color.green);
	                   }
	                   else if (val>=101 && val<=126) {
	                       textResult.setText("PreDiabetes Level: Please Do Excercise");
	                       textResult.setBackground(Color.yellow);
	                   }
	                   else if (val>126) {
	                       try {
	                           textResult.setText("Diagnosis of Diabetes Level: Please Consult Doctor");
	                           textResult.setBackground(Color.red);
	                           ////
	                           
	                          File afile = new File("sound.wav");
	                           AudioInputStream astream = null;
	                           try {
	                               astream = AudioSystem.getAudioInputStream(afile);
	                           } catch (UnsupportedAudioFileException ex) {
	                               Logger.getLogger(Java_Project.class.getName()).log(Level.SEVERE, null, ex);
	                           } catch (IOException ex) {
	                               Logger.getLogger(Java_Project.class.getName()).log(Level.SEVERE, null, ex);
	                           }
	                           Clip audio = null;
	                           try {
	                               audio = AudioSystem.getClip();
	                           } catch (LineUnavailableException ex) {
	                               Logger.getLogger(Java_Project.class.getName()).log(Level.SEVERE, null, ex);
	                           }
	                           audio.open(astream);
	                           audio.setFramePosition(0);
	                           audio.start();
	                           
	                           
	                           /////
	                       } catch (LineUnavailableException ex) {
	                           Logger.getLogger(Java_Project.class.getName()).log(Level.SEVERE, null, ex);
	                       } catch (IOException ex) {
	                           Logger.getLogger(Java_Project.class.getName()).log(Level.SEVERE, null, ex);
	                       }
	                   }
	                }
	                
	            }
	        });   
	       buttonClear.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent e)
	            {
	               textResult.setText("");
	               txtDose.setText("");
	               textResult.setBackground(Color.white);
	            }
	           
	       });
	       buttonBegin.setToolTipText("Click to get output");
	       buttonClear.setToolTipText("Click to clear input");
	       panelOpMode.add(buttonBegin);
	       panelOpMode.add(buttonClear);
	  
	       panelOpMode.setBorder(new TitledBorder("Operator Mode"));
	       
	       JPanel panelStart = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));       
	       ImageIcon icon = new ImageIcon("b3.jpg");
	       JLabel lebel = new JLabel("                     Insulin Pump Simulator       ");
	       Font f = new Font("Dialog", Font.PLAIN, 24);
	       lebel.setFont(f);
	       panelStart.add(lebel);
	       panelStart.add(new JLabel(icon));
	       panelStart.setBorder(new TitledBorder("Simulator"));
	       
	       JPanel panelOutput = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));     
	       JLabel lebel3 = new JLabel("");
	       //final JTextField textResult = new JTextField(40); // 1st line
	       panelOutput.add(lebel3);
	       panelOutput.add(textResult);
	       panelOutput.setBorder(new TitledBorder("Output"));
	       
	       JFrame fm = new JFrame();
	       fm.setTitle("Insulin Pump Project");
	       fm.setSize(600, 350);
	       fm.setLocation(350,120);
	       fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       fm.add(panelStart, BorderLayout.BEFORE_FIRST_LINE);
	       fm.add(panelDose, BorderLayout.WEST);
	       fm.add(panelOpMode, BorderLayout.EAST);
	       fm.add(panelOutput, BorderLayout.SOUTH);
	       
	       fm.setVisible(true);
	    }
	

	public static void main(String[] args) {
	Java_Project java=new Java_Project();

	}

}
