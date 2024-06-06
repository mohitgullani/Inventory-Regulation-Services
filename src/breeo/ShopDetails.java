/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breeo;

import com.itextpdf.text.BaseColor;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import java.io.OutputStream;
import java.io.File;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ShopDetails extends javax.swing.JFrame {

    
    public ShopDetails() {
        initComponents();
        menu.setVisible(false);
        createConnection();
        getBillNo();
    }
    public void openMenu()
    {
        Thread th=new Thread(){
            @Override
            public void run(){
                Toggle.setVisible(false);
                menu.setVisible(true);
                try{
                    for(int i=0;i<305;i++)
                    {
                        Thread.sleep(1);
                        menu.setSize(i,768);
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
        };th.start();
    }
     public void closeMenu()
    {
        Thread th=new Thread(){
            @Override
            public void run(){
                try{
                    for(int i=305;i>=0;i--)
                    {
                        Thread.sleep(1);
                        menu.setSize(i,768);
                    }
                Toggle.setVisible(true);
                menu.setVisible(false);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
        };th.start();
    }
     public void getClear()
    {
        p1.setBackground(new Color(239,136,22,255));
        p2.setBackground(new Color(239,136,22,255));
        p3.setBackground(new Color(239,136,22,255));
    }
    public void getClearPanelBorder()
    {
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p1.setBorder(b);
        p2.setBorder(b);
        p3.setBorder(b);
    }
    public void showDate()
    {
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        cdate=s.format(d);
    }
    public void showTime()
    {
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("hh:mm aa");
        ctime=s.format(d);
    }
    public void createConnection()
    {
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Breeo","root","root");
            }
        catch(Exception e)
        {
            
        }
    }

    public void getBillNo()
    {
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Breeo","root","root");
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("Select max(BillNo) from shopbills");
            while(rs1.next())
            {
                billno=rs1.getInt("max(BillNo)");
            }
            billno++;
            }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    public void clearAll()
    {
        sno=0;
        productdetails="";
        mrpdetails="";
        weightdetails="";
        qtydetails="";
        totalamountdetails="";
        mrp=0.0;
        totalamount=0.0;
       count=0;
       qty=0;
       totalqty=0;
       weight=0;
       totalweight=0;
       weightkg=0.0;
       productdetailsa=null;
       mrpdetailsa=null;
       weightdetailsa=null;
       qtydetailsa=null;
       totalamountdetailsa=null; 
       getBillNo();
       showDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconbar = new javax.swing.JPanel();
        Toggle = new javax.swing.JLabel();
        retaillogo = new javax.swing.JLabel();
        customerlogo = new javax.swing.JLabel();
        stocklogo = new javax.swing.JLabel();
        balancelogo = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        l3 = new javax.swing.JLabel();
        p4 = new javax.swing.JPanel();
        l4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jsaddpanel2 = new javax.swing.JPanel();
        add2 = new javax.swing.JLabel();
        jsaddpanel3 = new javax.swing.JPanel();
        add3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jsaddpanel4 = new javax.swing.JPanel();
        add4 = new javax.swing.JLabel();
        jsaddpanel5 = new javax.swing.JPanel();
        add5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconbar.setBackground(new java.awt.Color(239, 136, 22));
        iconbar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223)));
        iconbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Toggle.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Toggle.png")); // NOI18N
        Toggle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Toggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ToggleMouseClicked(evt);
            }
        });
        iconbar.add(Toggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        retaillogo.setBackground(new java.awt.Color(102, 102, 102));
        retaillogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        retaillogo.setIcon(new javax.swing.ImageIcon("C:\\RMR Garments\\Ritik\\Retail.png")); // NOI18N
        retaillogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        retaillogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retaillogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                retaillogoMouseEntered(evt);
            }
        });
        iconbar.add(retaillogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 110, 50, 47));

        customerlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerlogo.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Customer Management.png")); // NOI18N
        customerlogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerlogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerlogoMouseClicked(evt);
            }
        });
        iconbar.add(customerlogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 50, 47));

        stocklogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stocklogo.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Stock Management.png")); // NOI18N
        stocklogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stocklogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocklogoMouseClicked(evt);
            }
        });
        iconbar.add(stocklogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 250, 50, 47));

        balancelogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balancelogo.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Balance Analysis.png")); // NOI18N
        balancelogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        balancelogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                balancelogoMouseClicked(evt);
            }
        });
        iconbar.add(balancelogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 320, 50, 47));

        getContentPane().add(iconbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 768));

        menu.setBackground(new java.awt.Color(239, 136, 22));
        menu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Cross.png")); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 14, 32, 30));

        p1.setBackground(new java.awt.Color(239, 136, 22));
        p1.setForeground(new java.awt.Color(204, 204, 204));
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setBackground(new java.awt.Color(67, 48, 44));
        l1.setFont(new java.awt.Font("Cambria Math", 1, 25)); // NOI18N
        l1.setText("Retail");
        l1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l1MouseExited(evt);
            }
        });
        p1.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 47));

        menu.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 280, 47));

        p2.setBackground(new java.awt.Color(239, 136, 22));
        p2.setForeground(new java.awt.Color(204, 204, 204));
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l2.setBackground(new java.awt.Color(204, 204, 204));
        l2.setFont(new java.awt.Font("Cambria Math", 1, 25)); // NOI18N
        l2.setText("Shop Details");
        l2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l2MouseExited(evt);
            }
        });
        p2.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 47));

        menu.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 280, 47));

        p3.setBackground(new java.awt.Color(239, 136, 22));
        p3.setForeground(new java.awt.Color(204, 204, 204));
        p3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l3.setBackground(new java.awt.Color(204, 204, 204));
        l3.setFont(new java.awt.Font("Cambria Math", 1, 25)); // NOI18N
        l3.setText("Stock Management");
        l3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l3MouseExited(evt);
            }
        });
        p3.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 47));

        menu.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 280, 47));

        p4.setBackground(new java.awt.Color(239, 136, 22));
        p4.setForeground(new java.awt.Color(204, 204, 204));
        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l4.setBackground(new java.awt.Color(204, 204, 204));
        l4.setFont(new java.awt.Font("Cambria Math", 1, 25)); // NOI18N
        l4.setText("Balance Analysis");
        l4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l4MouseExited(evt);
            }
        });
        p4.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 280, 47));

        menu.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 280, 47));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Log Out.png")); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 130, 60));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 0, 768));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf1.setForeground(new java.awt.Color(153, 153, 153));
        tf1.setText("Search by Name");
        tf1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf1FocusLost(evt);
            }
        });
        tf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf1KeyReleased(evt);
            }
        });
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 320, 35));

        tb1.setBackground(new java.awt.Color(255, 204, 102));
        tb1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Shop ID", "Shop Name", "Contact No", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tb1FocusGained(evt);
            }
        });
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1);
        if (tb1.getColumnModel().getColumnCount() > 0) {
            tb1.getColumnModel().getColumn(0).setResizable(false);
            tb1.getColumnModel().getColumn(1).setResizable(false);
            tb1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1250, 240));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Shop Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1270, -1));

        tf2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf2.setForeground(new java.awt.Color(153, 153, 153));
        tf2.setText("Search by Shop ID");
        tf2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf2FocusLost(evt);
            }
        });
        tf2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf2KeyReleased(evt);
            }
        });
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 320, 35));

        tb2.setBackground(new java.awt.Color(255, 204, 102));
        tb2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Bill No.", "Total Amount", "Total Quantity", "Net Weight", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tb2FocusGained(evt);
            }
        });
        tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb2);
        if (tb2.getColumnModel().getColumnCount() > 0) {
            tb2.getColumnModel().getColumn(0).setResizable(false);
            tb2.getColumnModel().getColumn(1).setResizable(false);
            tb2.getColumnModel().getColumn(2).setResizable(false);
            tb2.getColumnModel().getColumn(4).setResizable(false);
            tb2.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 1250, 200));

        jsaddpanel2.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel2.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add2.setBackground(new java.awt.Color(255, 255, 255));
        add2.setFont(new java.awt.Font("Cambria Math", 1, 20)); // NOI18N
        add2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add2.setText("Edit");
        add2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add2MouseReleased(evt);
            }
        });
        add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add2KeyPressed(evt);
            }
        });
        jsaddpanel2.add(add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 25));

        jPanel1.add(jsaddpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, 110, 25));

        jsaddpanel3.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel3.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add3.setBackground(new java.awt.Color(255, 255, 255));
        add3.setFont(new java.awt.Font("Cambria Math", 1, 20)); // NOI18N
        add3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add3.setText("Delete");
        add3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add3MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add3MouseReleased(evt);
            }
        });
        add3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add3KeyPressed(evt);
            }
        });
        jsaddpanel3.add(add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 25));

        jPanel1.add(jsaddpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 690, 110, 25));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bills Details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1270, -1));

        tf4.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf4.setForeground(new java.awt.Color(153, 153, 153));
        tf4.setText("Search by Date");
        tf4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf4FocusLost(evt);
            }
        });
        tf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf4KeyReleased(evt);
            }
        });
        jPanel1.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 430, 320, 35));

        tf3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf3.setForeground(new java.awt.Color(153, 153, 153));
        tf3.setText("Search by Bill No.");
        tf3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf3FocusLost(evt);
            }
        });
        tf3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf3KeyReleased(evt);
            }
        });
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 320, 35));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jsaddpanel4.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel4.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add4.setBackground(new java.awt.Color(255, 255, 255));
        add4.setFont(new java.awt.Font("Cambria Math", 1, 20)); // NOI18N
        add4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add4.setText("Add New");
        add4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add4MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add4MouseReleased(evt);
            }
        });
        add4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add4KeyPressed(evt);
            }
        });
        jsaddpanel4.add(add4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 25));

        jPanel1.add(jsaddpanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 350, 110, 25));

        jsaddpanel5.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel5.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add5.setBackground(new java.awt.Color(255, 255, 255));
        add5.setFont(new java.awt.Font("Cambria Math", 1, 20)); // NOI18N
        add5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add5.setText("View Extra Details");
        add5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add5.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add5AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add5MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add5MouseReleased(evt);
            }
        });
        add5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add5KeyPressed(evt);
            }
        });
        jsaddpanel5.add(add5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 25));

        jPanel1.add(jsaddpanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 190, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 1290, 748));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Background Image.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1366, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
