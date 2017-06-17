/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arya Wicaksana
 */
public class UbahPendaftaran extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
        
private void UpdateTabelPendaftaran(){
    try
        {
            String sql = "select id_pendaftaran as 'ID Pendaftaran', jenis_permohonan"
                    + " as 'Jenis Permohonan', tgl_daftar as 'Tgl Daftar',"
                    + " tgl_jadi as 'Tgl Jadi', id_pengguna as 'ID Penginput',"
                    + " id_pendaftar as 'ID Pendaftar' from pendaftaran order by id_pendaftar desc; ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tblpendaftaran.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}
}

    public UbahPendaftaran() {
         setSize(1253, 553);
         initComponents();
         conn = KoneksiDB.ConnectDb();
         UpdateTabelPendaftaran();
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
        tblpendaftaran = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_idpengguna = new javax.swing.JTextField();
        txt_id_pendaftaran = new javax.swing.JTextField();
        txt_idpendaftar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan_perubahan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_kosongkan = new javax.swing.JButton();
        cb_jenis_permohonan = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tgl_daftar_ubah_pend = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        tgl_jadi_ubah_pend = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Ubah Pendaftaran");
        setToolTipText("");
        setAutoscrolls(true);
        setNextFocusableComponent(txt_id_pendaftaran);

        tblpendaftaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblpendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpendaftaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpendaftaran);

        jLabel1.setText("ID Pengguna :");

        jLabel2.setText("ID Pendaftaran :");

        jLabel3.setText("ID Pendaftar :");

        jLabel5.setText("Jenis Permohonan :");

        txt_id_pendaftaran.setFocusCycleRoot(true);
        txt_id_pendaftaran.setFocusTraversalPolicy(null);
        txt_id_pendaftaran.setFocusTraversalPolicyProvider(true);

        jLabel6.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel6.setText("Ubah Pendaftaran");

        btn_simpan_perubahan.setText("Simpan Perubahan");
        btn_simpan_perubahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_perubahanActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_kosongkan.setText("Kosongkan\nTeks\n");
        btn_kosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kosongkanActionPerformed(evt);
            }
        });

        cb_jenis_permohonan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KTP", "Surat Pindah", "Surat Pindah Datang" }));

        jLabel7.setText("Tanggal Daftar :");

        tgl_daftar_ubah_pend.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("Tanggal Jadi :");

        tgl_jadi_ubah_pend.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_simpan_perubahan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_kosongkan))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(95, 95, 95)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_idpengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tgl_daftar_ubah_pend, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(83, 83, 83)
                                        .addComponent(txt_id_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(93, 93, 93)
                                        .addComponent(txt_idpendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(164, 164, 164)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tgl_jadi_ubah_pend, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_jenis_permohonan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_idpendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tgl_daftar_ubah_pend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_idpengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tgl_jadi_ubah_pend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_jenis_permohonan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_kosongkan))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(btn_simpan_perubahan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblpendaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpendaftaranMouseClicked
        // TODO add your handling code here:
        btn_simpan_perubahan.setText("Simpan Perubahan");
            
        try{
            int row = tblpendaftaran.getSelectedRow();
            String Table_click = (tblpendaftaran.getModel().getValueAt(row, 0).toString());
            String sql= "select * from pendaftaran where id_pendaftaran='"+Table_click+"' ";
            
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            if(rs.next()) {
                String add1= rs.getString("id_pendaftaran");
                txt_id_pendaftaran.setText(add1);
                String add2= rs.getString("jenis_permohonan");
                cb_jenis_permohonan.setSelectedItem(add2);
                
                String add3= rs.getString("tgl_daftar");
                java.util.Date daftar = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(add3));
                tgl_daftar_ubah_pend.setDate(daftar);
                
                /*String add3= rs.getString("tgl_daftar");
                tgl_daftar_ubah_pend.setDateFormatString(add3);*/
                
                /*String add4= rs.getString("tgl_jadi");
                tgl_jadi_ubah_pend.setDateFormatString(add4);*/
                
                String add4= rs.getString("tgl_jadi");
                java.util.Date jadi = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(add4));
                tgl_jadi_ubah_pend.setDate(jadi);
                
                String add5= rs.getString("id_pengguna");
                txt_idpengguna.setText(add5);
                String add6= rs.getString("id_pendaftar");
                txt_idpendaftar.setText(add6);
            }
      }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblpendaftaranMouseClicked

    private void btn_simpan_perubahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_perubahanActionPerformed
        // TODO add your handling code here:
        try
        {
            String value1= txt_id_pendaftaran.getText();
            String value2= (String) cb_jenis_permohonan.getSelectedItem();
            String value3= tgl_daftar_ubah_pend.getDateFormatString();
            String value4= tgl_jadi_ubah_pend.getDateFormatString();
            String value5= txt_idpengguna.getText();
            String value6= txt_idpendaftar.getText();
                    
            String sql = "update pengguna set id_pendaftaran='"+value1+"' ,jenis_permohonan='"+value2+"'"
                    + " ,tgl_daftar='"+value3+"' , tgl_jadi='"+value4+"' ,id_pengguna='"+value5+"' , "
                    + "id_pendaftar='"+value6+"' where id_pendaftaran='"+value1+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil diubah.","[ SUKSES ]",1);
            UpdateTabelPendaftaran();
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_simpan_perubahanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menghapus data yang anda pilih?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
        String sql="delete from pendaftaran where id_pendaftaran= ?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_id_pendaftaran.getText());
            pst.execute();
            
            JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk menghapus data ini?","[ KONFIRMASI ]",JOptionPane.YES_NO_OPTION);
            UpdateTabelPendaftaran();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        else{};
        
    }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_kosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kosongkanActionPerformed
        // TODO add your handling code here:
        txt_idpengguna.setText("");
        txt_id_pendaftaran.setText("");
        txt_idpendaftar.setText("");
        cb_jenis_permohonan.setSelectedItem(null);
        tgl_daftar_ubah_pend.setDateFormatString(null);
        tgl_jadi_ubah_pend.setDateFormatString(null);
    }//GEN-LAST:event_btn_kosongkanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kosongkan;
    private javax.swing.JButton btn_simpan_perubahan;
    private javax.swing.JComboBox cb_jenis_permohonan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpendaftaran;
    private com.toedter.calendar.JDateChooser tgl_daftar_ubah_pend;
    private com.toedter.calendar.JDateChooser tgl_jadi_ubah_pend;
    private javax.swing.JTextField txt_id_pendaftaran;
    private javax.swing.JTextField txt_idpendaftar;
    private javax.swing.JTextField txt_idpengguna;
    // End of variables declaration//GEN-END:variables
}
