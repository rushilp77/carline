package carline;

import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class runner extends JFrame implements ActionListener {
	
	public static JTextArea[] names1=new JTextArea[6];
	public static JTextArea[] names2=new JTextArea[6];
	public static JPanel[] cones = new JPanel[6];
	public static JPanel[] cones2 = new JPanel[6];
	public static cone sam;
	static JList<String> listy;
	static DefaultListModel<String> l = new DefaultListModel<String> (); 
	
	static JButton remove;
	int prev=0;
	JFrame frame = new JFrame();

	UserPrompt bill = new UserPrompt();
	scanner bob = new scanner();

	
	public static JButton left;
	public static JButton refresh;
	JButton instr;


	
	public runner() throws Exception  {
		

		
		sam=new cone();
		
		sam.begin();
		
		
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());	
		frame.setVisible(false);


		
		JPanel bigwindow = new JPanel();
		JPanel windowL = new JPanel();
		JPanel windowR = new JPanel();
		JPanel button = new JPanel();
		
		
		
		frame.add(bigwindow, BorderLayout.CENTER);

		frame.add(button, BorderLayout.NORTH);
		bigwindow.setLayout(new GridLayout(1,3));
		
		
		windowL.setLayout(new GridLayout(7,2));
		windowR.setLayout(new GridLayout(7,2));
		Font fontbig = new Font("Verdana", Font.BOLD, 18);
		
		JTextArea curr = new JTextArea ("         CURRENT");
		JTextArea stud1 = new JTextArea ("STUDENTS");
		JTextArea stud2 = new JTextArea ("        STUDENTS");
		JTextArea que = new JTextArea ("COMING UP");
		
		
		curr.setFont(fontbig);
		stud1.setFont(fontbig);
		stud2.setFont(fontbig);
		que.setFont(fontbig);

		windowL.add(curr);
		windowL.add(stud1);
		
		windowR.add(stud2);
		windowR.add(que);
		
		Font font  = new Font("Verdana", Font.BOLD, 14);
		
		for(int i = 0; i<6; i++) {
			names1[i] = new JTextArea();
			names1[i].setFont(font);
			names2[i] = new JTextArea();
			names2[i].setFont(font);

			cones[i] = new JPanel();
			cones2[i] = new JPanel();
			windowL.add(cones[i]);
			windowL.add(names1[i]);
			windowR.add(cones2[i]);
			windowR.add(names2[i]);
		}

		
		cones[0].setBackground(Color.green);
		cones[1].setBackground(Color.blue);
		cones[2].setBackground(new Color(148,0,211));//purple
		cones[3].setBackground(Color.red);
		cones[4].setBackground(Color.yellow);
		cones[5].setBackground(new Color (255, 140, 0));//orange
		
		cones2[0].setBackground(Color.green);
		cones2[1].setBackground(Color.blue);
		cones2[2].setBackground(new Color(148,0,211));
		cones2[3].setBackground(Color.red);
		cones2[4].setBackground(Color.yellow);
		cones2[5].setBackground(new Color(255, 140, 0));

	
		remove = new JButton("Remove");
		
		
		button.add(remove);
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x= listy.getSelectedIndex();
			if ( x!= -1) {   
				cone.cars.remove(x);
				l.remove(x);
				
				if(x<=12)
					refresh();
				repaint();
	            
		}}}
			);
		instr= new JButton("Instructions");
		instr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "1. Drag and place this white window with the User Interface(UI) onto the projector screen.\r\n"
						+ "2. Before you scan, make sure your cursor is in the \"console\" in the Eclipse application."
						+"The person scanning barcodes should be wearing an airpod connected to the computer via bluetooth. \r\n Every time a barcode is scanned, they will hear the number that was scanned.\r\n"
						+ "3. The UI should refresh automatically every time you scan or remove a car. If it is not refreshing, press the Refresh button\r\n"
						+ "4. To remove an incorrect scan, click on the student's name in the list on the right side of the UI, and then press the Remove button\r\n"
						+"5. If unable to scan a barcode sticker, ask the driver for the child's name, and their ID. \r\n The driver should have been added as a pickup person by the parent. Then look for the child"
						+ "'s name in the barcode notebook, and scan the barcode. \r\n"
						+ "6. When a set of 6 cars is dismissed from the carline, press the \"Cars have left\" button\r\n"
						);
			}
			});
		bigwindow.add(windowL);
		bigwindow.add(windowR);
		

		
	
		left=new JButton("Cars have left");
		button.add(left);
		
		


		left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove();
				refresh();
			}
		});
		

		refresh=new JButton("Refresh");
		button.add(refresh);


		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refresh();
				repaint();
			}
		});
		button.add(instr);


		listy = new JList<>(l);
		listy.setBounds(100, 100, 200, 200);
		bigwindow.add(listy);
		frame.setVisible(true);
		
		while(true) {
		readConsole();
		}
		
		}
		
	


	public static void main(String[] args) throws Exception {
		new runner();
		
}
	
	public  void refresh() {

		
		for (int i = 0; i<6; i++) {
			if(i<sam.inline().size()) {
				names1[i].setText((sam.inline()).get(i));
			}
			else
				names1[i].setText("No more cars");

			
			if(i<sam.queue().size()) {
				names2[i].setText((sam.queue()).get(i));

			}
			else
				names2[i].setText("No more cars");


		}
		
						
		System.out.println("REFRESHING");
		

	}
	
	/**public static void firsttime() {
		for (int i = 0; i<5; i++) {
			
			if(i<sam.inline().size()) {
					names1[i].setText((sam.inline()).get(i));
					l.add(new JMenuItem(sam.inline().get(i)));
			}
			else
				names1[i].setText("No more cars");
			
			if(i<sam.queue().size()) {
				names2[i].setText((sam.queue()).get(i));
				l.add(new JMenuItem(sam.queue().get(i)));

			}
			else
				names2[i].setText("No more cars");
			}
	}**/
	
	public void readConsole () {
		int y=0; 
		int x;
		try{
			 y = bill.getInt("scan");
				x= y/10;

			 
			if(checkdigit.check(y)) {
			
			if((x<scanner.list.size()&&x>0)||x==999) {
				if(y!=prev) {
					cone.cars.add(x-1);
					l.addElement((x)+" " +sam.returnLast());
					sound.playScan(x);
				}
				else
					{System.out.println("The same barcode was scanned twice");
				sound.playRepeated();}
			}
			else if (x!=999)
				{System.out.println( x + ": Scan out of bounds. Please scan again");
				sound.playError();}
					}
			else {
				System.out.println(x + ": Scanning error. Please scan again");
				sound.playError();
			}
				}catch(NumberFormatException e){
					System.out.println("Your scan is not a number!");
				}
		prev=y;
		if(cone.cars.size()<=12) {
			refresh();
		}
		}
	
	public void remove() {
		for(int i=0; i<6; i++) {
			l.remove(0);
		}
		sam.remove();
		refresh();
		repaint();

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		}
		// TODO Auto-generated method stub
		
	}
	

	
	
	

	
	