String cdate="",ctime="";
int billno=0;
public static int checkvalue=0;
    private void ToggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToggleMouseClicked
        openMenu();
    }//GEN-LAST:event_ToggleMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        closeMenu();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void retaillogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retaillogoMouseClicked
        Billing b=new Billing();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retaillogoMouseClicked

    private void retaillogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retaillogoMouseEntered

    }//GEN-LAST:event_retaillogoMouseEntered

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        Billing b=new Billing();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l1MouseClicked

    private void l1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseEntered
        getClear();
        p1.setBackground(new Color(255,255,255,255));
        getClearPanelBorder();
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        p1.setBorder(b);
    }//GEN-LAST:event_l1MouseEntered

    private void l1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseExited
        p1.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p1.setBorder(b);
    }//GEN-LAST:event_l1MouseExited

    private void customerlogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerlogoMouseClicked
        ShopDetails s=new ShopDetails();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerlogoMouseClicked

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked
        ShopDetails s=new ShopDetails();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l2MouseClicked

    private void l2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseEntered
        getClear();
        p2.setBackground(new Color(255,255,255,255));
        getClearPanelBorder();
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        p2.setBorder(b);
    }//GEN-LAST:event_l2MouseEntered

    private void l2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseExited
        p2.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p2.setBorder(b);
    }//GEN-LAST:event_l2MouseExited

    private void stocklogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocklogoMouseClicked
        Border b1=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        stocklogo.setBorder(b1);  
        customerlogo.setBorder(null);
        StockFrame s=new StockFrame();
        s.setVisible(true);
    }//GEN-LAST:event_stocklogoMouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
        Border b1=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        stocklogo.setBorder(b1);  
        customerlogo.setBorder(null);
        StockFrame s=new StockFrame();
        s.setVisible(true);
    }//GEN-LAST:event_l3MouseClicked

    private void l3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseEntered
        getClear();
        p3.setBackground(new Color(255,255,255,255));
        getClearPanelBorder();
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        p3.setBorder(b);
    }//GEN-LAST:event_l3MouseEntered

    private void l3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseExited
        p3.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p3.setBorder(b);
    }//GEN-LAST:event_l3MouseExited
