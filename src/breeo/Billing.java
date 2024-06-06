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
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Billing extends javax.swing.JFrame {

    
    public Billing() {
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
        billdate.setText(cdate);
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
            con.setAutoCommit(false);
            }
        catch(Exception e)
        {
            
        }
    }
    public void clearCustomerDetails()
    {
        name.setText("");
        address.setText("");
        mobile.setText("");
        sid.setText("");
        bdate.setText("");
        bname.setText("");
        baddress.setText("");
        bcontact.setText("");
    }
    public void clearAllFields()
    {
        type1.setSelectedIndex(0);
        type2.setSelectedIndex(0);
        type3.setForeground(new Color(153,153,153,255));
        type3.setText("Enter Other Category");
        w1.setSelectedIndex(0);
        w2.setSelectedIndex(0);
        w3.setForeground(new Color(153,153,153,255));
        w3.setText("Weight");
        mrp1.setForeground(new Color(153,153,153,255));
        mrp1.setText("MRP");
        mrp2.setForeground(new Color(153,153,153,255));
        mrp2.setText("MRP");
        mrp3.setForeground(new Color(153,153,153,255));
        mrp3.setText("MRP");
        qty1.setForeground(new Color(153,153,153,255));
        qty1.setText("QTY");
        qty2.setForeground(new Color(153,153,153,255));
        qty2.setText("QTY");
        qty3.setForeground(new Color(153,153,153,255));
        qty3.setText("QTY"); 
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
            bbill.setText("No. "+billno);
            }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    public void clearAll()
    {
     clearAllFields();
     clearCustomerDetails();
     tqty.setText("");
     tamount.setText("");
     tweight.setText("");
     namount.setText("");
     bname.setText("");
     bdate.setText("");
     baddress.setText("");
     bcontact.setText("");
     bweight.setText("");
     btotal.setText("");
     ta1.setText("");
     ta2.setText("");
     ta3.setText("");
     ta4.setText("");
     ta7.setText("");
     ta8.setText("");
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
    billdate.setText(cdate);
    bdate.setText(cdate);
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bweight = new javax.swing.JLabel();
        baddress = new javax.swing.JLabel();
        btotal = new javax.swing.JLabel();
        bdate = new javax.swing.JLabel();
        bname = new javax.swing.JLabel();
        bcontact = new javax.swing.JLabel();
        bbill = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta4 = new javax.swing.JTextArea();
        ta5 = new javax.swing.JScrollPane();
        ta7 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta8 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        date8 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        date3 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        date5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        date10 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        billdate = new javax.swing.JTextField();
        date11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Amount = new javax.swing.JLabel();
        date9 = new javax.swing.JLabel();
        date4 = new javax.swing.JLabel();
        date6 = new javax.swing.JLabel();
        tqty = new javax.swing.JTextField();
        tweight = new javax.swing.JTextField();
        tamount = new javax.swing.JTextField();
        jsaddpanel5 = new javax.swing.JPanel();
        add5 = new javax.swing.JLabel();
        jsaddpanel6 = new javax.swing.JPanel();
        add6 = new javax.swing.JLabel();
        date7 = new javax.swing.JLabel();
        namount = new javax.swing.JTextField();
        jsaddpanel7 = new javax.swing.JPanel();
        add7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        type1 = new javax.swing.JComboBox<>();
        w1 = new javax.swing.JComboBox<>();
        mrp1 = new javax.swing.JTextField();
        qty1 = new javax.swing.JTextField();
        jsaddpanel1 = new javax.swing.JPanel();
        add1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        type3 = new javax.swing.JTextField();
        qty3 = new javax.swing.JTextField();
        jsaddpanel3 = new javax.swing.JPanel();
        add3 = new javax.swing.JLabel();
        w3 = new javax.swing.JTextField();
        mrp3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        type2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        w2 = new javax.swing.JComboBox<>();
        mrp2 = new javax.swing.JTextField();
        qty2 = new javax.swing.JTextField();
        jsaddpanel2 = new javax.swing.JPanel();
        add2 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bweight.setFont(new java.awt.Font("Cambria Math", 1, 16)); // NOI18N
        bweight.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(bweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 651, 140, 20));

        baddress.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(baddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 151, 460, 20));

        btotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btotal.setForeground(new java.awt.Color(255, 255, 255));
        btotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(btotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 652, 100, 20));

        bdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 124, 80, 20));

        bname.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 124, 300, 20));

        bcontact.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(bcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 179, 180, 20));

        bbill.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bbill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bbill.setText("No.");
        jPanel1.add(bbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, 90, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ta2.setEditable(false);
        ta2.setColumns(20);
        ta2.setRows(5);
        ta2.setBorder(null);
        jScrollPane1.setViewportView(ta2);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 284, 417));

        ta3.setEditable(false);
        ta3.setColumns(20);
        ta3.setRows(5);
        ta3.setBorder(null);
        jScrollPane2.setViewportView(ta3);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 0, 42, 417));

        ta4.setEditable(false);
        ta4.setColumns(20);
        ta4.setRows(5);
        ta4.setBorder(null);
        jScrollPane3.setViewportView(ta4);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 0, 40, 417));

        ta7.setEditable(false);
        ta7.setColumns(20);
        ta7.setRows(5);
        ta7.setBorder(null);
        ta5.setViewportView(ta7);

        jPanel2.add(ta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 0, 66, 417));

        ta8.setEditable(false);
        ta8.setColumns(20);
        ta8.setRows(5);
        ta8.setBorder(null);
        jScrollPane5.setViewportView(ta8);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 0, 95, 417));

        ta1.setEditable(false);
        ta1.setColumns(20);
        ta1.setRows(5);
        ta1.setBorder(null);
        jScrollPane6.setViewportView(ta1);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 420));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 234, 546, 417));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Bill.jpg")); // NOI18N
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 563, 750));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 10, 563, 750));

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

        jPanel5.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date8.setBackground(new java.awt.Color(204, 204, 204));
        date8.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date8.setForeground(new java.awt.Color(204, 204, 204));
        date8.setText("Shop Name");
        date8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel5.add(date8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        name.setBackground(new java.awt.Color(255, 204, 102));
        name.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });
        jPanel5.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 240, 30));

        date3.setBackground(new java.awt.Color(204, 204, 204));
        date3.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date3.setForeground(new java.awt.Color(204, 204, 204));
        date3.setText("Mobile");
        date3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel5.add(date3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 110, 30));

        sid.setBackground(new java.awt.Color(255, 204, 102));
        sid.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        sid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sidFocusLost(evt);
            }
        });
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });
        sid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sidKeyReleased(evt);
            }
        });
        jPanel5.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, 30));

        date5.setBackground(new java.awt.Color(204, 204, 204));
        date5.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date5.setForeground(new java.awt.Color(204, 204, 204));
        date5.setText("Address");
        date5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel5.add(date5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, 30));

        address.setBackground(new java.awt.Color(255, 204, 102));
        address.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        address.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressFocusLost(evt);
            }
        });
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addressKeyReleased(evt);
            }
        });
        jPanel5.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 540, 30));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer Information");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, -1));

        date10.setBackground(new java.awt.Color(204, 204, 204));
        date10.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date10.setForeground(new java.awt.Color(204, 204, 204));
        date10.setText("Shop ID");
        date10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel5.add(date10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 30));

        mobile.setBackground(new java.awt.Color(255, 204, 102));
        mobile.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        mobile.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mobile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileFocusLost(evt);
            }
        });
        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
        });
        jPanel5.add(mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 280, 30));

        billdate.setBackground(new java.awt.Color(255, 204, 102));
        billdate.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        billdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        billdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        billdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                billdateFocusLost(evt);
            }
        });
        billdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billdateActionPerformed(evt);
            }
        });
        billdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billdateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billdateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                billdateKeyTyped(evt);
            }
        });
        jPanel5.add(billdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 180, 30));

        date11.setBackground(new java.awt.Color(204, 204, 204));
        date11.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date11.setForeground(new java.awt.Color(204, 204, 204));
        date11.setText("Date");
        date11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel5.add(date11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 80, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 10, 710, 180));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Amount.setBackground(new java.awt.Color(204, 204, 204));
        Amount.setFont(new java.awt.Font("Cambria Math", 1, 27)); // NOI18N
        Amount.setForeground(new java.awt.Color(204, 204, 204));
        Amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Amount.setText("Billing System");
        jPanel3.add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 30));

        date9.setBackground(new java.awt.Color(204, 204, 204));
        date9.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date9.setForeground(new java.awt.Color(204, 204, 204));
        date9.setText("Total Quantity");
        date9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel3.add(date9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 30));

        date4.setBackground(new java.awt.Color(204, 204, 204));
        date4.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date4.setForeground(new java.awt.Color(204, 204, 204));
        date4.setText("Total Weight");
        date4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel3.add(date4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 180, 30));

        date6.setBackground(new java.awt.Color(204, 204, 204));
        date6.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date6.setForeground(new java.awt.Color(204, 204, 204));
        date6.setText("Total Amount");
        date6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel3.add(date6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 30));

        tqty.setEditable(false);
        tqty.setBackground(new java.awt.Color(255, 204, 102));
        tqty.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        tqty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tqty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tqtyFocusLost(evt);
            }
        });
        tqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tqtyActionPerformed(evt);
            }
        });
        tqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tqtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tqtyKeyReleased(evt);
            }
        });
        jPanel3.add(tqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 30));

        tweight.setEditable(false);
        tweight.setBackground(new java.awt.Color(255, 204, 102));
        tweight.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        tweight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tweight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tweight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tweightFocusLost(evt);
            }
        });
        tweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tweightActionPerformed(evt);
            }
        });
        tweight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tweightKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tweightKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tweightKeyTyped(evt);
            }
        });
        jPanel3.add(tweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 150, 30));

        tamount.setEditable(false);
        tamount.setBackground(new java.awt.Color(255, 204, 102));
        tamount.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        tamount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tamount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tamount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tamountFocusLost(evt);
            }
        });
        tamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamountActionPerformed(evt);
            }
        });
        tamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tamountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tamountKeyReleased(evt);
            }
        });
        jPanel3.add(tamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 150, 30));

        jsaddpanel5.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel5.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add5.setBackground(new java.awt.Color(255, 255, 255));
        add5.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        add5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add5.setText("Total");
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
        jsaddpanel5.add(add5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jPanel3.add(jsaddpanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 240, 40));

        jsaddpanel6.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel6.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add6.setBackground(new java.awt.Color(255, 255, 255));
        add6.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        add6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add6.setText("Print Bill");
        add6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add6MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add6MouseReleased(evt);
            }
        });
        add6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add6KeyPressed(evt);
            }
        });
        jsaddpanel6.add(add6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jPanel3.add(jsaddpanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 220, 40));

        date7.setBackground(new java.awt.Color(204, 204, 204));
        date7.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        date7.setForeground(new java.awt.Color(204, 204, 204));
        date7.setText("Net Amount");
        date7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 102), new java.awt.Color(255, 204, 102), null, null));
        jPanel3.add(date7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, 30));

        namount.setEditable(false);
        namount.setBackground(new java.awt.Color(255, 204, 102));
        namount.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        namount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        namount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        namount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                namountFocusLost(evt);
            }
        });
        namount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namountActionPerformed(evt);
            }
        });
        namount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                namountKeyReleased(evt);
            }
        });
        jPanel3.add(namount, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 150, 30));

        jsaddpanel7.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel7.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add7.setBackground(new java.awt.Color(255, 255, 255));
        add7.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        add7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add7.setText("Clear All");
        add7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add7MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add7MouseReleased(evt);
            }
        });
        add7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add7KeyPressed(evt);
            }
        });
        jsaddpanel7.add(add7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        jPanel3.add(jsaddpanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 210, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 576, 710, 184));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Cambria Math", 1, 27)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sev");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 30));

        type1.setBackground(new java.awt.Color(255, 204, 102));
        type1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        type1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(187, 120, 52), new java.awt.Color(0, 0, 0)));
        type1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        type1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                type1ItemStateChanged(evt);
            }
        });
        type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type1ActionPerformed(evt);
            }
        });
        jPanel4.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 300, 30));

        w1.setBackground(new java.awt.Color(255, 204, 102));
        w1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        w1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weight" }));
        w1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(187, 120, 52), new java.awt.Color(0, 0, 0)));
        w1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        w1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                w1ItemStateChanged(evt);
            }
        });
        w1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w1ActionPerformed(evt);
            }
        });
        jPanel4.add(w1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 45, 130, 30));

        mrp1.setBackground(new java.awt.Color(255, 204, 102));
        mrp1.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        mrp1.setForeground(new java.awt.Color(153, 153, 153));
        mrp1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mrp1.setText("MRP");
        mrp1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mrp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mrp1FocusLost(evt);
            }
        });
        mrp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrp1ActionPerformed(evt);
            }
        });
        mrp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mrp1KeyReleased(evt);
            }
        });
        jPanel4.add(mrp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 45, 120, 30));

        qty1.setBackground(new java.awt.Color(255, 204, 102));
        qty1.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        qty1.setForeground(new java.awt.Color(153, 153, 153));
        qty1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty1.setText("QTY");
        qty1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        qty1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qty1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qty1FocusLost(evt);
            }
        });
        qty1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qty1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty1KeyTyped(evt);
            }
        });
        jPanel4.add(qty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 45, 110, 30));

        jsaddpanel1.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel1.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add1.setBackground(new java.awt.Color(255, 255, 255));
        add1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        add1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add1.setText("Add to Cart");
        add1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                add1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                add1MouseReleased(evt);
            }
        });
        add1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                add1KeyPressed(evt);
            }
        });
        jsaddpanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 25));

        jPanel4.add(jsaddpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 110, 25));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 200, 710, 116));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Cambria Math", 1, 27)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Other");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 30));

        type3.setBackground(new java.awt.Color(255, 204, 102));
        type3.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        type3.setForeground(new java.awt.Color(153, 153, 153));
        type3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        type3.setText("Enter Other Category");
        type3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        type3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                type3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                type3FocusLost(evt);
            }
        });
        type3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type3ActionPerformed(evt);
            }
        });
        type3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                type3KeyReleased(evt);
            }
        });
        jPanel6.add(type3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 300, 30));

        qty3.setBackground(new java.awt.Color(255, 204, 102));
        qty3.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        qty3.setForeground(new java.awt.Color(153, 153, 153));
        qty3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty3.setText("QTY");
        qty3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        qty3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qty3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qty3FocusLost(evt);
            }
        });
        qty3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qty3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty3KeyTyped(evt);
            }
        });
        jPanel6.add(qty3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 45, 110, 30));

        jsaddpanel3.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel3.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add3.setBackground(new java.awt.Color(255, 255, 255));
        add3.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        add3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add3.setText("Add to Cart");
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

        jPanel6.add(jsaddpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 110, 25));

        w3.setBackground(new java.awt.Color(255, 204, 102));
        w3.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        w3.setForeground(new java.awt.Color(153, 153, 153));
        w3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        w3.setText("Weight");
        w3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        w3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                w3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                w3FocusLost(evt);
            }
        });
        w3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w3ActionPerformed(evt);
            }
        });
        w3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                w3KeyReleased(evt);
            }
        });
        jPanel6.add(w3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 45, 130, 30));

        mrp3.setBackground(new java.awt.Color(255, 204, 102));
        mrp3.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        mrp3.setForeground(new java.awt.Color(153, 153, 153));
        mrp3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mrp3.setText("MRP");
        mrp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrp3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mrp3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mrp3FocusLost(evt);
            }
        });
        mrp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrp3ActionPerformed(evt);
            }
        });
        mrp3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mrp3KeyReleased(evt);
            }
        });
        jPanel6.add(mrp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 45, 120, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 452, 710, 116));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(239, 136, 22), new java.awt.Color(239, 136, 22), new java.awt.Color(255, 252, 223), new java.awt.Color(255, 252, 223)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        type2.setBackground(new java.awt.Color(255, 204, 102));
        type2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        type2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        type2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(187, 120, 52), new java.awt.Color(0, 0, 0)));
        type2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        type2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                type2ItemStateChanged(evt);
            }
        });
        type2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type2ActionPerformed(evt);
            }
        });
        jPanel7.add(type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 300, 30));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Cambria Math", 1, 27)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mixture");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 30));

        w2.setBackground(new java.awt.Color(255, 204, 102));
        w2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        w2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weight" }));
        w2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(187, 120, 52), new java.awt.Color(0, 0, 0)));
        w2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        w2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                w2ItemStateChanged(evt);
            }
        });
        w2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w2ActionPerformed(evt);
            }
        });
        jPanel7.add(w2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 45, 130, 30));

        mrp2.setBackground(new java.awt.Color(255, 204, 102));
        mrp2.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        mrp2.setForeground(new java.awt.Color(153, 153, 153));
        mrp2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mrp2.setText("MRP");
        mrp2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mrp2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mrp2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mrp2FocusLost(evt);
            }
        });
        mrp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrp2ActionPerformed(evt);
            }
        });
        mrp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mrp2KeyReleased(evt);
            }
        });
        jPanel7.add(mrp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 45, 120, 30));

        qty2.setBackground(new java.awt.Color(255, 204, 102));
        qty2.setFont(new java.awt.Font("Cambria Math", 0, 15)); // NOI18N
        qty2.setForeground(new java.awt.Color(153, 153, 153));
        qty2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty2.setText("QTY");
        qty2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        qty2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qty2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qty2FocusLost(evt);
            }
        });
        qty2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qty2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qty2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qty2KeyTyped(evt);
            }
        });
        jPanel7.add(qty2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 45, 110, 30));

        jsaddpanel2.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel2.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add2.setBackground(new java.awt.Color(255, 255, 255));
        add2.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        add2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add2.setText("Add to Cart");
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

        jPanel7.add(jsaddpanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 110, 25));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 326, 710, 116));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Breoo Namkeen\\Images\\Background Image.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1366, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
