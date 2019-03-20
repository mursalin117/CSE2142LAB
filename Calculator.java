import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorWindow extends JFrame implements ActionListener{

	private Container c;
	private JTextField tf;
	private JPanel p1, p2, p3, p4, p5;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAC, bD, bM, bS, bA, bE;
	int num1, num2, result, op;
	double Dnum1, Dnum2, Dresult;

	CalculatorWindow(){

		c = this.getContentPane();
		c.setLayout(new GridLayout(5, 1));
		
		p1 = new JPanel();
		p1.setLayout(null);
		tf = new JTextField();
		tf.setBounds(50, 5, 200, 30);
		p1.add(tf);
		c.add(p1);

		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		b7 = new JButton("7");
		b7.setSize(50, 50);
		p2.add(b7);
		b8 = new JButton("8");
		b8.setSize(50, 50);
		p2.add(b8);
		b9 = new JButton("9");
		b9.setSize(50, 50);
		p2.add(b9);
		bAC = new JButton("AC");
		bAC.setSize(50, 50);
		p2.add(bAC);
		c.add(p2);

		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		b4 = new JButton("4");
		b4.setSize(50, 50);
		p3.add(b4);
		b5 = new JButton("5");
		b5.setSize(50, 50);
		p3.add(b5);
		b6 = new JButton("6");
		b6.setSize(50, 50);
		p3.add(b6);
		bD = new JButton("/");
		bD.setSize(50, 50);
		p3.add(bD);
		c.add(p3);

		p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		b1 = new JButton("1");
		b1.setSize(50, 50);
		p4.add(b1);
		b2 = new JButton("2");
		b8.setSize(50, 50);
		p4.add(b2);
		b3 = new JButton("3");
		b3.setSize(50, 50);
		p4.add(b3);
		bM = new JButton("X");
		bM.setSize(50, 50);
		p4.add(bM);
		c.add(p4);

		p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		b0 = new JButton("0");
		b0.setSize(50, 50);
		p5.add(b0);
		bA = new JButton("+");
		bA.setSize(50, 50);
		p5.add(bA);
		bS = new JButton("-");
		bS.setSize(50, 50);
		p5.add(bS);
		bE = new JButton("=");
		bAC.setSize(50, 50);
		p5.add(bE);
		c.add(p5);

		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bA.addActionListener(this);
		bS.addActionListener(this);
		bM.addActionListener(this);
		bD.addActionListener(this);
		bE.addActionListener(this);
		bAC.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == b0) tf.setText(tf.getText() + "0");
		else if(e.getSource() == b1) tf.setText(tf.getText() + "1");
		else if(e.getSource() == b2) tf.setText(tf.getText() + "2");
		else if(e.getSource() == b3) tf.setText(tf.getText() + "3");
		else if(e.getSource() == b4) tf.setText(tf.getText() + "4");
		else if(e.getSource() == b5) tf.setText(tf.getText() + "5");
		else if(e.getSource() == b6) tf.setText(tf.getText() + "6");
		else if(e.getSource() == b7) tf.setText(tf.getText() + "7");
		else if(e.getSource() == b8) tf.setText(tf.getText() + "8");
		else if(e.getSource() == b9) tf.setText(tf.getText() + "9");
		else if(e.getSource() == bA){

			num1 = Integer.parseInt(tf.getText());
			op = 1;
			tf.setText("");
		}
		else if(e.getSource() == bS){

			num1 = Integer.parseInt(tf.getText());
			op = 2;
			tf.setText("");	
		}
		else if(e.getSource() == bM){

			num1 = Integer.parseInt(tf.getText());
			op = 3;
			tf.setText("");
		}
		else if(e.getSource() == bD){
			num1 = Integer.parseInt(tf.getText());
			op = 4; 
			tf.setText("");
		}
		else if(e.getSource() == bE){

			if(op == 1){

				num2 = Integer.parseInt(tf.getText());
				result = num1 + num2;
				tf.setText(result + "");
			}
			else if(op == 2){

				num2 = Integer.parseInt(tf.getText());
				result = num1 - num2;
				tf.setText(result + "");
			}
			else if(op == 3){

				num2 = Integer.parseInt(tf.getText());
				result = num1 * num2;
				tf.setText(result + "");
			}
			else{

				num2 = Integer.parseInt(tf.getText());
				if(num2 == 0) tf.setText("Math Error");
				else{
					if(num1 >= num2){
					
						if(num1 % num2 == 0){
						
							result = num1 / num2;
							tf.setText(result + "");
						}
						else{
					
							Dnum1 = (double)num1;
							Dnum2 = (double)num2;
							Dresult = Dnum1 / Dnum2;
							tf.setText(Dresult + "");
						}
					}
					else{

						num1 *= 1000;
						Dnum1 = (double)num1;
						Dnum2 = (double)num2;
						Dresult = num1 / num2;
						Dresult /= 1000;
						tf.setText(Dresult + "");
					}
				}
			}
		}
		else{

			tf.setText("");
		}
	}

	public static void main(String args[]){
		
		CalculatorWindow cw = new CalculatorWindow();
		cw.setTitle("Calculator");
		cw.setBounds(10, 10, 310, 260);
		cw.setVisible(true);
		cw.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cw.setResizable(false);
	}
}