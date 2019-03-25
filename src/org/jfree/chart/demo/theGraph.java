package org.jfree.chart.demo;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class theGraph extends ApplicationFrame {

/**
* A demonstration application showing an XY series containing a null value.
*
* @param title  the frame title.
*/
	
	
	
public theGraph(final String title,String subtit,double l [] , double q [], int Accuracy) {
  
   super(title);
   double q1min = q[0], q2min = q[1], q3min = q[2];
   double q1max = q[3], q2max = q[4], q3max = q[5];

	
   
    final XYSeries series = new XYSeries("„‰ÿﬁ… «ﬂ· «·⁄Ì‘");

    for(double i = q1min ; i <= q1max ; i += Accuracy)
    for(double j = q2min ; j <= q2max ; j += Accuracy)
    for(double k = q3min ; k <= q3max ; k += Accuracy)
    
    series.add(
    		l[0] * Math.cos(Math.toRadians(i)) + l[1] * Math.cos(Math.toRadians(i+j)) + l[2] * Math.cos(Math.toRadians(i+j+k)),
    		l[0] * Math.sin(Math.toRadians(i)) + l[1] * Math.sin(Math.toRadians(i+j)) + l[2] * Math.sin(Math.toRadians(i+j+k))
    		);
    
 
   	 
   final XYSeriesCollection data = new XYSeriesCollection(series);
   final JFreeChart chart = ChartFactory.createScatterPlot(    	
   	subtit,
       "X", 
       "Y", 
       data,
       PlotOrientation.VERTICAL,
       true,
       true,
       false
   );

   final ChartPanel chartPanel = new ChartPanel(chart);
   chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
   setContentPane(chartPanel);
   
}

//****************************************************************************
//* JFREECHART DEVELOPER GUIDE                                               *
//* The JFreeChart Developer Guide, written by David Gilbert, is available   *
//* to purchase from Object Refinery Limited:                                *
//*                                                                          *
//* http://www.object-refinery.com/jfreechart/guide.html                     *
//*                                                                          *
//* Sales are used to provide funding for the JFreeChart project - please    * 
//* support us so that we can continue developing free software.             *
//****************************************************************************

/**
* Starting point for the demonstration application.
*
* @param args  ignored.
*/


//playing and stoping wav clip

private static Clip play(Clip clip,boolean play)
{
	if(play){
		
    try{      
    AudioInputStream stream = AudioSystem.getAudioInputStream(new File("mm.wav"));      
    AudioFormat format = stream.getFormat();      
    DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
    clip = (Clip) AudioSystem.getLine(info);        
    clip.open(stream);      
    clip.start();

    } catch (Exception e){      
     e.printStackTrace();    
    }  
	
	}else clip.stop();
	
	return clip;
}



public static void main(final String[] args) {
	int num = 0;
	do {
	
		
		
		//GUI SECTION :
		
		  JCheckBox Mahna = new JCheckBox("Do you want some \"Mahna Mahna\" during waiting?");
	      
		  JTextField l1Field = new JTextField(5);
	      JTextField l2Field = new JTextField(5);
	      JTextField l3Field = new JTextField(5);
	      
	      JTextField q1minField = new JTextField(5);
	      JTextField q2minField = new JTextField(5);
	      JTextField q3minField = new JTextField(5);
	      JTextField q1maxField = new JTextField(5);
	      JTextField q2maxField = new JTextField(5);
	      JTextField q3maxField = new JTextField(5);
	      
	      JRadioButton HighAcc = new JRadioButton("High Accuracy");
	      JRadioButton MedAcc = new JRadioButton("Normal Accuracy");
	      JRadioButton LowAcc = new JRadioButton("Low Accuracy");
	      HighAcc.setSelected(true);
	      ButtonGroup group = new ButtonGroup();

		  group.add(HighAcc);
		  group.add(MedAcc);
		  group.add(LowAcc);

	      
	      JPanel myPanel = new JPanel();
	      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	      myPanel.setSize(1000, 1000);
	      myPanel.add(new JLabel("L1:"));
	      myPanel.add(l1Field);
	      myPanel.add(new JLabel("L2:"));
	      myPanel.add(l2Field);
	      myPanel.add(new JLabel("L3:"));
	      myPanel.add(l3Field);
	      
	      myPanel.add(Box.createVerticalStrut(15));
	      
	      myPanel.add(new JLabel("q1 min:"));
	      myPanel.add(q1minField);
	      myPanel.add(new JLabel("q2 min:"));
	      myPanel.add(q2minField);
	      myPanel.add(new JLabel("q3 min:"));
	      myPanel.add(q3minField);
	      
	      myPanel.add(Box.createVerticalStrut(15));
	      
	      myPanel.add(new JLabel("q1 Max:"));
	      myPanel.add(q1maxField);
	      myPanel.add(new JLabel("q2 Max:"));
	      myPanel.add(q2maxField);
	      myPanel.add(new JLabel("q3 Max:"));
	      myPanel.add(q3maxField);
	      
	      myPanel.add(Box.createVerticalStrut(15));
	      

	      
	      myPanel.add(HighAcc);
	      myPanel.add(MedAcc);
	      myPanel.add(LowAcc);
	      
	      myPanel.add(Box.createVerticalStrut(15));	      
	      myPanel.add(Mahna);

	      
	      int result = JOptionPane.showConfirmDialog(null, myPanel,"Please Enter the values", JOptionPane.OK_CANCEL_OPTION);
	      
	      //Getting data from the gui
	      
	      if (result == JOptionPane.OK_OPTION) {
	      
	    		double l[] = new double[3];
	    		double q[] = new double[6];
	    		l[0] = Double.parseDouble(l1Field.getText()); 
	    		l[1] = Double.parseDouble(l2Field.getText()); 
	    		l[2] = Double.parseDouble(l3Field.getText()); 

	    		q[0] = Double.parseDouble(q1minField.getText()); 
	    		q[1] = Double.parseDouble(q2minField.getText()); 
	    		q[2] = Double.parseDouble(q3minField.getText()); 
	    		
	    		q[3] = Double.parseDouble(q1maxField.getText()); 
	    		q[4] = Double.parseDouble(q2maxField.getText()); 
	    		q[5] = Double.parseDouble(q3maxField.getText()); 
	    		
	    		double temp;
	    		
	    		if(q[3]<q[0]) {
	    			temp = q[3];
	    			q[3] = q[0];
	    			q[0] = temp;
	    		}
	    		
	    		if(q[4]<q[1]) {
	    			temp = q[4];
	    			q[4] = q[1];
	    			q[1] = temp;
	    		}
	    		
	    		if(q[5]<q[2]) {
	    			temp = q[5];
	    			q[5] = q[2];
	    			q[2] = temp;
	    		}
	    		
	    		
	  	      	int k = 2;
			      
	  	      	if(HighAcc.isSelected()) k = 2;
	  	      	else if(MedAcc.isSelected()) k = 3;
	  	      	else if(LowAcc.isSelected()) k = 5;
	      
	    		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    		
	    		//Displaying Loading window & playing music(if wanted) during waiting time 
	    		
	    		//Loading window :
	    		JWindow window = new JWindow();
	    		window.getContentPane().add(new JLabel("",new ImageIcon("loading.gif"),SwingConstants.CENTER));
	    		window.setBounds((int) (screenSize.getWidth()/2.25),(int) (screenSize.getHeight()/2.25),350,150);
	    		window.setVisible(true);
	    		
	    		
	    		//Music :
	    		
	    		Clip clip = null;
	    		boolean music = Mahna.isSelected();
	    		if(music) clip = play(clip,true);
	    
	    		//Creating the graph
	    		
	    		final theGraph demo = new theGraph("«·œÊ·Ì… ··»—„ÃÌ«  «·ﬁÊÌ…","Graph #" + (++num), l, q,k);

	    		demo.pack();
	    		RefineryUtilities.centerFrameOnScreen(demo);
	    		
	    		//closing the Loading window & the music
	    		window.dispose();
	    		if(music) play(clip,false);
	    		demo.setVisible(true);
	     
	      
	      } else break;
	
}while

( JOptionPane.showConfirmDialog(null,"Do you want to plot another graph?" ,null,JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION );

}
}






/*

String m1 =   JOptionPane.showInputDialog("Enter L1 L2 L3") + " "
		+ JOptionPane.showInputDialog("Enter q1min q2min q3min") + " " 
		+ JOptionPane.showInputDialog("Enter q1Max q2Max q3Max");


double l[] = new double[3];
double q[] = new double[6];

Scanner sc = new Scanner(m1);

for(int i = 0 ; i < 3 ; i++) {
l[i] = sc.nextDouble();
}

for(int i = 0 ; i < 3 ; i++) {
q[i] = sc.nextDouble();

}

for(int i = 3 ; i < 6 ; i++) {
q[i] = sc.nextDouble();

}

sc.close();

if(JOptionPane.showConfirmDialog(null, "Processing..... \nDo you want some \"Mahna Mahna\" while waiting ?") == 0) play();

final theGraph demo = new theGraph("«·œÊ·Ì… ··»—„ÃÌ«  «·ﬁÊÌ…","Graph #"+(++num),l,q);

demo.pack();

RefineryUtilities.centerFrameOnScreen(demo);

demo.setVisible(true);


c = JOptionPane.showConfirmDialog(null, "Do you want to plot another graph?"); */