String cdate="",ctime="";
int billno=0;
    private void ToggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToggleMouseClicked
        openMenu();
    }//GEN-LAST:event_ToggleMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        closeMenu();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void retaillogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retaillogoMouseClicked
        Billing r=new Billing();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_retaillogoMouseClicked

    private void retaillogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retaillogoMouseEntered

    }//GEN-LAST:event_retaillogoMouseEntered

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        Billing r=new Billing();
        r.setVisible(true);
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
        retaillogo.setBorder(null);
        StockFrame s=new StockFrame();
        s.setVisible(true);
    }//GEN-LAST:event_stocklogoMouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
        Border b1=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        stocklogo.setBorder(b1);  
        retaillogo.setBorder(null);
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
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        retaillogo.setBorder(b);
        stocklogo.setBorder(null);
        showDate();
        showTime();
        bdate.setText(billdate.getText());
        if(info==0)
       {
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Breeo","root","root");
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("Select distinct(PName) from Products where Category='Sev'");
            while(rs1.next())
            {
                type1.addItem(rs1.getString("PName"));
            }
            ResultSet rs2=st.executeQuery("Select distinct(PName) from Products where Category='Mixture'");
            while(rs2.next())
            {
                type2.addItem(rs2.getString("PName"));
            }
            ResultSet rs3=st.executeQuery("Select distinct(weight) from Weight");
            while(rs3.next())
            {
                w1.addItem(rs3.getString("weight"));
                w2.addItem(rs3.getString("weight"));
            }
           }
           catch(Exception e)
           {
            JOptionPane.showMessageDialog(null,"Record not Stored");
           }
        info++;
       }
       else
       {
           
       }        
    }//GEN-LAST:event_formWindowGainedFocus

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
 
    }//GEN-LAST:event_nameFocusLost

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed

    }//GEN-LAST:event_nameKeyPressed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased

    }//GEN-LAST:event_nameKeyReleased

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped

    }//GEN-LAST:event_nameKeyTyped

    private void sidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sidFocusLost
  
    }//GEN-LAST:event_sidFocusLost

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void sidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sidKeyPressed
 
    }//GEN-LAST:event_sidKeyPressed