int info=0;
public static int windowcount=0;
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        customerlogo.setBorder(b);
        stocklogo.setBorder(null);
        showDate();
        showTime();     
        if(windowcount==0)
        {
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            try
                {
                  while(model.getRowCount()>0)
                  {
                      for(int i=0;i<model.getRowCount();i++)
                            model.removeRow(i);
                  }
                 Statement st=con.createStatement();
                 ResultSet rs=st.executeQuery("select * from shopdetails");
                 while(rs.next())
                 {
                     model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                 }
                }
                catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null,"Record not Stored");
                }
            windowcount++;
            DefaultTableModel model1=(DefaultTableModel)tb2.getModel();
            try
                {
                  while(model1.getRowCount()>0)
                  {
                      for(int i=0;i<model1.getRowCount();i++)
                            model1.removeRow(i);
                  }
                }
                catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null,"Record not Stored");
                }
        }
        else
        {
            
        }
    }//GEN-LAST:event_formWindowGainedFocus
Connection con;
String id="";
int maxid=0;String sname="",scontact="",saddress="";String type="";
String sweight="",smrp="",sqty="";Double mrp,totalamount=0.0;
int sno=0,count,qty=0,totalqty=0,weight=0,totalweight=0;
String productdetails="",mrpdetails="",weightdetails="",qtydetails="",totalamountdetails="";Double weightkg;String[] productdetailsa,mrpdetailsa,weightdetailsa,qtydetailsa,totalamountdetailsa; 
int pdfspace=15;
    private void balancelogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balancelogoMouseClicked
        BalanceFrame b=new BalanceFrame();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_balancelogoMouseClicked

    private void l4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseClicked
        BalanceFrame b=new BalanceFrame();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l4MouseClicked

    private void l4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseEntered
        getClear();
        p4.setBackground(new Color(255,255,255,255));
        getClearPanelBorder();
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        p4.setBorder(b);
    }//GEN-LAST:event_l4MouseEntered

    private void l4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseExited
        p4.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p4.setBorder(b);
    }//GEN-LAST:event_l4MouseExited

    private void tf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf1FocusGained
        tf1.setForeground(new Color(153,153,153,255));
        tf2.setForeground(new Color(153,153,153,255));
        tf3.setForeground(new Color(153,153,153,255));
        tf4.setForeground(new Color(153,153,153,255));
        tf1.setText("");
        tf2.setText("Search by Shop ID");
        tf3.setText("Search by Bill No.");
        tf4.setText("Search by Date");
        DefaultTableModel model=(DefaultTableModel)tb1.getModel();
        try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
    }//GEN-LAST:event_tf1FocusGained

    private void tf1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf1FocusLost
        String strTemp=tf1.getText();
        tf1.setForeground(new Color(153,153,153,255));
        if(strTemp.equals(""))
        {
            tf1.setText("Search by Name");
        }
        else
        {

        }
    }//GEN-LAST:event_tf1FocusLost

    private void tf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyPressed

    }//GEN-LAST:event_tf1KeyPressed
