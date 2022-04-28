package encryption;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main implements ActionListener {

	private static JLabel label;
	private static JTextField userText;
	private static JLabel label2;
	private static JTextField encryptionResult;
	private static JButton button;
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(320, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		// Panel
		panel.setLayout(null);
		
		// Label
		label = new JLabel("Enter your string : ");
		label.setBounds(10, 20, 150, 25);
		panel.add(label);
		
		userText = new JTextField();
		userText.setBounds(125, 20, 165, 25);
		panel.add(userText);

		//	Result
		label2 = new JLabel("Result");
		label2.setBounds(10,60,150,25);
		panel.add(label2);
		
		
		//	Result Text
		encryptionResult = new JTextField();
		encryptionResult.setBounds(10, 90, 280, 25);
		encryptionResult.setEditable(false);
		panel.add(encryptionResult);
		
		//	Button
		button = new JButton("Encrypt String");
		
		button.setBounds(75, 135, 150, 30);
		panel.add(button);
		button.addActionListener(new Main());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Check = userText.getText();
		if(Check.isEmpty()) {
			encryptionResult.setText("Empty String!");
			return;
		}
		
		encryptionResult.setText(userText.getText());
	}

}
