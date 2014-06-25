import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BD_Application extends JFrame implements ActionListener{
	private JLabel jLabel1;
   
	private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    
    private JMenuBar jMenuBar1;
    private JMenuItem JMenuItem1;
    private JMenuItem JMenuItem2;
    private JMenuItem JMenuItem3;
   
    private JMenuItem mi_AjouterClient;
    private JMenuItem mi_BaseClients;
    private JMenuItem mi_BaseComptes;
    private JMenuItem mi_CrediterCompte;
    private JMenuItem mi_DebiterCompte;
    private JButton b_CrediterCompte;
    private JButton b_DbiterCompte;
    private JButton b_AjouterClient;
    private JButton b_CompteB;
    private JButton b_CompteE;
    private JButton b_CompteP;
    private JMenuItem mi_Quitter;
    private JPanel p1,p2,p3;
    JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

	private Component b_DebiterCompte;
    
    public BD_Application() {
        jLabel1 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        mi_Quitter = new JMenuItem();
        jMenu2 = new JMenu();
        mi_AjouterClient = new JMenuItem();
        mi_BaseClients = new JMenuItem();
        jMenu3 = new JMenu();
        jMenu5 = new JMenu();
        JMenuItem1 = new JMenuItem();
        JMenuItem2 = new JMenuItem();
        JMenuItem3 = new JMenuItem();
        mi_BaseComptes = new JMenuItem();
        jMenu4 = new JMenu();
        mi_CrediterCompte = new JMenuItem();
        mi_DebiterCompte = new JMenuItem();
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        b_CrediterCompte = new JButton("Cr�diter un compte");
        b_DbiterCompte = new JButton("D�biter un compte");
        b_AjouterClient = new JButton("Ajouter un nouveau Client");
        b_CompteP = new JButton("Compte Payant");
        b_CompteE = new JButton("Compte  Epargne");
        b_CompteB = new JButton("Compte Bancaire");
        //p2.setLayout(

        setTitle("Gestion des clients et des comptes bancaires");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon("image/banque.jpg"));
        jLabel1.setSize(100, 221);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setText("Fichier");
        jMenu1.setFont(new java.awt.Font("Sogoe print", 1, 12));


        mi_Quitter.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mi_Quitter.setText("Quitter");
        mi_Quitter.setFont(new java.awt.Font("Sogoe print", 1, 12));

        jMenu1.add(mi_Quitter);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clients");
        jMenu2.setFont(new java.awt.Font("Sogoe print", 1, 12));


        mi_AjouterClient.setText("Ajouter un nouveau Client");
       
        mi_AjouterClient.setFont(new java.awt.Font("Sogoe print", 1, 12));
        jMenu2.add(mi_AjouterClient);

        mi_BaseClients.setText("liste des clients");
      
        mi_BaseClients.setFont(new java.awt.Font("sogoe print", 1, 12));
        jMenu2.add(mi_BaseClients);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Comptes");
        jMenu3.setFont(new java.awt.Font("sogoe print", 1, 12));


        jMenu5.setText("Cr�er un nouveau compte");
        
        jMenu5.setFont(new java.awt.Font("sogoe print", 1, 12));


        JMenuItem1.setText("Compte bancaire");
       
        JMenuItem1.setFont(new java.awt.Font("sogoe print", 1, 12));
        jMenu5.add(JMenuItem1);

        JMenuItem2.setText("Compte epargne");
        
        JMenuItem2.setFont(new java.awt.Font("sogoe print", 1, 12));
        jMenu5.add(JMenuItem2);

        
        JMenuItem3.setText("Compte payant");
       
        JMenuItem3.setFont(new java.awt.Font("sogoe print", 1, 12));

        jMenu5.add(JMenuItem3);

        jMenu3.add(jMenu5);

        mi_BaseComptes.setText("liste des comptes");
        
        mi_BaseComptes.setFont(new java.awt.Font("sogoe print", 1, 12));
        jMenu3.add(mi_BaseComptes);
        

        jMenuBar1.add(jMenu3);

        jMenu4.setText("autres");
       jMenu4.setFont(new java.awt.Font("sogoe print", 1, 12));


        mi_CrediterCompte.setText("Cr�diter un compte");
        mi_CrediterCompte.setFont(new java.awt.Font("sogoe print", 1, 12));
        

        
        jMenu4.add(mi_CrediterCompte);

        mi_DebiterCompte.setText("D�biter un compte");
        mi_DebiterCompte.setFont(new java.awt.Font("sogoe print", 1, 12));
       

        jMenu4.add(mi_DebiterCompte);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);
        
        
        p1.add(b_AjouterClient);
        p1.setPreferredSize(new Dimension(300, 80));
        p2.setPreferredSize(new Dimension(300, 80));
        p3.setPreferredSize(new Dimension(300, 80));
        p2.add( b_CompteP);
        p2.add( b_CompteE);
        p2.add( b_CompteB);
        p3.add(b_CrediterCompte);
        p3.add(b_DbiterCompte);
        onglets.addTab("Ajouter un nouveau Client",p1);
        onglets.addTab("Ajouter un nouveau Compte",p2);
        onglets.addTab("autres",p3);

     
        this.setLayout(new BorderLayout());
        this.add(jLabel1,BorderLayout.NORTH);
        this.getContentPane().add(onglets,BorderLayout.CENTER);
        this.setResizable(true);
        
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "c'etai le projet d'IHM realis� par Asma BOUSSALEM, Merci ",
						"Quitter", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
        JMenuItem1.addActionListener(this);
        JMenuItem2.addActionListener(this);
        JMenuItem3.addActionListener(this);
        mi_AjouterClient.addActionListener(this);
        mi_BaseClients.addActionListener(this);
        mi_BaseComptes.addActionListener(this);
        mi_CrediterCompte.addActionListener(this);
        mi_DebiterCompte.addActionListener(this);
        b_CrediterCompte.addActionListener(this);
        b_DbiterCompte.addActionListener(this);
        mi_Quitter.addActionListener(this);
        b_AjouterClient.addActionListener(this);
        b_CompteP.addActionListener(this);
        b_CompteB.addActionListener(this);
        b_CompteE.addActionListener(this);
        
        

       this.setSize(500,400);
        setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mi_Quitter) {
			int n = JOptionPane.showConfirmDialog(null,
					"Souhaitez-vous vraiment quitter l'application ? ",
					"Comfirmation", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "c'etai le projet d'IHM realis� par Asma BOUSSALEM, Merci ",
						"Quitter", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
		if (e.getSource() == mi_AjouterClient || e.getSource() == b_AjouterClient) {
			new Ajouter_Client();
		}
		if (e.getSource() == mi_BaseClients) {
			new BD_Client();
		}
		if (e.getSource() == JMenuItem1 || e.getSource() == b_CompteB) {
			new compteBancaire();
		}
		if (e.getSource() == JMenuItem2 || e.getSource() == b_CompteE) {
			new compteEpargne();
		}
		if (e.getSource() == JMenuItem3 || e.getSource() == b_CompteP) {
			new comptePayant();
		}
		if (e.getSource() == mi_BaseComptes) {
			new BD_Compte();
		}
		if (e.getSource() == mi_CrediterCompte || e.getSource() == b_CrediterCompte) {
			new Compte_Crediter();
		}
		if (e.getSource() == mi_DebiterCompte || e.getSource() == b_DbiterCompte) {
			new Compte_Débiter();
		}
	}
}