Connection con;
String id="";
int maxid=0;
    private void sidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sidKeyReleased
        id=sid.getText();
        if(id.equals(""))
        {
            clearCustomerDetails();
        }
        else
        {
            int shopid=Integer.parseInt(id);
            try{
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("select max(SID) from shopdetails");
            while(rs1.next())
            {
                maxid=rs1.getInt("max(SID)");
            }
            if(shopid>maxid)
            {
                IDNotExist i=new IDNotExist();
                i.setVisible(true);
                clearCustomerDetails();
            }
            ResultSet rs=st.executeQuery("select * from shopdetails where SID="+shopid+"");
            while(rs.next())
            {
                sname=rs.getString("ShopName");
                saddress=rs.getString("Address");
                scontact=rs.getString("Contact");
                mobile.setText(scontact);
                name.setText(sname);
                address.setText(saddress);
                bname.setText(sname);
                baddress.setText(saddress);
                bcontact.setText(scontact);
                bdate.setText(billdate.getText());
            }
            }catch(Exception e)
            {
                System.out.println("Not inserted");
            }
        }
    }//GEN-LAST:event_sidKeyReleased
String sname="",scontact="",saddress="";
    private void addressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressFocusLost

    }//GEN-LAST:event_addressFocusLost

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyPressed

    }//GEN-LAST:event_addressKeyPressed

    private void addressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyReleased

        
    }//GEN-LAST:event_addressKeyReleased

    private void type1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_type1ItemStateChanged
      
    }//GEN-LAST:event_type1ItemStateChanged
