/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furqon0387;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author furqo
 */
public class ctkLaporan0387 extends javax.swing.JFrame {
    private Connection conn = new koneksi0387().connect();
    private DefaultTableModel tabmode;
    Calendar cal = Calendar.getInstance();
    int tahun = cal.get(Calendar.YEAR);
    int bulan = cal.get(Calendar.MONTH) + 1;
    int hari = cal.get(Calendar.DAY_OF_MONTH);
    String tanggal = tahun+"-"+bulan+"-"+hari;
    
    protected void datatabelplg(){
        Object[] Baris ={"No Pelanggan","Nama Pelanggan","Jenis Kelamin","Tempat Lahir","Tanggal Lahir","Alamat","Golongan","No Telepon","Pembayaran Terakhir"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pelanggan`";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_pel");
                obj[1] = hasil.getString("nama_pel");
                obj[2] = hasil.getString("jk");
                obj[3] = hasil.getString("tempat_lahir");
                obj[4] = hasil.getString("tgl_lahir");
                obj[5] = hasil.getString("alamat");
                obj[6] = hasil.getString("golongan");
                obj[7] = hasil.getString("no_telp");
                obj[8] = hasil.getString("pembayaran_terakhir");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }         
    }
    private DefaultTableModel tabelmode;
    
    protected void datatabelbyr(){
        Object[] Baris ={"No Rekening","No Pelanggan","Nama Pelanggan","Golongan","Alamat","Pemakaian","Tanggal Bayar","Tagihan","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pembayaran`";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_rek");
                obj[1] = hasil.getString("no_pel");
                obj[2] = hasil.getString("nama_pel");
                obj[3] = hasil.getString("golongan");
                obj[4] = hasil.getString("alamat");
                obj[5] = hasil.getString("pemakaian");
                obj[6] = hasil.getString("tanggal_pembayaran");
                obj[7] = hasil.getString("tagihan");
                obj[8] = hasil.getString("status_pembayaran");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }
    }

        protected void datatabelbyrlunas(){
        Object[] Baris ={"No Rekening","No Pelanggan","Nama Pelanggan","Golongan","Alamat","Pemakaian","Tanggal Bayar","Tagihan","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pembayaran` WHERE `status_pembayaran` = 2";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_rek");
                obj[1] = hasil.getString("no_pel");
                obj[2] = hasil.getString("nama_pel");
                obj[3] = hasil.getString("golongan");
                obj[4] = hasil.getString("alamat");
                obj[5] = hasil.getString("pemakaian");
                obj[6] = hasil.getString("tanggal_pembayaran");
                obj[7] = hasil.getString("tagihan");
                obj[8] = hasil.getString("status_pembayaran");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }
    }
        
        protected void datatabelbyrnunggak(){
        Object[] Baris ={"No Rekening","No Pelanggan","Nama Pelanggan","Golongan","Alamat","Pemakaian","Tanggal Bayar","Tagihan","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pembayaran` WHERE `status_pembayaran` = 1";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_rek");
                obj[1] = hasil.getString("no_pel");
                obj[2] = hasil.getString("nama_pel");
                obj[3] = hasil.getString("golongan");
                obj[4] = hasil.getString("alamat");
                obj[5] = hasil.getString("pemakaian");
                obj[6] = hasil.getString("tanggal_pembayaran");
                obj[7] = hasil.getString("tagihan");
                obj[8] = hasil.getString("status_pembayaran");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }
    }
    /**
     * Creates new form ctkLaporan0387
     */
    public ctkLaporan0387() {
        initComponents();
        datatabelbyr();
        btnHapus.setVisible(false);
        btPrintLp.setVisible(true);
        btPrintLpPel.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNopel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btPrintPel = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLaporan = new javax.swing.JTable();
        txtCariFurqon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JLabel();
        btPrintLp = new javax.swing.JLabel();
        cbData = new javax.swing.JComboBox();
        cbIsi = new javax.swing.JComboBox();
        btPrintLp1 = new javax.swing.JLabel();
        btPrintLpPel = new javax.swing.JLabel();
        cbBln = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(60, 30));
        setMinimumSize(new java.awt.Dimension(1250, 675));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Open Sans Extrabold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CETAK LAPORAN");

        jLabel2.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nomor Pelanggan");

        txtNopel.setBackground(new java.awt.Color(0, 102, 255));
        txtNopel.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        txtNopel.setForeground(new java.awt.Color(255, 255, 255));
        txtNopel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNopel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtNopel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNopelKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Back_To_32px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cetak Berdasarkan Nomor Pelanggan");

        btPrintPel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Print_96px_3.png"))); // NOI18N
        btPrintPel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPrintPelMouseClicked(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Delete_32px.png"))); // NOI18N
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNopel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPrintPel)
                .addGap(164, 164, 164))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNopel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus))
                .addGap(45, 45, 45)
                .addComponent(btPrintPel)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 430, 680);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbLaporan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));
        tbLaporan.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        tbLaporan.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tbLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLaporanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLaporan);

        txtCariFurqon.setFont(new java.awt.Font("Open Sans Light", 0, 12)); // NOI18N
        txtCariFurqon.setForeground(new java.awt.Color(0, 102, 255));
        txtCariFurqon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));
        txtCariFurqon.setSelectedTextColor(new java.awt.Color(0, 102, 255));
        txtCariFurqon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariFurqonKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Open Sans Extrabold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setText("Cari");

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Multiply_50px.png"))); // NOI18N
        btnKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarMouseClicked(evt);
            }
        });

        btPrintLp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Print_96px_1.png"))); // NOI18N
        btPrintLp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPrintLpMouseClicked(evt);
            }
        });

        cbData.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Data Pembayaran", "Data Pelanggan" }));
        cbData.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDataItemStateChanged(evt);
            }
        });
        cbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDataMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbDataMouseReleased(evt);
            }
        });
        cbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataActionPerformed(evt);
            }
        });
        cbData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbDataPropertyChange(evt);
            }
        });

        cbIsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "semua", "lunas", "tunggakan" }));
        cbIsi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIsiItemStateChanged(evt);
            }
        });
        cbIsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIsiMouseClicked(evt);
            }
        });
        cbIsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIsiActionPerformed(evt);
            }
        });

        btPrintLp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Conversion_48px.png"))); // NOI18N
        btPrintLp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPrintLp1MouseClicked(evt);
            }
        });

        btPrintLpPel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Print_96px_1.png"))); // NOI18N
        btPrintLpPel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPrintLpPelMouseClicked(evt);
            }
        });

        cbBln.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cbBln.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBlnItemStateChanged(evt);
            }
        });
        cbBln.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBlnMouseClicked(evt);
            }
        });
        cbBln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBlnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(562, 562, 562)
                        .addComponent(btnKeluar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCariFurqon)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btPrintLp1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbBln, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(btPrintLp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPrintLpPel)
                                .addGap(17, 17, 17)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKeluar)
                        .addGap(25, 25, 25))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCariFurqon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbBln, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btPrintLp1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPrintLpPel)
                            .addComponent(btPrintLp))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(430, 0, 820, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnKeluarMouseClicked

    private void tbLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLaporanMouseClicked
        // TODO add your handling code here:
        btnHapus.setVisible(true);
        int bar = tbLaporan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 1).toString();
        txtNopel.setText(a);
    }//GEN-LAST:event_tbLaporanMouseClicked

    private void txtNopelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopelKeyReleased
        // TODO add your handling code here:
        if (txtNopel.getText().equals("")) {
                btnHapus.setVisible(false);
        } else {
            btnHapus.setVisible(true);
        }
        String npmFurqon = txtNopel.getText();
       
        if (npmFurqon.matches("[0-9]*")) {
      } else {
            JOptionPane.showMessageDialog(null, "Nomor Pelanggan Harus Angka!");
        }
    }//GEN-LAST:event_txtNopelKeyReleased

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
            menuUtmMng0387 menuUtm = new menuUtmMng0387();
            menuUtm.show();
            this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtCariFurqonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariFurqonKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)tbLaporan.getModel();
        String search = txtCariFurqon.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tbLaporan.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
    }//GEN-LAST:event_txtCariFurqonKeyReleased

    private void btPrintPelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintPelMouseClicked
        String nopel = txtNopel.getText();
        
        if (nopel.equals("")) {
            JOptionPane.showMessageDialog(null, "Masukkan Nomor Pelanggan Untuk Mencetak Riwayat Pembayarannya");
        } else {  
        try {
            // TODO add your handling code here:
            Connection conn = new koneksi0387().connect();
            //JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/furqon0387/laporanNilai0387.jrxml");
            InputStream file = getClass().getResourceAsStream("/furqon0387/lpRiwayatByr.jrxml");
            JasperDesign jd = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.put("no_pel", nopel);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setTitle("Cetak Riwayat Pembayaran Pelanggan");
            jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nomor Pelanggans Tidak Ditemukan");
        }
      }
    }//GEN-LAST:event_btPrintPelMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        txtNopel.setText(null);
        btnHapus.setVisible(false);
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btPrintLpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintLpMouseClicked
        // TODO add your handling code here:        
        String isi = cbIsi.getSelectedItem().toString();
        String pbln = cbBln.getSelectedItem().toString();
        int abln = 0;     
        
        if (isi.equals("semua")) {
            try {
                if (pbln.equals("Januari")) {
                    abln = 1;
                } else if (pbln.equals("Februari")) {
                    abln = 2;
                } else if (pbln.equals("Maret")) {
                    abln = 3;
                } else if (pbln.equals("April")) {
                    abln = 4;
                } else if (pbln.equals("Mei")) {
                    abln = 5;
                } else if (pbln.equals("Juni")) {
                    abln = 6;
                } else if (pbln.equals("Juli")) {
                    abln = 7;
                } else if (pbln.equals("Agustus")) {
                    abln = 8;
                } else if (pbln.equals("September")) {
                    abln = 9;
                } else if (pbln.equals("Oktober")) {
                    abln = 10;
                } else if (pbln.equals("November")) {
                    abln = 11;
                } else if (pbln.equals("Desember")) {
                    abln = 12;
                }
                    Connection conn = new koneksi0387().connect();
                    //JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/furqon0387/laporanNilai0387.jrxml");
                    InputStream file = getClass().getResourceAsStream("/furqon0387/lpnPembayaran.jrxml");
                    JasperDesign jd = JRXmlLoader.load(file);
                    HashMap param = new HashMap();
                    param.put("bulan", abln);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
                    JasperViewer jv = new JasperViewer(jp,false);
                    jv.setTitle("Print Laporan Pembayaran");
                    jv.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Pembayaran Tidak Ditemukan");
                }
            } else {
                if (pbln.equals("Januari")) {
                    abln = 1;
                } else if (pbln.equals("Februari")) {
                    abln = 2;
                } else if (pbln.equals("Maret")) {
                    abln = 3;
                } else if (pbln.equals("April")) {
                    abln = 4;
                } else if (pbln.equals("Mei")) {
                    abln = 5;
                } else if (pbln.equals("Juni")) {
                    abln = 6;
                } else if (pbln.equals("Juli")) {
                    abln = 7;
                } else if (pbln.equals("Agustus")) {
                    abln = 8;
                } else if (pbln.equals("September")) {
                    abln = 9;
                } else if (pbln.equals("Oktober")) {
                    abln = 10;
                } else if (pbln.equals("November")) {
                    abln = 11;
                } else if (pbln.equals("Desember")) {
                    abln = 12;
                }
                try {
                    // TODO add your handling code here:
                    Connection conn = new koneksi0387().connect();
                    //JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/furqon0387/laporanNilai0387.jrxml");
                    InputStream file = getClass().getResourceAsStream("/furqon0387/lpPembayaran.jrxml");
                    JasperDesign jd = JRXmlLoader.load(file);
                    HashMap param = new HashMap();
                    param.put("status", isi);
                    param.put("bulan", abln);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
                    JasperViewer jv = new JasperViewer(jp,false);
                    jv.setTitle("Print Laporan Pembayaran");
                    jv.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Pembayaran Tidak Ditemukan");
                }
            }
    }//GEN-LAST:event_btPrintLpMouseClicked

    private void btPrintLp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintLp1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btPrintLp1MouseClicked

    private void cbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDataActionPerformed

    private void cbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDataMouseClicked

    private void cbDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDataMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDataMouseReleased

    private void cbIsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIsiActionPerformed
        // TODO add your handling code here:
        String pisi = cbIsi.getSelectedItem().toString();
        
        if (pisi.equals("semua")) {
            datatabelbyr();
        } else if (pisi.equals("lunas")) {
            datatabelbyrlunas();
        } else if (pisi.equals("tunggakan")) {
            datatabelbyrnunggak();
        }
    }//GEN-LAST:event_cbIsiActionPerformed

    private void btPrintLpPelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintLpPelMouseClicked
        // TODO add your handling code here:
            try {
                // TODO add your handling code here:
                Connection conn = new koneksi0387().connect();
                //JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/furqon0387/laporanNilai0387.jrxml");
                InputStream file = getClass().getResourceAsStream("/furqon0387/lpPelanggan.jrxml");
                JasperDesign jd = JRXmlLoader.load(file);
                HashMap param = new HashMap();
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer jv = new JasperViewer(jp,false);
                jv.setTitle("Print Laporan Pelanggan");
                jv.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Pelanggan Tidak Ditemukan");
            }  
    }//GEN-LAST:event_btPrintLpPelMouseClicked

    private void cbBlnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBlnActionPerformed
        // TODO add your handling code here:
        String pisi = cbIsi.getSelectedItem().toString();
        String pbln = cbBln.getSelectedItem().toString();
        int abln = 0;   
        
        if (pbln.equals("Januari")) {
            abln = 1;
        } else if (pbln.equals("Februari")) {
            abln = 2;
        } else if (pbln.equals("Maret")) {
            abln = 3;
        } else if (pbln.equals("April")) {
            abln = 4;
        } else if (pbln.equals("Mei")) {
            abln = 5;
        } else if (pbln.equals("Juni")) {
            abln = 6;
        } else if (pbln.equals("Juli")) {
            abln = 7;
        } else if (pbln.equals("Agustus")) {
            abln = 8;
        } else if (pbln.equals("September")) {
            abln = 9;
        } else if (pbln.equals("Oktober")) {
            abln = 10;
        } else if (pbln.equals("November")) {
            abln = 11;
        } else if (pbln.equals("Desember")) {
            abln = 12;
        }
        
        if (pisi.equals("semua")) {
        Object[] Baris ={"No Rekening","No Pelanggan","Nama Pelanggan","Golongan","Alamat","Pemakaian","Tanggal Bayar","Tagihan","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pembayaran` WHERE MONTH(`tanggal_pembayaran`) = "+abln+" OR MONTH(`update_stand`) = "+abln+"";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_rek");
                obj[1] = hasil.getString("no_pel");
                obj[2] = hasil.getString("nama_pel");
                obj[3] = hasil.getString("golongan");
                obj[4] = hasil.getString("alamat");
                obj[5] = hasil.getString("pemakaian");
                obj[6] = hasil.getString("tanggal_pembayaran");
                obj[7] = hasil.getString("tagihan");
                obj[8] = hasil.getString("status_pembayaran");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }
        } else {
        Object[] Baris ={"No Rekening","No Pelanggan","Nama Pelanggan","Golongan","Alamat","Pemakaian","Tanggal Bayar","Tagihan","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbLaporan.setModel(tabmode);
        String sql = "SELECT * FROM `pembayaran` WHERE `status_pembayaran` = '"+pisi+"' AND (MONTH(`tanggal_pembayaran`) = "+abln+" OR MONTH(`update_stand`) = "+abln+")";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Object[] obj = new Object[9];
                obj[0] = hasil.getString("no_rek");
                obj[1] = hasil.getString("no_pel");
                obj[2] = hasil.getString("nama_pel");
                obj[3] = hasil.getString("golongan");
                obj[4] = hasil.getString("alamat");
                obj[5] = hasil.getString("pemakaian");
                obj[6] = hasil.getString("tanggal_pembayaran");
                obj[7] = hasil.getString("tagihan");
                obj[8] = hasil.getString("status_pembayaran");
                tabmode.addRow(obj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      }
        }
    }//GEN-LAST:event_cbBlnActionPerformed

    private void cbIsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIsiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIsiMouseClicked

    private void cbBlnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBlnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBlnMouseClicked

    private void cbDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbDataPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDataPropertyChange

    private void cbDataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDataItemStateChanged
        // TODO add your handling code here:
        String ptable = cbData.getSelectedItem().toString();

        if (ptable.equals("Data Pembayaran")) {
            cbIsi.setSelectedItem("Semua");
            cbIsi.setEnabled(true);
            cbBln.setEnabled(true);
            btPrintLp.setVisible(true);
            btPrintLpPel.setVisible(false);
            datatabelbyr();
        } else if (ptable.equals("Data Pelanggan")) {
            cbIsi.setEnabled(false);
            btPrintLp.setVisible(false);
            btPrintLpPel.setVisible(true);
            cbBln.setEnabled(false);
            datatabelplg();
        }
    }//GEN-LAST:event_cbDataItemStateChanged

    private void cbIsiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIsiItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIsiItemStateChanged

    private void cbBlnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBlnItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBlnItemStateChanged

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
            java.util.logging.Logger.getLogger(ctkLaporan0387.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ctkLaporan0387.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ctkLaporan0387.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ctkLaporan0387.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ctkLaporan0387().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btPrintLp;
    private javax.swing.JLabel btPrintLp1;
    private javax.swing.JLabel btPrintLpPel;
    private javax.swing.JLabel btPrintPel;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnKeluar;
    private javax.swing.JComboBox cbBln;
    private javax.swing.JComboBox cbData;
    private javax.swing.JComboBox cbIsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLaporan;
    private javax.swing.JTextField txtCariFurqon;
    private javax.swing.JTextField txtNopel;
    // End of variables declaration//GEN-END:variables
}
