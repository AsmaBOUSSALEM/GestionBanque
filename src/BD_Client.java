import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BD_Client extends JFrame implements  ListSelectionListener {
	private JList jList1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private ConnectionDB conn;
   
    JScrollPane jScrollPane1 =new JScrollPane();
    DefaultListModel model=new DefaultListModel();
    
    public BD_Client() {
        jPanel1 = new JPanel();
        jLabel4 = new JLabel();
        
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();

        
        setTitle("Enregistrement  des clients");
        setResizable(false);

       
        jLabel4.setFont(new Font("Serif", 3, 12));
       
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText(" CIN Client  :");

        jLabel1.setFont(new Font("Serif", 1, 18));
        jLabel1.setText("Veuillez choisir le matricule du client :");
       

        jLabel3.setFont(new Font("Serif", 3, 12));
       
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText(" Nom & Prénom Client :");

        jTextField2.setEditable(false);

        jTextField3.setEditable(false);
        
        
        
        conn = new ConnectionDB();
		try {
			ResultSet rs = conn
					.executeQuery("SELECT nom AS nom_client, cin AS cin_client "
							+ "FROM client WHERE matricule = 1");
			while (rs.next()) {
				jTextField3.setText(rs.getString("nom_client"));
				jTextField2.setText(rs.getString("cin_client"));
			}
			
			for (int i = 1; i < Ajouter_Client.generateMatricule(); i++)
				model.addElement(i);
			
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

		jList1 = new JList(model);
		jList1.addListSelectionListener (this) ;
		
		
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
         
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(59, 59, 59)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel3))
        .addGap(27, 27, 27)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        .addComponent(jTextField3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        .addComponent(jTextField2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        .addComponent(jList1, GroupLayout.Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, GroupLayout.PREFERRED_SIZE))
        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
        .addContainerGap(36, Short.MAX_VALUE)) );
       
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(jLabel1)
            .addGap(25, 27, 27)
            .addComponent(jList1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25)
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(32, Short.MAX_VALUE)) );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        
        
        
       
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setEnabled(false);
			}
		});
        
        

        pack();
        setVisible(true);
    }
    public void valueChanged(ListSelectionEvent arg0) {
    	String ch = (String)jList1.getSelectedValue().toString() ;

    	conn = new ConnectionDB();
		try {
			ResultSet rs = conn
					.executeQuery("SELECT nom AS nom_client, cin AS cin_client "
							+ "FROM client WHERE matricule = "
							+ ch);
			while (rs.next()) {
				jTextField3.setText(rs.getString("nom_client"));
				jTextField2.setText(rs.getString("cin_client"));
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				conn.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}}

		
	}
	
	
	
	 
}