String searchn="";
    private void tf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyReleased
        tf1.setForeground(Color.black);
        searchn=tf1.getText();
        if(searchn.equals(""))
        {
            tf1.setText("");
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
            
        }
        else
        { 
         DefaultTableModel model=(DefaultTableModel)tb1.getModel();
         try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails where ShopName like '%"+searchn+"%'");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
        }
    }//GEN-LAST:event_tf1KeyReleased

    private void tf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf2FocusGained
        tf1.setForeground(new Color(153,153,153,255));
        tf2.setForeground(new Color(153,153,153,255));
        tf3.setForeground(new Color(153,153,153,255));
        tf4.setForeground(new Color(153,153,153,255));
        tf2.setText("");
        tf1.setText("Search by Name");
        tf3.setText("Search by Bill No.");
        tf4.setText("Search by Date");
        DefaultTableModel model=(DefaultTableModel)tb1.getModel();
        try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }        
    }//GEN-LAST:event_tf2FocusGained

    private void tf2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf2FocusLost
        String strTemp=tf2.getText();
        tf2.setForeground(new Color(153,153,153,255));
        if(strTemp.equals(""))
        {
            tf2.setText("Search by Shop ID");
        }
        else
        {

        }
    }//GEN-LAST:event_tf2FocusLost

    private void tf2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2KeyPressed
