import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainClass {

	public static void main(String[] args) {

  	
    	MyWindow sr = new MyWindow();
    	JFrame jf = new JFrame();
    	jf.setTitle("Sorting Algorithms by Slawomir Malczewski - D15124507");    
    	jf.setLocation(100,100);    
    	jf.setSize(800, 625);    
    	jf.setResizable(false);    
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    	jf.add(sr);    
    	jf.setVisible(true); 
    	   
	}

}



class MyWindow extends JPanel{
	public JLabel enterArraySize, quickSortMethodLabel, insertionMethodLabel, mergeSortLabel, timeLabel, emptyLabel;
	public JTextField enterArraySizeTextField, quickSortMethodTimeNS, insertionMethodTimeNS, quickSortMethodTimeMS, insertionMethodTimeMS, mergeSortMethodTimeNS, mergeSortMethodTimeMS;
	public JTextArea displayGeneratedArea, displaySortedArea, displayQuickSortTime, displayInsertionTime;
	public JButton generateArrayButton, exitButton;

	
	GridBagConstraints gbc = new GridBagConstraints();
	
	//Constructor
	public MyWindow(){
		//To have a better control of the window layout we will use GridBagLayout manager
		setLayout(new GridBagLayout());
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(5, 5, 5, 5); //padding for the buttons
		
		//Parts of the program window to enter the size of the array
		enterArraySize = new JLabel("Enter size of the array:");
		enterArraySize.setFont(new Font("Arial", Font.BOLD,14));
		enterArraySize.setForeground(Color.BLACK);
		gbc.weightx = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(enterArraySize, gbc);
		
		enterArraySizeTextField = new JTextField(20);
		enterArraySizeTextField.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(enterArraySizeTextField, gbc);
		
		generateArrayButton = new JButton("Generate Array"); 
		generateArrayButton.setFont(new Font("Arial", Font.BOLD, 12)); 
		generateArrayButton.setForeground(Color.BLUE); 
		gbc.weightx = 0;
		gbc.gridwidth = 4;
		gbc.gridx = 0; //X-position for the button 'Translate' 
		gbc.gridy = 1; //Y-position for the button 'Translate'  
		//gbc.fill = GridBagConstraints.HORIZONTAL; 
		add(generateArrayButton, gbc);	
		
	
		//Parts of the program window to display GENERATED-NOT SORTED array with vertical scroll		
		displayGeneratedArea = new JTextArea(10,15);
		displayGeneratedArea.setBorder(new TitledBorder ( new EtchedBorder(),"Generated Array"));
		displayGeneratedArea.setEditable(false); //set text area non-editable
		displayGeneratedArea.setLineWrap(true);
		displayGeneratedArea.setWrapStyleWord(true);

		
		//Adding JScrollPane to the window 
		JScrollPane generatedArrayAreaSP = new JScrollPane(displayGeneratedArea);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(generatedArrayAreaSP, gbc);
		
		//Parts of the program window to display SORTED array with vertical scroll		
		displaySortedArea = new JTextArea(10,15);
		displaySortedArea.setBorder(new TitledBorder ( new EtchedBorder(),"Sorted Array"));
		displaySortedArea.setEditable(false); //set text area non-editable
		displaySortedArea.setLineWrap(true);
		displaySortedArea.setWrapStyleWord(true);

		
		//Adding JScrollPane to the window 
		JScrollPane sortedArrayAreaSP = new JScrollPane(displaySortedArea);
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(sortedArrayAreaSP, gbc);
		
		generateArrayButton.addActionListener(new generateArray());
		
		//Parts of the program window to display QuickSort Method results
		quickSortMethodLabel = new JLabel("Quick Sort Method");
		quickSortMethodLabel.setFont(new Font("Sanserif",Font.BOLD, 14));
		quickSortMethodLabel.setHorizontalAlignment(JLabel.CENTER);
		gbc.weightx = 1;
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		add(quickSortMethodLabel, gbc);
		
		//Parts of the program window to display InsertionSort Method results
		insertionMethodLabel = new JLabel("Insertion Sort Method");
		insertionMethodLabel.setFont(new Font("Sanserif",Font.BOLD, 14));
		insertionMethodLabel.setHorizontalAlignment(JLabel.CENTER);
		gbc.weightx = 1;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		add(insertionMethodLabel, gbc);
		
		//Parts of the program window to display MergeSort Method results
		mergeSortLabel = new JLabel("Merge Sort Method");
		mergeSortLabel.setFont(new Font("Sanserif",Font.BOLD, 14));
		mergeSortLabel.setHorizontalAlignment(JLabel.CENTER);
		gbc.weightx = 1;
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		add(mergeSortLabel, gbc);
		
		//Parts of the program window to display Time [ns] results
		timeLabel = new JLabel("Time [Nanoseconds]: ");
		gbc.weightx = 0.0;
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(timeLabel, gbc);
		
		//Quick Sort Time [ns]
		quickSortMethodTimeNS = new JTextField(10);
		quickSortMethodTimeNS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 1;
		gbc.gridy = 7;	
		add(quickSortMethodTimeNS, gbc);
		
		//Insertion Sort Time [ns]
		insertionMethodTimeNS = new JTextField(10);
		insertionMethodTimeNS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 2;
		gbc.gridy = 7;	
		add(insertionMethodTimeNS, gbc);
		
		//Merge Sort Time [ns]
		mergeSortMethodTimeNS = new JTextField(10);
		mergeSortMethodTimeNS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 3;
		gbc.gridy = 7;	
		add(mergeSortMethodTimeNS, gbc);

		
		//Parts of the program window to display Time [ms] results
		timeLabel = new JLabel("Time [Microseconds]: ");
		gbc.weightx = 0.0;
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(timeLabel, gbc);
		
		//Quick Sort Time [ms]
		quickSortMethodTimeMS = new JTextField(10);
		quickSortMethodTimeMS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 1;
		gbc.gridy = 8;	
		add(quickSortMethodTimeMS, gbc);
		
		//Insertion Sort Time [ms]
		insertionMethodTimeMS = new JTextField(10);
		insertionMethodTimeMS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 2;
		gbc.gridy = 8;	
		add(insertionMethodTimeMS, gbc);
		
		//Merge Sort Time [ms]
		mergeSortMethodTimeMS = new JTextField(10);
		mergeSortMethodTimeMS.setHorizontalAlignment(JTextField.CENTER); //text will be displayed in the middle of the Text Field
		gbc.gridx = 3;
		gbc.gridy = 8;	
		add(mergeSortMethodTimeMS, gbc);
		
		//Let's define Exit button
		exitButton = new JButton("EXIT"); 
		exitButton.setFont(new Font("Arial", Font.BOLD, 14)); 
		exitButton.setForeground(Color.RED); 
		gbc.weightx = 0;
		gbc.gridwidth = 4;
		gbc.gridx = 0; //X-position for the button 'Translate' 
		gbc.gridy = 9; //Y-position for the button 'Translate'  
		//gbc.fill = GridBagConstraints.HORIZONTAL; 
		add(exitButton, gbc);	
		
		//Part of the Grid Bag Layout to set positioning from left-top corner of the window
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 2;
		emptyLabel = new JLabel(" ");
		add(emptyLabel, gbc);
		
		exitButton.addActionListener(new closeWindow());
		
	}
	
