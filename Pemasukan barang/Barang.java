/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package datapemasukanbarang;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Barang extends javax.swing.JFrame {

    /**
     * Creates new form Barang
     */
    public Barang() {
        initComponents();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        loadData();
    }
    
    
    private void resetForm(){
        Id_barangTxt.setText("");
        Nama_barangTxt.setText("");
        Jenis_BarangTxt.setText("");
        Harga_barangTxt.setText("");
    }
    private void loadData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Satuan");
        model.addColumn("Harga Barang");
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("jenis_barang"),
                    rs.getString("satuan"),
                    rs.getString("harga_beli")
                });
            }
            TabelData.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void cariData(String key){
        try{
            Object[] judul_kolom = {"Id Barang", "Nama Barang","Jenis Barang", "Satuan", "Harga "};
            DefaultTableModel tabModel=new DefaultTableModel(null,judul_kolom);
            TabelData.setModel(tabModel);
            
           Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs=stmt.executeQuery("SELECT * FROM barang WHERE id_barang LIKE '%" + key + "%' OR nama_barang LIKE '%" + key + "%' OR jenis_barang LIKE '%" + key + "%' OR satuan LIKE '%" + key + "%' OR harga_beli LIKE '%" + key + "%'");  
            while(rs.next()){
                Object[] data={
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("jenis_barang"),
                    rs.getString("satuan"),
                    rs.getString("harga_beli")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelData = new javax.swing.JTable();
        IdBarangLabel = new javax.swing.JLabel();
        NamabarangLabel = new javax.swing.JLabel();
        SatuanBarangLabel = new javax.swing.JLabel();
        HargaLabel = new javax.swing.JLabel();
        NamabarangLabel3 = new javax.swing.JLabel();
        Nama_barangTxt = new javax.swing.JTextField();
        Id_barangTxt = new javax.swing.JTextField();
        SatuanCombo = new javax.swing.JComboBox<>();
        Jenis_BarangTxt = new javax.swing.JTextField();
        Harga_barangTxt = new javax.swing.JTextField();
        AddNewBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        CariData = new javax.swing.JLabel();
        CarDataText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BARANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        TabelData.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TabelData.setForeground(new java.awt.Color(0, 51, 102));
        TabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelData.setGridColor(new java.awt.Color(0, 51, 102));
        TabelData.setSelectionBackground(new java.awt.Color(102, 102, 102));
        TabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelData);

        IdBarangLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel.setText("Id Barang");

        NamabarangLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        NamabarangLabel.setForeground(new java.awt.Color(0, 51, 102));
        NamabarangLabel.setText("Nama Barang");

        SatuanBarangLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        SatuanBarangLabel.setForeground(new java.awt.Color(0, 51, 102));
        SatuanBarangLabel.setText("Satuan");

        HargaLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        HargaLabel.setForeground(new java.awt.Color(0, 51, 102));
        HargaLabel.setText("Jenis Barang");

        NamabarangLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        NamabarangLabel3.setForeground(new java.awt.Color(0, 51, 102));
        NamabarangLabel3.setText("Harga Barang");

        Nama_barangTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nama_barangTxtActionPerformed(evt);
            }
        });

        Id_barangTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_barangTxtActionPerformed(evt);
            }
        });

        SatuanCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pcs", "item", "unit", "kg", "buah", "botol", "kardus" }));

        Jenis_BarangTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jenis_BarangTxtActionPerformed(evt);
            }
        });

        Harga_barangTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Harga_barangTxtActionPerformed(evt);
            }
        });

        AddNewBtn.setText("AddNew");
        AddNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        updateBtn.setText("update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        CariData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CariData.setForeground(new java.awt.Color(0, 51, 102));
        CariData.setText("Cari Data");

        CarDataText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CarDataTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NamabarangLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SatuanBarangLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HargaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(IdBarangLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nama_barangTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SatuanCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 298, Short.MAX_VALUE)
                            .addComponent(Jenis_BarangTxt)
                            .addComponent(Id_barangTxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NamabarangLabel3)
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AddNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                            .addComponent(Harga_barangTxt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CariData)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarDataText, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CariData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id_barangTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn)
                    .addComponent(IdBarangLabel)
                    .addComponent(CarDataText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nama_barangTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NamabarangLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SatuanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SatuanBarangLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jenis_BarangTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HargaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NamabarangLabel3)
                            .addComponent(Harga_barangTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddNewBtn)
                            .addComponent(updateBtn)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(Cancel))
                .addGap(102, 102, 102))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nama_barangTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nama_barangTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nama_barangTxtActionPerformed

    private void Jenis_BarangTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jenis_BarangTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jenis_BarangTxtActionPerformed

    private void Harga_barangTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Harga_barangTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Harga_barangTxtActionPerformed

    private void AddNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewBtnActionPerformed
        resetForm();
    }//GEN-LAST:event_AddNewBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String idBarang = Id_barangTxt.getText();
        String nama_barang = Nama_barangTxt.getText();
        String jenis_barang = Jenis_BarangTxt.getText();
        String satuan = SatuanCombo.getSelectedItem().toString();
        String harga_beli = Harga_barangTxt.getText();
        

        // Periksa apakah input tidak kosong
        if(idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(nama_barang.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(jenis_barang.isEmpty()){
            JOptionPane.showMessageDialog(this, "Jenis Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(satuan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Satuan Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(harga_beli.isEmpty()){
            JOptionPane.showMessageDialog(this, "Harga Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn =(Connection)Config.configDB();
            // SQL untuk memasukkan data ke tabel
            String sql = "INSERT INTO barang (id_barang, nama_barang, jenis_barang, satuan, harga_beli) VALUES (?, ?, ?, ?, ?)";

            // Membuat PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idBarang);
            pstmt.setString(2, nama_barang);
            pstmt.setString(3, jenis_barang);
            pstmt.setString(4, satuan);
            pstmt.setString(5, harga_beli);

            // Menjalankan perintah SQL
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Menutup koneksi dan statement
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        String idBarang = Id_barangTxt.getText();

        // Check if ID Barang is not empty
        if(idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = (Connection) Config.configDB();
            // SQL to delete data from table
            String sql = "DELETE FROM barang WHERE id_barang = ?";

            // Create PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idBarang);

            // Execute SQL command
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close connection and statement
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        MainMenu MainMenuFrame = new MainMenu();
        MainMenuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String idBarang = Id_barangTxt.getText();
        String nama_barang = Nama_barangTxt.getText();
        String jenis_barang = Jenis_BarangTxt.getText();
        String satuan = SatuanCombo.getSelectedItem().toString();
        String harga_beli = Harga_barangTxt.getText();

        // Periksa apakah input tidak kosong
        if(idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(nama_barang.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(jenis_barang.isEmpty()){
            JOptionPane.showMessageDialog(this, "Jenis Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(satuan.isEmpty()){
            JOptionPane.showMessageDialog(this, "Satuan Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if(harga_beli.isEmpty()){
            JOptionPane.showMessageDialog(this, "Harga Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        conn = (Connection) Config.configDB();
        // SQL untuk memperbarui data di tabel
        String sql = "UPDATE barang SET nama_barang = ?, jenis_barang = ?, satuan = ?, harga_beli = ? WHERE id_barang = ?";

        // Membuat PreparedStatement
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nama_barang);
        pstmt.setString(2, jenis_barang);
        pstmt.setString(3, satuan);
        pstmt.setString(4, harga_beli);
        pstmt.setString(5, idBarang);

        // Menjalankan perintah SQL
        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadData();
        }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Menutup koneksi dan statement
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void Id_barangTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_barangTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_barangTxtActionPerformed

    private void TabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDataMouseClicked
        int selectedRow = TabelData.getSelectedRow();

        if (selectedRow != -1) {
            String id_barang = TabelData.getValueAt(selectedRow, 0).toString();
            String nama_barang = TabelData.getValueAt(selectedRow, 1).toString();
            String jenis_barang = TabelData.getValueAt(selectedRow, 2).toString();
            String satuan = TabelData.getValueAt(selectedRow, 3).toString();
            String harga_barang = TabelData.getValueAt(selectedRow, 4).toString();

            Id_barangTxt.setText(id_barang);
            Nama_barangTxt.setText(nama_barang);
            Jenis_BarangTxt.setText(jenis_barang);
            SatuanCombo.setSelectedItem(satuan);
            Harga_barangTxt.setText(harga_barang);
        }
    }//GEN-LAST:event_TabelDataMouseClicked

    private void CarDataTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CarDataTextKeyReleased
        String key=CarDataText.getText();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            loadData();
        }
    }//GEN-LAST:event_CarDataTextKeyReleased

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
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewBtn;
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField CarDataText;
    private javax.swing.JLabel CariData;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel HargaLabel;
    private javax.swing.JTextField Harga_barangTxt;
    private javax.swing.JLabel IdBarangLabel;
    private javax.swing.JTextField Id_barangTxt;
    private javax.swing.JTextField Jenis_BarangTxt;
    private javax.swing.JTextField Nama_barangTxt;
    private javax.swing.JLabel NamabarangLabel;
    private javax.swing.JLabel NamabarangLabel3;
    private javax.swing.JLabel SatuanBarangLabel;
    private javax.swing.JComboBox<String> SatuanCombo;
    private javax.swing.JTable TabelData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

}

