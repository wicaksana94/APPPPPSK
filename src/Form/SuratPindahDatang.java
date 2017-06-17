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

public class SuratPindahDatang extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String alasan_pindah;
    String jenis_kepindahan;
    public static String status_kk_bagi_yg_pindah;
    public static String no_kk;
    
    /**
     * Creates new form SuratPindahDatang
     */
    
     private void cekIsiSuratPindahDatang(){
    if ( (txt_no_surat_pindah_datang.getText().equals("")) ){
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
	
        else if		(status_kk_bagi_yg_pindah==null){
		JOptionPane.showMessageDialog(null, "Status KK Bagi Yang Pindah pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}
    
        else if		(txt_no_kk_ddt.getText().equals("")){
		JOptionPane.showMessageDialog(null, "No.KK pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}
 
        else if		(txt_nik_kepala_keluaga_ddt.getText().equals("")){
		JOptionPane.showMessageDialog(null, "NIK Kepala Keluarga pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}
    
        else if		(txt_nama_kepala_keluarga_ddt.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Nama Kepala Keluarga pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}

        else if		(tgl_kedatangan_ddt.getDateFormatString().equals(null)){
		JOptionPane.showMessageDialog(null, "Tanggal Kedatangan pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}
    
         else if	(txt_dusun_dukuh_kampung_ddt.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Dusun/Dukuh/Kampung pada Data Daerah Tujuan harus diisi","[ PERHATIAN ]",2);
		}
}
    
    private void batasanInput() {
        txt_nik_dda.setDocument(new batasInput((byte)16).getOnlyNumber(txt_nik_dda));
        txt_no_kk_dda.setDocument(new batasInput((byte)16).getOnlyNumber(txt_no_kk_dda));
        txt_kodepos_dda.setDocument(new batasInput((byte)5).getOnlyNumber(txt_kodepos_dda));
        txt_telepon_dda.setDocument(new batasInput((byte)7).getOnlyNumber(txt_telepon_dda));
        txt_no_kk_ddt.setDocument(new batasInput((byte)16).getOnlyNumber(txt_no_kk_ddt));
    }

    private void isiOtomatis_dda(){
    lbl_alamat_ddt.setText(Pendaftar.txtalamat.getText());
    lbl_desa_kelurahan_ddt.setText((String) Pendaftar.cbdesakelurahan.getSelectedItem());
    lbl_rt_ddt.setText(Pendaftar.txtRT.getText());
    lbl_rw_ddt.setText(Pendaftar.txtRW.getText());
    lbl_nama_dda.setText(Pendaftar.txtnama.getText());
    lbl_id_daftar_kyd.setText(DapatkanId_daftar_kyd.lbl_bakal_id_daftar_kyd.getText());
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
             CetakSPD32 c = new CetakSPD32();
             c.setVisible(true);
        }
        else {
           CetakSPD39 d = new CetakSPD39();
           d.setVisible(true);
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
    
    private void isi_Id_DDT(){
      try
       {
            String Sql = "select max(id_ddt) from data_daerah_tujuan";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_ddt.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_ddt.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_ddt.setText(siap);
            }
       }
catch (Exception e)
{String ddt;
        ddt="1";
    lbl_id_ddt.setText(ddt);
    System.out.println(e);
}  
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
    
    private void IsiOtomatis(){
        txtRT.setText(txtRT.getText());
        txtRW.setText(txtRW.getText());
        txtnama.setText(txtnama.getText());
        txtalamat.setText(txtalamat.getText());
        Isilblopsiantar();
        
        txt_nama_kepala_keluarga_ddt.setText(txt_nama_kepala_keluarga.getText());
    }

    private void IsiKodeForm(){
        if (Pendaftaran.cb_opsi_sp.getSelectedItem()=="Antar Kecamatan dalam Satu Kabupaten"){
            lbl_kode_form.setText("F-1.30");
            txt_kab_kota_dda.setText("Temanggung");
            txt_provinsi_dda.setText("Jawa Tengah");
        }
        else {
        lbl_kode_form.setText("F-1.39");}
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
            pst.setString(4, txt_alamat_dda.getText());
            pst.setInt(5, Integer.parseInt(txt_rt_dda.getText()));
            pst.setInt(6, Integer.parseInt(txt_rw_dda.getText()));
            pst.setString(7, txt_dusun_dukuh_kampung_dda.getText());
            pst.setString(8, txt_desa_kelurahan_dda.getText());
            pst.setString(9, txt_kecamatan_dda.getText());
            pst.setString(10, txt_kab_kota_dda.getText());
            pst.setString(11, txt_provinsi_dda.getText());
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
    
    private void MasukkanDDT(){
           try
        {   
            String Sql = "insert into data_daerah_tujuan (id_ddt, statuskk_yg_pindah_ddt, no_kk, "
                    + "nik_kepala_keluarga, nama_kepala_keluarga, tgl_kedatangan, alamat_ddt, "
                    + "rt_ddt, rw_dda, dusun_dukuh_kampung, desa_kelurahan_ddt, kecamatan_ddt, "
                    + "kab_kota_ddt, provinsi_ddt, id_pendaftar, id_pendaftaran) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, Integer.parseInt(lbl_id_ddt.getText()));
            pst.setString(2, status_kk_bagi_yg_pindah);
            pst.setString(3, no_kk);
            pst.setString(4, txt_nik_kepala_keluaga_ddt.getText());
            pst.setString(5, txt_nama_kepala_keluarga_ddt.getText());
            pst.setString(6, ((JTextField)tgl_kedatangan_ddt.getDateEditor().getUiComponent()).getText());
            pst.setString(7, txt_alamat_dda.getText());
            pst.setInt(8, Integer.parseInt(lbl_rt_ddt.getText()));
            pst.setInt(9, Integer.parseInt(lbl_rw_ddt.getText()));
            pst.setString(10, txt_dusun_dukuh_kampung_ddt.getText());
            pst.setString(11, lbl_desa_kelurahan_ddt.getText());
            pst.setString(12, lbl_kecamatan_ddt.getText());
            pst.setString(13, lbl_kab_kota_ddt.getText());
            pst.setString(14, lbl_provinsi_ddt.getText());
            pst.setInt(15, Integer.parseInt(Pendaftar.lbl_id_pendaftar.getText()));
            pst.setInt(16, Integer.parseInt(Pendaftaran.lbl_id_pendaftaran.getText()));
           
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);

            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "DDT tidak bisa diinputkan.");
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }   
    }

    private void MasukkanSuratPindahDatang() {
        try
        {   
            String Sql = "insert into surat_pindah_datang (id_surat_pindah_datang, kode_form, no_surat_pindah_datang,"
                    + " provinsi, kab_kota, kecamatan, dusun_dukuh_kampung, desa_kelurahan, "
                    + "id_dda, id_ddt, id_pendaftar, id_pendaftaran, id_daftar_kyd, id_desa_kelurahan) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setString(2, lbl_kode_form.getText());
            pst.setString(3, txt_no_surat_pindah_datang.getText());
            pst.setString(4, txt_provinsi_dda.getText());
            pst.setString(5, txt_kab_kota_dda.getText());
            pst.setString(6, txt_kecamatan_dda.getText());
            pst.setString(7, txt_dusun_dukuh_kampung_ddt.getText());
            pst.setString(8, txt_desa_kelurahan_dda.getText());
            pst.setInt(9, Integer.parseInt(lbl_id_dda.getText()));
            pst.setInt(10, Integer.parseInt(lbl_id_ddt.getText()));
            pst.setInt(11, Integer.parseInt(Pendaftar.lbl_id_pendaftar.getText()));
            pst.setInt(12, Integer.parseInt(Pendaftaran.lbl_id_pendaftaran.getText()));
            pst.setInt(13, Integer.parseInt(KeluargaYangDatang.lbl_id_daftar_kyd.getText()));
            pst.setInt(14, Integer.parseInt(lbl_kode_desa_kelurahan.getText()));
           
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);

            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Surat Pindah Datang tidak bisa diinputkan.");
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    public SuratPindahDatang() {
        initComponents();
        conn = KoneksiDB.ConnectDb();
        IsiOtomatis();
        IsiKodeForm();
        isiOtomatis_dda();
        isiKodeDesaKelurahan();
        isi_Id_DDA();
        isi_Id_DDT();
        //cekIsiSuratPindahDatang();
        setSize(1113, 640);
        dda.setVisible(false);
        ddt.setVisible(false);
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

        bg_status_kk_yg_pindah_dkp = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        btnktpcetak = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblopsiantar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_dusun_dukuh_kampung_ddt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nomor_kk_tetap_2 = new javax.swing.JRadioButton();
        numpang_kk_2 = new javax.swing.JRadioButton();
        membuat_kk_baru_2 = new javax.swing.JRadioButton();
        txt_no_kk_ddt = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txt_nik_kepala_keluaga_ddt = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tgl_kedatangan_ddt = new com.toedter.calendar.JDateChooser();
        lbl_kecamatan_ddt = new javax.swing.JLabel();
        lbl_kab_kota_ddt = new javax.swing.JLabel();
        lbl_provinsi_ddt = new javax.swing.JLabel();
        lbl_desa_kelurahan_ddt = new javax.swing.JLabel();
        lbl_alamat_ddt = new javax.swing.JLabel();
        txt_nama_kepala_keluarga_ddt = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        lbl_rw_ddt = new javax.swing.JLabel();
        lbl_rt_ddt = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_kode_desa_kelurahan = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbl_nama_dda = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_telepon_dda = new javax.swing.JTextField();
        txt_kodepos_dda = new javax.swing.JTextField();
        txt_no_kk_dda = new javax.swing.JTextField();
        txt_dusun_dukuh_kampung_dda = new javax.swing.JTextField();
        txt_nik_dda = new javax.swing.JTextField();
        txt_nama_kepala_keluarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_kecamatan_dda = new javax.swing.JTextField();
        txt_kab_kota_dda = new javax.swing.JTextField();
        txt_provinsi_dda = new javax.swing.JTextField();
        txt_desa_kelurahan_dda = new javax.swing.JTextField();
        txt_alamat_dda = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_rt_dda = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_rw_dda = new javax.swing.JTextField();
        txt_no_surat_pindah_datang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_id_daftar_kyd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_kode_form = new javax.swing.JLabel();
        dda = new javax.swing.JButton();
        ddt = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_id_dda = new javax.swing.JLabel();
        lbl_id_ddt = new javax.swing.JLabel();

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
        jLabel1.setText("Surat Pindah Datang");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        lblopsiantar.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        lblopsiantar.setText("xxxxxxxx xxxxxxxxx");
        getContentPane().add(lblopsiantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Daerah Tujuan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Alamat tujuan Pindah :");

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

        jLabel5.setText("Status KK Bagi Yang Pindah :");

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

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("No.KK :");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("NIK Kepala Keluarga :");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("Nama Kepala Keluarga :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Tanggal Kedatangan :");

        tgl_kedatangan_ddt.setDateFormatString("yyyy-MM-dd");

        lbl_kecamatan_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_kecamatan_ddt.setText("Temanggung");

        lbl_kab_kota_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_kab_kota_ddt.setText("Temanggung");

        lbl_provinsi_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_provinsi_ddt.setText("Jawa Tengah");

        lbl_desa_kelurahan_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_desa_kelurahan_ddt.setText("lbl_desa_kelurahan_dda");

        lbl_alamat_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_alamat_ddt.setText("alamat");
        lbl_alamat_ddt.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("RW :");

        lbl_rw_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rw_ddt.setText("xxx");

        lbl_rt_ddt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_rt_ddt.setText("xxx");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("RT :");

        jLabel2.setText("Kode Desa/Kelurahan :");

        lbl_kode_desa_kelurahan.setText("kode desa kelurahan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(numpang_kk_2)
                        .addGap(18, 18, 18)
                        .addComponent(membuat_kk_baru_2)
                        .addGap(18, 18, 18)
                        .addComponent(nomor_kk_tetap_2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txt_no_kk_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_desa_kelurahan_ddt)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_kecamatan_ddt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(lbl_alamat_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_rt_ddt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel42)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_rw_ddt)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_kab_kota_ddt)
                                .addGap(93, 93, 93)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_provinsi_ddt))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_dusun_dukuh_kampung_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tgl_kedatangan_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(10, 10, 10)
                                .addComponent(txt_nik_kepala_keluaga_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nama_kepala_keluarga_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_kode_desa_kelurahan)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numpang_kk_2)
                    .addComponent(membuat_kk_baru_2)
                    .addComponent(nomor_kk_tetap_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txt_no_kk_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nama_kepala_keluarga_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_nik_kepala_keluaga_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl_kedatangan_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)
                                .addComponent(txt_dusun_dukuh_kampung_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_alamat_ddt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41)
                            .addComponent(lbl_rt_ddt))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(lbl_kecamatan_ddt)
                            .addComponent(lbl_kab_kota_ddt)
                            .addComponent(lbl_provinsi_ddt)
                            .addComponent(lbl_desa_kelurahan_ddt)))
                    .addComponent(jLabel42)
                    .addComponent(lbl_rw_ddt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbl_kode_desa_kelurahan))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1050, 280));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("No.Surat :");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, -1, 20));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Daerah Asal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Nama :");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 20));

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
        jPanel4.add(lbl_nama_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 250, 20));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Dusun/Dukuh/Kampung :");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 53, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Desa/Kelurahan :");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Kecamatan :");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Kab/Kota :");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 20));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Provinsi :");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, 20));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("Kode Pos :");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, 20));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("Telepon :");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        txt_telepon_dda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(txt_telepon_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 110, -1));
        jPanel4.add(txt_kodepos_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 80, -1));
        jPanel4.add(txt_no_kk_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 21, 230, -1));
        jPanel4.add(txt_dusun_dukuh_kampung_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 51, 230, -1));
        jPanel4.add(txt_nik_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 149, -1));

        txt_nama_kepala_keluarga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nama_kepala_keluargaFocusLost(evt);
            }
        });
        txt_nama_kepala_keluarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nama_kepala_keluargaKeyPressed(evt);
            }
        });
        jPanel4.add(txt_nama_kepala_keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 21, 193, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nama Kepala Keluarga :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 24, -1, -1));
        jPanel4.add(txt_kecamatan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 160, -1));

        txt_kab_kota_dda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kab_kota_ddaActionPerformed(evt);
            }
        });
        jPanel4.add(txt_kab_kota_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 160, -1));
        jPanel4.add(txt_provinsi_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 151, 30));
        jPanel4.add(txt_desa_kelurahan_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 150, 30));
        jPanel4.add(txt_alamat_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 290, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("RT :");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        jPanel4.add(txt_rt_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 26, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("RW :");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        jPanel4.add(txt_rw_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 29, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1050, 190));
        getContentPane().add(txt_no_surat_pindah_datang, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 160, -1));

        jLabel6.setText("ID Daftar kyd :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        lbl_id_daftar_kyd.setText("xxxxx");
        getContentPane().add(lbl_id_daftar_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 120, -1));

        jLabel7.setText("Kode Form : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        lbl_kode_form.setText("F-1.XX");
        getContentPane().add(lbl_kode_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 60, -1));

        dda.setText("dda");
        dda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddaActionPerformed(evt);
            }
        });
        getContentPane().add(dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, -1, -1));

        ddt.setText("ddt");
        ddt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddtActionPerformed(evt);
            }
        });
        getContentPane().add(ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 560, -1, -1));

        jLabel11.setText("ID DDA :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        jLabel12.setText("ID DDT :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        lbl_id_dda.setText("jLabel12");
        getContentPane().add(lbl_id_dda, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        lbl_id_ddt.setText("jLabel13");
        getContentPane().add(lbl_id_ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       MasukkanDDA();
       MasukkanDDT();
       MasukkanSuratPindahDatang();
       isi_Id_DDA();
       isi_Id_DDT();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnktpcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnktpcetakActionPerformed
       if (Pendaftaran.cb_opsi_sp.getSelectedItem()=="Antar Kecamatan dalam Satu Kabupaten"){
        CetakSPD32 c = new CetakSPD32();
        c.setVisible(true);
        }
        else {
        CetakSPD39 d = new CetakSPD39();
        d.setVisible(true);
       }
    }//GEN-LAST:event_btnktpcetakActionPerformed

    private void ddaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddaActionPerformed
        // TODO add your handling code here:
        MasukkanDDA();
    }//GEN-LAST:event_ddaActionPerformed

    private void numpang_kk_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numpang_kk_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Numpang KK";
        txt_no_kk_ddt.setEnabled(true);
        no_kk = txt_no_kk_ddt.getText();
    }//GEN-LAST:event_numpang_kk_2ActionPerformed

    private void membuat_kk_baru_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membuat_kk_baru_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Membuat KK Baru";
        txt_no_kk_ddt.setEnabled(true);
        no_kk = txt_no_kk_ddt.getText();
    }//GEN-LAST:event_membuat_kk_baru_2ActionPerformed

    private void nomor_kk_tetap_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomor_kk_tetap_2ActionPerformed
        // TODO add your handling code here:
        status_kk_bagi_yg_pindah="Nomor KK Tetap";
        txt_no_kk_ddt.setEnabled(false);
        txt_no_kk_ddt.setText(txt_no_kk_dda.getText());
        no_kk = txt_no_kk_dda.getText();
    }//GEN-LAST:event_nomor_kk_tetap_2ActionPerformed

    private void ddtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddtActionPerformed
        // TODO add your handling code here:
        MasukkanDDT();
    }//GEN-LAST:event_ddtActionPerformed

    private void txt_kab_kota_ddaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kab_kota_ddaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kab_kota_ddaActionPerformed

    private void txt_nama_kepala_keluargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nama_kepala_keluargaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_kepala_keluargaFocusLost

    private void txt_nama_kepala_keluargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nama_kepala_keluargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_kepala_keluargaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_status_kk_yg_pindah_dkp;
    public static javax.swing.JButton btnktpcetak;
    public static javax.swing.JButton dda;
    public static javax.swing.JButton ddt;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    public static javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel29;
    public static javax.swing.JLabel jLabel30;
    public static javax.swing.JLabel jLabel31;
    public static javax.swing.JLabel jLabel37;
    public static javax.swing.JLabel jLabel38;
    public static javax.swing.JLabel jLabel39;
    public static javax.swing.JLabel jLabel40;
    public static javax.swing.JLabel jLabel41;
    public static javax.swing.JLabel jLabel42;
    public static javax.swing.JLabel jLabel43;
    public static javax.swing.JLabel jLabel44;
    public static javax.swing.JLabel jLabel45;
    public static javax.swing.JLabel jLabel46;
    public static javax.swing.JLabel jLabel47;
    public static javax.swing.JLabel jLabel48;
    public static javax.swing.JLabel jLabel49;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel50;
    public static javax.swing.JLabel jLabel51;
    public static javax.swing.JLabel jLabel52;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lbl_alamat_ddt;
    public static javax.swing.JLabel lbl_desa_kelurahan_ddt;
    public static javax.swing.JLabel lbl_id_daftar_kyd;
    public static javax.swing.JLabel lbl_id_dda;
    public static javax.swing.JLabel lbl_id_ddt;
    public static javax.swing.JLabel lbl_kab_kota_ddt;
    public static javax.swing.JLabel lbl_kecamatan_ddt;
    private javax.swing.JLabel lbl_kode_desa_kelurahan;
    public static javax.swing.JLabel lbl_kode_form;
    public static javax.swing.JLabel lbl_nama_dda;
    public static javax.swing.JLabel lbl_provinsi_ddt;
    public static javax.swing.JLabel lbl_rt_ddt;
    public static javax.swing.JLabel lbl_rw_ddt;
    public static javax.swing.JLabel lblopsiantar;
    public static javax.swing.JRadioButton membuat_kk_baru_2;
    public static javax.swing.JRadioButton nomor_kk_tetap_2;
    public static javax.swing.JRadioButton numpang_kk_2;
    public static com.toedter.calendar.JDateChooser tgl_kedatangan_ddt;
    public static javax.swing.JTextField txt_alamat_dda;
    public static javax.swing.JTextField txt_desa_kelurahan_dda;
    public static javax.swing.JTextField txt_dusun_dukuh_kampung_dda;
    public static javax.swing.JTextField txt_dusun_dukuh_kampung_ddt;
    public static javax.swing.JTextField txt_kab_kota_dda;
    public static javax.swing.JTextField txt_kecamatan_dda;
    public static javax.swing.JTextField txt_kodepos_dda;
    public static javax.swing.JTextField txt_nama_kepala_keluarga;
    public static javax.swing.JTextField txt_nama_kepala_keluarga_ddt;
    public static javax.swing.JTextField txt_nik_dda;
    public static javax.swing.JTextField txt_nik_kepala_keluaga_ddt;
    public static javax.swing.JTextField txt_no_kk_dda;
    public static javax.swing.JTextField txt_no_kk_ddt;
    public static javax.swing.JTextField txt_no_surat_pindah_datang;
    public static javax.swing.JTextField txt_provinsi_dda;
    public static javax.swing.JTextField txt_rt_dda;
    public static javax.swing.JTextField txt_rw_dda;
    public static javax.swing.JTextField txt_telepon_dda;
    // End of variables declaration//GEN-END:variables

}
