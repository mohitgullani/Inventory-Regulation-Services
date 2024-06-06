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
public class SearchBillsbyDate extends javax.swing.JFrame {

    
    public SearchBillsbyDate() {
        initComponents();
        menu.setVisible(false);
        createConnection();
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tf6 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        tf7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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

        tb1.setBackground(new java.awt.Color(255, 204, 102));
        tb1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill No.", "Total Amount", "Total Quantity", "Net Weight", "Date", "Time", "Shop ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tb1.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb1.getColumnModel().getColumn(1).setResizable(false);
            tb1.getColumnModel().getColumn(1).setPreferredWidth(205);
            tb1.getColumnModel().getColumn(2).setResizable(false);
            tb1.getColumnModel().getColumn(2).setPreferredWidth(100);
            tb1.getColumnModel().getColumn(3).setResizable(false);
            tb1.getColumnModel().getColumn(3).setPreferredWidth(205);
            tb1.getColumnModel().getColumn(4).setResizable(false);
            tb1.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb1.getColumnModel().getColumn(5).setResizable(false);
            tb1.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb1.getColumnModel().getColumn(6).setResizable(false);
            tb1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1310, 360));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("All Shop Bills");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 980, -1));

        tf1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf1.setForeground(new java.awt.Color(153, 153, 153));
        tf1.setText("Search by Date");
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
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 380, 35));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Shop Details");
        jLabel37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 15, 1250, 35));

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel38.setText("Shop Name");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 210, 30));

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel39.setText("Shop ID");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 30));

        tf2.setEditable(false);
        tf2.setBackground(new java.awt.Color(240, 240, 240));
        tf2.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 360, 30));

        tf3.setEditable(false);
        tf3.setBackground(new java.awt.Color(240, 240, 240));
        tf3.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 80, 360, 30));

        tf4.setEditable(false);
        tf4.setBackground(new java.awt.Color(240, 240, 240));
        tf4.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 360, 30));

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel40.setText("Contact No.");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, 30));

        tf5.setEditable(false);
        tf5.setBackground(new java.awt.Color(240, 240, 240));
        tf5.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 360, 30));

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel41.setText("Address");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 210, 30));

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel42.setText("Total Bills");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, 210, 30));

        tf6.setEditable(false);
        tf6.setBackground(new java.awt.Color(240, 240, 240));
        tf6.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 195, 360, 30));

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel43.setText("Net Amount");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 195, 210, 30));

        tf7.setEditable(false);
        tf7.setBackground(new java.awt.Color(240, 240, 240));
        tf7.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 195, 360, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 1310, 260));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Back Image.png")); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 100, 36));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1350, 748));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Background Image.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1366, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
String cdate="",ctime="";
int billno=0;
public static int checkvalue=0;
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        Billing b=new Billing();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l1MouseClicked

    private void l1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseEntered

    }//GEN-LAST:event_l1MouseEntered

    private void l1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseExited
        p1.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p1.setBorder(b);
    }//GEN-LAST:event_l1MouseExited

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked
        SearchBillsbyDate s=new SearchBillsbyDate();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l2MouseClicked

    private void l2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseEntered

    }//GEN-LAST:event_l2MouseEntered

    private void l2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseExited
        p2.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p2.setBorder(b);
    }//GEN-LAST:event_l2MouseExited

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked

    }//GEN-LAST:event_l3MouseClicked

    private void l3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseEntered

    }//GEN-LAST:event_l3MouseEntered

    private void l3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseExited
        p3.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p3.setBorder(b);
    }//GEN-LAST:event_l3MouseExited