String type="";
String sweight="",smrp="",sqty="";
    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        type=type1.getSelectedItem().toString();
    }//GEN-LAST:event_type1ActionPerformed

    private void w1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_w1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_w1ItemStateChanged

    private void w1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w1ActionPerformed
        sweight=w1.getSelectedItem().toString();
    }//GEN-LAST:event_w1ActionPerformed

    private void mrp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp1FocusGained
        mrp1.setText("");
    }//GEN-LAST:event_mrp1FocusGained

    private void mrp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mrp1ActionPerformed

    private void qty1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty1FocusGained
        qty1.setText("");
    }//GEN-LAST:event_qty1FocusGained

    private void qty1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qty1KeyPressed

    private void qty1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty1KeyReleased
        qty1.setForeground(Color.black);
    }//GEN-LAST:event_qty1KeyReleased

    private void qty1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_qty1KeyTyped

    private void add1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add1AncestorAdded

    }//GEN-LAST:event_add1AncestorAdded
Double mrp,totalamount=0.0;
int sno=0,count,qty=0,totalqty=0,weight=0,totalweight=0;
String productdetails="",mrpdetails="",weightdetails="",qtydetails="",totalamountdetails="";
    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked
        smrp=mrp1.getText();
        sqty=qty1.getText();
        try
        {
            mrp=Double.parseDouble(smrp);
        }
        catch(Exception e)
        {
            ValidPrice v=new ValidPrice();
            v.setVisible(true);
            count++;
        }
        try
        {
            qty=Integer.parseInt(sqty);
        }
        catch(Exception e)
        {
            if(count==0)
            {
                ValidQty v=new ValidQty();
                v.setVisible(true);
                count++;
            }
        }
        if((type.equals("Select"))||(type.equals(""))&&(count==0))
        {
          ValidType v=new ValidType();
          v.setVisible(true);
        }
        if((sweight.equals("Weight"))||(sweight.equals(""))&&(count==0))
        {
          ValidWeight v=new ValidWeight();
          v.setVisible(true);
        }
        if((type.equals("Select"))||(sweight.equals("Weight")))
        {

        }
        else
        {
            try
            {
                mrp=Double.parseDouble(smrp);
                qty=Integer.parseInt(sqty);
                                sno++;
                if(sno==1)
                {
                    productdetails=type+"/";
                    weightdetails=sweight+"/";
                    qtydetails=sqty+"/";
                    mrpdetails=smrp+"/";
                    totalamountdetails=(mrp*qty)+"/";
                    ta1.append(" "+sno);
                    ta2.append(" "+type);
                    ta3.append(" "+sweight);
                    ta4.append("   "+qty);
                    ta7.append("    "+mrp);
                    ta8.append("     "+Math.round(mrp*qty));
                }
                else
                {
                    productdetails=productdetails+type+"/";
                    weightdetails=weightdetails+sweight+"/";
                    qtydetails=qtydetails+sqty+"/";
                    mrpdetails=mrpdetails+smrp+"/";
                    totalamountdetails=totalamountdetails+(mrp*qty)+"/";
                    ta1.append("\n "+sno);
                    ta2.append("\n "+type);
                    ta3.append("\n "+sweight);
                    ta4.append("\n   "+qty);
                    ta7.append("\n    "+mrp);
                    ta8.append("\n     "+Math.round(mrp*qty));                    
                }
            }
            catch(Exception e)
            {
                
            }
            
            totalamount=totalamount+(mrp*qty);
            totalqty=totalqty+qty;
            weight=Integer.parseInt(sweight);
            totalweight=totalweight+(weight*qty);
            clearAllFields();
        }
        count=0;
    }//GEN-LAST:event_add1MouseClicked

    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add1MouseEntered

    private void add1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1MousePressed

    private void add1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add1MouseReleased

    private void add1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add1KeyPressed

    private void type2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_type2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_type2ItemStateChanged

    private void type2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type2ActionPerformed
    type=type2.getSelectedItem().toString();
    }//GEN-LAST:event_type2ActionPerformed

    private void w2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_w2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_w2ItemStateChanged

    private void w2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w2ActionPerformed
        sweight=w2.getSelectedItem().toString();        
    }//GEN-LAST:event_w2ActionPerformed

    private void mrp2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp2FocusGained
        mrp2.setText("");
    }//GEN-LAST:event_mrp2FocusGained

    private void mrp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mrp2ActionPerformed

    private void qty2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty2FocusGained
        qty2.setText("");
    }//GEN-LAST:event_qty2FocusGained

    private void qty2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qty2KeyPressed

    private void qty2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2KeyReleased
        qty2.setForeground(Color.black);
    }//GEN-LAST:event_qty2KeyReleased

    private void qty2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_qty2KeyTyped

    private void add2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add2AncestorAdded

    private void add2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add2MouseClicked
        smrp=mrp2.getText();
        sqty=qty2.getText();
        try
        {
            mrp=Double.parseDouble(smrp);
        }
        catch(Exception e)
        {
            ValidPrice v=new ValidPrice();
            v.setVisible(true);
            count++;
        }
        try
        {
            qty=Integer.parseInt(sqty);
        }
        catch(Exception e)
        {
            if(count==0)
            {
                ValidQty v=new ValidQty();
                v.setVisible(true);
                count++;
            }
        }
        if((type2.equals("Select"))||(type2.equals(""))&&(count==0))
        {
          ValidType v=new ValidType();
          v.setVisible(true);
        }
        if((sweight.equals("Weight"))||(sweight.equals(""))&&(count==0))
        {
          ValidWeight v=new ValidWeight();
          v.setVisible(true);
        }
        if((type2.equals("Select"))||(sweight.equals("Weight")))
        {

        }
        else
        {
            try
            {
                mrp=Double.parseDouble(smrp);
                qty=Integer.parseInt(sqty);
                sno++;
                if(sno==1)
                {
                    productdetails=type+"/";
                    weightdetails=sweight+"/";
                    qtydetails=sqty+"/";
                    mrpdetails=smrp+"/";
                    totalamountdetails=(mrp*qty)+"/";
                    
                    ta1.append(" "+sno);
                    ta2.append(" "+type);
                    ta3.append(" "+sweight);
                    ta4.append("   "+qty);
                    ta7.append("    "+mrp);
                    ta8.append("     "+Math.round(mrp*qty));
                }
                else
                {
                    productdetails=productdetails+type+"/";
                    weightdetails=weightdetails+sweight+"/";
                    qtydetails=qtydetails+sqty+"/";
                    mrpdetails=mrpdetails+smrp+"/";
                    totalamountdetails=totalamountdetails+(mrp*qty)+"/";
                    ta1.append("\n "+sno);
                    ta2.append("\n "+type);
                    ta3.append("\n "+sweight);
                    ta4.append("\n   "+qty);
                    ta7.append("\n    "+mrp);
                    ta8.append("\n     "+Math.round(mrp*qty));
                }
            }
            catch(Exception e)
            {
                
            }
            totalamount=totalamount+(mrp*qty);
            totalqty=totalqty+qty;
            weight=Integer.parseInt(sweight);
            totalweight=totalweight+(weight*qty);
            clearAllFields();
        }
        count=0;
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

    private void type3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type3FocusGained
        type3.setText("");
    }//GEN-LAST:event_type3FocusGained

    private void type3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type3ActionPerformed

    private void qty3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty3FocusGained
        qty3.setText("");
    }//GEN-LAST:event_qty3FocusGained

    private void qty3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qty3KeyPressed

    private void qty3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty3KeyReleased
        qty3.setForeground(Color.black);
    }//GEN-LAST:event_qty3KeyReleased

    private void qty3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qty3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_qty3KeyTyped

    private void add3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add3AncestorAdded

    private void add3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add3MouseClicked
         type=type3.getText();
         sweight=w3.getText();
         smrp=mrp3.getText();
         sqty=qty3.getText();
        try
        {
            mrp=Double.parseDouble(smrp);
        }
        catch(Exception e)
        {
            ValidPrice v=new ValidPrice();
            v.setVisible(true);
            count++;
        }
        try
        {
            qty=Integer.parseInt(sqty);
        }
        catch(Exception e)
        {
            if(count==0)
            {
                ValidQty v=new ValidQty();
                v.setVisible(true);
                count++;
            }
        }
        if((type3.equals("Enter Other Category"))||(type3.equals(""))&&(count==0))
        {
          ValidType v=new ValidType();
          v.setVisible(true);
          count++;
        }
        if((sweight.equals("Weight"))||(sweight.equals(""))&&(count==0))
        {
          ValidWeight v=new ValidWeight();
          v.setVisible(true);
          count++;
        }
        if((type2.equals("Enter Other Category"))||(sweight.equals("Weight")))
        {

        }
        else
        {
            try
            {
                mrp=Double.parseDouble(smrp);
                qty=Integer.parseInt(sqty);
                sno++;
                if(sno==1)
                {
                    productdetails=type+"/";
                    weightdetails=sweight+"/";
                    qtydetails=sqty+"/";
                    mrpdetails=smrp+"/";
                    totalamountdetails=(mrp*qty)+"/";
                    ta1.append(" "+sno);
                    ta2.append(" "+type);
                    ta3.append(" "+sweight);
                    ta4.append("   "+qty);
                    ta7.append("    "+mrp);
                    ta8.append("     "+mrp*qty);
                }
                else
                {
                    productdetails=productdetails+type+"/";
                    weightdetails=weightdetails+sweight+"/";
                    qtydetails=qtydetails+sqty+"/";
                    mrpdetails=mrpdetails+smrp+"/";
                    totalamountdetails=totalamountdetails+(mrp*qty)+"/";
                    ta1.append("\n "+sno);
                    ta2.append("\n "+type);
                    ta3.append("\n "+sweight);
                    ta4.append("\n   "+qty);
                    ta7.append("\n    "+mrp);
                    ta8.append("\n     "+Math.round(mrp*qty));
                }
            }
            catch(Exception e)
            {
                
            }
            totalamount=totalamount+(mrp*qty);
            totalqty=totalqty+qty;
            weight=Integer.parseInt(sweight);
            totalweight=totalweight+(weight*qty);
            clearAllFields();
        }
        count=0;
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

    private void w3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_w3FocusGained
        w3.setText("");
    }//GEN-LAST:event_w3FocusGained

    private void w3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w3ActionPerformed

    private void mrp3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp3FocusGained
        mrp3.setText("");
    }//GEN-LAST:event_mrp3FocusGained

    private void mrp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mrp3ActionPerformed

    private void tqtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tqtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tqtyFocusLost

    private void tqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tqtyActionPerformed

    private void tqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tqtyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tqtyKeyPressed

    private void tqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tqtyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tqtyKeyReleased

    private void tweightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tweightFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tweightFocusLost

    private void tweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tweightActionPerformed

    private void tweightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweightKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tweightKeyPressed

    private void tweightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweightKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tweightKeyReleased

    private void tweightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tweightKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tweightKeyTyped

    private void tamountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tamountFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tamountFocusLost

    private void tamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamountActionPerformed

    private void tamountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamountKeyPressed

    private void tamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tamountKeyReleased

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileFocusLost

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileActionPerformed

    private void mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyPressed

    private void mobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyReleased

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyTyped

    private void add5AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add5AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add5AncestorAdded
