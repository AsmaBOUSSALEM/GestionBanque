import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class BD_Compte extends javax.swing.JFrame implements ActionListener, ItemListener {
	private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private ConnectionDB conn;
    
    
    public BD_Compte() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        
        setTitle("Base des comptes");
        setResizable(false);

        

        
        jLabel1.setFont(new java.awt.Font("Serif", 1, 18));
        
        jLabel1.setText("Veuillez choisir le code de compte:");
        
        

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18));
        
        jLabel2.setText("Taux");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 18));
        
        jLabel5.setText("Taux d'opération");

        jTextField1.setEditable(false);

        jTextField4.setEditable(false);

        jTextField3.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18));

        jLabel3.setText("Matricule");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18));

        jLabel4.setText("Solde");

        jTextField2.setEditable(false);

        jTextField5.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18));

        jLabel6.setText("Nom & Prénom Client");

        jTextField6.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Serif", 1, 18));

        jLabel7.setText("Decouvert");

        jButton1.setText("Fermer");
        
        for (int i = 1; i < compteBancaire.generateCode(); i++)
			jComboBox1.addItem(i);
        
        conn = new ConnectionDB();
		try {
			ResultSet rs = conn
					.executeQuery("SELECT client.nom AS nom_temp, "
							+ "compte.matricule AS matricule_temp, "
							+ "compte.solde AS solde_temp, "
							+ "compte.decouvert AS decouvert_temp, "
							+ "compte.taux AS taux_temp, "
							+ "compte.taux_operation AS taux_operation_temp "
							+ "FROM compte, client WHERE code = "
							+ jComboBox1.getSelectedItem().toString() + " AND "
							+ "compte.matricule = client.matricule");
			while (rs.next()) {
				jTextField5.setText(rs.getString("nom_temp"));
				jTextField6.setText(rs.getInt("solde_temp") + "");
				jTextField3.setText(rs.getInt("decouvert_temp") + "");
				jTextField1.setText(rs.getInt("taux_temp") + "");
				jTextField4.setText(rs.getInt("taux_operation_temp")
						+ "");
				jTextField2.setText(rs.getInt("matricule_temp") + "");
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            
        .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
                 
       .addGroup(jPanel1Layout.createSequentialGroup()
       .addGap(34, 34, 34)
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       .addGroup(jPanel1Layout.createSequentialGroup()
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            
       .addComponent(jLabel3)
       .addComponent(jLabel2)
       .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
       .addGap(18, 18, 18)
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
       .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
       .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
       .addComponent(jTextField6))
                        
       .addGap(41, 41, 41)
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       .addComponent(jLabel5)
       .addComponent(jLabel6)
                           
       .addComponent(jLabel7))
       .addGap(18, 18, 18)
       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
       .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            
       .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
       .addGroup(jPanel1Layout.createSequentialGroup()
       .addGap(191, 191, 191)
       .addComponent(jButton1)
                        
       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
       .addGap(38, 38, 38)));
        
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
               
        .addGap(37, 37, 37)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
        .addGap(39, 39, 39)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   
        .addComponent(jLabel3)
        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel6)
                   
        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    
        .addComponent(jLabel2)
        .addComponent(jLabel5)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
        .addGap(32, 32, 32)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    
        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel4)
        .addComponent(jLabel7)
        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(32, 32, 32)
        .addComponent(jButton1)
        .addGap(21, 21, 21)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        
        		
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
       .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        
        
        jButton1.addActionListener(this);
        jComboBox1.addItemListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setEnabled(false);
			}
		});
		
		

        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButton1) {
			setVisible(false);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		conn = new ConnectionDB();
		try {
			ResultSet rs = conn
			.executeQuery("SELECT client.nom AS nom_temp, "
					+ "compte.matricule AS matricule_temp, "
					+ "compte.solde AS solde_temp, "
					+ "compte.decouvert AS decouvert_temp, "
					+ "compte.taux AS taux_temp, "
					+ "compte.taux_operation AS taux_operation_temp "
					+ "FROM compte, client WHERE code = "
					+ jComboBox1.getSelectedItem().toString() + " AND "
					+ "compte.matricule = client.matricule");
			while (rs.next()) {
				jTextField5.setText(rs.getString("nom_temp"));
				jTextField6.setText(rs.getInt("solde_temp") + "");
				jTextField3.setText(rs.getInt("decouvert_temp") + "");
				jTextField1.setText(rs.getInt("taux_temp") + "");
				jTextField4.setText(rs.getInt("taux_operation_temp")
						+ "");
				jTextField2.setText(rs.getInt("matricule_temp") + "");
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}                 
}