String searchid="";
    private void tf2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf2KeyReleased
        tf2.setForeground(Color.black);
        searchid=tf2.getText();
        if(searchid.equals(""))
        {
            tf2.setText("");
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
            
        }
        else
        { 
         DefaultTableModel model=(DefaultTableModel)tb1.getModel();
         try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails where SID like '%"+searchid+"%'");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
        }        
    }//GEN-LAST:event_tf2KeyReleased

    private void add2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add2AncestorAdded

    private void add2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseClicked
        EditShopDetails e=new EditShopDetails(sid);
        e.setVisible(true);
    }//GEN-LAST:event_add2MouseClicked

    private void add2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add2MouseEntered

    private void add2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add2MousePressed

    private void add2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add2MouseReleased

    private void add2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add2KeyPressed

    private void add3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add3AncestorAdded

    private void add3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseClicked
        try
        {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from shopbills where BillNo="+billn+"");
            while(rs.next())
            {
                Statement st1=con.createStatement();
                st1.executeUpdate("insert into deletedbills values("+billn+","+rs.getInt("Total_Amount")+","+rs.getInt("Total_Quantity")+",'"+rs.getString("Net_Weight")+"','"+rs.getString("Date")+"','"+rs.getString("Time")+"',"+rs.getInt("SID")+")");
                st1.executeUpdate("delete from shopbills where BillNo="+billn+"");
            }
            InfoUpdatedSuccessfully i=new InfoUpdatedSuccessfully();
            i.setVisible(true);
        }
        catch(Exception e)
        {

        }        
    }//GEN-LAST:event_add3MouseClicked

    private void add3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add3MouseEntered

    private void add3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add3MousePressed

    private void add3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add3MouseReleased

    private void add3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add3KeyPressed

    private void tf4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf4FocusGained
        tf3.setForeground(new Color(153,153,153,255));
        tf4.setForeground(new Color(153,153,153,255));
        tf4.setText("");
        tf3.setText("Search by Bill No.");
        
        String tempn=tf1.getText();
        if(tempn.equals("Search by Name"))
        {
            tf1.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf1.setForeground(Color.black);
            tf1.setText(tempn);
        }
        
        String tempid=tf2.getText();
        if(tempid.equals("Search by Shop ID"))
        {
            tf2.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf2.setForeground(Color.black);
            tf2.setText(tempid);
        }

        DefaultTableModel model1=(DefaultTableModel)tb2.getModel();
            try
            {
              while(model1.getRowCount()>0)
              {
                  for(int i=0;i<model1.getRowCount();i++){
                        model1.removeRow(i);
                  }
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where SID="+sid+"");
             while(rs.next())
             {
                 model1.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_tf4FocusGained

    private void tf4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf4FocusLost
        String strTemp=tf4.getText();
        tf4.setForeground(new Color(153,153,153,255));
        if(strTemp.equals(""))
        {
            tf4.setText("Search by Date");
        }
        else
        {

        }
    }//GEN-LAST:event_tf4FocusLost

    private void tf4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4KeyPressed
String searchdate="";
    private void tf4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf4KeyReleased
        tf4.setForeground(Color.black);
        searchdate=tf4.getText();
        if(searchdate.equals(""))
        {
            tf3.setText("");
            DefaultTableModel model=(DefaultTableModel)tb2.getModel();
            try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where SID="+sid+"");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
            
        }
        else
        { 
         DefaultTableModel model=(DefaultTableModel)tb2.getModel();
         try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where Date like '%"+searchdate+"%' and SID="+sid+"");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
        }
    }//GEN-LAST:event_tf4KeyReleased

    private void tf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf3FocusGained
        tf3.setForeground(new Color(153,153,153,255));
        tf4.setForeground(new Color(153,153,153,255));
        tf3.setText("");
        tf4.setText("Search by Date");
        
        String tempn=tf1.getText();
        if(tempn.equals("Search by Name"))
        {
            tf1.setForeground(new Color(153,153,153,255));
        }
        else
        {
           tf1.setForeground(Color.black);
           tf1.setText(tempn); 
        }
        String tempid=tf2.getText();
        if(tempid.equals("Search by Shop ID"))
        {
            tf2.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf2.setForeground(Color.black);
            tf2.setText(tempid);
        }
        DefaultTableModel model1=(DefaultTableModel)tb2.getModel();
        try
        {
          while(model1.getRowCount()>0)
          {
              for(int i=0;i<model1.getRowCount();i++){
                    model1.removeRow(i);
              }
          }
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("select * from shopbills where SID="+sid+"");
         while(rs.next())
         {
             model1.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
         }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tf3FocusGained

    private void tf3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf3FocusLost
        String strTemp=tf3.getText();
        tf3.setForeground(new Color(153,153,153,255));
        if(strTemp.equals(""))
        {
            tf3.setText("Search by Bill No.");
        }
        else
        {
            tf3.setText("");
        }
    }//GEN-LAST:event_tf3FocusLost

    private void tf3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3KeyPressed
String searchbill="";
    private void tf3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf3KeyReleased
        tf3.setForeground(Color.black);
        searchbill=tf3.getText();
        if(searchbill.equals(""))
        {
            tf3.setText("");
            DefaultTableModel model=(DefaultTableModel)tb2.getModel();
            try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where SID="+sid+"");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
            
        }
        else
        { 
         DefaultTableModel model=(DefaultTableModel)tb2.getModel();
         try
            {
              while(model.getRowCount()>0)
              {
                  for(int i=0;i<model.getRowCount();i++)
                        model.removeRow(i);
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where BillNo like '%"+searchbill+"%'");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
        }
    }//GEN-LAST:event_tf3KeyReleased
int sid=0;
    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        DefaultTableModel model=(DefaultTableModel)tb1.getModel();
        sid=(int) model.getValueAt(tb1.getSelectedRow(),0);
        
        
        DefaultTableModel model1=(DefaultTableModel)tb2.getModel();
            try
            {
              while(model1.getRowCount()>0)
              {
                  for(int i=0;i<model1.getRowCount();i++){
                        model1.removeRow(i);
                  }
              }
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopbills where SID="+sid+"");
             while(rs.next())
             {
                 model1.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)});
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_tb1MouseClicked

    private void tb1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb1FocusGained
        String searchn=tf1.getText();
        if(searchn.equals("Search by Name"))
        {
            tf1.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf1.setForeground(Color.black);   
        }
        String searchid=tf2.getText();
        if(searchid.equals("Search by Shop ID"))
        {
            tf2.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf2.setForeground(Color.black);   
        }
        tf3.setForeground(new Color(153,153,153,255));
        tf4.setForeground(new Color(153,153,153,255));
        tf3.setText("Search by Bill No.");
        tf4.setText("Search by Date");
    }//GEN-LAST:event_tb1FocusGained

    private void tb2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb2FocusGained
        String searchbill=tf3.getText();
        if(searchbill.equals("Search by Bill No."))
        {
            tf3.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf3.setForeground(Color.black);   
        }
        String searchdate=tf4.getText();
        if(searchdate.equals("Search by Date"))
        {
            tf4.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf4.setForeground(Color.black);   
        }
    }//GEN-LAST:event_tb2FocusGained
