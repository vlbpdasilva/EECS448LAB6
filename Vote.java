import javax.swing.*;
import java.awt.event.*;
import java.awt.Component;
import java.io.*;

public class Vote 
{
	private JPanel swing_panel;
	private JButton Bernie;
	private JButton Hillary;
	private JButton Trump;
	private JButton Cruz;
	private JTextField text_firstName;
	private JTextField text_lastName;
	private JLabel label_A;
	private JLabel label_B;
	private JLabel result;

	
	public Vote()
	{
		swing_panel = new JPanel();
		label_A = new JLabel("Enter first name:");
		label_B = new JLabel("Enter last name:");
		result = new JLabel("Enter your name and candidate of choice");
		text_firstName = new JTextField(20);
		text_lastName = new JTextField(20);
		Bernie = new JButton("BERNIE");
		Hillary = new JButton("HILLARY");
		Trump = new JButton("TRUMP");
		Cruz = new JButton("CRUZ");
		
		swing_panel.add(label_A);
		swing_panel.add(text_firstName);
		swing_panel.add(label_B);
		swing_panel.add(text_lastName);
		swing_panel.add(Bernie);
		swing_panel.add(Hillary);
		swing_panel.add(Trump);
		swing_panel.add(Cruz);
		swing_panel.add(result);		
		
		Bernie.addActionListener(bernieSupporter());	
		Hillary.addActionListener(hillarySupporter());	
		Trump.addActionListener(trumpSupporter());	
		Cruz.addActionListener(cruzSupporter());	

	}
	
	public Component getContent()
	{
		return (swing_panel);
	}
	
	private ActionListener bernieSupporter()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String firstName = text_firstName.getText();
				String lastName = text_lastName.getText();
				String fileName = lastName + "_" + firstName + "_ballot.txt";
				if(!checkString(firstName) || !checkString(lastName))
				{
					result.setText("Invalid input(s).");
				}
				else if(assertUser(fileName))
				{
					fileWriter(fileName, "Bernie");
					result.setText("You just felt the Bern.");
				}
				else
				{
					result.setText("You have already voted!");
				}
			}
		};
		
		return listener;
	}
	private ActionListener hillarySupporter()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String firstName = text_firstName.getText();
				String lastName = text_lastName.getText();
				String fileName = lastName + "_" + firstName + "_ballot.txt";
				if(!checkString(firstName) || !checkString(lastName))
				{
					result.setText("Invalid input(s).");
				}
				else if(assertUser(fileName))
				{
					fileWriter(fileName, "Hillary");
					result.setText("You are Hillary-ous!");
				}
				else
				{
					result.setText("You have already voted!");
				}
			}
		};
		
		return listener;
	}
	private ActionListener trumpSupporter()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String firstName = text_firstName.getText();
				String lastName = text_lastName.getText();
				String fileName = lastName + "_" + firstName + "_ballot.txt";
				if(!checkString(firstName) || !checkString(lastName))
				{
					result.setText("Invalid input(s).");
				}
				else if(assertUser(fileName))
				{
					fileWriter(fileName, "Trump");
					result.setText("You made America great again.");
				}
				else
				{
					result.setText("You have already voted!");
				}
			}
		};
		
		return listener;
	}
	private ActionListener cruzSupporter()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String firstName = text_firstName.getText();
				String lastName = text_lastName.getText();
				String fileName = lastName + "_" + firstName + "_ballot.txt";
				if(!checkString(firstName) || !checkString(lastName))
				{
					result.setText("Invalid input(s).");
				}
				else if(assertUser(fileName))
				{
					fileWriter(fileName, "Cruz");
					result.setText("You voted for a Canadian.");
				}
				else
				{
					result.setText("You have already voted!");
				}
			}
		};
		
		return listener;
	}

	
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
		Vote demo = new Vote();
		
		frame.getContentPane().add(demo.getContent());
		frame.setSize(350, 150);
		frame.setVisible(true);
	}
	
	
	public static void fileWriter(String s, String cast)
	{
		try 
		{

			File file = new File(s);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cast);
			bw.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}			
	}
	
	public static boolean assertUser (String s) // returns TRUE if voter IS ABLE TO VOTE
	{
		File file = new File(s);
		return(!(file.isFile()));		
		
	}
	
	public static boolean checkString (String s)
	{
		if (s == "" || s.isEmpty())
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}