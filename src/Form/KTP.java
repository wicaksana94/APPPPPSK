/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import static Form.Pendaftar.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arya Wicaksana
 */
public class KTP extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String permohonanktp;
    
    /**
     * Creates new form KTP
     */
    
public void bersih(){
        bgpermohonanktp.setSelected(null, false);
        txtktpnokk.setText(null);
        txtktpnik.setText("");
        txtktpkodepos.setText("");
}     

public void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(30);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(120); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(24); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(265);
        column = jTable1.getColumnModel().getColumn(5); 
        column.setPreferredWidth(26); 
        column = jTable1.getColumnModel().getColumn(6); 
        column.setPreferredWidth(30); 
        column = jTable1.getColumnModel().getColumn(7); 
        column.setPreferredWidth(90); 
    }

private void UpdateTabelKTP(){
    try
        {
            String sql = "select id_ktp as 'ID', permohonan_ktp as 'Jenis Permohonan', "
                    + "nama as 'Nama', no_kk as 'Nomor KK', nik as 'NIK', alamat as 'Alamat', "
                    + "rt as 'RT', rw as 'RW', kodepos as 'Kodepos', id_pendaftaran as 'ID Pendaftaran', "
                    + "id_pendaftar as 'ID Pendaftar' "
                    + "from ktp order by id_ktp desc;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}
}

private void id_ktp_siap(){
          try
       {
            String Sql = "select max(id_ktp) from ktp";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_ktp.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_ktp.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_ktp.setText(siap);
            }
       }
catch (Exception e)
{String i;
        i="1";
    lbl_id_ktp.setText(i);
    System.out.println(e);
}   
}
    
    private void IsiOtomatis(){
        lbl_rt_ktp.setText(txtRT.getText());
        lbl_rw_ktp.setText(txtRW.getText());
        lblktpnama.setText(txtnama.getText());
        lblktpalamat.setText(txtalamat.getText());
        /*txtktprt.setText(txtRT.getText());
        txtktprw.setText(txtRW.getText());*/
        
    }

    private void cekIsiKTP(){
        if		(permohonanktp==null){
		JOptionPane.showMessageDialog(null, "Pilih Permohonan KTP","[ PERHATIAN ]",2);
	}
        
	else if ( (txtktpnokk.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "No.KK harus diisi","[ PERHATIAN ]",2);
		}
        
	else if		(txtktpnik.getText().equals("")){
		JOptionPane.showMessageDialog(null, "NIK harus diisi","[ PERHATIAN ]",2);
		}
		
	else if		(lblktpalamat.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Alamat harus diisi","[ PERHATIAN ]",2);
		}
				
	else if		(txtktpkodepos.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Kodepos harus diisi","[ PERHATIAN ]",2);
		}
        else {
            //btnlanjutpendaftaran.setEnabled(true);
        }
}
    
    public KTP() {
        initComponents();
        conn = KoneksiDB.ConnectDb();
        IsiOtomatis();
        UpdateTabelKTP();
        lebarKolom();
        this.setSize(491, 539);
        id_ktp_siap();
        jLabel10.setText("Form ini diisi oleh "+jabatan+" "+idpengguna);
        txtktpnik.setDocument(new batasInput((byte)16).getOnlyNumber(txtktpnik));
        txtktpnokk.setDocument(new batasInput((byte)16).getOnlyNumber(txtktpnokk));
        /*txtktprt.setDocument(new batasInput((byte)3).getOnlyNumber(txtktprt));
        txtktprw.setDocument(new batasInput((byte)3).getOnlyNumber(txtktprw));*/
        txtktpkodepos.setDocument(new batasInput((byte)5).getOnlyNumber(txtktpkodepos));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnubahdata = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lbl_id_ktp = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("KTP input");
        setPreferredSize(new java.awt.Dimension(1280, 525));

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 525));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SFNS Display", 0, 48)); // NOI18N
        jLabel1.setText("KTP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Permohonan KTP :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 86, -1, -1));

        bgpermohonanktp.add(rb_baru_ktp);
        rb_baru_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_baru_ktp.setText("Baru");
        rb_baru_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_baru_ktpActionPerformed(evt);
            }
        });
        jPanel1.add(rb_baru_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 82, -1, -1));

        bgpermohonanktp.add(rb_perpanjangan_ktp);
        rb_perpanjangan_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_perpanjangan_ktp.setText("Perpanjangan");
        rb_perpanjangan_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_perpanjangan_ktpActionPerformed(evt);
            }
        });
        jPanel1.add(rb_perpanjangan_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        bgpermohonanktp.add(rb_penggantian_ktp);
        rb_penggantian_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_penggantian_ktp.setText("Penggantian");
        rb_penggantian_ktp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_penggantian_ktpActionPerformed(evt);
            }
        });
        jPanel1.add(rb_penggantian_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("No.KK :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 145, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("NIK :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 176, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Alamat :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 207, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("RT :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 297, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("RW :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 325, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kode Pos :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 325, -1, -1));
        jPanel1.add(txtktpkodepos, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 325, 77, -1));
        jPanel1.add(txtktpnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 176, 368, -1));
        jPanel1.add(txtktpnokk, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 145, 368, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nama :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 114, -1, -1));

        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 44));

        lbl_rt_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_rt_ktp.setText("jLabel10");
        jPanel1.add(lbl_rt_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 297, -1, -1));

        lbl_rw_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_rw_ktp.setText("jLabel11");
        jPanel1.add(lbl_rw_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 325, -1, -1));

        lblktpnama.setText("jLabel10");
        jPanel1.add(lblktpnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 117, 306, -1));

        lblktpalamat.setText("jLabel10");
        lblktpalamat.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblktpalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 210, 368, 81));

        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 28, 755, -1));

        btnubahdata.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnubahdata.setText("Ubah Data");
        btnubahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahdataActionPerformed(evt);
            }
        });
        jPanel1.add(btnubahdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 171, 44));

        btnhapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnhapus.setText("Hapus Data");
        btnhapus.setEnabled(false);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("ID No. Urut Permohonan KTP :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 58, -1, -1));

        lbl_id_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_id_ktp.setText("xxxxxxxxxx");
        jPanel1.add(lbl_id_ktp, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 58, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        cekIsiKTP();
        try
        {   String no_kk = txtktpnokk.getText();
            String nik = txtktpnik.getText();
            String nama = lblktpnama.getText();
            String alamat = lblktpalamat.getText();
            
            String Sql = "insert into ktp (id_ktp,permohonan_ktp,nama,no_kk,nik,"
                    + "alamat,rt,rw,kodepos,id_pendaftaran,id_pendaftar) values (?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setString(2, permohonanktp);
            pst.setString(3, nama);
            pst.setString(4, no_kk);
            pst.setString(5, nik);
            pst.setString(6, alamat);         
            pst.setInt(7, Integer.parseInt(lbl_rt_ktp.getText()));
            pst.setInt(8, Integer.parseInt(lbl_rw_ktp.getText()));
            pst.setInt(9, Integer.parseInt(txtktpkodepos.getText())); 
            pst.setInt(10, Integer.parseInt(Pendaftaran.lbl_id_pendaftaran.getText()));
            pst.setInt(11, Integer.parseInt(Pendaftar.lbl_id_pendaftar.getText()));
            
            pst.execute();
           
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);
           
            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (SQLException e)
        {
            //JOptionPane.showMessageDialog(null, "Penambahan data ke tabel SQL : Error");
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void rb_baru_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_baru_ktpActionPerformed
        // TODO add your handling code heCetakFormKTPxpermohonanktp = "Baru";
        permohonanktp = "Baru";
    }//GEN-LAST:event_rb_baru_ktpActionPerformed

    private void rb_perpanjangan_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_perpanjangan_ktpActionPerformed
        // TODO add your handling code here:
        permohonanktp = "Perpanjangan";
    
    }//GEN-LAST:event_rb_perpanjangan_ktpActionPerformed

    private void rb_penggantian_ktpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_penggantian_ktpActionPerformed
        // TODO add your handling code here:
        permohonanktp = "Penggantian";
    }//GEN-LAST:event_rb_penggantian_ktpActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:

        int p = JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk menghapus?", "Hapus", JOptionPane.YES_NO_OPTION);
        if (p==0){
            try {
                String sql = "delete from pendaftar where id_ktp=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, lbl_id_ktp.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null, "Terhapus.","[ SUKSES ]",1);
                UpdateTabelKTP();
                lebarKolom();
                bersih();
                id_ktp_siap();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnubahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahdataActionPerformed
        // TODO add your handling code here:
        this.setSize(1280, 525);
        btnhapus.setEnabled(false);
        btnsimpan.setEnabled(false);
        try
        {
            int value1 = Integer.parseInt(lbl_id_ktp.getText());
            String value2 = permohonanktp;
            String value3 = lblktpnama.getText();
            String value4 = txtktpnokk.getText();
            String value5 = txtktpnik.getText();
            String value6 = lblktpalamat.getText();
            int value7 = Integer.parseInt(txtRT.getText());
            int value8 = Integer.parseInt(txtRW.getText());
            int value9 = Integer.parseInt(txtktpkodepos.getText());
            int value10 = Integer.parseInt(Pendaftaran.lbl_id_pendaftaran.getText());
            int value11 = Integer.parseInt(Pendaftar.lbl_id_pendaftar.getText());

            String sql="update ktp set id_ktp='"+value1+"', permohonan_ktp='"+value2+"', "
            + "nama='"+value3+"', no_kk='"+value4+"', nik='"+value5+"', "
            + "alamat='"+value6+"', rt='"+value7+"', rw='"+value8+"', kodepos='"+value9+"', "
            + "id_pendaftaran='"+value10+"', id_pendaftar='"+value11+"' "
            + "where id_ktp='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Tersimpan.","[ SUKSES ]",1);
            UpdateTabelKTP();
            lebarKolom();

        }
        catch (SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnubahdataActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btnubahdata.setFont(new java.awt.Font("Tahoma", 1, 12));
        btnubahdata.setText("Simpan Perubahan");
        btnsimpan.setEnabled(false);
        btnlanjutpendaftaran.setEnabled(false);
        btnhapus.setEnabled(true);
        try{
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql= "select * from ktp where id_ktp='"+Table_click+"' ";

            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()) {

                String add0= rs.getString("id_ktp");
                lbl_id_ktp.setText(add0);

                String add1= rs.getString("permohonan_ktp");
                if (add1.equals("Baru") ) {
                    permohonanktp="Baru";
                    rb_baru_ktp.setSelected(true);
                } else if(add1.equals("Perpanjangan") ) {
                    permohonanktp="Perpanjangan";
                    rb_perpanjangan_ktp.setSelected(true);
                }else {
                    permohonanktp="Penggantian";
                    rb_penggantian_ktp.setSelected(true);
                }

                String add2= rs.getString("nama");
                lblktpnama.setText(add2);

                String add3= rs.getString("no_kk");
                txtktpnokk.setText(add3);

                String add4= rs.getString("nik");
                txtktpnik.setText(add4);

                String add5= rs.getString("alamat");
                lblktpalamat.setText(add5);

                String add6= rs.getString("rt");
                lbl_rt_ktp.setText(add6);

                String add7= rs.getString("rw");
                lbl_rw_ktp.setText(add7);

                String add8= rs.getString("kodepos");
                txtktpkodepos.setText(add8);

                String add9= rs.getString("id_pendaftaran");
                Pendaftaran.lbl_id_pendaftaran.setText(add9);

                String add10= rs.getString("id_pendaftar");
                Pendaftar.lbl_id_pendaftar.setText(add10);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.ButtonGroup bgpermohonanktp = new javax.swing.ButtonGroup();
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubahdata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_id_ktp;
    public static final javax.swing.JLabel lbl_rt_ktp = new javax.swing.JLabel();
    public static final javax.swing.JLabel lbl_rw_ktp = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblktpalamat = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblktpnama = new javax.swing.JLabel();
    public static final javax.swing.JRadioButton rb_baru_ktp = new javax.swing.JRadioButton();
    public static final javax.swing.JRadioButton rb_penggantian_ktp = new javax.swing.JRadioButton();
    public static final javax.swing.JRadioButton rb_perpanjangan_ktp = new javax.swing.JRadioButton();
    public static final javax.swing.JTextField txtktpkodepos = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtktpnik = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtktpnokk = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
