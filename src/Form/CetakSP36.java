/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import Form.SuratPindah.*;
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
public class CetakSP36 extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form CetakSP36
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
    
        private void isiNamaPetugas(){
            try {
                int id_nama = MenuUtama.idpengguna;
                String sql = "select nama_admin from pengguna where id_pengguna = '"+id_nama+"' ";
                pst=conn.prepareStatement(sql);
                rs = pst.executeQuery();
            
                while(rs.next())
            {
                lbl_nama_petugas.setText(rs.getString(1));
            }
            }catch (Exception e) {
            }
        }
        
        private void isiOtomatisAtas(){
            lbl_no_surat.setText(SuratPindah.txt_no_surat_pindah.getText());
            lbl_desa_kelurahan.setText(SuratPindah.lbl_desa_kelurahan_dda.getText());
            lbl_dusun_dukuh_kampung.setText(SuratPindah.txt_dusun_dukuh_kampung_dda.getText());
        }
    
        private void isiOtomatisDDA(){
            lbl_no_kk_dda.setText(SuratPindah.txt_no_kk_dda.getText());
            lbl_nama_keluarga_dda.setText(SuratPindah.txt_nama_kepala_keluarga.getText());
            lbl_alamat.setText(SuratPindah.lbl_alamat_dda.getText());
            lbl_rt_dda.setText(SuratPindah.lbl_rt_dda.getText());
            lbl_rw_dda.setText(SuratPindah.lbl_rw_dda.getText());
            lbl_dusun_dukuh_kampung_dda.setText(SuratPindah.txt_dusun_dukuh_kampung_dda.getText());
            lbl_desa_kelurahan_dda.setText(SuratPindah.lbl_desa_kelurahan_dda.getText());
            lbl_kodepos_dda.setText(SuratPindah.txt_kodepos_dda.getText());
            lbl_telepon_dda.setText(SuratPindah.txt_telepon_dda.getText());
            lbl_kecamatan_dda.setText(SuratPindah.lbl_kecamatan_dda.getText());
            lbl_kab_kota_dda.setText(SuratPindah.lbl_kab_kota_dda.getText());
            lbl_provinsi_dda.setText(SuratPindah.lbl_provinsi_dda.getText());
            lbl_nik_dda.setText(SuratPindah.txt_nik_dda.getText());
            lbl_nama_dda.setText(SuratPindah.lbl_nama_dda.getText());
        }
        
        private void isiOtomatisDKP(){
            String no_alasan_pindah;
            if (SuratPindah.alasan_pindah=="Pekerjaan") {
                lbl_no_alasan_pindah.setText("1");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else if (SuratPindah.alasan_pindah=="Pendidikan") {
                lbl_no_alasan_pindah.setText("2");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else if (SuratPindah.alasan_pindah=="Keamanan") {
                lbl_no_alasan_pindah.setText("3");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else if (SuratPindah.alasan_pindah=="Kesehatan") {
                lbl_no_alasan_pindah.setText("4");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else if (SuratPindah.alasan_pindah=="Perumahan") {
                lbl_no_alasan_pindah.setText("5");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else if (SuratPindah.alasan_pindah=="Keluarga") {
                lbl_no_alasan_pindah.setText("6");
                lbl_alasan_lainnya.setVisible(false);
            } 
            else {
                lbl_no_alasan_pindah.setText("7");
                lbl_alasan_lainnya.setVisible(true);
                lbl_alasan_lainnya.setText(SuratPindah.txt_lainnya.getText());
            }
 
            lbl_alamat_tujuan_pindah.setText(SuratPindah.txt_alamat_tujuan_pindah_dkp.getText());
            lbl_rt_dkp.setText(SuratPindah.txt_rt_dkp.getText());
            lbl_rw_dkp.setText(SuratPindah.txt_rw_dkp.getText());
            lbl_dusun_dukuh_kampung_dkp.setText(SuratPindah.txt_dusun_dukuh_kampung_dkp.getText());
            lbl_desa_kelurahan_dkp.setText(SuratPindah.txt_desa_kelurahan_dkp.getText());
            lbl_kecamatan_dkp.setText(SuratPindah.txt_kecamatan_dkp.getText());
            lbl_kab_kota_dkp.setText(SuratPindah.txt_kab_kota_dkp.getText());
            lbl_provinsi_dkp.setText(SuratPindah.txt_provinsi_dkp.getText());
            lbl_telepon_dkp.setText(SuratPindah.txt_telepon_dkp.getText());
            lbl_kodepos_dkp.setText(SuratPindah.txt_kodepos_dkp.getText());
            
            if (SuratPindah.jenis_kepindahan=="Kep.Keluarga") {
                lbl_no_jenis_kepindahan_dkp.setText("1");
            } 
            else if (SuratPindah.jenis_kepindahan=="Kep.Keluarga dan Seluruh Angg. Keluarga") {
                lbl_no_jenis_kepindahan_dkp.setText("2");
            } 
            else if (SuratPindah.jenis_kepindahan=="Kep.Keluarga dan Sbg. Angg. Keluarga") {
                lbl_no_jenis_kepindahan_dkp.setText("3");
            } 
            else {
                lbl_no_jenis_kepindahan_dkp.setText("4");
            }
            
            if (SuratPindah.status_kk_bagi_yg_tdk_pindah=="Numpang KK") {
                lbl_status_kk_bagi_yg_tdk_pindah_dkp.setText("1");
            } 
            else if (SuratPindah.status_kk_bagi_yg_tdk_pindah=="Membuat KK Baru") {
                lbl_status_kk_bagi_yg_tdk_pindah_dkp.setText("2");
            } 
            else {
                lbl_status_kk_bagi_yg_tdk_pindah_dkp.setText("3");
            }
            
            if (SuratPindah.status_kk_bagi_yg_pindah=="Numpang KK") {
                lbl_status_kk_bagi_yg_pindah_dkp.setText("1");
            } 
            else if (SuratPindah.status_kk_bagi_yg_pindah=="Membuat KK Baru") {
                lbl_status_kk_bagi_yg_pindah_dkp.setText("2");
            } 
            else {
                lbl_status_kk_bagi_yg_pindah_dkp.setText("3");
            }
            
            lbl_tgl_sekarang.setText(MenuUtama.lblTanggal.getText());
        }

        private void UpdateTabelCetakSPD(){
    try
        {
            String z = SuratPindah.lbl_id_daftar_kyp.getText();
                    
            String SQL = "SELECT no_kyp AS  'No.', nik_kyp AS  'NIK', nama_kyp AS  'Nama', masa_berlaku_ktp_kyp AS  'Masa Berlaku KTP S/D',  `shdk_kyp` AS  'SHDK'" +
                         "FROM keluarga_yang_pindah " +
                         " where id_daftar_kyp = '"+z+"' ";
            pst=conn.prepareStatement(SQL);
            rs = pst.executeQuery(SQL);
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
   }
}
        
    public CetakSP36() {
        initComponents();
        conn = KoneksiDB.ConnectDb(); 
        tinggiBaris();
        isiKodeDesaKelurahan();
        isiNamaPetugas();
        isiOtomatisAtas();
        isiOtomatisDDA();
        isiOtomatisDKP();
        UpdateTabelCetakSPD();
        lbl_pemohon.setText(SuratPindahDatang.lbl_nama_dda.getText());
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
        lbl_rt_dkp = new javax.swing.JLabel();
        lbl_rw_dkp = new javax.swing.JLabel();
        lbl_kab_kota_dkp = new javax.swing.JLabel();
        lbl_alamat_tujuan_pindah = new javax.swing.JLabel();
        lbl_alasan_lainnya = new javax.swing.JLabel();
        lbl_provinsi_dkp = new javax.swing.JLabel();
        lbl_telepon_dkp = new javax.swing.JLabel();
        lbl_kecamatan_dkp = new javax.swing.JLabel();
        lbl_desa_kelurahan_dkp = new javax.swing.JLabel();
        lbl_no_jenis_kepindahan_dkp = new javax.swing.JLabel();
        lbl_status_kk_bagi_yg_tdk_pindah_dkp = new javax.swing.JLabel();
        lbl_tgl_sekarang = new javax.swing.JLabel();
        lbl_dusun_dukuh_kampung_dkp = new javax.swing.JLabel();
        lbl_kodepos_dkp = new javax.swing.JLabel();
        lbl_kode_desa_kelurahan = new javax.swing.JLabel();
        lbl_no_alasan_pindah = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_status_kk_bagi_yg_pindah_dkp = new javax.swing.JLabel();
        Temanggung = new javax.swing.JLabel();
        lbl_nama_petugas = new javax.swing.JLabel();
        lbl_pemohon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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
        jLayeredPane2.add(lbl_dusun_dukuh_kampung, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 154, 320, 20));

        lbl_rw_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rw_dda.setText("lbl_rw_dda");
        jLayeredPane2.add(lbl_rw_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 30, 20));

        lbl_rt_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rt_dda.setText("lbl_rt_dda");
        jLayeredPane2.add(lbl_rt_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 30, 20));

        lbl_nama_keluarga_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nama_keluarga_dda.setText("lbl_nama_keluarga_dda");
        jLayeredPane2.add(lbl_nama_keluarga_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 263, 380, 20));

        lbl_alamat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_alamat.setText("lbl_alamat");
        jLayeredPane2.add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 220, 20));

        lbl_no_kk_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_kk_dda.setText("lbl_no_kk_dda");
        jLayeredPane2.add(lbl_no_kk_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 330, 10));

        lbl_no_surat.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_surat.setText("lbl_no_surat");
        jLayeredPane2.add(lbl_no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 150, 10));

        lbl_desa_kelurahan.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan.setText("lbl_desa_kelurahan");
        jLayeredPane2.add(lbl_desa_kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 134, 210, 20));

        lbl_desa_kelurahan_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan_dda.setText("lbl_desa_kelurahan_dda");
        jLayeredPane2.add(lbl_desa_kelurahan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 309, 140, 20));

        lbl_kecamatan_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kecamatan_dda.setText("lbl_kecamatan_dda");
        jLayeredPane2.add(lbl_kecamatan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 321, 150, 30));

        lbl_kodepos_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kodepos_dda.setText("lbl_kodepos_dda");
        jLayeredPane2.add(lbl_kodepos_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 343, -1, 20));

        lbl_nama_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nama_dda.setText("lbl_nama_dda");
        jLayeredPane2.add(lbl_nama_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 379, 370, 20));

        lbl_telepon_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_telepon_dda.setText("lbl_telepon_dda");
        jLayeredPane2.add(lbl_telepon_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 343, 140, 20));

        lbl_nik_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_nik_dda.setText("lbl_nik_dda");
        jLayeredPane2.add(lbl_nik_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 363, 350, 20));

        lbl_provinsi_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_provinsi_dda.setText("lbl_provinsi_dda");
        jLayeredPane2.add(lbl_provinsi_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 321, 150, 30));

        lbl_kab_kota_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kab_kota_dda.setText("lbl_kab_kota_dda");
        jLayeredPane2.add(lbl_kab_kota_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 20));

        lbl_dusun_dukuh_kampung_dda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dusun_dukuh_kampung_dda.setText("lbl_dusun_dukuh_kampung_dda");
        jLayeredPane2.add(lbl_dusun_dukuh_kampung_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 299, 290, 10));

        lbl_rt_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rt_dkp.setText("lbl_rt_dkp");
        jLayeredPane2.add(lbl_rt_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 433, 30, 20));

        lbl_rw_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_rw_dkp.setText("lbl_rw_dkp");
        jLayeredPane2.add(lbl_rw_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 433, 30, 20));

        lbl_kab_kota_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kab_kota_dkp.setText("lbl_kab_kota_dkp");
        jLayeredPane2.add(lbl_kab_kota_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 464, 150, 20));

        lbl_alamat_tujuan_pindah.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_alamat_tujuan_pindah.setText("lbl_alamat_tujuan_pindah");
        jLayeredPane2.add(lbl_alamat_tujuan_pindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 438, 210, 10));

        lbl_alasan_lainnya.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbl_alasan_lainnya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_alasan_lainnya.setText("lbl_alasan_lainnya");
        lbl_alasan_lainnya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane2.add(lbl_alasan_lainnya, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 419, 60, 20));

        lbl_provinsi_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_provinsi_dkp.setText("lbl_provinsi_dkp");
        jLayeredPane2.add(lbl_provinsi_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 150, 20));

        lbl_telepon_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_telepon_dkp.setText("lbl_telepon_dkp");
        jLayeredPane2.add(lbl_telepon_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 491, 150, 30));

        lbl_kecamatan_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kecamatan_dkp.setText("lbl_kecamatan_dkp");
        jLayeredPane2.add(lbl_kecamatan_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 150, 20));

        lbl_desa_kelurahan_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_desa_kelurahan_dkp.setText("lbl_desa_kelurahan_dkp");
        jLayeredPane2.add(lbl_desa_kelurahan_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 464, 160, 20));

        lbl_no_jenis_kepindahan_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_jenis_kepindahan_dkp.setText("lbl_no_jenis_kepindahan_dkp");
        jLayeredPane2.add(lbl_no_jenis_kepindahan_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 140, 10));

        lbl_status_kk_bagi_yg_tdk_pindah_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_status_kk_bagi_yg_tdk_pindah_dkp.setText("lbl_status_kk_bagi_yg_tdk_pindah_dkp");
        jLayeredPane2.add(lbl_status_kk_bagi_yg_tdk_pindah_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 180, 10));

        lbl_tgl_sekarang.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_tgl_sekarang.setText("lbl_tgl_sekarang");
        jLayeredPane2.add(lbl_tgl_sekarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 730, 80, -1));

        lbl_dusun_dukuh_kampung_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_dusun_dukuh_kampung_dkp.setText("lbl_dusun_dukuh_kampung_dkp");
        lbl_dusun_dukuh_kampung_dkp.setToolTipText("");
        lbl_dusun_dukuh_kampung_dkp.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_dusun_dukuh_kampung_dkp.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLayeredPane2.add(lbl_dusun_dukuh_kampung_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 452, 290, 20));

        lbl_kodepos_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kodepos_dkp.setText("lbl_kodepos_dkp");
        jLayeredPane2.add(lbl_kodepos_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 491, 100, 30));

        lbl_kode_desa_kelurahan.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_kode_desa_kelurahan.setText("lbl_kode_desa_kelurahan");
        jLayeredPane2.add(lbl_kode_desa_kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 134, 90, 20));

        lbl_no_alasan_pindah.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_no_alasan_pindah.setText("lbl_no_alasan_pindah");
        jLayeredPane2.add(lbl_no_alasan_pindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 100, 30));

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

        jLayeredPane2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 500, 110));

        lbl_status_kk_bagi_yg_pindah_dkp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbl_status_kk_bagi_yg_pindah_dkp.setText("lbl_status_kk_bagi_yg_pindah_dkp");
        jLayeredPane2.add(lbl_status_kk_bagi_yg_pindah_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 568, -1, -1));

        Temanggung.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Temanggung.setText("Temanggung");
        jLayeredPane2.add(Temanggung, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 728, 60, -1));

        lbl_nama_petugas.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbl_nama_petugas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nama_petugas.setText("jLabel2");
        jLayeredPane2.add(lbl_nama_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 790, 100, 20));

        lbl_pemohon.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lbl_pemohon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_pemohon.setText("jLabel3");
        jLayeredPane2.add(lbl_pemohon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 784, 100, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/1.36 kecil.jpg"))); // NOI18N
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        cetak();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menutup Cetak Surat Pindah F-1.36?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
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
    private javax.swing.JLabel lbl_alamat_tujuan_pindah;
    private javax.swing.JLabel lbl_alasan_lainnya;
    private javax.swing.JLabel lbl_desa_kelurahan;
    private javax.swing.JLabel lbl_desa_kelurahan_dda;
    private javax.swing.JLabel lbl_desa_kelurahan_dkp;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung_dda;
    private javax.swing.JLabel lbl_dusun_dukuh_kampung_dkp;
    private javax.swing.JLabel lbl_kab_kota_dda;
    private javax.swing.JLabel lbl_kab_kota_dkp;
    private javax.swing.JLabel lbl_kecamatan_dda;
    private javax.swing.JLabel lbl_kecamatan_dkp;
    private javax.swing.JLabel lbl_kode_desa_kelurahan;
    private javax.swing.JLabel lbl_kodepos_dda;
    private javax.swing.JLabel lbl_kodepos_dkp;
    private javax.swing.JLabel lbl_nama_dda;
    private javax.swing.JLabel lbl_nama_keluarga_dda;
    private javax.swing.JLabel lbl_nama_petugas;
    private javax.swing.JLabel lbl_nik_dda;
    private javax.swing.JLabel lbl_no_alasan_pindah;
    private javax.swing.JLabel lbl_no_jenis_kepindahan_dkp;
    private javax.swing.JLabel lbl_no_kk_dda;
    private javax.swing.JLabel lbl_no_surat;
    private javax.swing.JLabel lbl_pemohon;
    private javax.swing.JLabel lbl_provinsi_dda;
    private javax.swing.JLabel lbl_provinsi_dkp;
    private javax.swing.JLabel lbl_rt_dda;
    private javax.swing.JLabel lbl_rt_dkp;
    private javax.swing.JLabel lbl_rw_dda;
    private javax.swing.JLabel lbl_rw_dkp;
    private javax.swing.JLabel lbl_status_kk_bagi_yg_pindah_dkp;
    private javax.swing.JLabel lbl_status_kk_bagi_yg_tdk_pindah_dkp;
    private javax.swing.JLabel lbl_telepon_dda;
    private javax.swing.JLabel lbl_telepon_dkp;
    private javax.swing.JLabel lbl_tgl_sekarang;
    // End of variables declaration//GEN-END:variables
}
