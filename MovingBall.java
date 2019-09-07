import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MovingBall{
	
	JFrame frame;
	CircleDrawPanel drawPanel;
	Color color = Color.green;
	JButton button;
	
	public static void main (String[] args){
		MovingBall gui = new MovingBall();
		gui.go();
	}

	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new CircleDrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		button = new JButton("Click me to start");
		button.addActionListener(new AnimateCircleListener());
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

	class AnimateCircleListener implements ActionListener{
		public void actionPerformed(ActionEvent event){		
			if  (button.getText().equals("Click me to start"))
				button.setText("Click me to stop");							
			else
				button.setText("Click me to start");
							
  	}
  }

	class CircleDrawPanel extends JPanel{
		 private int x = 0;		
		 private int y = 0;		
		 private int diameter = 100;	
		 private int dx = 10;		
		 private int dy = 10;		
	  
	 public void paintComponent (Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2=(Graphics2D)g;
		 g2.setColor(color);
			
		 if (x < diameter)	  	dx = Math.abs(dx);
		 if (x > getWidth() )  	dx = -Math.abs(dx);
		 if (y < diameter)		  dy = Math.abs(dy);
		 if (y > getHeight() )	dy = -Math.abs(dy);
		 x += dx;
		 y += dy;
						
		 g2.fillOval (x-diameter,y-diameter,diameter,diameter);
			
		 repaint();
			
		 try{
			 Thread.sleep(50);
		 }catch (Exception ex) 
		 {}
				
  }
 }
}
