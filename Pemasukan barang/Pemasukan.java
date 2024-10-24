package datapemasukanbarang;

import java.text.ParseException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Pemasukan extends javax.swing.JFrame {

    /**
     * Creates new form Pemukanas
     */
    public Pemasukan() {
        initComponents();

        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        loadData();
        loadSupplierData();
        loadBarangData();

        this.setLocation(x, y);
    }

    private void resetForm() {
        idPemasukanTxt.setText("");
        TanggalMasuk.cleanup();
        jumlahMasukTxt.setText("");
        hargaSatuan.setText("");

    }

    private void loadData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Pemasukan");
        model.addColumn("Tanggal Pemasukkan");
        model.addColumn("Id Supplier");
        model.addColumn("Id Barang");
        model.addColumn("Jumlah Masuk");
        model.addColumn("harga Satuan");

        try {
            Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM pemasukkan";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getString("id_pemasukkan"),
                        rs.getString("tanggal_masuk"),
                        rs.getString("id_supplier"),
                        rs.getString("id_barang"),
                        rs.getString("jumlah_masuk"),
                        rs.getString("harga_satuan")
                });
            }
            TabelData.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadSupplierData() {
        try {
            Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT id_supplier FROM supplier";
            ResultSet rs = stmt.executeQuery(sql);

            idSupplierCombo.removeAllItems();
            while (rs.next()) {
                idSupplierCombo.addItem(rs.getString("id_supplier"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadBarangData() {
        try {
            Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT id_barang FROM barang";
            ResultSet rs = stmt.executeQuery(sql);

            idBarangCombo.removeAllItems();
            while (rs.next()) {
                idBarangCombo.addItem(rs.getString("id_barang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cariData(String key){
        try{
            Object[] judul_kolom = {"Id Pemasukkan", "Tanggal Pemasukkan","Id Supplier", "Id Barang", "Jumlah Masuk","Harga Satuan"};
            DefaultTableModel tabModel=new DefaultTableModel(null,judul_kolom);
            TabelData.setModel(tabModel);
            
           Connection conn = (Connection) Config.configDB();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs=stmt.executeQuery("SELECT * FROM barang WHERE id_pemasukkan LIKE '%" + key + "%' OR tanggal_masuk LIKE '%" + key + "%' OR id_supplier LIKE '%" + key + "%' OR id_barang LIKE '%" + key + "%' OR jumlah_masuk LIKE '%" + key + "%' OR harga_satuan LIKE '%");  
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelData = new javax.swing.JTable();
        IdBarangLabel = new javax.swing.JLabel();
        idPemasukanTxt = new javax.swing.JTextField();
        IdBarangLabel1 = new javax.swing.JLabel();
        TanggalMasuk = new com.toedter.calendar.JDateChooser();
        IdBarangLabel2 = new javax.swing.JLabel();
        idSupplierCombo = new javax.swing.JComboBox<>();
        idBarangCombo = new javax.swing.JComboBox<>();
        IdBarangLabel3 = new javax.swing.JLabel();
        IdBarangLabel4 = new javax.swing.JLabel();
        jumlahMasukTxt = new javax.swing.JTextField();
        IdBarangLabel5 = new javax.swing.JLabel();
        hargaSatuan = new javax.swing.JTextField();
        AddNewBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        CariData = new javax.swing.JLabel();
        CarDataText = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BARANG MASUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
        TabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelData);

        IdBarangLabel.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel.setText("Id Pemasukkan");

        idPemasukanTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPemasukanTxtActionPerformed(evt);
            }
        });

        IdBarangLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel1.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel1.setText("Tanggal masuk");

        IdBarangLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel2.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel2.setText("id_supplier");

        idSupplierCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        idSupplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idSupplierComboActionPerformed(evt);
            }
        });

        idBarangCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        idBarangCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBarangComboActionPerformed(evt);
            }
        });

        IdBarangLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel3.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel3.setText("id_barang");

        IdBarangLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel4.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel4.setText("jumlah masuk");

        jumlahMasukTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahMasukTxtActionPerformed(evt);
            }
        });

        IdBarangLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        IdBarangLabel5.setForeground(new java.awt.Color(0, 51, 102));
        IdBarangLabel5.setText("harga satuan");

        hargaSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaSatuanActionPerformed(evt);
            }
        });

        AddNewBtn.setText("AddNew");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        CariData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CariData.setForeground(new java.awt.Color(0, 51, 102));
        CariData.setText("Cari Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(IdBarangLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IdBarangLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IdBarangLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IdBarangLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(IdBarangLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(IdBarangLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(idPemasukanTxt)
                            .addComponent(jumlahMasukTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hargaSatuan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(idSupplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(idBarangCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(AddNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CariData)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarDataText, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPemasukanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdBarangLabel)
                    .addComponent(CarDataText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdBarangLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idSupplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdBarangLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idBarangCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdBarangLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdBarangLabel4)
                            .addComponent(jumlahMasukTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdBarangLabel5)
                            .addComponent(hargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddNewBtn)
                            .addComponent(Update)
                            .addComponent(Delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtn)
                            .addComponent(Cancel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        String idPemasukan = idPemasukanTxt.getText();

        // Check if ID Barang is not empty
        if(idPemasukan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = (Connection) Config.configDB();
            // SQL to delete data from table
            String sql = "DELETE FROM pemasukkan WHERE id_pemasukkan = ?";

            // Create PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idPemasukan);

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
    }//GEN-LAST:event_DeleteActionPerformed

    private void idPemasukanTxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idPemasukanTxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idPemasukanTxtActionPerformed

    private void idSupplierComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idSupplierComboActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idSupplierComboActionPerformed

    private void idBarangComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_idBarangComboActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_idBarangComboActionPerformed

    private void jumlahMasukTxtActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jumlahMasukTxtActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jumlahMasukTxtActionPerformed

    private void hargaSatuanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_hargaSatuanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_hargaSatuanActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_UpdateActionPerformed
        String idPemasukan = idPemasukanTxt.getText();
        Date tanggalMasukDate = TanggalMasuk.getDate();
        String idSupplier = idSupplierCombo.getSelectedItem().toString();
        String idBarang = idBarangCombo.getSelectedItem().toString();
        String jumlahMasuk = jumlahMasukTxt.getText();
        String hargaSatuanBarang = hargaSatuan.getText();

        // Periksa apakah input tidak kosong
        if (idPemasukan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Pemasukkan tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (idSupplier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jenis Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (idBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Satuan Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (jumlahMasuk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah Masuk tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargaSatuanBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harga Satuan Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Config.configDB();
            // Format tanggal untuk SQL
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(tanggalMasukDate);

            // SQL untuk memperbarui data di tabel
            String sql = "UPDATE pemasukkan SET tanggal_masuk = ?, id_supplier = ?, id_barang = ?, jumlah_masuk = ?, harga_satuan = ? WHERE id_pemasukkan = ?";

            // Membuat PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, formattedDate);
            pstmt.setString(2, idSupplier);
            pstmt.setString(3, idBarang);
            pstmt.setString(4, jumlahMasuk);
            pstmt.setString(5, hargaSatuanBarang);
            pstmt.setString(6, idPemasukan);

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
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }// GEN-LAST:event_UpdateActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelActionPerformed
        MainMenu MainmenuFrame = new MainMenu();
        MainmenuFrame.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_CancelActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveBtnActionPerformed
        String idPemasukan = idPemasukanTxt.getText();
        Date tanggalMasukDate = TanggalMasuk.getDate();
        String idSupplier = idSupplierCombo.getSelectedItem().toString();
        String idBarang = idBarangCombo.getSelectedItem().toString();
        String jumlahMasuk = jumlahMasukTxt.getText();
        String hargaSatuanBarang = hargaSatuan.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalMasuk = null;
        if (tanggalMasukDate != null) {
            tanggalMasuk = dateFormat.format(tanggalMasukDate);
        }

        try {
            if(idPemasukan.isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID Pemasukan tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(tanggalMasukDate == null){
                JOptionPane.showMessageDialog(this, "Tanggal Masuk tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(idSupplier.isEmpty()){
                JOptionPane.showMessageDialog(this, "ID Supplier tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(idBarang.isEmpty()){
                JOptionPane.showMessageDialog(this, "ID Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(jumlahMasuk.isEmpty()){
                JOptionPane.showMessageDialog(this, "Jumlah Masuk tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(hargaSatuanBarang.isEmpty()){
                JOptionPane.showMessageDialog(this, "Harga Satuan Barang tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = (Connection) Config.configDB();
            String sql = "INSERT INTO pemasukkan (id_pemasukkan, tanggal_masuk, id_supplier, id_barang, jumlah_masuk, harga_satuan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, idPemasukan);
            pstm.setString(2, tanggalMasuk);
            pstm.setString(3, idSupplier);
            pstm.setString(4, idBarang);
            pstm.setString(5, jumlahMasuk);
            pstm.setString(6, hargaSatuanBarang);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully");
            loadData();
            resetForm();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_saveBtnActionPerformed

    private void TabelDataMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TabelDataMouseClicked
        int selectedRow = TabelData.getSelectedRow();

        if (selectedRow != -1) {
            String id_pemasukkan = TabelData.getValueAt(selectedRow, 0).toString();
            String tanggal_masuk = TabelData.getValueAt(selectedRow, 1).toString();
            String id_supplier = TabelData.getValueAt(selectedRow, 2).toString();
            String id_barang = TabelData.getValueAt(selectedRow, 3).toString();
            String jumlah_masuk = TabelData.getValueAt(selectedRow, 4).toString();
            String harga_satuan = TabelData.getValueAt(selectedRow, 5).toString();

            idPemasukanTxt.setText(id_pemasukkan);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateFormat.parse(tanggal_masuk);
                TanggalMasuk.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            idSupplierCombo.setSelectedItem(id_supplier);
            idBarangCombo.setSelectedItem(id_barang);
            jumlahMasukTxt.setText(jumlah_masuk);
            hargaSatuan.setText(harga_satuan);
        }
    }// GEN-LAST:event_TabelDataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

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
    private javax.swing.JButton Delete;
    private javax.swing.JLabel IdBarangLabel;
    private javax.swing.JLabel IdBarangLabel1;
    private javax.swing.JLabel IdBarangLabel2;
    private javax.swing.JLabel IdBarangLabel3;
    private javax.swing.JLabel IdBarangLabel4;
    private javax.swing.JLabel IdBarangLabel5;
    private javax.swing.JTable TabelData;
    private com.toedter.calendar.JDateChooser TanggalMasuk;
    private javax.swing.JButton Update;
    private javax.swing.JTextField hargaSatuan;
    private javax.swing.JComboBox<String> idBarangCombo;
    private javax.swing.JTextField idPemasukanTxt;
    private javax.swing.JComboBox<String> idSupplierCombo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahMasukTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
