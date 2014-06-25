import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class compteEpargne extends JFrame implements ActionListener {
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
    private ConnectionDB conn;
    
    public compteEpargne() {
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jTextField3 = new JTextField();
        jButton1 = new JButton();
        jComboBox1 = new JComboBox();
        jTextField1 = new JTextField();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField4 = new JTextField();

        setTitle("Création d'un nouveau compte Epargne");
        setResizable(false);

        

        jButton2.setText("Annuler");
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);

        


        jLabel1.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel1.setText("Compte Epargne");

        
        
        

        jButton1.setText("Enregistrer");
        jButton1.setHorizontalAlignment(SwingConstants.LEADING);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);

        jTextField1.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel5.setText("Taux");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel2.setText("Code");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel3.setText("Matricule");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18));

        jLabel4.setText("Solde");
        
        jTextField1.setText(compteBancaire.generateCode() + "");
        
        for (int i = 1; i < Ajouter_Client.generateMatricule(); i++)
			jComboBox1.addItem(i);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
           
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(18, 18, 18)
                       
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(jLabel5)
        .addComponent(jLabel2))
                        
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(jTextField4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
        .addGap(34, 34, 34)
                        
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(jLabel3)
        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                           
        .addComponent(jTextField3)
        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
        .addGroup(jPanel1Layout.createSequentialGroup()
                       
        .addGap(110, 110, 110)
        .addComponent(jLabel1)))
        .addContainerGap(24, Short.MAX_VALUE))
        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(95, Short.MAX_VALUE)
        .addComponent(jButton1)
                
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        .addGap(81, 81, 81)) );
       
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
                
        .addGap(25, 25, 25)
        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        .addGap(42, 42, 42)
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
        .addGap(31, 31, 31)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    
        .addComponent(jButton2)
        .addComponent(jButton1))
        .addContainerGap(25, Short.MAX_VALUE)) );

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
			if (!jTextField3.getText().equals("")
					&& !jTextField4.getText().equals("")) {
				conn = new ConnectionDB();
				try {
					conn.executeUpdate("INSERT INTO compte VALUES("
							+ jTextField1.getText()
							+ ", 'Compte Epargne', "
							+ jComboBox1.getSelectedItem()
									.toString() + ", "
							+ jTextField3.getText() + ", 0, "
							+ jTextField4.getText() + ", 0)");
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
}