int info=0;
public static int windowcount=0;
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
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
                 ResultSet rs=st.executeQuery("select * from shopbills");
                 while(rs.next())
                 {
                     model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
                 }
                   ResultSet rs1=st.executeQuery("select count(BillNo) from shopbills");
                   while(rs1.next())
                   {
                       tf6.setText(""+rs1.getInt("count(BillNo)"));
                   }
                   ResultSet rs2=st.executeQuery("select sum(Total_Amount) from shopbills");
                    while(rs2.next())
                    {
                        tf7.setText(""+rs2.getInt("sum(Total_Amount)")+"/-");
                    }
                }
                catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null,"Record not Stored");
                }
            windowcount++;
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
    private void l4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseClicked
        BalanceFrame b=new BalanceFrame();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l4MouseClicked

    private void l4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseEntered

    }//GEN-LAST:event_l4MouseEntered

    private void l4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseExited
        p4.setBackground(new Color(239,136,22,255));
        Border b=BorderFactory.createLineBorder(new Color(239,136,22,255), 1);
        p4.setBorder(b);
    }//GEN-LAST:event_l4MouseExited
String searchn="";
    private void tf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf1FocusGained
        tf1.setForeground(Color.BLACK);
        tf1.setText("");
            try
            {
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select count(BillNo) from shopbills");
             while(rs.next())
             {
                 tf6.setText(""+rs.getInt("count(BillNo)"));
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            try
                {
                  while(model.getRowCount()>0)
                  {
                      for(int i=0;i<model.getRowCount();i++)
                            model.removeRow(i);
                  }
                 Statement st=con.createStatement();
                 ResultSet rs=st.executeQuery("select * from shopbills");
                 while(rs.next())
                 {
                     model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
                 }
                   ResultSet rs1=st.executeQuery("select count(BillNo) from shopbills");
                   while(rs1.next())
                   {
                       tf6.setText(""+rs1.getInt("count(BillNo)"));
                   }
                   ResultSet rs2=st.executeQuery("select sum(Total_Amount) from shopbills");
                    while(rs2.next())
                    {
                        tf7.setText(""+rs2.getInt("sum(Total_Amount)")+"/-");
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
            tf1.setText("Search by Shop ID");
        }
        else
        {

        }
    }//GEN-LAST:event_tf1FocusLost

    private void tf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1KeyPressed
String searchdate="";
    private void tf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyReleased
        tf1.setForeground(Color.black);
        searchdate=tf1.getText();
        if(searchdate.equals(""))
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
             ResultSet rs=st.executeQuery("select * from shopbills");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
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
             ResultSet rs=st.executeQuery("select * from shopbills where Date like '%"+searchdate+"%'");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
             }
            }
            catch(Exception e)
            {
             JOptionPane.showMessageDialog(null,"Record not Stored");
            }
        }      
        try
            {
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select count(BillNo) from shopbills where Date like '%"+searchdate+"%'");
             while(rs.next())
             {
                 tf6.setText(""+rs.getInt("count(BillNo)"));
             }
             ResultSet rs2=st.executeQuery("select sum(Total_Amount) from shopbills where Date like '%"+searchdate+"%'");
             while(rs2.next())
             {
                 tf7.setText(""+rs2.getInt("sum(Total_Amount)")+"/-");
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_tf1KeyReleased
String searchbill="",sid="";
    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        DefaultTableModel model=(DefaultTableModel)tb1.getModel();
        sid=(String) model.getValueAt(tb1.getSelectedRow(),6);
            try
            {
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from shopdetails where SID="+sid+"");
             while(rs.next())
             {
                 tf3.setText(""+sid);
                 tf2.setText(rs.getString("ShopName"));
                 tf4.setText(rs.getString("Contact"));
                 tf5.setText(rs.getString("Address"));
             }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_tb1MouseClicked

    private void tb1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb1FocusGained
        String searchn=tf1.getText();
        if(searchn.equals("Search by Date"))
        {
            tf1.setForeground(new Color(153,153,153,255));
        }
        else
        {
            tf1.setForeground(Color.black);   
        }
        String searchid=tf1.getText();
    }//GEN-LAST:event_tb1FocusGained
int billn=0;
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        LoginForm l=new LoginForm();
        l.setVisible(true);
        LogoutSuccess lo=new LogoutSuccess();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ShopDetails s=new ShopDetails();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(SearchBillsbyDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBillsbyDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBillsbyDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBillsbyDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBillsbyDate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JTable tb1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}
