import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;

public class Converter 
{
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JTextField text;
	private JLabel label;
	private JLabel value;

	
	public Converter()
	{
		panel = new JPanel();
		button1 = new JButton("Convert from F to C");
		button2 = new JButton("Convert from F to K");
		button3 = new JButton("Convert from C to K");
		button4 = new JButton("Convert from C to F");
		button5 = new JButton("Convert from K to F");
		button6 = new JButton("Convert from K to C");
		text = new JTextField(3);
		label = new JLabel("Press desired button");
		value = new JLabel("Value:");
		
		button1.addActionListener(buttonListener1());	
		button2.addActionListener(buttonListener2());	
		button3.addActionListener(buttonListener3());	
		button4.addActionListener(buttonListener4());	
		button5.addActionListener(buttonListener5());	
		button6.addActionListener(buttonListener6());	
		
		panel.add(value);
		panel.add(text);
		panel.add(button1);
		panel.add(label);
		panel.add(button2);

		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener1()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInC = FtoC(tempInF);
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	
	private ActionListener buttonListener2()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					double tempInK = FtoK(tempInF);
					String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	private ActionListener buttonListener3()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInC = Double.parseDouble(input);//convert String to double
					double tempInK = CtoK(tempInC);
					String newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	private ActionListener buttonListener4()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInC = Double.parseDouble(input);//convert String to double
					double tempInF = CtoF(tempInC);
					String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	private ActionListener buttonListener5()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInF = KtoF(tempInK);
					String newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	private ActionListener buttonListener6()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				if(assertInput(input))
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					double tempInC = KtoC(tempInK);
					String newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
												       //only display 2 places past decimal
					label.setText(newText);
					System.out.println(newText);
				}
				else { label.setText("Invalid input!"); }
			}
		};
		
		return listener;
	}
	
	public static double FtoC (double a)
	{
		return (((a - 32) * 5 ) / 9);
	}
	
	public static double FtoK (double a)
	{
		return (FtoC(a) + 273);
	}
	
	public static double CtoK (double a)
	{
		return (a + 273);
	}
	
	public static double CtoF (double a)
	{
		return (((a * 9) /5) + 32);
	}
	
	public static double KtoF (double a)
	{
		return (CtoF(KtoC(a)));
	}
	
	public static double KtoC (double a)
	{
		return (a - 273);
	}
	
	public static boolean assertInput (String s)
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
	
}