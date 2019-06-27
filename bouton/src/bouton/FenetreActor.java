package bouton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetreActor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Bdd bdd = new Bdd();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreActor frame = new FenetreActor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreActor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBounds(119, 336, 81, 25);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = textField.getText();
				int actor_id = Integer.parseInt(text);
				
				bdd.deleteActor(actor_id);
				
				
			}
		});
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(33, 128, 124, 38);
		contentPane.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(33, 206, 124, 38);
		contentPane.add(textArea_2);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(33, 285, 124, 38);
		contentPane.add(textArea_3);

		JLabel lblFirstname = new JLabel("first_name");
		lblFirstname.setBounds(55, 103, 81, 16);
		contentPane.add(lblFirstname);

		JLabel lblLastname = new JLabel("last_name");
		lblLastname.setBounds(55, 177, 56, 16);
		contentPane.add(lblLastname);

		JLabel lblLastupdate = new JLabel("last_update");
		lblLastupdate.setBounds(55, 257, 102, 16);
		contentPane.add(lblLastupdate);
		JButton btnNewButton = new JButton("SELECT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dm = bdd.getActor();
				table.setModel(dm);
			}
		});
		btnNewButton.setBounds(446, 157, 97, 25);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 28, 242, 107);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "actor_id", "first_name", "last_name", "last_update" }));

		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String first_name = textArea_1.getText();
					String last_name = textArea_2.getText();
					bdd.insertActor(first_name, last_name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}

			
		});

		btnNewButton_1.setBounds(12, 336, 81, 25);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(33, 48, 124, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblActorid = new JLabel("actor_id");
		lblActorid.setBounds(65, 19, 56, 16);
		contentPane.add(lblActorid);

	}
}
