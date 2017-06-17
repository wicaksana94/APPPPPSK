/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import static Form.Pendaftar.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Arya Wicaksana
 */

public class SuratPindah extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public static String alasan_pindah;
    public static String jenis_kepindahan;
    public static String status_kk_bagi_yg_tdk_pindah,status_kk_bagi_yg_pindah;
    
    /**
     * Creates new form SuratPindah
     */

    private void cekIsiSuratPindah(){
    if ( (txt_no_surat_pindah.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "No. Surat harus diisi","[ PERHATIAN ]",2);
		}
    
        else if ( (txt_no_kk_dda.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "No. KK pada Data Daerah Asal harus diisi","[ PERHATIAN ]",2);
		}
                
        else if ( (txt_nama_kepala_keluarga.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "Nama Kepala Keluarga pada Data Daerah Asal harus diisi","[ PERHATIAN ]",2);
		}
        
        else if ( (txt_dusun_dukuh_kampung_dda.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "Dusun/Dukuh/Kampung pada Data Daerah Asal harus diisi","[ PERHATIAN ]",2);
		}
        
        else if ( (txt_kodepos_dda.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "Kodepos pada Data Daerah Asal harus diisi","[ PERHATIAN ]",2);
		}
	
        else if ( (txt_nik_dda.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "NIK Pemohon pada Data Daerah Asal harus diisi","[ PERHATIAN ]",2);
		}
        
	else if		(alasan_pindah==null){
		JOptionPane.showMessageDialog(null, "Alasan Pindah pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
                }
	
	else if		(txt_alamat_tujuan_pindah_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Alamat Tujuan Pindah pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
	
        else if		(txt_rt_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "RT pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_rw_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "RW pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
	else if		(txt_dusun_dukuh_kampung_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Dusun/Dukuh/Kampung pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_desa_kelurahan_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Desa/Kelurahan pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_kecamatan_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Kecamatan pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_kab_kota_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Kabupaten/Kota pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_provinsi_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Provinsi pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
		
        else if		(txt_kodepos_dkp.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Kodepos pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
						
	else if		(jenis_kepindahan==null){
		JOptionPane.showMessageDialog(null, "Jenis Kepindahan pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
	        
        else if		(status_kk_bagi_yg_pindah==null){
		JOptionPane.showMessageDialog(null, "Status KK Bagi Yang Pindah pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
        
        else if		(status_kk_bagi_yg_tdk_pindah==null){
		JOptionPane.showMessageDialog(null, "Status KK Bagi Yang Tidak Pindah pada Data Kepindahan harus diisi","[ PERHATIAN ]",2);
		}
}
    
    private void batasanInput() {
        txt_nik_dda.setDocument(new batasInput((byte)16).getOnlyNumber(txt_nik_dda));
        txt_no_kk_dda.setDocument(new batasInput((byte)16).getOnlyNumber(txt_no_kk_dda));
        txt_kodepos_dda.setDocument(new batasInput((byte)5).getOnlyNumber(txt_kodepos_dda));
        txt_telepon_dda.setDocument(new batasInput((byte)7).getOnlyNumber(txt_telepon_dda));
        txt_rt_dkp.setDocument(new batasInput((byte)2).getOnlyNumber(txtRT));
        txt_rw_dkp.setDocument(new batasInput((byte)2).getOnlyNumber(txtRW));
        txt_kodepos_dkp.setDocument(new batasInput((byte)5).getOnlyNumber(txt_kodepos_dkp));
        txt_telepon_dkp.setDocument(new batasInput((byte)7).getOnlyNumber(txt_telepon_dkp));
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
    
    private void isiOtomatis_dda(){
    lbl_alamat_dda.setText(Pendaftar.txtalamat.getText());
    lbl_desa_kelurahan_dda.setText((String) Pendaftar.cbdesakelurahan.getSelectedItem());
    lbl_rt_dda.setText(Pendaftar.txtRT.getText());
    lbl_rw_dda.setText(Pendaftar.txtRW.getText());
    lbl_nama_dda.setText(Pendaftar.txtnama.getText());
    lbl_id_daftar_kyp.setText(KeluargaYangPindah.lbl_id_daftar_kyp.getText());
    }
    
    private void Isilblopsiantar(){
        if (Pendaftaran.cb_opsi_sp.getSelectedItem()=="Antar Kecamatan dalam Satu Kabupaten") {
           lblopsiantar.setText("Antar Kecamatan dalam Satu Kabupaten");  
        }
        else {
           lblopsiantar.setText("Antar Kota/Kabupaten atau Antar Provinsi");   
        }
    }

    private void pilihanCetak(){
        if (lblopsiantar.getText().equals("Antar Kecamatan dalam Satu Kabupaten")) {
             CetakSP30 x = new CetakSP30();
             x.setVisible(true);
        }
        else {
           CetakSP35 y = new CetakSP35();
           y.setVisible(true);
            
           CetakSP36 z = new CetakSP36();
           z.setVisible(true);
        }
    }
    
    private void isi_Id_DDA(){
        try
       {
            String Sql = "select max(id_dda) from data_daerah_asal";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_dda.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_dda.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_dda.setText(siap);
            }
       }
catch (Exception e)
{String dda;
        dda="1";
    lbl_id_dda.setText(dda);
    System.out.println(e);
}
    }
    
    private void isi_Id_DKP(){
      try
       {
            String Sql = "select max(id_dkp) from data_kepindahan";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_dkp.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_dkp.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_dkp.setText(siap);
            }
       }
catch (Exception e)
{String dkp;
        dkp="1";
    lbl_id_dkp.setText(dkp);
    System.out.println(e);
}  
    }
    
    
    private void IsiOtomatis(){
        txtRT.setText(txtRT.getText());
        txtRW.setText(txtRW.getText());
        txtnama.setText(txtnama.getText());
        txtalamat.setText(txtalamat.getText());
        Isilblopsiantar();
        /*txtktprt.setText(txtRT.getText());
        txtktprw.setText(txtRW.getText());*/
        
    }

    private void IsiKodeForm(){
        if (Pendaftaran.cb_opsi_sp.getSelectedItem()=="Antar Kecamatan dalam Satu Kabupaten"){
            lbl_kode_form.setText("F-1.30");
            txt_kab_kota_dkp.setText("Temanggung");
            txt_provinsi_dkp.setText("Jawa Tengah");
        }
        else {
        lbl_kode_form.setText("F-1.35 dan F-1.36");}
    }
  
    private void MasukkanDDA(){
        try
        {   
            String Sql = "insert into data_daerah_asal (id_dda, no_kk, nama_kepala_keluarga, alamat_dda,"
                    + " rt_dda, rw_dda, dusun_dukuh_kampung_dda, desa_kelurahan_dda, kecamatan_dda, "
                    + "kab_kota_dda, provinsi_dda, kodepos_dda, telepon_dda, NIK_pemohon_dda, nama_dda, "
                    + "id_pendaftar, id_pendaftaran) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, Integer.parseInt(lbl_id_dda.getText()));
            pst.setString(2, txt_no_kk_dda.getText());
            pst.setString(3, txt_nama_kepala_keluarga.getText());
            pst.setString(4, lbl_alamat_dda.getText());
            pst.setInt(5, Integer.parseInt(lbl_rt_dda.getText()));
            pst.setInt(6, Integer.parseInt(lbl_rw_dda.getText()));
            pst.setString(7, txt_dusun_dukuh_kampung_dda.getText());
            pst.setString(8, lbl_desa_kelurahan_dda.getText());
            pst.setString(9, lbl_kecamatan_dda.getText());
            pst.setString(10, lbl_kab_kota_dda.getText());
            pst.setString(11, lbl_provinsi_dda.getText());
            pst.setString(12, txt_kodepos_dda.getText());
            pst.setString(13, txt_telepon_dda.getText());
            pst.setString(14, txt_nik_dda.getText());
            pst.setString(15, lbl_nama_dda.getText());
            pst.setString(16, Pendaftar.lbl_id_pendaftar.getText());
            pst.setString(17, Pendaftaran.lbl_id_pendaftaran.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);
           
            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "DDA tidak bisa diinputkan."); 
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void MasukkanDKP(){
           try
        {   
            String Sql = "insert into data_kepindahan (id_dkp, alasan_pindah_dkp, alamat_tujuan_pindah_dkp,"
                    + " rt_dkp, rw_dkp, dusun_dukuh_kampung_dkp, desa_kelurahan_dkp, kecamatan_dkp, kab_kota_dkp,"
                    + " provinsi_dkp, kodepos_dkp, telepon_dkp, jenis_kepindahan_dkp, statuskk_yg_tdk_pindah_dkp, "
                    + "statuskk_yg_pindah_dkp, id_pendaftar, id_pendaftaran) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, Integer.parseInt(lbl_id_dkp.getText()));
            pst.setString(2, alasan_pindah);
            pst.setString(3, txt_alamat_tujuan_pindah_dkp.getText());
            pst.setInt(4, Integer.parseInt(txt_rt_dkp.getText()));
            pst.setInt(5, Integer.parseInt(txt_rw_dkp.getText()));
            pst.setString(6, txt_dusun_dukuh_kampung_dkp.getText());
            pst.setString(7, txt_desa_kelurahan_dkp.getText());
            pst.setString(8, txt_kecamatan_dkp.getText());
            pst.setString(9, txt_kab_kota_dkp.getText());
            pst.setString(10, txt_provinsi_dkp.getText());
            pst.setString(11, txt_kodepos_dkp.getText());
            pst.setString(12, txt_telepon_dkp.getText());
            pst.setString(13, jenis_kepindahan);
            pst.setString(14, status_kk_bagi_yg_tdk_pindah);
            pst.setString(15, status_kk_bagi_yg_pindah);
            pst.setString(16, Pendaftar.lbl_id_pendaftar.getText());
            pst.setString(17, Pendaftaran.lbl_id_pendaftaran.getText());
            
           
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);

            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "DKP tidak bisa diinputkan.");
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e.getErrorCode());
        }   
    }
    
    
    private void MasukkanSuratPindah() {
       try
        {   
            String Sql = "insert into surat_pindah (id_surat_pindah, kode_form, no_surat_pindah,"
                    + " provinsi, kab_kota, kecamatan, dusun_dukuh_kampung, desa_kelurahan, "
                    + "id_dda, id_dkp, id_pendaftar, id_pendaftaran, id_daftar_kyp, id_desa_kelurahan) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setString(2, lbl_kode_form.getText());
            pst.setString(3, txt_no_surat_pindah.getText());
            pst.setString(4, lbl_provinsi_dda.getText());
            pst.setString(5, lbl_kab_kota_dda.getText());
            pst.setString(6, lbl_kecamatan_dda.getText());
            pst.setString(7, txt_dusun_dukuh_kampung_dda.getText());
            pst.setString(8, lbl_desa_kelurahan_dda.getText());
            pst.setInt(9, Integer.parseInt(lbl_id_dda.getText()));
            pst.setInt(10, Integer.parseInt(lbl_id_dkp.getText()));
            pst.setInt(11, Integer.parseInt(Pendaftar.lbl_id_pendaftar.getText()));
            pst.setInt(12, Integer.parseInt(DapatkanId_daftar_kyp.lbl_no_pendaftaran.getText()));
            pst.setInt(13, Integer.parseInt(KeluargaYangPindah.lbl_id_daftar_kyp.getText()));
            pst.setInt(14, Integer.parseInt(lbl_kode_desa_kelurahan.getText()));
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);

            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Surat Pindah tidak bisa diinputkan.");
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    public SuratPindah() {
        initComponents();
        conn = KoneksiDB.ConnectDb();
        IsiOtomatis();
        isiKodeDesaKelurahan();
        IsiKodeForm();
        isi_Id_DDA();
        isi_Id_DKP();
        isiOtomatis_dda();
        setSize(1113, 640);
        dda.setVisible(false);
        dkp.setVisible(false);
        jLabel10.setText("Form ini diisi oleh "+jabatan+" "+idpengguna);
        batasanInput();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_alasan_pindah_dkp = new javax.swing.ButtonGroup();
        bg_status_kk_yg_tdk_pindah_dkp = new javax.swing.ButtonGroup();
        bg_status_kk_yg_pindah_dkp = new javax.swing.ButtonGroup();
        bg_jenis_kepindahan_dkp = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        btnktpcetak = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblopsiantar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_telepon_dkp = new javax.swing.JTextField();
        txt_kodepos_dkp = new javax.swing.JTextField();
        txt_dusun_dukuh_kampung_dkp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        txt_lainnya = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        membuat_kk_baru_1 = new javax.swing.JRadioButton();
        numpang_kk_1 = new javax.swing.JRadioButton();
        nomor_kk_tetap_1 = new javax.swing.JRadioButton();
        nomor_kk_tetap_2 = new javax.swing.JRadioButton();
        numpang_kk_2 = new javax.swing.JRadioButton();
        membuat_kk_baru_2 = new javax.swing.JRadioButton();
        txt_desa_kelurahan_dkp = new javax.swing.JTextField();
        txt_kecamatan_dkp = new javax.swing.JTextField();
        txt_kab_kota_dkp = new javax.swing.JTextField();
        txt_provinsi_dkp = new javax.swing.JTextField();
        txt_rt_dkp = new javax.swing.JTextField();
        txt_rw_dkp = new javax.swing.JTextField();
        txt_alamat_tujuan_pindah_dkp = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_alamat_dda = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbl_nama_dda = new javax.swing.JLabel();
        lbl_rt_dda = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbl_rw_dda = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_telepon_dda = new javax.swing.JTextField();
        lbl_kab_kota_dda = new javax.swing.JLabel();
        lbl_provinsi_dda = new javax.swing.JLabel();
        lbl_kecamatan_dda = new javax.swing.JLabel();
        lbl_desa_kelurahan_dda = new javax.swing.JLabel();
        txt_kodepos_dda = new javax.swing.JTextField();
        txt_no_kk_dda = new javax.swing.JTextField();
        txt_dusun_dukuh_kampung_dda = new javax.swing.JTextField();
        txt_nik_dda = new javax.swing.JTextField();
        txt_nama_kepala_keluarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_kode_desa_kelurahan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_id_daftar_kyp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_kode_form = new javax.swing.JLabel();
        dda = new javax.swing.JButton();
        dkp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_id_dkp = new javax.swing.JLabel();
        lbl_id_dda = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, -1, -1));

        btnktpcetak.setText("Cetak");
        btnktpcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnktpcetakActionPerformed(evt);
            }
        });
        getContentPane().add(btnktpcetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 560, -1, -1));

        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel1.setText("Surat Pindah");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        lblopsiantar.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        lblopsiantar.setText("xxxxxxxx xxxxxxxxx");
        getContentPane().add(lblopsiantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Kepindahan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Alamat tujuan Pindah :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("RT :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("RW :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Dusun/Dukuh/Kampung :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Desa/Kelurahan :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Kecamatan :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Kab/Kota :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Provinsi :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Kode Pos :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Telepon :");

        txt_telepon_dkp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setText("Alasan Pindah :");

        bg_alasan_pindah_dkp.add(jRadioButton1);
        jRadioButton1.setText("Pekerjaan");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton2);
        jRadioButton2.setText("Pendidikan");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton3);
        jRadioButton3.setText("Keamanan");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton4);
        jRadioButton4.setText("Kesehatan");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton5);
        jRadioButton5.setText("Perumahan");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton6);
        jRadioButton6.setText("Keluarga");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        bg_alasan_pindah_dkp.add(jRadioButton7);
        jRadioButton7.setText("Lainnya, sebutkan");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        txt_lainnya.setEnabled(false);
        txt_lainnya.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_lainnyaFocusLost(evt);
            }
        });

        jLabel3.setText("Jenis Kepindahan :");

        bg_jenis_kepindahan_dkp.add(jRadioButton8);
        jRadioButton8.setText("Kep.Keluarga");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        bg_jenis_kepindahan_dkp.add(jRadioButton9);
        jRadioButton9.setText("Kep.Keluarga dan Seluruh Anggota Keluarga");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        bg_jenis_kepindahan_dkp.add(jRadioButton10);
        jRadioButton10.setText("Kep.Keluarga dan Sbg. Angg. Keluarga");
        jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton10ActionPerformed(evt);
            }
        });

        bg_jenis_kepindahan_dkp.add(jRadioButton11);
        jRadioButton11.setText("Anggota Keluarga");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });

        jLabel4.setText("Status KK Bagi Yang Tidak Pindah :");

        jLabel5.setText("Status KK Bagi Yang Pindah :");

        bg_status_kk_yg_tdk_pindah_dkp.add(membuat_kk_baru_1);
        membuat_kk_baru_1.setText("Membuat KK Baru");
        membuat_kk_baru_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membuat_kk_baru_1ActionPerformed(evt);
            }
        });

        bg_status_kk_yg_tdk_pindah_dkp.add(numpang_kk_1);
        numpang_kk_1.setText("Numpang KK");
        numpang_kk_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numpang_kk_1ActionPerformed(evt);
            }
        });

        bg_status_kk_yg_tdk_pindah_dkp.add(nomor_kk_tetap_1);
        nomor_kk_tetap_1.setText("Nomor KK Tetap");
        nomor_kk_tetap_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomor_kk_tetap_1ActionPerformed(evt);
            }
        });

        bg_status_kk_yg_pindah_dkp.add(nomor_kk_tetap_2);
        nomor_kk_tetap_2.setText("Nomor KK Tetap");
        nomor_kk_tetap_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomor_kk_tetap_2ActionPerformed(evt);
            }
        });

        bg_status_kk_yg_pindah_dkp.add(numpang_kk_2);
        numpang_kk_2.setText("Numpang KK");
        numpang_kk_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numpang_kk_2ActionPerformed(evt);
            }
        });

        bg_status_kk_yg_pindah_dkp.add(membuat_kk_baru_2);
        membuat_kk_baru_2.setText("Membuat KK Baru");
        membuat_kk_baru_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membuat_kk_baru_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(8, 8, 8)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_lainnya, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_alamat_tujuan_pindah_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_rt_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton9)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_telepon_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_kodepos_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rw_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_dusun_dukuh_kampung_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desa_kelurahan_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kecamatan_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_kab_kota_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_provinsi_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(16, 16, 16)
                            .addComponent(numpang_kk_1)
                            .addGap(18, 18, 18)
                            .addComponent(membuat_kk_baru_1)
                            .addGap(18, 18, 18)
                            .addComponent(nomor_kk_tetap_1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numpang_kk_2)
                            .addGap(18, 18, 18)
                            .addComponent(membuat_kk_baru_2)
                            .addGap(18, 18, 18)
                            .addComponent(nomor_kk_tetap_2))))
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(txt_lainnya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_alamat_tujuan_pindah_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_rt_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txt_rw_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txt_dusun_dukuh_kampung_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_desa_kelurahan_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(txt_kecamatan_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txt_kab_kota_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txt_provinsi_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton10)
                            .addComponent(jRadioButton11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_kodepos_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_telepon_dkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33)))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(membuat_kk_baru_1)
                    .addComponent(numpang_kk_1)
                    .addComponent(nomor_kk_tetap_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numpang_kk_2)
                    .addComponent(membuat_kk_baru_2)
                    .addComponent(nomor_kk_tetap_2))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1050, 280));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("No.Surat :");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, 20));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Daerah Asal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_alamat_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_alamat_dda.setText("alamat");
        lbl_alamat_dda.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(lbl_alamat_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 54, 305, 20));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Nama :");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 20));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Alamat :");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 51, -1, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("No.KK :");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 50, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("NIK Pemohon :");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        lbl_nama_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_nama_dda.setText("nama");
        jPanel4.add(lbl_nama_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 290, 20));

        lbl_rt_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rt_dda.setText("xxx");
        jPanel4.add(lbl_rt_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("RT :");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 80, -1, -1));

        lbl_rw_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rw_dda.setText("xxx");
        jPanel4.add(lbl_rw_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 80, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("RW :");
        jPanel4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 80, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Dusun/Dukuh/Kampung :");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 53, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Desa/Kelurahan :");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Kecamatan :");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Kab/Kota :");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Provinsi :");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Kode Pos :");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 77, -1, 20));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("Telepon :");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 80, -1, -1));

        txt_telepon_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(txt_telepon_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 77, 110, -1));

        lbl_kab_kota_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_kab_kota_dda.setText("Temanggung");
        jPanel4.add(lbl_kab_kota_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        lbl_provinsi_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_provinsi_dda.setText("Jawa Tengah");
        jPanel4.add(lbl_provinsi_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        lbl_kecamatan_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_kecamatan_dda.setText("Temanggung");
        jPanel4.add(lbl_kecamatan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        lbl_desa_kelurahan_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_desa_kelurahan_dda.setText("lbl_desa_kelurahan_dda");
        jPanel4.add(lbl_desa_kelurahan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, -1, -1));
        jPanel4.add(txt_kodepos_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 78, 80, -1));
        jPanel4.add(txt_no_kk_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 21, 230, -1));
        jPanel4.add(txt_dusun_dukuh_kampung_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 51, 251, -1));
        jPanel4.add(txt_nik_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 149, -1));
        jPanel4.add(txt_nama_kepala_keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 21, 180, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nama Kepala Keluarga :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        lbl_kode_desa_kelurahan.setText("kode desa kelurahan");
        jPanel4.add(lbl_kode_desa_kelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        jLabel12.setText("Kode Desa/Kelurahan :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1050, 190));
        getContentPane().add(txt_no_surat_pindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 160, -1));

        jLabel6.setText("ID Daftar kyp :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        lbl_id_daftar_kyp.setText("xxxxx");
        getContentPane().add(lbl_id_daftar_kyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 80, -1));

        jLabel7.setText("Kode Form : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        lbl_kode_form.setText("F-1.XX");
        getContentPane().add(lbl_kode_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 110, -1));

        dda.setText("dda");
        dda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddaActionPerformed(evt);
            }
        });
        getContentPane().add(dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, -1, -1));

        dkp.setText("dkp");
        dkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dkpActionPerformed(evt);
            }
        });
        getContentPane().add(dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 560, -1, -1));

        jLabel8.setText("ID DDA :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel11.setText("ID DKP :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        lbl_id_dkp.setText("jLabel12");
        getContentPane().add(lbl_id_dkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        lbl_id_dda.setText("jLabel13");
        getContentPane().add(lbl_id_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       MasukkanDDA();
       MasukkanDKP();
       MasukkanSuratPindah();
       isi_Id_DDA();
       isi_Id_DKP();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnktpcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnktpcetakActionPerformed
        if (Pendaftaran.cb_opsi_sp.getSelectedItem()=="Antar Kecamatan dalam Satu Kabupaten"){
        CetakSP30 c = new CetakSP30();
        c.setVisible(true);
        }
        else {
        CetakSP35 d = new CetakSP35();
        //setLocation(400, 10);
        d.setVisible(true);
        d.setLocation(400, 10);
        CetakSP36 e = new CetakSP36();
        e.setVisible(true);
        }
    }//GEN-LAST:event_btnktpcetakActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Pekerjaan";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Keamanan";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Kesehatan";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
        jenis_kepindahan="Kep.Keluarga dan Seluruh Angg. Keluarga";
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton10ActionPerformed
        // TODO add your handling code here:
        jenis_kepindahan="Kep.Keluaga dan Sbg.Angg. Keluarga";
    }//GEN-LAST:event_jRadioButton10ActionPerformed

    private void ddaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddaActionPerformed
        // TODO add your handling code here:
        MasukkanDDA();
    }//GEN-LAST:event_ddaActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Pendidikan";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Perumahan";
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        alasan_pindah="Keluarga";
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        txt_lainnya.setEnabled(true);
        alasan_pindah=txt_lainnya.getText();
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
        jenis_kepindahan="Kep.Keluarga";
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
        jenis_kepindahan="Anggota Keluarga";
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void numpang_kk_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numpang_kk_1ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_tdk_pindah="Numpang KK";
    }//GEN-LAST:event_numpang_kk_1ActionPerformed

    private void membuat_kk_baru_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membuat_kk_baru_1ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_tdk_pindah="Membuat KK Baru";
    }//GEN-LAST:event_membuat_kk_baru_1ActionPerformed

    private void nomor_kk_tetap_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomor_kk_tetap_1ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_tdk_pindah="Nomor KK Tetap";
    }//GEN-LAST:event_nomor_kk_tetap_1ActionPerformed

    private void numpang_kk_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numpang_kk_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Numpang KK";
    }//GEN-LAST:event_numpang_kk_2ActionPerformed

    private void membuat_kk_baru_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membuat_kk_baru_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Membuat KK Baru";
    }//GEN-LAST:event_membuat_kk_baru_2ActionPerformed

    private void nomor_kk_tetap_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomor_kk_tetap_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Nomor KK Tetap";
    }//GEN-LAST:event_nomor_kk_tetap_2ActionPerformed

    private void dkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dkpActionPerformed
        // TODO add your handling code here:
        MasukkanDKP();
    }//GEN-LAST:event_dkpActionPerformed

    private void txt_lainnyaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_lainnyaFocusLost
        // TODO add your handling code here:
        alasan_pindah=txt_lainnya.getText();
    }//GEN-LAST:event_txt_lainnyaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_alasan_pindah_dkp;
    private javax.swing.ButtonGroup bg_jenis_kepindahan_dkp;
    private javax.swing.ButtonGroup bg_status_kk_yg_pindah_dkp;
    private javax.swing.ButtonGroup bg_status_kk_yg_tdk_pindah_dkp;
    private javax.swing.JButton btnktpcetak;
    private javax.swing.JButton dda;
    private javax.swing.JButton dkp;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel29;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel30;
    public static javax.swing.JLabel jLabel31;
    public static javax.swing.JLabel jLabel32;
    public static javax.swing.JLabel jLabel33;
    public static javax.swing.JLabel jLabel37;
    public static javax.swing.JLabel jLabel38;
    public static javax.swing.JLabel jLabel39;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    public static javax.swing.JLabel jLabel42;
    public static javax.swing.JLabel jLabel43;
    public static javax.swing.JLabel jLabel44;
    public static javax.swing.JLabel jLabel45;
    public static javax.swing.JLabel jLabel46;
    public static javax.swing.JLabel jLabel47;
    public static javax.swing.JLabel jLabel48;
    public static javax.swing.JLabel jLabel49;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JRadioButton jRadioButton1;
    public static javax.swing.JRadioButton jRadioButton10;
    public static javax.swing.JRadioButton jRadioButton11;
    public static javax.swing.JRadioButton jRadioButton2;
    public static javax.swing.JRadioButton jRadioButton3;
    public static javax.swing.JRadioButton jRadioButton4;
    public static javax.swing.JRadioButton jRadioButton5;
    public static javax.swing.JRadioButton jRadioButton6;
    public static javax.swing.JRadioButton jRadioButton7;
    public static javax.swing.JRadioButton jRadioButton8;
    public static javax.swing.JRadioButton jRadioButton9;
    public static javax.swing.JLabel lbl_alamat_dda;
    public static javax.swing.JLabel lbl_desa_kelurahan_dda;
    public static javax.swing.JLabel lbl_id_daftar_kyp;
    private javax.swing.JLabel lbl_id_dda;
    private javax.swing.JLabel lbl_id_dkp;
    public static javax.swing.JLabel lbl_kab_kota_dda;
    public static javax.swing.JLabel lbl_kecamatan_dda;
    private javax.swing.JLabel lbl_kode_desa_kelurahan;
    private javax.swing.JLabel lbl_kode_form;
    public static javax.swing.JLabel lbl_nama_dda;
    public static javax.swing.JLabel lbl_provinsi_dda;
    public static javax.swing.JLabel lbl_rt_dda;
    public static javax.swing.JLabel lbl_rw_dda;
    private javax.swing.JLabel lblopsiantar;
    public static javax.swing.JRadioButton membuat_kk_baru_1;
    public static javax.swing.JRadioButton membuat_kk_baru_2;
    public static javax.swing.JRadioButton nomor_kk_tetap_1;
    public static javax.swing.JRadioButton nomor_kk_tetap_2;
    public static javax.swing.JRadioButton numpang_kk_1;
    public static javax.swing.JRadioButton numpang_kk_2;
    public static javax.swing.JTextField txt_alamat_tujuan_pindah_dkp;
    public static javax.swing.JTextField txt_desa_kelurahan_dkp;
    public static javax.swing.JTextField txt_dusun_dukuh_kampung_dda;
    public static javax.swing.JTextField txt_dusun_dukuh_kampung_dkp;
    public static javax.swing.JTextField txt_kab_kota_dkp;
    public static javax.swing.JTextField txt_kecamatan_dkp;
    public static javax.swing.JTextField txt_kodepos_dda;
    public static javax.swing.JTextField txt_kodepos_dkp;
    public static javax.swing.JTextField txt_lainnya;
    public static javax.swing.JTextField txt_nama_kepala_keluarga;
    public static javax.swing.JTextField txt_nik_dda;
    public static javax.swing.JTextField txt_no_kk_dda;
    public static final javax.swing.JTextField txt_no_surat_pindah = new javax.swing.JTextField();
    public static javax.swing.JTextField txt_provinsi_dkp;
    public static javax.swing.JTextField txt_rt_dkp;
    public static javax.swing.JTextField txt_rw_dkp;
    public static javax.swing.JTextField txt_telepon_dda;
    public static javax.swing.JTextField txt_telepon_dkp;
    // End of variables declaration//GEN-END:variables

}
