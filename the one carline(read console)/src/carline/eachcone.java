package carline;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class eachcone extends JPanel {
	public int h = 300;
	public int w = 100;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(int i = 30; i<h; i+=54) {
        	g.setColor(Color.RED);
        	g.fillRect(i, 10, 500, 500);
        }
    }
    
    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new eachcone());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

