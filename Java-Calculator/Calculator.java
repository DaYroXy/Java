import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] operatorsButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton,
	decButton, equButton,delButton, clrButton;
	
	JPanel panel;
	
	public void loadCalculator() {
		
//		Frame
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(345, 440);
		frame.setLayout(null);
		
//		TexField Result
		textfield = new JTextField();
		textfield.setBounds(25, 10, 280, 50);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		textfield.setFont(font1);
		textfield.setEditable(false);
		
//		OperatorButtons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("delete");
		clrButton = new JButton("Clear");
		
//		Operator Buttons Array
		operatorsButtons[0] = addButton;
		operatorsButtons[1] = subButton;
		operatorsButtons[2] = mulButton;
		operatorsButtons[3] = divButton;
		operatorsButtons[4] = decButton;
		operatorsButtons[5] = equButton;
		operatorsButtons[6] = delButton;
		operatorsButtons[7] = clrButton;
		
//		Operators button Loop
		for(int i=0; i < operatorsButtons.length; i++) {
			operatorsButtons[i].addActionListener(this);
			operatorsButtons[i].setFocusable(false);
		}
		
//		Number Buttons Loop
		for(int i=0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
		}
		

		panel = new JPanel();
		panel.setBounds(25, 75, 280, 250);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		
//		Buttons Layout
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		
		panel.add(divButton);
		
		
//		Clear & Delete Buttons
		clrButton.setBounds(25, 335, 135, 50);
		delButton.setBounds(170, 335, 135, 50);
		
//		Frame Area
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i < numberButtons.length; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		for(int i=0; i < operatorsButtons.length; i++) {
			if(e.getSource() != clrButton && e.getSource() != delButton && e.getSource() != equButton) {
				if(e.getSource() == operatorsButtons[i]) {
					textfield.setText(textfield.getText().concat(operatorsButtons[i].getText()));
				}
			}
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText(null);
		}
		
		if(e.getSource() == delButton) {
			if(textfield.getText().length() > 0) {
				textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
			}
		}
		
	}
	
}
