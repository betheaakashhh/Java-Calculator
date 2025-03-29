import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;





public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[8];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, eqlButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Consolas",Font.BOLD,30);
	
	double num1 = 0, num2 = 0, result = 0;
	String operator;
	
	
	Calculator(){
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480,600);
		frame.setLayout(null);
		
		//icon
		
		ImageIcon icon = new ImageIcon("F:/technothings/java/JavaProjects/JavaSwing/OIP.jpg");
		frame.setIconImage(icon.getImage());
		
		textfield = new JTextField();
	    textfield.setEditable(false);
		textfield.setBounds(25,25,400,50);
		textfield.setFont(myFont);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		decButton = new JButton(".");
		delButton = new JButton("del");
		eqlButton = new JButton("=");
		clrButton = new JButton("C");
		
		//iindexing function button
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = eqlButton;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		
		for(int i = 0; i<8 ; i++){
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(myFont);
			functionButton[i].setFocusable(false);
			
		}
		
		for(int i = 0; i<10 ; i++){
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(myFont);
			numberButton[i].setFocusable(false);
			
		}
		
		delButton.setBounds(50,430,145,50);
		clrButton.setBounds(230,430,145,50);
		
		//color setting
		clrButton.setBackground(new Color(255,0,0));
		delButton.setBackground(new Color(255,255,0));
		eqlButton.setBackground(new Color(145,255,0));
		
		
		
		panel = new JPanel();
		panel.setBounds(25,90,400,320);
		panel.setLayout(new GridLayout(4,4,10,10));
		// panel.setBackground(Color.GRAY);
		
		//adding numbers to  panel
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		
		
		panel.add(numberButton[0]);
		panel.add(eqlButton);
		panel.add(divButton);
		// panel.add(Button);
		
		
		
		
		
		
		
		
		
		
		
		
		frame.add(panel);
		frame.add(textfield);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	public static void main(String[] args){
		Calculator cals = new Calculator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		for(int i =0; i<10;i++){
			if(e.getSource() == numberButton[i]){
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton){
			textfield.setText(textfield.getText().concat("."));
		}
		//addition
		
		if(e.getSource() == addButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "+";
			textfield.setText("");
		}
		
		//subtration
		if(e.getSource() == subButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "-";
			textfield.setText("");
		}
		// multiplication
		if(e.getSource() == mulButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "x";
			textfield.setText("");
		}
		
		//division
		
		if(e.getSource() == divButton){
			num1 = Double.parseDouble(textfield.getText());
			operator = "/";
			textfield.setText("");
		}
		
		//equla
		if(e.getSource() == eqlButton){
			num2 = Double.parseDouble(textfield.getText());
			switch(operator){
				case "+":
				  result = num1 + num2; 
				  break;
				case "-":
				  result = num1 - num2; 
				  break;
				case "x":
				  result = num1*num2; 
				  break;
				case "/":
				  result = num1/num2; 
				  break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrButton){
			textfield.setText("");
		}
		if(e.getSource() == delButton){
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0;i<string.length()-1;i++){
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
	}
}
