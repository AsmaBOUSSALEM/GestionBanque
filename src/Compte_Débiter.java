import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Compte_Débiter extends javax.swing.JFrame implements ActionListener{
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private ConnectionDB conn;
    
    public Compte_Débiter() {
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setTitle("D�biter un compte");
        setResizable(false);

       

        jButton1.setText("Enregistrer");

        jButton2.setText("Annuler");

        
        jLabel1.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel1.setText("Veuillez choisir le compte � d�biter :");

        
        jLabel2.setFont(new java.awt.Font("Serif", 1, 18));
       
        jLabel2.setText("Entrer le montant � D�biter:");
        
        for (int i = 1; i < compteBancaire.generateCode(); i++)
			jComboBox1.addItem(i);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
                        
        .addGap(23, 23, 23)
        .addComponent(jLabel1)
        .addGap(29, 29, 29)
                        
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(92, 92, 92)
                                
        .addComponent(jLabel2)
        .addGap(18, 18, 18))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jButton1)
         .addGap(34, 34, 34)))
                        
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jButton2)
         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
         .addContainerGap(48, Short.MAX_VALUE)));
        
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    
         .addComponent(jLabel1)
         .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGap(44, 44, 44)
                
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
         .addComponent(jLabel2)
         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
         .addComponent(jButton2)
         .addComponent(jButton1))
         .addGap(35, 35, 35)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
			if (jTextField1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Remplir tous le champs obligatoirement", "Obligatoire",
						JOptionPane.ERROR_MESSAGE);
			} else {
				conn = new ConnectionDB();
				try {
					ResultSet rs = conn
					.executeQuery("SELECT solde AS solde_temp, "
							+ "taux AS taux_temp, "
							+ "taux_operation AS taux_operation_temp "
							+ "FROM compte WHERE code = "
							+ jComboBox1.getSelectedItem()
									.toString());
					int resultat = 0, resultat1 = 0, resultat3 = 0, resultat4 = 0;
					while (rs.next()) {
						resultat1 = rs.getInt("solde_temp");
						resultat3 = rs.getInt("taux_temp");
						resultat4 = rs.getInt("taux_operation_temp");
						resultat = ((resultat1 + Integer
								.parseInt(jTextField1.getText())) - ((resultat1 * resultat4) / 100))
								+ ((resultat1 * resultat3) / 100);
					}
					conn.executeUpdate("UPDATE compte SET solde = "
							+ resultat + " WHERE code = "
							+ jComboBox1.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null,
							"Le compte a �t� cr�dit� avec succ�",
							"Retrait", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						conn.closeConnection();
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
					}
				 }
			}
		}
	}               
}
