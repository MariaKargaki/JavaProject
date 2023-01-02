/*
 * 321/2015081
 * Kargaki Maria
 * Prwth Atomikh Ergasia
 * 
 */

package icsd15081_Lab01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GrafikoPerivallon implements ActionListener {

	Util util = new Util(); //dhmiourgia antikeimenou typou util 

	JFrame frame = new JFrame("Daneistikh Vivliothikh"); //dhmiourgia frame
	JPanel panel = new JPanel(); //dhmiourgia panel
	JButton button1 = new JButton("Kataxwrhsh"); //dhmiourgia koumpiwn
	JButton button2 = new JButton("Anazhthsh");

	class Koumpi1 implements ActionListener {
		JButton okButton = new JButton("Proceed");

		public void actionPerformed(ActionEvent e) {

			JFrame frame1 = new JFrame("Kataxwrhsh"); //dhmiourgia frame
			
			frame1.setLocationRelativeTo(null); //topothethsh sto kentro
			frame1.setVisible(true); //orato

			String array[] = new String[] { "Please Select", "Periodiko", "Vivlio" }; //oi eploges pou periexei mesa to combobox
			JComboBox combo1 = new JComboBox(array); //dhmioutrgia tou combobox
			

			okButton.addActionListener(new ActionListener() { //dinoume zwh sto plhktro kataxwrhsh kai mas anoigei ena neo parathrio me vash tis paraktw entoles

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (combo1.getSelectedItem().equals("Vivlio")) { //ean o xrhsths apo to combobox epileksei vivlio tote dhmiourgeitai ena neo frame
						JFrame frame = new JFrame("Eisagwgh Stoixeiwn"); 
						//dinoume tis aparaithtes entoles gia to frame
						frame.setSize(200, 200);
						frame.setLocationRelativeTo(null);
						frame.setLayout(new GridLayout(9, 1));
						frame.setVisible(true);
						
						//dhmiourgia twn aparaithtwn pediwn(textefields) pou tha symphrwnei o xrhsths me vash ta zhtoumena pou prostithontai sta labels
						JTextField tfTitlos = new JTextField(null, 30);
						JLabel label1 = new JLabel("Dwse Titlo Vivliou");
						JTextField tfIsbn = new JTextField(25);
						JLabel label2 = new JLabel("Dwse kwdiko ISBN");
						JTextField tfSyg = new JTextField(50);
						JLabel label3 = new JLabel("Dwse Syggrafeis");
						JTextField tfEtos = new JTextField(20);
						JLabel label4 = new JLabel("Dwse etos ekdoshs");
						JTextField tfPerigrafh = new JTextField(50);
						JLabel label5 = new JLabel("Dwse mia perigrafh");
						JTextField tfEidos = new JTextField(25);
						JLabel label6 = new JLabel("Dwse eidos/kathgoria");
						JTextField tfSelida = new JTextField(25);
						JLabel label7 = new JLabel("Dwse arithmo selidwn");
						JTextField tfThesh = new JTextField(25);
						JLabel label8 = new JLabel("Dwse thesh tou viviou sto rafi");

						JButton saveButton = new JButton("Save"); //dhmiolurgia koumbiou

						saveButton.addActionListener(new ActionListener() { //dinoume zwh sto koumbi

							@Override
							public void actionPerformed(ActionEvent e) {
								//dhmiourgia antikeimenou ths kalshs vivlio to opoio pairnei ta stoixeia poueisagei o xrhsths me thn getText pairnei to keimeno
								//h integer.parseInt metatrepei ton int se string
								Vivlio book = new Vivlio(tfTitlos.getText(), Integer.parseInt(tfEtos.getText()),
										Integer.parseInt(tfSelida.getText()), Integer.parseInt(tfThesh.getText()),
										tfIsbn.getText(), tfSyg.getText(), tfPerigrafh.getText(), tfEidos.getText());

								util.writeTofile(book); //kaloume th synarthsh writetofile me parametro to antikeimeno ths klashs book
								frame.dispose(); //kai vgainei apo to frame

							}

						});
						//prostithontai sto frame ta label kai ta textfield
						frame.add(label1);
						frame.add(tfTitlos);
						frame.add(label2);
						frame.add(tfIsbn);
						frame.add(label3);
						frame.add(tfSyg);
						frame.add(label4);
						frame.add(tfEtos);
						frame.add(label5);
						frame.add(tfPerigrafh);
						frame.add(label6);
						frame.add(tfEidos);
						frame.add(label7);
						frame.add(tfSelida);
						frame.add(label8);
						frame.add(tfThesh);
						saveButton.setSize(115, 30); // diastaseis sto button
						frame.add(saveButton, BorderLayout.CENTER); // prosthetoume to koumpi sto frame

						frame.pack(); // emfanizei to frame stis diastaseis pou kanei to pack
					} 
					else if (combo1.getSelectedItem().equals("Periodiko")) { //ean o xrhsths o epileksei apo to combobox to periodiko
						JFrame frame = new JFrame("Eisagwgh stoixeiwn"); //neo frame 
						

						frame.setSize(200, 200);
						frame.setLocationRelativeTo(null);
						frame.setLayout(new GridLayout(9, 1));
						frame.setVisible(true);
						
						//dhmioyrgia textfields kai labels mesa sto frame
						JTextField titlos = new JTextField(50);//
						JLabel label1 = new JLabel("Dwse Titlo Periodikou");

						JTextField arithmosTomou = new JTextField(50);//
						JLabel label2 = new JLabel("Dwse Arithmo Tomou");

						JTextField etos = new JTextField(50);//
						JLabel label3 = new JLabel("Dwse to Etos Ekdoshs");

						JTextField teuxos = new JTextField(50);
						JLabel label4 = new JLabel("Dwse ton Aritmho Teuxous");

						JTextField kathgoria = new JTextField(50);
						JLabel label5 = new JLabel("Dwse thn Thmeatikh Kathgoria");

						JTextField arithmosSelidwn = new JTextField(50);
						JLabel label6 = new JLabel("Dwse ton Arithmo twn Selidwn");

						JTextField thesh = new JTextField(50);
						JLabel label7 = new JLabel("Dwse th Thesh pou Fulassetai");

						JButton saveButton = new JButton("Save");

						saveButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								//dhmiourgia antikeimenou tupou periodikou to opoio pairnei ta stoixeia pou eisagei o xrhsths gia thn kataxwrhsh neou periodikou
								//ta stoixeia ta pairnei me thn getText() kai h Integer.parseInt metatepei ta int kai se String
								Periodiko magazine = new Periodiko(titlos.getText(),
										Integer.parseInt(arithmosTomou.getText()), Integer.parseInt(etos.getText()),
										Integer.parseInt(teuxos.getText()), kathgoria.getText(),
										Integer.parseInt(arithmosSelidwn.getText()), Integer.parseInt(thesh.getText()));

								//klhsh ths synarthshs me parametro to antikeimeno magazine
								//h synarthsh grafei ta stoixeia pou pairnei gia thn kataxwrhsh twn stoixeiwn tou periodikou kai ta peranei sto arxeio
								util.writeTofile(magazine); 
								frame.dispose(); //kleinei to frame

							}

						});
						//prosthikh twn labels kai twn textfields sto frame
						frame.add(label1);
						frame.add(titlos);
						frame.add(label2);
						frame.add(arithmosTomou);
						frame.add(label3);
						frame.add(etos);
						frame.add(label4);
						frame.add(teuxos);
						frame.add(label5);
						frame.add(kathgoria);
						frame.add(label6);
						frame.add(arithmosSelidwn);
						frame.add(label7);
						frame.add(thesh);

						
						frame.add(saveButton, BorderLayout.CENTER); //prosthikh tou button sro frame

						frame.pack(); //ginetai pack tou frame

					}

				}

			});

			JPanel panel = new JPanel(); //dhmiourgia panel

			panel.add(combo1); //prostithetai sto panel to combobox
			panel.add(okButton); //prostithetai sto panel to button		
			frame1.add(panel); //prostithetai sto frame to panel
			frame1.pack(); //ginetai pack() sto frame
		}

	}

	//kai se afth thn periptwsh akolouthoume ta parapanw me th monh diafora oti twra proketai gia anazhthsh
	//dhmiourgoume peripou ta idia grafika me parapanw
	class Koumpi2 implements ActionListener {

		JButton buttonSearch = new JButton("Proceed");

		public void actionPerformed(ActionEvent e) {
			JLabel titlosV = new JLabel("Dwse titlo pros anazhthsh: ");
			JFrame frameA = new JFrame("Anazhthsh");
			frameA.setLocationRelativeTo(null);
			frameA.setVisible(true);

			
			
			JRadioButton Vivlio = new JRadioButton("Vivlio"); //dhmiourgia radiobutton
			JRadioButton Periodiko = new JRadioButton("Periodiko");

			String arrayVivlio[] = new String[] { "Please Select", "Titlos", "ISBN" };
			JComboBox comboVivlio = new JComboBox(arrayVivlio);

			String arrayPeriodiko[] = new String[] { "Please Select", "Titlos", "Etos" };
			JComboBox comboPeriodiko = new JComboBox(arrayPeriodiko);

			JButton btn = new JButton("Search");

			buttonSearch.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (Vivlio.isSelected()) { //ean o xrhsths epileksei apo ra radiobutton to vivlio
						Periodiko.setSelected(false); //tote apopeiplegetai to periodiko
	
						JFrame anazhthsh = new JFrame("Anazhthsh Kataxwrhmenou Vivliou");
						anazhthsh.setSize(200, 200);
						anazhthsh.setLocationRelativeTo(null);
						anazhthsh.setLayout(new GridLayout(4, 1));
						anazhthsh.setVisible(true);

					

						JLabel label1 = new JLabel("Epelekse titlo h ISBN gia anazhthsh vivliou: ");
						

						JTextField titlos = new JTextField(null, 50);
						
						//prozthetei sto frame to label to combobox to textfield kai to button
						anazhthsh.add(label1);
						anazhthsh.add(comboVivlio);
						anazhthsh.add(titlos);
						anazhthsh.add(btn);

						anazhthsh.pack();
						
						
						btn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (comboVivlio.getSelectedItem().equals("Titlos")) { //ean  o xrhsths epileksei ton titlo gia na kanei thn anazhthsh tou vivliou
									Vivlio vivlio = new Vivlio(titlos.getText(), ""); //dhmiourgeitai ena antikeimeno to opoio pairnei ton titlo tou vivliou

									appender(util.search(vivlio)); //kaleitai h synarthsh appender h opoia periexei thn synarthsh search() h opoia kanei anazhthsh kai pairnei ws orisma to vivlio
								} else if (comboVivlio.getSelectedItem().equals("ISBN")) { //ean  o xrhsths epileksei to isbn gia na kanei thn anazhthsh tou vivliou
									Vivlio vivlio = new Vivlio("", titlos.getText());

									appender(util.search(vivlio));
								}

							}

						});

					} else if (Periodiko.isSelected()) { //alliws an epilexthei to periodiko
						Vivlio.setSelected(false);
						JLabel label1 = new JLabel("Epelekse titlo h etos ekdoshs gia anazhthsh periodikou: ");
						JButton btn = new JButton("Search");
						JFrame anazhthsh = new JFrame("Anazhthsh Kataxwrhmenou Periodikou");
						anazhthsh.setSize(200, 200);
						anazhthsh.setLocationRelativeTo(null);
						anazhthsh.setLayout(new GridLayout(4, 1));
						anazhthsh.setVisible(true);
						JTextField textF = new JTextField(null, 50);
						btn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								Periodiko periodiko = new Periodiko(textF.getText());
								if (comboPeriodiko.getSelectedItem().equals("Titlos")) { //ean gia anazhthsh epileksei ton titlo
									Periodiko periodiko1 = new Periodiko(textF.getText(), 0); //emfanizei ola ta periodika pou antapokrinontai ston titlo pou dothike

									appender(util.search(periodiko1));//kaleitai h synarthsh appender() h opoia periexei thn synarthsh  search() h opoio kanei anazhthsh kai pairnei ws orisma to periodiko
									// kai sthn anazhthsh epistrefei ths kataxwrhseis 
								} else if (comboVivlio.getSelectedItem().equals("Etos Ekdoshs")) { //ean gia anazhthsh epileksei toetos ekdoshs

									Periodiko periodiko1 = new Periodiko("", Integer.parseInt(textF.getText()));

									appender(util.search(periodiko1));

								}

							}

						});
						anazhthsh.add(label1);
						anazhthsh.add(comboPeriodiko);
						anazhthsh.add(textF);
						anazhthsh.add(btn);

						anazhthsh.pack();

					}
					frameA.dispose();

				}

			});

			JPanel panel = new JPanel();

			panel.add(Vivlio);
			panel.add(Periodiko);
			panel.add(buttonSearch);
			frameA.add(panel);
			frameA.pack();

		}
	}

	public void newGraphics() {
		button1.addActionListener(new Koumpi1()); 
		button2.addActionListener(new Koumpi2());

		panel.add(button1); //prosthikh twn koumpiwn sto panel
		panel.add(button2);

		frame.setSize(300, 200); //thetoume diastaseis sto frame		
		frame.setLocationRelativeTo(null); //orisoume n aemfanizetai sto kentro ths othonhs
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //na kleinei apo to x
		frame.setVisible(true); //kai na einai orato

		frame.add(panel); //kai telos prosthetoumr to panel sto frame

	}

	public void appender(ArrayList<Stoixeia> list) {
		JFrame append = new JFrame("show the list");
		append.setLayout(new GridLayout(2, 1));
		append.setSize(200, 50);
		append.setLocationRelativeTo(null);
		append.setVisible(true);

		JTextArea area = new JTextArea(100, 50);
		area.append(list.toString());
		area.setEditable(false);
		JButton done = new JButton("OK");
		append.add(area);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				append.dispose();
			}
		});
		append.add(done);
		append.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
