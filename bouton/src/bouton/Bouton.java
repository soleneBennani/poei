package bouton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Bouton extends JFrame {
	
	Bouton(){
		
	}
	Bdd bdd = new Bdd();

	private String[] touche = { "SELECT", "DELETE", "UPDATE", "INSERT" };
	private JButton[] bouton = new JButton[touche.length];

	private JPanel container = new JPanel();

	Dimension dim = new Dimension(90, 40);

	public void buttons() {

		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setContentPane(container);

		this.Bouton();
		this.setVisible(true);

		
		String header[] = { "Civilité", "Nom", "Prenom"};
		String[][] data = new String[4][7];
		for (int j = 0; j < 4; j++) {
			data[j][0] = "test";
			data[j][1] = "test";
			data[j][2] = "test";
			data[j][3] = "test";
			data[j][4] = "test";
			data[j][5] = "test";
			data[j][6] = "test";

		}
	
		DefaultTableModel model = new DefaultTableModel(data,header);

		JTable table = new JTable(model);
		JTableHeader titres = table.getTableHeader();
		titres.setBackground(Color.yellow);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVisible(true);
		container.add(scroll);
		
	
		table.setPreferredScrollableViewportSize(new Dimension(450,163));
        table.setFillsViewportHeight(true);



	}

	public void Bouton() {
		for (int i = 0; i < touche.length; i++) {
			bouton[i] = new JButton(touche[i]);
			bouton[i].setPreferredSize(dim);
			container.add(bouton[i]);

			switch (i) {

			case 3:
				bouton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("chui là");
						//bdd.select();
					}
				});

				break;
			case 2:

				bouton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});

				break;
			case 1:
				bouton[i].addActionListener(null);

				break;
			case 0:
				bouton[i].addActionListener(null);

				break;

			default:

				bouton[i].addActionListener(null);
				break;

			}

		}

	}

}
