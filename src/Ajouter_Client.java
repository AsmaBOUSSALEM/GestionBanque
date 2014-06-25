import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Ajouter_Client extends JFrame implements ActionListener {
	private JButton jButton1;
    private JButton jButton2;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    private JPanel jPanel1;
    
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private static ConnectionDB conn;
    
    public Ajouter_Client() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setTitle("Saisir un nouveau Client ");

      

        jLabel1.setFont(new Font("Serif", 1, 18));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Veuillez saisir les informations suivantes :");
      

        jLabel2.setFont(new Font("Serif", 3, 12));
        jLabel2.setText("Matricule");


        jLabel3.setFont(new Font("Serif", 3, 12));
        jLabel3.setText("Nom & Prenom client");


        jLabel4.setFont(new Font("Serif", 3, 12));
        jLabel4.setText("CIN client");


        jTextField1.setEditable(false);
        jTextField1.setText("" + generateMatricule());

        jButton1.setText("Envoyer");

        jButton2.setText("Annuler");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton1)
                .addGap(47, 47, 47)
                .addComponent(jButton2)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        
        
        
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setEnabled(false);
			}
		});
        
        

        pack();
        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButton2) {
			setVisible(false);
		}
		if (e.getSource() == jButton1) {
			if (jTextField3.getText().equals("")
					|| jTextField2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Remplir tous les champs vide", "Obligatoire",
						JOptionPane.ERROR_MESSAGE);
				jTextField3.setText("");
				jTextField2.setText("");
			} else {
				conn = new ConnectionDB();
				try {
					conn.executeUpdate("INSERT INTO client VALUES("
							+ jTextField1.getText() + ", '"
							+ jTextField3.getText() + "', '"
							+ jTextField2.getText() + "')");
					conn.closeConnection();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				JOptionPane.showMessageDialog(null,
						"L'ajout de client est Réussite",
						"Client ajouté", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		}
	}
	
	public static int generateMatricule() {
		conn = new ConnectionDB();
		int prochain = -1;
		try {
			ResultSet rs = conn
					.executeQuery("SELECT MAX(matricule) AS next_matricule FROM client");
			while (rs.next())
				prochain = rs.getInt("next_matricule");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return prochain + 1;
	}
}
