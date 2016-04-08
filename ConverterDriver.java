import javax.swing.JFrame;


public class ConverterDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Temperature Converter");
		Converter demo = new Converter();
		
		frame.getContentPane().add(demo.getContent());
		frame.setSize(200, 280);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}