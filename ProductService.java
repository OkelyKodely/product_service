
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhcho
 */
public class ProductService extends javax.swing.JFrame {

    private Paging paging;
    private int totalPages;
    private int totalRecords;
    private Product currentProduct;
    private File file;
    private byte[] imgBytes;    

    /**
     * Creates new form ProductService
     */
    public ProductService()
    {
        paging = new Paging();
        paging.setCurrentPage(1);
        paging.setRecordsPerPage(15);
        getInitialProductsInfo();
        paging.setPages(totalPages);
        paging.setTotalRecords(totalRecords);
        
        initComponents();

        getProducts();

        jtblProducts.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try
                {
                    String productID = jtblProducts.getValueAt(jtblProducts.getSelectedRow(), 0).toString();
                    currentProduct = getProduct(productID);
                    setProduct(currentProduct);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void setProduct(Product product)
    {
        jtxtProductID1.setText(product.getProductID());
        jtxtName.setText(product.getName());
        jtxtPrice.setText(product.getPrice()+"");
        jtxtStockQty.setText(product.getStockQty()+"");
        jtxtDesc.setText(product.getDescription());
    }

    public Connection getConnection()
    {
        Connection conn = null;

        String hostName = "ec2-54-163-240-54.compute-1.amazonaws.com";
        String dbName = "d89l9begjikklj";
        String userName = "isscllglmxgeln";
        String password = "334f696049572d4bc9c3b6b78c3410301e24dd3b5fd2b96dc15bf4c1c6fed113";

        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + hostName + "/" + dbName + "?user=" + userName + "&password=" + password + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception e)
        {
            e.printStackTrace();

            return null;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        jtxtProductID1 = new javax.swing.JTextField();
        jtxtName = new javax.swing.JTextField();
        jtxtPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        label5 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtDesc = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblProducts = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        label6 = new java.awt.Label();
        jtxtStockQty = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        shallYouValidate = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label1.setText("Desc");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        label2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label2.setText("Product ID");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        label3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label3.setText("Name");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        label4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label4.setText("Price");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jtxtProductID1.setBackground(new java.awt.Color(245, 245, 245));
        jtxtProductID1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtProductID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtProductID1ActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtProductID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 180, 60));

        jtxtName.setBackground(new java.awt.Color(245, 245, 245));
        jtxtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 240, 60));

        jtxtPrice.setBackground(new java.awt.Color(245, 245, 245));
        jtxtPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 240, 60));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Choose Image...");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 240, 210));

        label5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label5.setText("Image");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jtxtDesc.setBackground(new java.awt.Color(245, 245, 245));
        jtxtDesc.setColumns(20);
        jtxtDesc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtDesc.setLineWrap(true);
        jtxtDesc.setRows(5);
        jtxtDesc.setAutoscrolls(false);
        jtxtDesc.setMinimumSize(new java.awt.Dimension(1000, 22));
        jScrollPane1.setViewportView(jtxtDesc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 510, -1));

        jtblProducts.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Price", "Name", "Stock Qty"
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
        jtblProducts.setGridColor(new java.awt.Color(0, 0, 0));
        jtblProducts.setOpaque(false);
        jScrollPane2.setViewportView(jtblProducts);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 360, 450));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 160, 80));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/insert.png"))); // NOI18N
        jButton2.setText("Insert");
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 150, 80));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.setIconTextGap(10);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, 180, 80));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/first.png"))); // NOI18N
        jButton4.setText("First");
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 150, 80));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/previous.png"))); // NOI18N
        jButton5.setText("Prev");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 140, 80));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/last.png"))); // NOI18N
        jButton6.setText("Last");
        jButton6.setIconTextGap(10);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 490, 150, 80));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        jButton7.setText("Next");
        jButton7.setIconTextGap(10);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 140, 80));

        label6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label6.setText("Stock Qty");
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jtxtStockQty.setBackground(new java.awt.Color(245, 245, 245));
        jtxtStockQty.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtStockQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStockQtyActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtStockQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 110, 60));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Database Application");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Product Service");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 350, 370));

        shallYouValidate.setForeground(java.awt.Color.blue);
        jPanel1.add(shallYouValidate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 600, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setLabel("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, 520, 50));

        jButton9.setText("Save to Disk");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNameActionPerformed

    private void jtxtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtPriceActionPerformed

    private void jtxtProductID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtProductID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtProductID1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Delete selected product item?", "Delete", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
        {
            try
            {
                Connection con = getConnection();

                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM products where productid = ?");
                ps.setString(1, jtxtProductID1.getText());
                ps.executeUpdate();
                ps.close();

                con.close();

                JOptionPane.showMessageDialog(null, "Deleted");

                getProducts();
            }
            catch(Exception e)
            {
                e.printStackTrace();

                getProducts();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //INSERT
        boolean isValid = validateForm();
        
        if(isValid && this.file != null)
        {
            //insert current product into the db table `products`
            currentProduct = new Product();
            currentProduct.setProductID(jtxtProductID1.getText());
            currentProduct.setName(jtxtName.getText());
            currentProduct.setPrice(Double.parseDouble(jtxtPrice.getText()));
            currentProduct.setImage(this.file);
            currentProduct.setDescription(jtxtDesc.getText());
            currentProduct.setStockQty(Integer.parseInt(jtxtStockQty.getText()));
    
            try
            {
                Connection con = getConnection();
                
                FileInputStream fis = new FileInputStream(currentProduct.getImage());
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO products (productID, productName, price, image, description, stockQty, inputdate) VALUES (?, ?, ?, ?, ?, ?, current_timestamp)");
                ps.setString(1, currentProduct.getProductID());
                ps.setString(2, currentProduct.getName());
                ps.setDouble(3, currentProduct.getPrice());
                ps.setBinaryStream(4, fis, (int) currentProduct.getImage().length());
                ps.setString(5, currentProduct.getDescription());
                ps.setInt(6, currentProduct.getStockQty());
                ps.executeUpdate();
                ps.close();
                fis.close();

                con.close();
                
                JOptionPane.showMessageDialog(null, "Inserted");
                
                getProducts();
            }
            catch(Exception e)
            {
                e.printStackTrace();

                getProducts();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getInitialProductsInfo()
    {
        try
        {
            Connection con = getConnection();
        
            PreparedStatement ps = con.prepareStatement("select count(id) as totalRecords from products;");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                this.totalRecords = rs.getInt("totalRecords");
                this.totalPages = (int) Math.ceil((double) this.totalRecords/(double) paging.getRecordsPerPage());
            }
            rs.close();
            ps.close();
            
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }        
    }

    private void getProducts()
    {
        DefaultTableModel model = (DefaultTableModel) jtblProducts.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        try
        {
            Connection con = getConnection();
        
            PreparedStatement ps = con.prepareStatement(
                    "select * from products order by inputdate desc"
                    + " limit " + paging.getRecordsPerPage() 
                    + " offset " + ((paging.getCurrentPage()-1)*paging.getRecordsPerPage())
                    + ";");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String a = rs.getString("productID");
                String b = rs.getString("price");
                String c = rs.getString("productName");
                String d = rs.getString("stockQty");
                model.addRow(new Object[]{a,b,c,d});
            }
            rs.close();
            ps.close();
            
            con.close();
            
            this.getInitialProductsInfo();
            
            this.setTitle(
                    paging.getTotalRecords() + " items found | page: " +
                    paging.getCurrentPage() + " | " +
                    "showing items: " + ((paging.getCurrentPage()-1)*paging.getRecordsPerPage()+1) +
                    " Of " + ((paging.getCurrentPage()-1)*paging.getRecordsPerPage()+(paging.getTotalRecords()-((paging.getCurrentPage()-1)*paging.getRecordsPerPage()))) +
                    "");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private Product getProduct(String productID)
    {
        Product product = new Product();
        
        try
        {
            Connection con = getConnection();
        
            PreparedStatement ps = con.prepareStatement("select * from products where productID = ?;");
            ps.setString(1, productID);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String a = rs.getString("productID");
                String b = rs.getString("price");
                String c = rs.getString("productName");
                String d = rs.getString("stockQty");
                String e = rs.getString("description");
                this.imgBytes = rs.getBytes("image");
                this.file = File.createTempFile("tempImg", null, null);
                FileOutputStream fos = new FileOutputStream(this.file);
                fos.write(imgBytes);
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
                jLabel1.setIcon(resizeImage(img,jLabel1.getWidth(),jLabel1.getHeight()));
                product.setProductID(a);
                product.setPrice(Double.parseDouble(b));
                product.setName(c);
                product.setStockQty(Integer.parseInt(d));
                product.setDescription(e);
            }
            rs.close();
            ps.close();
            
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return product;
    }
    
    private boolean validateForm()
    {
        boolean validationRequired = false;
        shallYouValidate.setText("");

        String productID = jtxtProductID1.getText();
        if(productID.length() == 0)
        {
            jtxtProductID1.setBackground(new Color(255,255,255));
            validationRequired = true;
        }
        else
        {
            jtxtProductID1.setBackground(new Color(245,245,245));
        }

        String productName = jtxtName.getText();
        if(productName.length() == 0)
        {
            jtxtName.setBackground(new Color(255,255,255));
            validationRequired = true;
        }
        else
        {
            jtxtName.setBackground(new Color(245,245,245));
        }

        String productPrice = jtxtPrice.getText();
        if(productPrice.length() == 0)
        {
            jtxtPrice.setBackground(new Color(255,255,255));
            validationRequired = true;
        }
        else
        {
            jtxtPrice.setBackground(new Color(245,245,245));
        }

        String productDesc = jtxtDesc.getText();
        if(productDesc.length() == 0)
        {
            jtxtDesc.setBackground(new Color(255,255,255));
            validationRequired = true;
        }
        else
        {
            jtxtDesc.setBackground(new Color(245,245,245));
        }

        String productQty = jtxtStockQty.getText();
        if(productQty.length() == 0)
        {
            jtxtStockQty.setBackground(new Color(255,255,255));
            validationRequired = true;
        }
        else
        {
            jtxtStockQty.setBackground(new Color(245,245,245));
        }
        
        if(validationRequired)
        {
            shallYouValidate.setForeground(Color.BLACK);
            shallYouValidate.setText("*PLEASE VALIDATE THE FIELDS THAT ARE WHITE!!!");
        }
        else
        {
            shallYouValidate.setText("");
        }
        
        return !validationRequired;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //UPDATE
        boolean isValid = validateForm();
        
        if(isValid && this.file != null)
        {
            //update current product to the db table `products`
            //insert current product into the db table `products`
            currentProduct = new Product();
            currentProduct.setProductID(jtxtProductID1.getText());
            currentProduct.setName(jtxtName.getText());
            currentProduct.setPrice(Double.parseDouble(jtxtPrice.getText()));
            currentProduct.setImage(this.file);
            currentProduct.setDescription(jtxtDesc.getText());
            currentProduct.setStockQty(Integer.parseInt(jtxtStockQty.getText()));
    
            try
            {
                Connection con = getConnection();
                
                FileInputStream fis = new FileInputStream(currentProduct.getImage());
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE products set productid = ?, productName = ?, price = ?, image = ?, description = ?, stockQty = ?, inputdate = current_timestamp where productID = ?");
                ps.setString(1, currentProduct.getProductID());
                ps.setString(2, currentProduct.getName());
                ps.setDouble(3, currentProduct.getPrice());
                ps.setBinaryStream(4, fis, (int) currentProduct.getImage().length());
                ps.setString(5, currentProduct.getDescription());
                ps.setInt(6, currentProduct.getStockQty());
                ps.setString(7, currentProduct.getProductID());
                ps.executeUpdate();
                ps.close();
                fis.close();

                con.close();
            
                JOptionPane.showMessageDialog(null, "Updated");
                
                getProducts();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                getProducts();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        paging.setCurrentPage(1);
        getProducts();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        paging.moveToPrevPage();
        getProducts();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        paging.setCurrentPage(paging.getPages());
        getProducts();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        paging.moveToNextPage();
        getProducts();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jtxtStockQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtStockQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStockQtyActionPerformed

    private ImageIcon resizeImage(BufferedImage b, int w, int h)
    {
        BufferedImage tempImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr = tempImg.createGraphics();
        
        gr.drawImage(b, 0, 0, w, h, null);
        gr.dispose();
        
        return new ImageIcon(tempImg);
    }
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            this.file = fc.getSelectedFile();
            try
            {
                BufferedImage b = ImageIO.read(file);
                ImageIcon ii = resizeImage(b, jLabel1.getWidth(), jLabel1.getHeight());
                jLabel1.setIcon(ii);
            }
            catch(Exception e)
            {
            }
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        JFrame frame = new JFrame();
        if(JOptionPane.showConfirmDialog(frame, "Confirm Exit?", "Exit", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //Save Image
        if(this.file != null && this.imgBytes != null)
        {
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save to Disk");    

            int userSelection = fileChooser.showSaveDialog(parentFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    Thread myThread = new Thread(new Runnable() {
                        public void run() {
                            try {
                                FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
                                fos.write(imgBytes);
                                JOptionPane.showMessageDialog(null, "Saved");
                                fos.close();
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    myThread.start();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblProducts;
    private javax.swing.JTextArea jtxtDesc;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtPrice;
    private javax.swing.JTextField jtxtProductID1;
    private javax.swing.JTextField jtxtStockQty;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JLabel shallYouValidate;
    // End of variables declaration//GEN-END:variables
}