	//Let's define closing window action
	class closeWindow implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}		
	}


	//Let's define generateArray function which is invoked when Generate Array Button is pressed
	class generateArray implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
	  	String ArraySizeString = enterArraySizeTextField.getText();
	  	int ArraySize = Integer.parseInt(ArraySizeString);
	  	
	  	CreateArray userArray = new CreateArray(ArraySize);
	  	
	  	int workArray[] = Arrays.copyOf(userArray.populateArray(), userArray.populateArray().length);
	  	
	  	//Let's display generated unsorted array
	  	displayGeneratedArea.setText(Arrays.toString(workArray));

	  		  	
	  	Quicksort sort1 = new Quicksort();
	  	sort1.main(workArray);
	  	sort1.measuredTimeNS();
	  	
	  	quickSortMethodTimeNS.setText(sort1.measuredTimeNS());
	  	quickSortMethodTimeMS.setText(sort1.measuredTimeMS());
	  	
	  	InsertionSort insertion1 = new InsertionSort();
	  	insertion1.insertionSort(workArray);
	  	insertion1.measuredTimeNS();
	  	
	  	insertionMethodTimeNS.setText(insertion1.measuredTimeNS());
	  	insertionMethodTimeMS.setText(insertion1.measuredTimeMS());
	  	
	  	
	  	MergeSort mergesort1 = new MergeSort();
	  	mergesort1.sort(workArray);
	  	
	  	mergeSortMethodTimeNS.setText(mergesort1.measuredTimeNS());
	  	mergeSortMethodTimeMS.setText(mergesort1.measuredTimeMS());
	  	
	  	
	  	//Let's display sorted array
	  	displaySortedArea.setText(sort1.main(workArray));
	  	
		}
	}
}