int billn=0;
    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
        DefaultTableModel model=(DefaultTableModel)tb2.getModel();
        billn=(int) model.getValueAt(tb2.getSelectedRow(),0);
    }//GEN-LAST:event_tb2MouseClicked

    private void add4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add4AncestorAdded

    private void add4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseClicked
        AddNewID a=new AddNewID();
        a.setVisible(true);
    }//GEN-LAST:event_add4MouseClicked

    private void add4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add4MouseEntered

    private void add4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add4MousePressed

    private void add4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add4MouseReleased

    private void add4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add4KeyPressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        LoginForm l=new LoginForm();
        l.setVisible(true);
        LogoutSuccess lo=new LogoutSuccess();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void add5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add5AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add5AncestorAdded

    private void add5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseClicked
    SearchBillsbyDate s=new SearchBillsbyDate();
    s.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_add5MouseClicked

    private void add5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add5MouseEntered

    private void add5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add5MousePressed

    private void add5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add5MouseReleased

    private void add5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add5KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShopDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShopDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Toggle;
    private javax.swing.JLabel add2;
    private javax.swing.JLabel add3;
    private javax.swing.JLabel add4;
    private javax.swing.JLabel add5;
    private javax.swing.JLabel balancelogo;
    private javax.swing.JLabel customerlogo;
    private javax.swing.JPanel iconbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jsaddpanel2;
    private javax.swing.JPanel jsaddpanel3;
    private javax.swing.JPanel jsaddpanel4;
    private javax.swing.JPanel jsaddpanel5;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JLabel retaillogo;
    private javax.swing.JLabel stocklogo;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
