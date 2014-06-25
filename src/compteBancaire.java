import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class compteBancaire extends javax.swing.JFrame implements ActionListener {
	private JButton jButton1;
    private JButton jButton2;
    private JComboBox jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private static ConnectionDB conn;
    
    public compteBancaire() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jLabel4 = new JLabel();
        jTextField4 = new JTextField();
        jLabel5 = new JLabel();
        jComboBox1 = new JComboBox();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setTitle("Création d'un nouveau compte bancaire");
        setResizable(false);

       

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel1.setText("Compte Bancaire");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18));
        
        jLabel2.setText("Code");

        jTextField1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18));
        
        jLabel3.setText("Matricule");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel4.setText("Solde");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel5.setText("Decouvert");

        jButton1.setText("Enregistrer");
        jButton1.setHorizontalAlignment(SwingConstants.LEADING);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);

        jButton2.setText("Annuler");
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        
        jTextField1.setText(generateCode() + "");
        
        for (int i = 1; i < Ajouter_Client.generateMatricule(); i++)
			jComboBox1.addItem(i);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(jLabel5)
        .addComponent(jLabel2))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(jTextField4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        .addGap(34, 34, 34))
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jButton1)
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                    
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(jLabel3)
        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            
        .addComponent(jTextField3)
        .addComponent(jComboBox1, 0, 90, Short.MAX_VALUE))))
        .addContainerGap(44, Short.MAX_VALUE))
        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(134, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(125, 125, 125)) );
        
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
               
        .addContainerGap()
        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        .addGap(33, 33, 33)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(38, 38, 38)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel4)
        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                   
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel2))
                           
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel3)
        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel5))))
                
        .addGap(43, 43, 43)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(jButton2)
        .addComponent(jButton1))
        .addContainerGap(22, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
			if (!jTextField3.getText().equals("")
					&& !jTextField4.getText().equals("")) {
				conn = new ConnectionDB();
				try {
					conn.executeUpdate("INSERT INTO compte VALUES("
							+ jTextField1.getText()
							+ ", 'Compte Bancaire', "
							+ jComboBox1.getSelectedItem()
									.toString() + ", "
							+ jTextField3.getText() + ", "
							+ jTextField4.getText() + ", 0, 0)");
					conn.closeConnection();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				JOptionPane.showMessageDialog(null,
						"Le nouveau compte a été ajouté avec succé",
						"Compte ajouté", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,
						"Interdiction de laisser des champs vide", "Interdit",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
    
    public static int generateCode() {
		conn = new ConnectionDB();
		int prochain = -1;
		try {
			ResultSet rs = conn
					.executeQuery("SELECT MAX(code) AS next_code FROM compte");
			while (rs.next())
				prochain = rs.getInt("next_code");
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
