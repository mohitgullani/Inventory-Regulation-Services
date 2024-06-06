/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breeo;

import static breeo.ShopDetails.windowcount;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class StockFrame extends javax.swing.JFrame {

 
    public StockFrame() {
        initComponents();
        createConnection();
        setBackground(new Color(0,0,0,0));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        p3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        type1 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        tf5 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,180));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 255), null, null));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p3.setBackground(new java.awt.Color(0,0,0,0));
        p3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        p3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1326, 3, -1, 34));

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Add a New Product");
        jLabel37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 15, 630, 35));

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel38.setText("New Product Name");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 30));

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel39.setText("Category");
        jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 30));

        tf1.setBackground(new java.awt.Color(240, 240, 240));
        tf1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 130, 360, 30));

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Add");
        jLabel43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 170, 110, 30));

        type1.setBackground(new java.awt.Color(255, 204, 102));
        type1.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
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
        jPanel3.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 80, 360, 30));

        jLabel41.setBackground(new java.awt.Color(204, 204, 204));
        jLabel41.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Add a New Weight");
        jLabel41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 15, 630, 35));

        jLabel45.setBackground(new java.awt.Color(204, 204, 204));
        jLabel45.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel45.setText("New Weight (in gm)");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 220, 30));

        tf2.setBackground(new java.awt.Color(240, 240, 240));
        tf2.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 360, 30));

        jLabel46.setBackground(new java.awt.Color(204, 204, 204));
        jLabel46.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Add");
        jLabel46.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 130, 110, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Available Products");
        jLabel40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 15, 630, 35));

        tb1.setBackground(new java.awt.Color(255, 204, 102));
        tb1.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNO", "Product Name", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1);
        if (tb1.getColumnModel().getColumnCount() > 0) {
            tb1.getColumnModel().getColumn(0).setResizable(false);
            tb1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb1.getColumnModel().getColumn(1).setResizable(false);
            tb1.getColumnModel().getColumn(1).setPreferredWidth(580);
            tb1.getColumnModel().getColumn(2).setResizable(false);
            tb1.getColumnModel().getColumn(2).setPreferredWidth(290);
        }

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 630, 130));

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Available Weights");
        jLabel42.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 15, 630, 35));

        tb2.setBackground(new java.awt.Color(255, 204, 102));
        tb2.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNO", "Available Weights"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb2);
        if (tb2.getColumnModel().getColumnCount() > 0) {
            tb2.getColumnModel().getColumn(0).setResizable(false);
            tb2.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb2.getColumnModel().getColumn(1).setResizable(false);
            tb2.getColumnModel().getColumn(1).setPreferredWidth(580);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 630, 130));

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Edit Weight Details");
        jLabel44.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 630, 35));

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Edit Products Details");
        jLabel47.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 240, 630, 35));

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Delete Selected Item");
        jLabel48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 230, 30));

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Delete Selected Weight");
        jLabel49.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 260, 30));

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel50.setText("Product Name");
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 285, 210, 30));

        tf3.setBackground(new java.awt.Color(240, 240, 240));
        tf3.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 285, 360, 30));

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel51.setText("Category");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 210, 30));

        tf4.setEditable(false);
        tf4.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 330, 360, 30));

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Update Product Details");
        jLabel52.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 370, 270, 30));

        jLabel53.setBackground(new java.awt.Color(204, 204, 204));
        jLabel53.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel53.setText("Weight");
        jPanel5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 285, 210, 30));

        tf5.setBackground(new java.awt.Color(240, 240, 240));
        tf5.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        tf5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 285, 350, 30));

        jLabel54.setBackground(new java.awt.Color(204, 204, 204));
        jLabel54.setFont(new java.awt.Font("Cambria Math", 1, 22)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Update Weight Details");
        jLabel54.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 330, 260, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(629, 629, 629))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
int xx,yy;
Connection con;
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        p3.setBackground(new Color(232,17,36,255));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        p3.setBackground(Color.black);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xx,y-yy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx=evt.getX();
        yy=evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        String pname=tf1.getText();
        try
        {
            Statement st=con.createStatement();
            st.executeUpdate("insert into products values('"+pname+"','"+type+"')");
            ProductAddedSuccessfully1 i=new ProductAddedSuccessfully1();
            i.setVisible(true);
        }
        catch(Exception e)
        {

        }
        sno=0;
            try
            {
            Statement st=con.createStatement();
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            while(model.getRowCount()>0)
             {
                for(int i=0;i<model.getRowCount();i++)
                    model.removeRow(i);
             }
            ResultSet rs=st.executeQuery("select * from products");
            while(rs.next())
            {
                sno++;
                model.addRow(new Object[]{sno,rs.getString(1),rs.getString(2)});
            }
           }
           catch(Exception e)
           {
               System.out.println(e);
           } 
    }//GEN-LAST:event_jLabel43MouseClicked

    private void type1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_type1ItemStateChanged

    }//GEN-LAST:event_type1ItemStateChanged
    String type="";
    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        type=type1.getSelectedItem().toString();
    }//GEN-LAST:event_type1ActionPerformed

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        String weight=tf2.getText();
        try
        {
            Statement st=con.createStatement();
            st.executeUpdate("insert into weight values('"+weight+"')");
            WeightAddedSuccessfully i=new WeightAddedSuccessfully();
            i.setVisible(true);
        }
        catch(Exception e)
        {

        }
