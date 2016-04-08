import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.util.Random;

public class Dice {
	
	private JButton button1;
	private JPanel content;
	private JLabel label;
	private JLabel message;
	private JTextField text;
	
	public Dice()
	{
		message = new JLabel("Enter number of sides: ");
		button1 = new JButton("Roll dice!");
		label = new JLabel("Button not pressed yet");
		text = new JTextField(3);
				
		button1.addActionListener( button1Action() );
						
		content = new JPanel();
		content.add(message);
		content.add(text);
		content.add(button1);
		content.add(label);		
	}
	public Component getContent()
	{
		return(content);
	}
	
	private ActionListener button1Action() 
	{
		
        	ActionListener action = new ActionListener()
        	{
	            @Override
	            public void actionPerformed(ActionEvent e) 
	            {
	            	if(!(assertInput(text.getText())))
	            		label.setText("Error: check input!");
	            	else
	            	{	           		
		              	int resultInt = randInt(Integer.parseInt(text.getText()));
		            	String resultString = resultInt + "";	            	
		                label.setText("You rolled: " + resultString);
		                button1.setText("Roll again!");
	            	}
	            }
        	};
        return action;
    }
	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Exercise 1 -- DICE");
		Dice demo = new Dice();
		
		frame.add(demo.getContent());
		frame.setSize(300, 100);
		frame.setVisible(true);
	}
	
	public static int randInt(int range) 
	{

	    Random rand = new Random();
	    int randomNum = rand.nextInt(range) + 1;

	    return randomNum;
	    
	}
	public static boolean assertInput (String s) // returns TRUE if input is VALID
	{
		if (s == "" || s.isEmpty())
		{
			return false;
		}
		else 
		{
			for(char c : s.toCharArray())
			{
				if(!(Character.isDigit(c)))
					return false;
			}
		}
		
		return true;
	}

	public static void main (String[] args)
	{
		createAndDisplayGUI();			
		
	}

}
