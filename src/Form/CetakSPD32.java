/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import Form.SuratPindahDatang.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arya Wicaksana
 */
public class CetakSPD32 extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form CetakSPD32
     */
    public void cetak(){
        PrinterJob pj = PrinterJob.getPrinterJob();
pj.setJobName("nama_");
pj.setCopies(1);
PageFormat format = pj.defaultPage();
format.setOrientation(PageFormat.PORTRAIT);

pj.setPrintable(new Printable() {
public int print(Graphics pg, PageFormat pf, int pageNum){
if (pageNum > 0){
return Printable.NO_SUCH_PAGE;
}
Graphics2D g2 = (Graphics2D) pg;
g2.translate(pf.getImageableX(), pf.getImageableY());
jLayeredPane2.paint(g2);
return Printable.PAGE_EXISTS;
}
});
if (pj.printDialog() == false)
return;

try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }   
    }
    
     private void tinggiBaris(){
        jTable1.setRowHeight(10);
        jTable1.getTableHeader().setFont(new Font("SansSerif", 0 , 8));
    }
    
    private void isiKodeDesaKelurahan(){
         try {
            String kode = Pendaftar.cbdesakelurahan.getSelectedItem().toString();
            System.out.println("kode adalah "+kode);
            String Sql = "SELECT id_desa_kelurahan FROM desa_kelurahan WHERE nama_desa_kelurahan='"+kode+"' ";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_kode_desa_kelurahan.setText(rs.getString(1));
            }
        } catch (Exception e) {
        }   
    }
    
        private void isiOtomatisAtas(){
            lbl_no_surat.setText(SuratPindahDatang.txt_no_surat_pindah_datang.getText());
            lbl_desa_kelurahan.setText(SuratPindahDatang.lbl_desa_kelurahan_ddt.getText());
            lbl_dusun_dukuh_kampung.setText(SuratPindahDatang.txt_dusun_dukuh_kampung_ddt.getText());
        }
    
        private void isiOtomatisDDA(){
            lbl_no_kk_dda.setText(SuratPindahDatang.txt_no_kk_dda.getText());
            lbl_nama_keluarga_dda.setText(SuratPindahDatang.txt_nama_kepala_keluarga.getText());
            lbl_alamat.setText(SuratPindahDatang.txt_alamat_dda.getText());
            lbl_rt_dda.setText(SuratPindahDatang.txt_rt_dda.getText());
            lbl_rw_dda.setText(SuratPindahDatang.txt_rw_dda.getText());
            lbl_dusun_dukuh_kampung_dda.setText(SuratPindahDatang.txt_dusun_dukuh_kampung_dda.getText());
            lbl_desa_kelurahan_dda.setText(SuratPindahDatang.txt_desa_kelurahan_dda.getText());
            lbl_kodepos_dda.setText(SuratPindahDatang.txt_kodepos_dda.getText());
            lbl_telepon_dda.setText(SuratPindahDatang.txt_telepon_dda.getText());
            lbl_kecamatan_dda.setText(SuratPindahDatang.txt_kecamatan_dda.getText());
            lbl_kab_kota_dda.setText(SuratPindahDatang.txt_kab_kota_dda.getText());
            lbl_provinsi_dda.setText(SuratPindahDatang.txt_provinsi_dda.getText());
            lbl_nik_dda.setText(SuratPindahDatang.txt_nik_dda.getText());
            lbl_nama_dda.setText(SuratPindahDatang.lbl_nama_dda.getText());
        }
        
        private void isiOtomatisDDT(){
           if (SuratPindahDatang.status_kk_bagi_yg_pindah=="Numpang KK") {
                lbl_status_kk_bagi_yg_pindah_ddt.setText("1");
            } 
            else if (SuratPindahDatang.status_kk_bagi_yg_pindah=="Membuat KK Baru") {
                lbl_status_kk_bagi_yg_pindah_ddt.setText("2");
            } 
            else {
                lbl_status_kk_bagi_yg_pindah_ddt.setText("3");
            }
           
            lbl_no_kk_ddt.setText(SuratPindahDatang.txt_no_kk_ddt.getText());
            lbl_nik_ddt.setText(SuratPindahDatang.txt_nik_kepala_keluaga_ddt.getText());
            lbl_nama_kepala_keluarga_ddt.setText(SuratPindahDatang.txt_nama_kepala_keluarga_ddt.getText());
            
            lbl_tgl_kedatangan_ddt.setText(SuratPindahDatang.tgl_kedatangan_ddt.getDateFormatString().toString());
            
            lbl_alamat_ddt.setText(SuratPindahDatang.lbl_alamat_ddt.getText());
            lbl_rt_ddt.setText(SuratPindahDatang.lbl_rt_ddt.getText());
            lbl_rw_ddt.setText(SuratPindahDatang.lbl_rw_ddt.getText());
            lbl_dusun_dukuh_kampung_dkp.setText(SuratPindahDatang.txt_dusun_dukuh_kampung_ddt.getText());
            lbl_desa_kelurahan_ddt.setText(SuratPindahDatang.lbl_desa_kelurahan_ddt.getText());
            lbl_kecamatan_ddt.setText(SuratPindahDatang.lbl_kecamatan_ddt.getText());
            lbl_kab_kota_ddt.setText(SuratPindahDatang.lbl_kab_kota_ddt.getText());
            lbl_provinsi_ddt.setText(SuratPindahDatang.lbl_provinsi_ddt.getText());
                     
            lbl_tgl_sekarang.setText(MenuUtama.lblTanggal.getText());
        }

        private void UpdateTabelCetakSPD(){
    try
        {
            String z = SuratPindahDatang.lbl_id_daftar_kyd.getText();
                    
            String SQL = "SELECT no_kyd AS  'No.', nik_kyd AS  'NIK', nama_kyd AS  'Nama', masa_berlaku_ktp_kyd AS  'Masa Berlaku KTP S/D',  `shdk_kyd` AS  'SHDK'" +
                         "FROM keluarga_yang_datang " +
                         " where id_daftar_kyd = '"+z+"' ";
            pst=conn.prepareStatement(SQL);
            rs = pst.executeQuery(SQL);
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
   }
}
                 
    public CetakSPD32() {
        initComponents();
        conn = KoneksiDB.ConnectDb(); 
        tinggiBaris();
        isiKodeDesaKelurahan();
        isiOtomatisAtas();
        isiOtomatisDDA();
        isiOtomatisDDT();
        UpdateTabelCetakSPD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbl_dusun_dukuh_kampung = new javax.swing.JLabel();
        lbl_rw_dda = new javax.swing.JLabel();
        lbl_rt_dda = new javax.swing.JLabel();
        lbl_nama_keluarga_dda = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_no_kk_dda = new javax.swing.JLabel();
        lbl_no_surat = new javax.swing.JLabel();
        lbl_desa_kelurahan = new javax.swing.JLabel();
        lbl_desa_kelurahan_dda = new javax.swing.JLabel();
        lbl_kecamatan_dda = new javax.swing.JLabel();
        lbl_kodepos_dda = new javax.swing.JLabel();
        lbl_nama_dda = new javax.swing.JLabel();
        lbl_telepon_dda = new javax.swing.JLabel();
        lbl_nik_dda = new javax.swing.JLabel();
        lbl_provinsi_dda = new javax.swing.JLabel();
        lbl_kab_kota_dda = new javax.swing.JLabel();
        lbl_dusun_dukuh_kampung_dda = new javax.swing.JLabel();
        lbl_rt_ddt = new javax.swing.JLabel();
        lbl_rw_ddt = new javax.swing.JLabel();
        lbl_kab_kota_ddt = new javax.swing.JLabel();
        lbl_alamat_ddt = new javax.swing.JLabel();
        lbl_provinsi_ddt = new javax.swing.JLabel();
        lbl_kecamatan_ddt = new javax.swing.JLabel();
        lbl_desa_kelurahan_ddt = new javax.swing.JLabel();
        lbl_tgl_sekarang = new javax.swing.JLabel();
        lbl_dusun_dukuh_kampung_dkp = new javax.swing.JLabel();
        lbl_kode_desa_kelurahan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_status_kk_bagi_yg_pindah_ddt = new javax.swing.JLabel();
        lbl_tgl_kedatangan_ddt = new javax.swing.JLabel();
        lbl_nik_ddt = new javax.swing.JLabel();
        lbl_no_kk_ddt = new javax.swing.JLabel();
        lbl_nama_kepala_keluarga_ddt = new javax.swing.JLabel();
        Temanggung = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dusun_dukuh_kampung.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dusun_dukuh_kampung.setText("lbl_desa_dukuh_kampung");
        jLayeredPane2.add(lbl_dusun_dukuh_kampung, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 191, 360, -1));

        lbl_rw_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rw_dda.setText("lbl_rw_dda");
        jLayeredPane2.add(lbl_rw_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 293, 30, 20));

        lbl_rt_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rt_dda.setText("lbl_rt_dda");
        jLayeredPane2.add(lbl_rt_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 297, 30, -1));

        lbl_nama_keluarga_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nama_keluarga_dda.setText("lbl_nama_keluarga_dda");
        jLayeredPane2.add(lbl_nama_keluarga_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 281, 380, -1));

        lbl_alamat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_alamat.setText("lbl_alamat");
        jLayeredPane2.add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 294, 210, 20));

        lbl_no_kk_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_kk_dda.setText("lbl_no_kk_dda");
        jLayeredPane2.add(lbl_no_kk_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 330, 20));

        lbl_no_surat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_surat.setText("lbl_no_surat");
        jLayeredPane2.add(lbl_no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 234, 150, 10));

        lbl_desa_kelurahan.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan.setText("lbl_desa_kelurahan");
        jLayeredPane2.add(lbl_desa_kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 172, 210, -1));

        lbl_desa_kelurahan_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan_dda.setText("lbl_desa_kelurahan_dda");
        jLayeredPane2.add(lbl_desa_kelurahan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 323, 140, 20));

        lbl_kecamatan_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kecamatan_dda.setText("lbl_kecamatan_dda");
        jLayeredPane2.add(lbl_kecamatan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 341, 150, 20));

        lbl_kodepos_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kodepos_dda.setText("lbl_kodepos_dda");
        jLayeredPane2.add(lbl_kodepos_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 361, 100, -1));

        lbl_nama_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nama_dda.setText("lbl_nama_dda");
        jLayeredPane2.add(lbl_nama_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 393, 370, 20));

        lbl_telepon_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_telepon_dda.setText("lbl_telepon_dda");
        jLayeredPane2.add(lbl_telepon_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 361, 140, -1));

        lbl_nik_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nik_dda.setText("lbl_nik_dda");
        jLayeredPane2.add(lbl_nik_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 340, -1));

        lbl_provinsi_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_provinsi_dda.setText("lbl_provinsi_dda");
        jLayeredPane2.add(lbl_provinsi_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 341, 150, 20));

        lbl_kab_kota_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kab_kota_dda.setText("lbl_kab_kota_dda");
        jLayeredPane2.add(lbl_kab_kota_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 324, 140, 20));

        lbl_dusun_dukuh_kampung_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dusun_dukuh_kampung_dda.setText("lbl_dusun_dukuh_kampung_dda");
        jLayeredPane2.add(lbl_dusun_dukuh_kampung_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 313, 290, 10));

        lbl_rt_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rt_ddt.setText("lbl_rt_ddt");
        jLayeredPane2.add(lbl_rt_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 30, 20));

        lbl_rw_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rw_ddt.setText("lbl_rw_ddt");
        jLayeredPane2.add(lbl_rw_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 30, 20));

        lbl_kab_kota_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kab_kota_ddt.setText("lbl_kab_kota_ddt");
        jLayeredPane2.add(lbl_kab_kota_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 554, 140, 10));

        lbl_alamat_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_alamat_ddt.setText("lbl_alamat_ddt");
        jLayeredPane2.add(lbl_alamat_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 210, 20));

        lbl_provinsi_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_provinsi_ddt.setText("lbl_provinsi_ddt");
        lbl_provinsi_ddt.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLayeredPane2.add(lbl_provinsi_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 561, 140, 20));

        lbl_kecamatan_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kecamatan_ddt.setText("lbl_kecamatan_ddt");
        jLayeredPane2.add(lbl_kecamatan_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 130, 10));

        lbl_desa_kelurahan_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan_ddt.setText("lbl_desa_kelurahan_ddt");
        jLayeredPane2.add(lbl_desa_kelurahan_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 554, 130, 10));

        lbl_tgl_sekarang.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_tgl_sekarang.setText("lbl_tgl_sekarang");
        lbl_tgl_sekarang.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane2.add(lbl_tgl_sekarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 710, 80, 20));

        lbl_dusun_dukuh_kampung_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dusun_dukuh_kampung_dkp.setText("lbl_dusun_dukuh_kampung_dkp");
        jLayeredPane2.add(lbl_dusun_dukuh_kampung_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 534, 290, 20));

        lbl_kode_desa_kelurahan.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kode_desa_kelurahan.setText("lbl_kode_desa_kelurahan");
        jLayeredPane2.add(lbl_kode_desa_kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 173, 120, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jLayeredPane2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 500, 110));

        lbl_status_kk_bagi_yg_pindah_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_status_kk_bagi_yg_pindah_ddt.setText("lbl_status_kk_bagi_yg_pindah_ddt");
        jLayeredPane2.add(lbl_status_kk_bagi_yg_pindah_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 442, -1, 10));

        lbl_tgl_kedatangan_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_tgl_kedatangan_ddt.setText("lbl_tgl_kedatangan_ddt");
        jLayeredPane2.add(lbl_tgl_kedatangan_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 503, 150, 20));

        lbl_nik_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nik_ddt.setText("lbl_nik_ddt");
        jLayeredPane2.add(lbl_nik_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 280, 20));

        lbl_no_kk_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_kk_ddt.setText("lbl_no_kk_ddt");
        jLayeredPane2.add(lbl_no_kk_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 458, 290, 10));

        lbl_nama_kepala_keluarga_ddt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nama_kepala_keluarga_ddt.setText("lbl_nama_kepala_keluarga_ddt");
        jLayeredPane2.add(lbl_nama_kepala_keluarga_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 380, -1));

        Temanggung.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Temanggung.setText("Temanggung");
        jLayeredPane2.add(Temanggung, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 710, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/1.32 kecil.jpg"))); // NOI18N
        jLayeredPane2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLayeredPane1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        jMenuItem1.setText("Print");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        cetak();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Temanggung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_alamat_ddt;
    private javax.swing.JLabel lbl_desa_kelurahan;
    private javax.swing.JLabel lbl_desa_kelurahan_dda;
    private javax.swing.JLabel lbl_desa_kelurahan_ddt;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung_dda;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung_dkp;
    private javax.swing.JLabel lbl_kab_kota_dda;
    private javax.swing.JLabel lbl_kab_kota_ddt;
    private javax.swing.JLabel lbl_kecamatan_dda;
    private javax.swing.JLabel lbl_kecamatan_ddt;
    private javax.swing.JLabel lbl_kode_desa_kelurahan;
    private javax.swing.JLabel lbl_kodepos_dda;
    private javax.swing.JLabel lbl_nama_dda;
    private javax.swing.JLabel lbl_nama_keluarga_dda;
    private javax.swing.JLabel lbl_nama_kepala_keluarga_ddt;
    private javax.swing.JLabel lbl_nik_dda;
    private javax.swing.JLabel lbl_nik_ddt;
    private javax.swing.JLabel lbl_no_kk_dda;
    private javax.swing.JLabel lbl_no_kk_ddt;
    private javax.swing.JLabel lbl_no_surat;
    private javax.swing.JLabel lbl_provinsi_dda;
    private javax.swing.JLabel lbl_provinsi_ddt;
    private javax.swing.JLabel lbl_rt_dda;
    private javax.swing.JLabel lbl_rt_ddt;
    private javax.swing.JLabel lbl_rw_dda;
    private javax.swing.JLabel lbl_rw_ddt;
    private javax.swing.JLabel lbl_status_kk_bagi_yg_pindah_ddt;
    private javax.swing.JLabel lbl_telepon_dda;
    private javax.swing.JLabel lbl_tgl_kedatangan_ddt;
    private javax.swing.JLabel lbl_tgl_sekarang;
    // End of variables declaration//GEN-END:variables
}
