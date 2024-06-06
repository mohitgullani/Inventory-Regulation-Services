package breeo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BalanceFrame extends javax.swing.JFrame {

    
    public BalanceFrame() {
        initComponents();
        menu.setVisible(false);
        createConnection();
        getBillNo();
    }
    JFrame frame;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        p9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jsaddpanel1 = new javax.swing.JPanel();
        add1 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
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

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 305, 768));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,120));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Shop Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1270, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        p9.setBackground(new java.awt.Color(204, 255, 255));
        p9.setLayout(new java.awt.BorderLayout());
        jPanel1.add(p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1250, 510));

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Total Income");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        tf1.setEditable(false);
        tf1.setBackground(new java.awt.Color(255, 204, 102));
        tf1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf1FocusGained(evt);
            }
        });
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 230, 30));

        tf2.setEditable(false);
        tf2.setBackground(new java.awt.Color(255, 204, 102));
        tf2.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf2FocusGained(evt);
            }
        });
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 230, 30));

        tf3.setEditable(false);
        tf3.setBackground(new java.awt.Color(255, 204, 102));
        tf3.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf3FocusGained(evt);
            }
        });
        tf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf3ActionPerformed(evt);
            }
        });
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 230, 30));

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Total Quantity");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 180, 30));

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Total Weight");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 170, 30));

        jsaddpanel1.setBackground(new java.awt.Color(255, 204, 102));
        jsaddpanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(225, 162, 81), new java.awt.Color(225, 162, 81)));
        jsaddpanel1.setPreferredSize(new java.awt.Dimension(700, 307));
        jsaddpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add1.setBackground(new java.awt.Color(255, 255, 255));
        add1.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        add1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add1.setText("Search");
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
        jsaddpanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jPanel1.add(jsaddpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 610, 30));

        tf4.setBackground(new java.awt.Color(255, 204, 102));
        tf4.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf4FocusGained(evt);
            }
        });
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        jPanel1.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, 300, 30));

        jLabel45.setBackground(new java.awt.Color(204, 204, 204));
        jLabel45.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("To(YYYY-MM-DD)");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 60, 200, 30));

        jLabel46.setBackground(new java.awt.Color(204, 204, 204));
        jLabel46.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("From (YYYY-MM-DD)");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 30));

        tf5.setBackground(new java.awt.Color(255, 204, 102));
        tf5.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        tf5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf5FocusGained(evt);
            }
        });
        tf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf5ActionPerformed(evt);
            }
        });
        jPanel1.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1240, -1));

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
        BalanceFrame s=new BalanceFrame();
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
        balancelogo.setBorder(null);
        StockFrame b=new StockFrame();
        b.setVisible(true);
    }//GEN-LAST:event_stocklogoMouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
        Border b1=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        stocklogo.setBorder(b1);  
        balancelogo.setBorder(null);
        StockFrame b=new StockFrame();
        b.setVisible(true);
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
int windowcount=0;
String datearray[];
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Border b=BorderFactory.createBevelBorder(1, new Color(204,204,255,255), new Color(225,162,81,255));
        balancelogo.setBorder(b);
        stocklogo.setBorder(null);
        Double totalweight=0.0;
        String oldDate="";
        if(windowcount==0)
        {
            showDate();
            Date d = null;
            int count=0;
            try {
                d = new SimpleDateFormat("yyyy-MM-dd").parse(cdate);
            } catch (ParseException ex) {
                Logger.getLogger(BalanceFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH,-9);
            oldDate=s.format(c.getTime());
            System.out.println(oldDate);
            System.out.println(cdate);
            
            try
            {
                Statement st=con.createStatement();
                ResultSet rs2 =st.executeQuery("Select count(distinct(Date)) from shopbills where Date between '"+oldDate+"' and '"+cdate+"' order by Date");
                while(rs2.next())
                {
                    datearray=new String[rs2.getInt("count(distinct(Date))")];
                    totalamount=new int[rs2.getInt("count(distinct(Date))")];
                }
                count=0;
                ResultSet rs3 =st.executeQuery("Select distinct(Date) from shopbills where Date between '"+oldDate+"' and '"+cdate+"' order by Date");
                while(rs3.next())
                {
                    datearray[count++]=rs3.getString("Date");
                }
            }
            catch(Exception e)
            {
                System.out.println("something went wrong");
            }
            try
            {
                Statement st=con.createStatement();
                for(int i=0;i<datearray.length;i++)
                {
                    ResultSet rs=st.executeQuery("Select sum(Total_Amount) from shopbills where Date='"+datearray[i]+"'");
                    while(rs.next())
                    {
                        totalamount[i]=rs.getInt("sum(Total_Amount)");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("error");
            }           
            DefaultCategoryDataset dataset=new DefaultCategoryDataset();
            for(int i=0;i<datearray.length;i++)
            {
                dataset.setValue(totalamount[i],"Amount",datearray[i].substring(8, 10));
            }
            JFreeChart barchart=ChartFactory.createLineChart("Balance Analysis", "Date", "Amount",dataset, PlotOrientation.VERTICAL, false,true,true);
            CategoryPlot plot=barchart.getCategoryPlot();

            plot.setRangeGridlinePaint(Color.black);
            plot.setBackgroundPaint(new Color(249,215,184,255));
            ChartPanel barPanel=new ChartPanel(barchart);
            p9.removeAll();
            p9.add(barPanel,BorderLayout.CENTER);
            p9.validate();
            System.out.println("Success");
            windowcount++;
        }
        else
        {
            
        }
        Double kgw=0.0;
        Double gmw=0.0;
        try
            {
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select sum(Total_Amount) from shopbills where Date between '"+oldDate+"' and '"+cdate+"'");
                while(rs.next())
                {
                    tf1.setText(""+rs.getInt("sum(Total_Amount)")+"/-");
                }
                ResultSet rs1=st.executeQuery("Select sum(Total_Quantity) from shopbills where Date between '"+oldDate+"' and '"+cdate+"'");
                while(rs1.next())
                {
                    tf3.setText(""+rs1.getInt("sum(Total_Quantity)"));
                }
                ResultSet rs3=st.executeQuery("Select sum(Net_Weight) from shopbills where Date between '"+oldDate+"' and '"+cdate+"' and Net_Weight like '% gm'");
                while(rs3.next())
                {
                    gmw=rs3.getDouble("sum(Net_Weight)");
                }
                ResultSet rs4=st.executeQuery("Select sum(Net_Weight) from shopbills where Date between '"+oldDate+"' and '"+cdate+"' and Net_Weight like '% kg'");
                while(rs4.next())
                {
                    kgw=rs4.getDouble("sum(Net_Weight)");
                }
                totalweight=(gmw/1000)+kgw;
                System.out.println(totalweight);
                tf2.setText(""+totalweight+" Kg");
            }
            catch(Exception e)
            {
                System.out.println("error");
            }         
    }//GEN-LAST:event_formWindowGainedFocus
Connection con;
int totalamount[];
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
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1FocusGained

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void tf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3ActionPerformed

    private void tf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf3FocusGained

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void tf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2FocusGained

    private void add1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_add1AncestorAdded

    }//GEN-LAST:event_add1AncestorAdded

    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked
            datearray=null;
            Double gmw=0.0;
            Double kgw=0.0;
            Double totalweight=0.0;
            totalamount=null;
            String oldDate=tf5.getText();
            String newdate=tf4.getText();
            showDate();
            Date d = null;
            int count=0;
            try {
                d = new SimpleDateFormat("yyyy-MM-dd").parse(cdate);
            } catch (ParseException ex) {
                Logger.getLogger(BalanceFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(oldDate);
            System.out.println(newdate);
            
            try
            {
                Statement st=con.createStatement();
                ResultSet rs2 =st.executeQuery("Select count(distinct(Date)) from shopbills where Date between '"+oldDate+"' and '"+newdate+"' order by Date");
                while(rs2.next())
                {
                    datearray=new String[rs2.getInt("count(distinct(Date))")];
                    totalamount=new int[rs2.getInt("count(distinct(Date))")];
                }
                count=0;
                ResultSet rs3 =st.executeQuery("Select distinct(Date) from shopbills where Date between '"+oldDate+"' and '"+newdate+"' order by Date");
                while(rs3.next())
                {
                    datearray[count++]=rs3.getString("Date");
                }
            }
            catch(Exception e)
            {
                System.out.println("something went wrong");
            }
            try
            {
                Statement st=con.createStatement();
                for(int i=0;i<datearray.length;i++)
                {
                    ResultSet rs=st.executeQuery("Select sum(Total_Amount) from shopbills where Date='"+datearray[i]+"'");
                    while(rs.next())
                    {
                        totalamount[i]=rs.getInt("sum(Total_Amount)");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("error");
            }           
            DefaultCategoryDataset dataset=new DefaultCategoryDataset();
            for(int i=0;i<datearray.length;i++)
            {
                dataset.setValue(totalamount[i],"Amount",datearray[i].substring(8, 10));
            }
            JFreeChart barchart=ChartFactory.createLineChart("Balance Analysis", "Date", "Amount",dataset, PlotOrientation.VERTICAL, false,true,true);
            CategoryPlot plot=barchart.getCategoryPlot();

            plot.setRangeGridlinePaint(Color.black);
            plot.setBackgroundPaint(new Color(249,215,184,255));
            ChartPanel barPanel=new ChartPanel(barchart);
            p9.removeAll();
            p9.add(barPanel,BorderLayout.CENTER);
            p9.validate();
            try
            {
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("Select sum(Total_Amount) from shopbills where Date between '"+oldDate+"' and '"+newdate+"'");
                while(rs.next())
                {
                    tf1.setText(""+rs.getInt("sum(Total_Amount)")+"/-");
                }
                ResultSet rs1=st.executeQuery("Select sum(Total_Quantity) from shopbills where Date between '"+oldDate+"' and '"+newdate+"'");
                while(rs1.next())
                {
                    tf3.setText(""+rs1.getInt("sum(Total_Quantity)"));
                }
                ResultSet rs3=st.executeQuery("Select sum(Net_Weight) from shopbills where Date between '"+oldDate+"' and '"+newdate+"' and Net_Weight like '% gm'");
                while(rs3.next())
                {
                    gmw=rs3.getDouble("sum(Net_Weight)");
                }
                ResultSet rs4=st.executeQuery("Select sum(Net_Weight) from shopbills where Date between '"+oldDate+"' and '"+newdate+"' and Net_Weight like '% kg'");
                while(rs4.next())
                {
                    kgw=rs4.getDouble("sum(Net_Weight)");
                }
                totalweight=(gmw/1000)+kgw;
                System.out.println(totalweight);
                tf2.setText(""+totalweight+" Kg");
            }
            catch(Exception e)
            {
                System.out.println("error");
            }         
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

    private void tf4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4FocusGained

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5FocusGained

    private void tf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf5ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        LoginForm l=new LoginForm();
        l.setVisible(true);
        LogoutSuccess lo=new LogoutSuccess();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked
String searchn="";String searchid="";String searchdate="";String searchbill="";int sid=0;int billn=0;
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
            java.util.logging.Logger.getLogger(BalanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BalanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BalanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BalanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BalanceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Toggle;
    private javax.swing.JLabel add1;
    private javax.swing.JLabel balancelogo;
    private javax.swing.JLabel customerlogo;
    private javax.swing.JPanel iconbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jsaddpanel1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p9;
    private javax.swing.JLabel retaillogo;
    private javax.swing.JLabel stocklogo;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    // End of variables declaration//GEN-END:variables
}
