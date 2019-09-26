import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class GUI1 extends JFrame {

	private static final long serialVersionUID = 1L;

	// painel onde adiciona tudo o que o a GUI vai ter butões imagens etc..
	private JPanel panel;
	
	private BD bd;
	
	//campos de textos onde se incere o que se quer 
	private JTextField robotTextField;
	private JTextField raioTextField;
	private JTextField anguloTextField;
	private JTextField distanciaTextField;
	private JTextField consolaTextField;
	
	//butões com ações
	private JButton btnFrente;

	//criação das cores
	private Color black;
	private Color blu;
	private Color gr;
	private Color re;
	private Color ye;
	private Color pur;
	
	//criação dos botões
	private JButton btnParar;
	private JButton btnRecuar;
	private JButton btnEsquerda;
	private JButton btnDireita;
	
	
	// corre a JFrame
	public static void main(String[] args) {
		GUI1 frame = new GUI1();
		frame.run();
	}
	public void run() {
	}

	// metodo que cria a frame
	public GUI1() {
		
		bd = new BD();
		
		setTitle("A45101_A45102_A45170");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				closeWindow();
	        }
	    });
		setBounds(100, 100, 600, 400);
		
		//JPanel que é adicionado á JFrame e exibe tudo grafico
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(panel);
		panel.setLayout(null);
		
		//cores utilizadas para botões e etc
		black = new Color(26, 26, 26);
		blu = new Color(76,181,245);
		gr = new Color(0,168,107);
		re = new Color(239,84,85);
		ye = new Color(250,215,68);
		pur = new Color(149,43,209);
		
		//chama as diferentes componentes da janela
		textFieldComponents();
		getButtons();
		getConsola();
		getdebug();
		getBack();
		
		setVisible(true);
	}

	// desenha as componentes na janela
	private void textFieldComponents() {

		// Campo onde se escreve o nome do robo
		robotTextField = new JTextField();
		robotTextField.setText(""+bd.getNomeRobot()); //vai buscar o nome dado no construtor
		robotTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.setNomeRobot(robotTextField.getText()); //da set do nome do robo quando la se escreve alguma coisa
				myPrint(bd.getNomeRobot());                //dá print desse mesmo texto
			}
		});
		robotTextField.setForeground(Color.white);// cor da letra
		robotTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		robotTextField.setBackground(black);
		robotTextField.setBounds(96, 21, 285, 23);
		panel.add(robotTextField);
		robotTextField.setColumns(10);//define o número de neste layout e invalida o layout
		

		// campo onde se escreve o tamanho do raio
		raioTextField = new JTextField();
		raioTextField.setText(""+bd.getRaio());
		raioTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.setRaio(Integer.parseInt(raioTextField.getText()));
				myPrint("Raio - "+String.valueOf(bd.getRaio()));
			}
		});
		raioTextField.setForeground(Color.green);// cor da letra
		raioTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		raioTextField.setBackground(black);
		raioTextField.setBounds(64, 87, 108, 23);
		panel.add(raioTextField);
		raioTextField.setColumns(10);
		

		//campo onde se escreve o angulo
		anguloTextField = new JTextField();
		anguloTextField.setText(""+bd.getAngulo());
		anguloTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.setAngulo(Integer.parseInt(anguloTextField.getText()));;
				myPrint("Ângulo - "+String.valueOf(bd.getAngulo()));
			}
		});
		anguloTextField.setForeground(Color.cyan);// cor da letra
		anguloTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		anguloTextField.setBackground(black);
		anguloTextField.setBounds(253, 87, 108, 23);
		panel.add(anguloTextField);
		anguloTextField.setColumns(10);
		

		//campo onde se escreve a distância percorrida
		distanciaTextField = new JTextField();
		distanciaTextField.setText(""+bd.getDistancia());
		distanciaTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.setDistancia((Integer.parseInt(distanciaTextField.getText())));
				myPrint("Distância - "+String.valueOf(bd.getDistancia()));
			}
		});
		distanciaTextField.setForeground(Color.red);// cor da letra
		distanciaTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		distanciaTextField.setBackground(black);
		distanciaTextField.setBounds(458, 87, 108, 23);
		panel.add(distanciaTextField);
		distanciaTextField.setColumns(10);

		// botão de On/Off
		JRadioButton btOnOff = new JRadioButton("On/Off");
		btOnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bd.getRobot().OpenEV3(bd.getNomeRobot()) && btOnOff.isSelected()) {
					btOnOff.setSelected(true);
					bd.setOnOff(true);
					myPrint("ligado");
					estadoBotoes();
				}
				else {
					bd.getRobot().CloseEV3();
					btOnOff.setSelected(false);
					bd.setOnOff(false);
					myPrint("desligado");
					estadoBotoes();
				}
			}
		});
		btOnOff.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btOnOff.setBounds(453, 21, 97, 23);
		panel.add(btOnOff);

	}

	
	//metodo que cria todos os botões
	private void getButtons() {
		
		//botão de Frente
		btnFrente = new JButton("");
		btnFrente.setIcon(new ImageIcon("src\\frente.png"));
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myPrint("Frente " + bd.getDistancia());
				bd.getRobot().Reta(bd.getDistancia());
			}
		});
		btnFrente.setBackground(gr);
		btnFrente.setBounds(207, 132, 170, 55);
		panel.add(btnFrente);
		
		
		//botão de Parar
		btnParar = new JButton("");
		btnParar.setIcon(new ImageIcon("src\\parar.png"));
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myPrint("Parar");
				bd.getRobot().Parar(true);
			}
		});
		btnParar.setForeground(Color.BLACK);
		btnParar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnParar.setBackground(re);
		btnParar.setBounds(207, 200, 170, 55);
		panel.add(btnParar);
		
		
		//botão de andar para trás ou retaguarda
		btnRecuar = new JButton("");
		btnRecuar.setIcon(new ImageIcon("src\\retaguarda.png"));
		btnRecuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myPrint("Retaguarda -" + bd.getDistancia());
				bd.getRobot().Reta(-bd.getDistancia());
			}
		});
		btnRecuar.setBackground(ye);
		btnRecuar.setBounds(207, 268, 170, 55);
		panel.add(btnRecuar);
		
		
		//botão de andar para a esquerda
		btnEsquerda = new JButton("");
		btnEsquerda.setIcon(new ImageIcon("src\\esquerda.png"));
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myPrint("Esquerda com raio de " + bd.getRaio() + " e angulo de " + bd.getAngulo());
				bd.getRobot().CurvarEsquerda(bd.getRaio(), bd.getAngulo());
			}
		});
		btnEsquerda.setBackground(blu);
		btnEsquerda.setBounds(24, 200, 170, 55);
		panel.add(btnEsquerda);
		
		
		//botão de andar para a direita
		btnDireita = new JButton("");
		btnDireita.setIcon(new ImageIcon("src\\direita.png"));
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myPrint("Direita com raio de " + bd.getRaio() + " e angulo de " + bd.getAngulo());
				bd.getRobot().CurvarDireita(bd.getRaio(), bd.getAngulo());
			}
		});
		btnDireita.setBackground(pur);
		btnDireita.setBounds(390, 200, 170, 55);
		panel.add(btnDireita);
	}
	
	//Text Field com a consola
	private void getConsola() {
		
		consolaTextField = new JTextField();
		consolaTextField.setBounds(28, 332, 534, 20);
		panel.add(consolaTextField);
		consolaTextField.setColumns(10);
	}
	
	//botão de debug
	private void getdebug() {
		
		JCheckBox debugCheckBox = new JCheckBox("Debug");
		debugCheckBox.setSelected(bd.isDebug());
		debugCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.setDebug(debugCheckBox.isSelected());
				myPrint("Debug - "+bd.isDebug());//diz se o debug está ativo ou não
			}
		});
		debugCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		debugCheckBox.setBounds(480, 298, 81, 23);
		panel.add(debugCheckBox);
	}

	// vai buscar o background
	private void getBack() {

		JLabel background = new JLabel(new ImageIcon("src\\background.jpg"));
		background.setBounds(2, 2, 580, 357); // valor que fica com as bordas
		getContentPane().add(background);
		

	}
	public void closeWindow() {
		GUI1 frame = new GUI1();
		bd.getRobot().CloseEV3();
		frame.dispose();
		System.exit(0);
	}
	
	private void estadoBotoes() {
		
		if (bd.isOnOff()) {
			btnFrente.setEnabled(true);
			btnParar.setEnabled(true);
			btnRecuar.setEnabled(true);
			btnEsquerda.setEnabled(true);
			btnDireita.setEnabled(true);
		}
		else {
			btnFrente.setEnabled(false);
			btnParar.setEnabled(false);
			btnRecuar.setEnabled(false);
			btnEsquerda.setEnabled(false);
			btnDireita.setEnabled(false);
		}
	}
	
	//print para debug
	private void myPrint(String s) {
		if (bd.isDebug()) {
			bd.setConsola(s);
			consolaTextField.setText(bd.getConsola());
		}
	}
}