Double weightkg;
    private void add5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add5MouseClicked
        tqty.setText(""+totalqty);
        tamount.setText(""+Math.round(totalamount));
        if(totalweight>1000)
        {
            weightkg=(double)totalweight/1000;
            tweight.setText(""+weightkg+" Kg");
            bweight.setText(""+weightkg+" Kg");
        }
        else
        {
            tweight.setText(""+totalweight+" gm");
            bweight.setText(""+totalweight+" gm");
        }
        btotal.setText(""+Math.round(totalamount));
        String temp=sid.getText();
        int tempid=0;
        try
        {
            tempid=Integer.parseInt(temp);
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select sum(Total_Amount) from shopbills where SID="+tempid+"");
            while(rs.next())
            {
                namount.setText(""+rs.getInt("sum(Total_Amount)")+"/-");
            }
            
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
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

    private void add6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add6AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add6AncestorAdded
String[] productdetailsa,mrpdetailsa,weightdetailsa,qtydetailsa,totalamountdetailsa; 
int pdfspace=15;
    private void add6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseClicked
        System.out.println(productdetails);
        System.out.println(weightdetails);
        System.out.println(qtydetails);
        System.out.println(mrpdetails);
        System.out.println(totalamountdetails);
        int tempid=Integer.parseInt(sid.getText());
        String tempdate=billdate.getText();
        String tempweight="";
           try
            {
            if(totalweight>1000)
            {
                tempweight=weightkg+" Kg";
            }
            else
            {
                tempweight=totalweight+" gm";
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Breeo","root","root");
            Statement st=con.createStatement();
            st.executeUpdate("insert into shopbills values("+billno+","+totalamount+","+totalqty+",'"+tempweight+"','"+billdate+"','"+ctime+"',"+tempid+")");
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
           productdetailsa=productdetails.split("/");
           mrpdetailsa=mrpdetails.split("/");
           weightdetailsa=weightdetails.split("/");
           qtydetailsa=qtydetails.split("/");
           totalamountdetailsa=totalamountdetails.split("/");
                  try{
        String file_name="C:\\Breoo Namkeen\\Shop Bills\\Color Bill.pdf";
        String outputFilePath="C:\\Breoo Namkeen\\Shop Bills\\"+billno+".pdf";
        OutputStream fos = new FileOutputStream(new File(outputFilePath));
        PdfReader pdfReader = new PdfReader(file_name);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, fos);
        
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                  
                  PdfContentByte pdfContentByte = pdfStamper.getOverContent(i);
 
                  pdfContentByte.beginText();
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),11);
                  
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,bname.getText(), 470, 750, 270);//Name Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,bname.getText(), 470, 320, 270);//Name Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,billdate.getText(), 470,493, 270);//Date Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,billdate.getText(), 470,50, 270);//Date Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,baddress.getText(), 449,750, 270);//Address Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,baddress.getText(), 449,320, 270);//Address Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,bcontact.getText(), 427,550, 270);//Contact Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,bcontact.getText(), 427,115, 270);//Contact Lower
                                    
                    pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),15);
                    
                    pdfContentByte.showTextAligned(Element.ALIGN_CENTER,""+billno, 553,495, 270);//Bill No Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,""+billno, 553,55, 270);//Bill No Lower
                  
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1257,BaseFont.EMBEDDED),11);
                  
                  for(int j=0;j<productdetailsa.length;j++)
                  {                    
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+(j+1), 380-(j*pdfspace),852, 270);//SNO1 Upper
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,productdetailsa[j], 380-(j*pdfspace),830, 270);//Item1 Upper
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,weightdetailsa[j], 380-(j*pdfspace),625, 270);//Weight1 Upper
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,qtydetailsa[j], 380-(j*pdfspace),587, 270);//Quantity1 Upper
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,mrpdetailsa[j], 380-(j*pdfspace),555, 270);//Amount1 Upper
                    Double tempamount=Integer.parseInt(qtydetailsa[j])*Double.parseDouble(mrpdetailsa[j]);

                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+Math.round(tempamount), 380-(j*pdfspace),495, 270);//Total1 Upper
                    
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+(j+1), 380-(j*pdfspace),410, 270);//SNO1 Lower
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,productdetailsa[j], 380-(j*pdfspace),387, 270);//Item1 Lower
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,weightdetailsa[j], 380-(j*pdfspace),183, 270);//Weight1 Lower
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,qtydetailsa[j], 380-(j*pdfspace),145, 270);//Quantity1 Lower
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,mrpdetailsa[j], 380-(j*pdfspace),112, 270);//Amount1 Lower
                  
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+Math.round(tempamount), 380-(j*pdfspace),55, 270);//Total1 Lower
                  
                    System.out.println("Text added in "+outputFilePath);
                  }
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),12);
                    pdfContentByte.setColorFill(BaseColor.WHITE);
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+Math.round(totalamount), 64,495, 270);//Net Amount Upper
                    
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,""+Math.round(totalamount), 64,58, 270);//Net Amount Lower
                    
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,tempweight, 64,742, 270);//Net Weight Upper
                    
                    pdfContentByte.showTextAligned(Element.ALIGN_LEFT,tempweight, 64,301, 270);//Net Weight Lower
                  pdfContentByte.endText();
           }
        pdfStamper.close();
        System.out.println("Finished");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        try {
            Desktop.getDesktop().open(new File("C:\\Breoo Namkeen\\Shop Bills\\"+billno+".pdf"));
        } catch (IOException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                  sno=0;
    }//GEN-LAST:event_add6MouseClicked

    private void add6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add6MouseEntered

    private void add6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add6MousePressed

    private void add6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add6MouseReleased

    private void add6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add6KeyPressed

    private void namountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namountFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_namountFocusLost

    private void namountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namountActionPerformed

    private void namountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namountKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_namountKeyPressed

    private void namountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_namountKeyReleased

    private void add7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add7AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_add7AncestorAdded

    private void add7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseClicked
    clearAll();
    }//GEN-LAST:event_add7MouseClicked

    private void add7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add7MouseEntered

    private void add7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add7MousePressed

    private void add7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add7MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_add7MouseReleased

    private void add7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_add7KeyPressed

    private void billdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billdateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_billdateFocusLost

    private void billdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billdateActionPerformed

    private void billdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billdateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_billdateKeyPressed

    private void billdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billdateKeyReleased
        bdate.setText(billdate.getText());
    }//GEN-LAST:event_billdateKeyReleased

    private void billdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billdateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_billdateKeyTyped

    private void mrp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp1FocusLost
        String strTemp=mrp1.getText();
        if(strTemp.equals(""))
        {
            mrp1.setForeground(new Color(153,153,153,255));
            mrp1.setText("MRP");
        }
        else
        {
            
        }
    }//GEN-LAST:event_mrp1FocusLost

    private void mrp2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp2FocusLost
        String strTemp=mrp2.getText();
        if(strTemp.equals(""))
        {
            mrp2.setForeground(new Color(153,153,153,255));
            mrp2.setText("MRP");
        }
        else
        {
            
        }
    }//GEN-LAST:event_mrp2FocusLost

    private void mrp3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mrp3FocusLost
        String strTemp=mrp3.getText();
        if(strTemp.equals(""))
        {
            mrp3.setForeground(new Color(153,153,153,255));
            mrp3.setText("MRP");
        }
        else
        {
            
        }
    }//GEN-LAST:event_mrp3FocusLost

    private void qty1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty1FocusLost
        String strTemp=qty1.getText();
        if(strTemp.equals(""))
        {
            qty1.setForeground(new Color(153,153,153,255));
            qty1.setText("QTY");
        }
        else
        {
            
        }
    }//GEN-LAST:event_qty1FocusLost

    private void qty2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty2FocusLost
        String strTemp=qty2.getText();
        if(strTemp.equals(""))
        {
            qty2.setForeground(new Color(153,153,153,255));
            qty2.setText("QTY");
        }
        else
        {
            
        }
    }//GEN-LAST:event_qty2FocusLost

    private void qty3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qty3FocusLost
        String strTemp=qty3.getText();
        if(strTemp.equals(""))
        {
            qty3.setForeground(new Color(153,153,153,255));
            qty3.setText("QTY");
        }
        else
        {
            
        }
    }//GEN-LAST:event_qty3FocusLost

    private void type3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type3FocusLost
        String strTemp=type3.getText();
        if(strTemp.equals(""))
        {
            type3.setForeground(new Color(153,153,153,255));
            type3.setText("Enter Other Category");
        }
        else
        {
            
        }
    }//GEN-LAST:event_type3FocusLost

    private void w3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_w3FocusLost
        String strTemp=w3.getText();
        if(strTemp.equals(""))
        {
            w3.setForeground(new Color(153,153,153,255));
            w3.setText("Weight");
        }
        else
        {
            
        }
    }//GEN-LAST:event_w3FocusLost

    private void mrp1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mrp1KeyReleased
        mrp1.setForeground(Color.black);
    }//GEN-LAST:event_mrp1KeyReleased

    private void mrp2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mrp2KeyReleased
        mrp2.setForeground(Color.black);
    }//GEN-LAST:event_mrp2KeyReleased

    private void mrp3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mrp3KeyReleased
        mrp3.setForeground(Color.black);
    }//GEN-LAST:event_mrp3KeyReleased

    private void type3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_type3KeyReleased
        type3.setForeground(Color.black);
    }//GEN-LAST:event_type3KeyReleased

    private void w3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_w3KeyReleased
        w3.setForeground(Color.black);
    }//GEN-LAST:event_w3KeyReleased

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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        LoginForm l=new LoginForm();
        l.setVisible(true);
        LogoutSuccess lo=new LogoutSuccess();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel Toggle;
    private javax.swing.JLabel add1;
    private javax.swing.JLabel add2;
    private javax.swing.JLabel add3;
    private javax.swing.JLabel add5;
    private javax.swing.JLabel add6;
    private javax.swing.JLabel add7;
    private javax.swing.JTextField address;
    private javax.swing.JLabel baddress;
    private javax.swing.JLabel balancelogo;
    private javax.swing.JLabel bbill;
    private javax.swing.JLabel bcontact;
    private javax.swing.JLabel bdate;
    private javax.swing.JTextField billdate;
    private javax.swing.JLabel bname;
    private javax.swing.JLabel btotal;
    private javax.swing.JLabel bweight;
    private javax.swing.JLabel customerlogo;
    private javax.swing.JLabel date10;
    private javax.swing.JLabel date11;
    private javax.swing.JLabel date3;
    private javax.swing.JLabel date4;
    private javax.swing.JLabel date5;
    private javax.swing.JLabel date6;
    private javax.swing.JLabel date7;
    private javax.swing.JLabel date8;
    private javax.swing.JLabel date9;
    private javax.swing.JPanel iconbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel jsaddpanel1;
    private javax.swing.JPanel jsaddpanel2;
    private javax.swing.JPanel jsaddpanel3;
    private javax.swing.JPanel jsaddpanel5;
    private javax.swing.JPanel jsaddpanel6;
    private javax.swing.JPanel jsaddpanel7;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField mrp1;
    private javax.swing.JTextField mrp2;
    private javax.swing.JTextField mrp3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField namount;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JTextField qty1;
    private javax.swing.JTextField qty2;
    private javax.swing.JTextField qty3;
    private javax.swing.JLabel retaillogo;
    private javax.swing.JTextField sid;
    private javax.swing.JLabel stocklogo;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextArea ta2;
    private javax.swing.JTextArea ta3;
    private javax.swing.JTextArea ta4;
    private javax.swing.JScrollPane ta5;
    private javax.swing.JTextArea ta7;
    private javax.swing.JTextArea ta8;
    private javax.swing.JTextField tamount;
    private javax.swing.JTextField tqty;
    private javax.swing.JTextField tweight;
    private javax.swing.JComboBox<String> type1;
    private javax.swing.JComboBox<String> type2;
    private javax.swing.JTextField type3;
    private javax.swing.JComboBox<String> w1;
    private javax.swing.JComboBox<String> w2;
    private javax.swing.JTextField w3;
    // End of variables declaration//GEN-END:variables
}