sno=0;    
try
    {
    Statement st=con.createStatement();
    DefaultTableModel model=(DefaultTableModel)tb2.getModel();
    while(model.getRowCount()>0)
     {
        for(int i=0;i<model.getRowCount();i++)
            model.removeRow(i);
     }
    ResultSet rs=st.executeQuery("select * from weight");
    while(rs.next())
    {
        sno++;
        model.addRow(new Object[]{sno,rs.getString(1)});
    }
   }
   catch(Exception e)
   {
       System.out.println(e);
   }  
    }//GEN-LAST:event_jLabel46MouseClicked
int info=0,sno=0;
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(info==0)
       {
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Breeo","root","root");
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("Select distinct(Category) from Products");
            while(rs1.next())
            {
                type1.addItem(rs1.getString("Category"));
            }
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            while(model.getRowCount()>0)
             {
                for(int i=0;i<model.getRowCount();i++)
                    model.removeRow(i);
             }
            ResultSet rs=st.executeQuery("select * from products");
            while(rs.next())
            {
                sno++;
                model.addRow(new Object[]{sno,rs.getString(1),rs.getString(2)});
            }
            DefaultTableModel model2=(DefaultTableModel)tb2.getModel();
            ResultSet rs2=st.executeQuery("select * from weight");
            sno=0;
            while(rs2.next())
            {
                sno++;
                model2.addRow(new Object[]{sno,rs2.getString(1)});
            }
            
            
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
            info++;
       }
       else
       {
           
       }        
    }//GEN-LAST:event_formWindowGainedFocus

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        sno=0;    
        try
            {
            Statement st=con.createStatement();
            st.executeUpdate("delete from products where PName='"+pname+"' and Category='"+cname+"'");
            DefaultTableModel model=(DefaultTableModel)tb1.getModel();
            while(model.getRowCount()>0)
             {
                for(int i=0;i<model.getRowCount();i++)
                    model.removeRow(i);
             }
            ResultSet rs=st.executeQuery("select * from products");
            while(rs.next())
            {
                sno++;
                model.addRow(new Object[]{sno,rs.getString(1),rs.getString(2)});
            }
           }
           catch(Exception e)
           {
               System.out.println(e);
           }        
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        sno=0;    
        try
            {
            Statement st=con.createStatement();
            st.executeUpdate("delete from weight where weight='"+sweight+"'");
            DefaultTableModel model=(DefaultTableModel)tb2.getModel();
            while(model.getRowCount()>0)
             {
                for(int i=0;i<model.getRowCount();i++)
                    model.removeRow(i);
             }
            ResultSet rs=st.executeQuery("select * from weight");
            while(rs.next())
            {
                sno++;
                model.addRow(new Object[]{sno,rs.getString(1)});
            }
            WeightDeletedSuccess w=new WeightDeletedSuccess();
            w.setVisible(true);
           }
           catch(Exception e)
           {
               System.out.println(e);
           } 
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
String npname=tf3.getText();
String ncname=tf4.getText();
sno=0;    
try
    {
    Statement st=con.createStatement();
    st.executeUpdate("update products set PName='"+npname+"' where Category='"+cname+"' and PName='"+pname+"'");
    DefaultTableModel model=(DefaultTableModel)tb1.getModel();
    while(model.getRowCount()>0)
     {
        for(int i=0;i<model.getRowCount();i++)
            model.removeRow(i);
     }
    ResultSet rs=st.executeQuery("select * from products");
    while(rs.next())
    {
        sno++;
        model.addRow(new Object[]{sno,rs.getString(1),rs.getString(2)});
    }
    DetailsUpdatedSuccess d=new DetailsUpdatedSuccess();
    d.setVisible(true);
   }
   catch(Exception e)
   {
       System.out.println(e);
   }    
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
String nweight=tf5.getText();
sno=0;    
try
    {
    Statement st=con.createStatement();
    st.executeUpdate("update weight set weight='"+nweight+"' where weight='"+sweight+"'");
    DefaultTableModel model=(DefaultTableModel)tb2.getModel();
    while(model.getRowCount()>0)
     {
        for(int i=0;i<model.getRowCount();i++)
            model.removeRow(i);
     }
    ResultSet rs=st.executeQuery("select * from weight");
    while(rs.next())
    {
        sno++;
        model.addRow(new Object[]{sno,rs.getString(1)});
    }
    WeightUpdatedSuccess d=new WeightUpdatedSuccess();
    d.setVisible(true);
   }
   catch(Exception e)
   {
       System.out.println(e);
   }   
    }//GEN-LAST:event_jLabel54MouseClicked
String pname="",cname="";
    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        DefaultTableModel model=(DefaultTableModel)tb1.getModel();
        pname=(String)model.getValueAt(tb1.getSelectedRow(),1);
        cname=(String)model.getValueAt(tb1.getSelectedRow(),2);
        tf3.setText(pname);
        tf4.setText(cname);
    }//GEN-LAST:event_tb1MouseClicked
String sweight="";
    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
        DefaultTableModel model=(DefaultTableModel)tb2.getModel();
        sweight=(String)model.getValueAt(tb2.getSelectedRow(),1);
        tf5.setText(sweight);
    }//GEN-LAST:event_tb2MouseClicked

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
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel p3;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JComboBox<String> type1;
    // End of variables declaration//GEN-END:variables
}
