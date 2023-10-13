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


public class insideinterface extends JFrame implements ActionListener {
	
	public static JTextArea[] names1=new JTextArea[5];
	public static JTextArea[] names2=new JTextArea[5];
	public static JPanel[] cones = new JPanel[5];
	public static JPanel[] cones2 = new JPanel[5];
	public static cone sam;
	static int num = 0;
	int toremove = 0;
	
	static JMenu menu;
	static JMenuBar bar;
	static ArrayList <JMenuItem> items = new ArrayList<JMenuItem>();
	static JButton remove;
	int prev=0;
	JFrame frame = new JFrame();

	UserPrompt bill = new UserPrompt();
	scanner bob = new scanner();

	
	public static JButton left;
	public static JButton refresh;


	
	public insideinterface() throws Exception  {
		

		
		sam=new cone();
		
		sam.begin();
		
		
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());	
		frame.setVisible(false);


		
		JPanel window = new JPanel();
		JPanel bigwindow = new JPanel();
		JPanel windowL = new JPanel();
		JPanel windowR = new JPanel();
		JPanel button = new JPanel();
		
		frame.add(bigwindow, BorderLayout.CENTER);

		frame.add(button, BorderLayout.NORTH);
		bigwindow.setLayout(new GridLayout(2,1));
		
		window.setLayout(new GridLayout(1,2));
		
		windowL.setLayout(new GridLayout(6,2));
		windowR.setLayout(new GridLayout(6,2));
		Font fontbig = new Font("Verdana", Font.BOLD, 18);
		
		JTextArea curr = new JTextArea ("CURRENT");
		JTextArea stud1 = new JTextArea ("STUDENTS");
		JTextArea stud2 = new JTextArea ("STUDENTS");
		JTextArea que = new JTextArea ("IN QUEUE");
		
		menu = new JMenu("LIST");
		
		curr.setFont(fontbig);
		stud1.setFont(fontbig);
		stud2.setFont(fontbig);
		que.setFont(fontbig);

		windowL.add(curr);
		windowL.add(stud1);
		
		windowR.add(stud2);
		windowR.add(que);
		
		Font font  = new Font("Verdana", Font.BOLD, 14);
		
		for(int i = 0; i<5; i++) {
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

		
		cones[0].setBackground(Color.red);
		cones[1].setBackground(Color.black);
		cones[2].setBackground(Color.blue);
		cones[3].setBackground(Color.green);
		cones[4].setBackground(Color.yellow);
		
		cones2[0].setBackground(Color.red);
		cones2[1].setBackground(Color.black);
		cones2[2].setBackground(Color.blue);
		cones2[3].setBackground(Color.green);
		cones2[4].setBackground(Color.yellow);

		bar = new JMenuBar();

		bigwindow.add(bar);
		remove = new JButton("remove");
		bar.add(menu);
		button.add(remove);
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				items.remove(toremove);
				num--;
				repaint();
				toremove =0;
			}
		});
		bigwindow.add(window);
		window.add(windowL);
		window.add(windowR);

		
	
		left=new JButton("Cars have left");
		button.add(left);
		
		


		left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove();;
				refresh();
			}
		});
		

		refresh=new JButton("Refresh");
		button.add(refresh);


		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refresh();
			}
		});

		frame.setVisible(true);
		
		for (int i = 0; i<100; i++) {
		readConsole();
		}
		
		}
		
	


	public static void main(String[] args) throws Exception {
		new insideinterface();
		
}
	
	public  void refresh() {

		
		for (int i = 0; i<5; i++) {
			if(i<sam.inline().size()) {
				names1[i].setText((sam.inline()).get(i));
				items.remove(0);
				items.add(new JMenuItem(sam.inline().get(i)));
				items.get(num).addActionListener(this);
				menu.add(items.get(num));
				num++;
				
			}
			else
				names1[i].setText("No more cars");

			
			if(i<sam.queue().size()) {
				names2[i].setText((sam.queue()).get(i));
				items.remove(5);
				items.add(new JMenuItem(sam.queue().get(i)));
				menu.add(items.get(num));
				num++;
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
					items.add(new JMenuItem(sam.inline().get(i)));
			}
			else
				names1[i].setText("No more cars");
			
			if(i<sam.queue().size()) {
				names2[i].setText((sam.queue()).get(i));
				items.add(new JMenuItem(sam.queue().get(i)));

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
			
			if(x<scanner.list.size()&&x>0) {
				if(y!=prev)
					cone.cars.add(x-1);
				else
					System.out.println("Repeated scan");
			}
			else
				System.out.println( x + ": Scan out of bounds. Please scan again");
					}
			else
				System.out.println(x + ": Scanning error. Please scan again");
				}catch(NumberFormatException e){
					System.out.println("Your scan is not a number!");
				}
		prev=y;
		}
	
	public void startFrame() {
		
	}
	public void remove() {
		for(int i=0; i<5; i++) {
			items.remove(0);
		}
		sam.remove();
		repaint();

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<items.size(); i++) {
			if(e.getSource()==items.get(i)) {
				toremove = i;
				break;
			}
		}
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
	
	