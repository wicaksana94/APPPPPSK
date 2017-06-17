/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import static Form.MenuUtama.desktopPane;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arya Wicaksana
 */
public class KeluargaYangDatang extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form KeluargaYangDatang
     */

    private void bersih(){
        
        txt_nama_kyd.setText("");
        txt_nik_kyd.setText("");
        txt_no_kyd.setText("");
        txt_shdk_kyd.setText("");
        tgl_masa_berlaku_ktp_kyd.setDate(null);
    }
    
   private void id_kyd_siap(){
          try
       {
            String Sql = "select max(id_kyd) from keluarga_yang_datang";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_kyd.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_kyd.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_kyd.setText(siap);
            }
       }
catch (Exception e)
{String kyd;
        kyd="1";
    lbl_id_kyd.setText(kyd);
    System.out.println(e);
}    
}    
            
        private void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(29);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(130); 
        column = jTable1.getColumnModel().getColumn(2); 
        column.setPreferredWidth(140); 
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(140); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(53);
        column = jTable1.getColumnModel().getColumn(3); 
        column.setPreferredWidth(140); 
        column = jTable1.getColumnModel().getColumn(4); 
        column.setPreferredWidth(53);
    }

        private void UpdateTabelKYD(){
            //String z = DapatkanId_daftar_kyd.lbl_id_daftar_kyd.getText();
            String z = lbl_id_daftar_kyd.getText();
            try
        {
            //String sql = "SELECT * FROM keluarga_yang_datang where id_daftar_kyd = '"+z+"' ";
            String sql = "select id_kyd as 'ID KyD', no_kyd as 'No.Urut',"
                    + " nik_kyd as 'NIK', nama_kyd as 'Nama', "
                    + "masa_berlaku_ktp_kyd as 'Masa berlaku KTP', shdk_kyd as 'SHDK',"
                    + " id_daftar_kyd as 'ID Daftar KyD' from keluarga_yang_datang"
                    + " where id_daftar_kyd = '"+z+"' ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}
}
        
    private void batasanInput(){
        txt_nik_kyd.setDocument(new batasInput((byte)16).getOnlyNumber(txt_nik_kyd));
        txt_no_kyd.setDocument(new batasInput((byte)2).getOnlyNumber(txt_no_kyd));
    }
        
    public KeluargaYangDatang() {
        initComponents();
        conn = KoneksiDB.ConnectDb();
        jTable1.getTableHeader().setFont(new Font("SansSerif", 0 , 8));
        lbl_id_daftar_kyd.setText(DapatkanId_daftar_kyd.lbl_bakal_id_daftar_kyd.getText());
        id_kyd_siap();
        lebarKolom();
        UpdateTabelKYD();
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tgl_masa_berlaku_ktp_kyd = new com.toedter.calendar.JDateChooser();
        txt_nama_kyd = new javax.swing.JTextField();
        txt_nik_kyd = new javax.swing.JTextField();
        txt_shdk_kyd = new javax.swing.JTextField();
        btn_tambahkan_kyd = new javax.swing.JButton();
        btn_perbarui_kyd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_id_daftar_kyd = new javax.swing.JLabel();
        btn_lanjut_kyd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_no_kyd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl_id_kyd = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "NIK", "Nama", "Masa Berlaku KTP S/D", "SHDK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 281, 516, 210));

        jLabel6.setText("id kyd :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, -1, -1));

        jLabel7.setText("NIK :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 129, -1, -1));

        jLabel8.setText("Nama :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel9.setText("Masa Berlaku KTP S/D :");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 183, -1, 20));

        jLabel11.setText("SHDK :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 214, -1, -1));

        tgl_masa_berlaku_ktp_kyd.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(tgl_masa_berlaku_ktp_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 183, 175, -1));
        jPanel3.add(txt_nama_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 157, 192, -1));
        jPanel3.add(txt_nik_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 126, 215, -1));

        txt_shdk_kyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_shdk_kydActionPerformed(evt);
            }
        });
        jPanel3.add(txt_shdk_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 214, 210, -1));

        btn_tambahkan_kyd.setText("Tambahkan");
        btn_tambahkan_kyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahkan_kydActionPerformed(evt);
            }
        });
        jPanel3.add(btn_tambahkan_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        btn_perbarui_kyd.setText("Perbarui");
        btn_perbarui_kyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbarui_kydActionPerformed(evt);
            }
        });
        jPanel3.add(btn_perbarui_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("SFNS Display", 0, 36)); // NOI18N
        jLabel1.setText("Keluarga yang Datang (kyd)");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel2.setText("id daftar kyd :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));

        lbl_id_daftar_kyd.setText("XXX");
        jPanel3.add(lbl_id_daftar_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 49, -1, -1));

        btn_lanjut_kyd.setText("Lanjutkan");
        btn_lanjut_kyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lanjut_kydActionPerformed(evt);
            }
        });
        jPanel3.add(btn_lanjut_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 500, -1, -1));

        jLabel3.setText("No.kyd :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, -1, -1));

        txt_no_kyd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_no_kydActionPerformed(evt);
            }
        });
        jPanel3.add(txt_no_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 95, 43, -1));

        jButton1.setText("Kosongkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 240, -1, -1));

        lbl_id_kyd.setText("xxxxx");
        jPanel3.add(lbl_id_kyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 69, 103, -1));

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bersih();
        id_kyd_siap();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_no_kydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_no_kydActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_no_kydActionPerformed

    private void btn_perbarui_kydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbarui_kydActionPerformed
        // TODO add your handling code here:
        try
        {
            int value1 = Integer.parseInt(lbl_id_kyd.getText());
            int value2 = Integer.parseInt(txt_no_kyd.getText());
            String value3 = txt_nik_kyd.getText();
            String value4 = txt_nama_kyd.getText();
            String value5 = tgl_masa_berlaku_ktp_kyd.getDateFormatString();
            String value6 = txt_shdk_kyd.getText();
            int value7 = Integer.parseInt(lbl_id_daftar_kyd.getText());
            
            String sql="update keluarga_yang_datang set id_kyd='"+value1+"', no_kyd='"+value2+"', "
                    + "nik_kyd='"+value3+"', nama_kyd='"+value4+"', masa_berlaku_ktp_kyd='"+value5+"', "
                    + "shdk_kyd='"+value6+"', id_daftar_kyd='"+value7+"' where id_kyd= '"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data telah diubah.","[ SUKSES ]",1);
            UpdateTabelKYD();
            
            btn_perbarui_kyd.setFont(new java.awt.Font("Tahoma", 0, 11));
            btn_perbarui_kyd.setText("Perbarui");
            btn_tambahkan_kyd.setEnabled(true);
            btn_lanjut_kyd.setEnabled(true);
            
        }
        catch (Exception e){
        }
    }//GEN-LAST:event_btn_perbarui_kydActionPerformed

    private void btn_tambahkan_kydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahkan_kydActionPerformed
        // TODO add your handling code here:
        try
        {
            String Sql = "insert into keluarga_yang_datang (id_kyd, no_kyd, nik_kyd, nama_kyd,"
                    + " masa_berlaku_ktp_kyd, shdk_kyd, id_daftar_kyd) values (?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setInt(2, Integer.parseInt(txt_no_kyd.getText()));
            pst.setString(3, txt_nik_kyd.getText());
            pst.setString(4, txt_nama_kyd.getText());
            pst.setString(5, ((JTextField)tgl_masa_berlaku_ktp_kyd.getDateEditor().getUiComponent()).getText());
            pst.setString(6, txt_shdk_kyd.getText());
            pst.setInt(7, Integer.parseInt(lbl_id_daftar_kyd.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);
            UpdateTabelKYD();
            id_kyd_siap();
            btn_lanjut_kyd.setEnabled(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Penambahan data ke tabel SQL : Error");
            //JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_tambahkan_kydActionPerformed

    private void txt_shdk_kydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_shdk_kydActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_shdk_kydActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btn_perbarui_kyd.setFont(new java.awt.Font("Tahoma", 1, 12));
        btn_perbarui_kyd.setText("Simpan Perubahan");
        btn_tambahkan_kyd.setEnabled(false);
        btn_lanjut_kyd.setEnabled(false);
        
        try{
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql= "select * from keluarga_yang_datang where id_kyd='"+Table_click+"' ";

            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            if(rs.next()) {
                String add0= rs.getString("id_kyd");
                lbl_id_kyd.setText(add0);
                String add1= rs.getString("no_kyd");
                txt_no_kyd.setText(add1);
                String add2= rs.getString("nik_kyd");
                txt_nik_kyd.setText(add2);
                String add3= rs.getString("nama_kyd");
                txt_nama_kyd.setText(add3);
                String add4= rs.getString("masa_berlaku_ktp_kyd");
                tgl_masa_berlaku_ktp_kyd.setDateFormatString(add4);
                String add5= rs.getString("shdk_kyd");
                txt_shdk_kyd.setText(add5);
                String add6= rs.getString("id_daftar_kyd");
                lbl_id_daftar_kyd.setText(add6);
            }
        }
        catch(Exception e){
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_lanjut_kydActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lanjut_kydActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk melanjutkan? " +
                 "Pastikan data-data yang sudah anda isikan sudah valid", "Lanjutkan?", JOptionPane.YES_NO_OPTION);
        if (p==0){
        SuratPindahDatang l = new SuratPindahDatang();
        desktopPane.add(l);
        l.setVisible(true);
        this.setVisible(false);
        }
    }//GEN-LAST:event_btn_lanjut_kydActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menghapus data yang anda pilih?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            try {
                String sql = "delete from keluarga_yang_datang where id_kyd=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1, lbl_id_kyd.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null, "Terhapus.","[ SUKSES ]",1);
                UpdateTabelKYD();
                
                bersih();

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

        }
        else {};
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lanjut_kyd;
    private javax.swing.JButton btn_perbarui_kyd;
    private javax.swing.JButton btn_tambahkan_kyd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel lbl_id_daftar_kyd;
    public static javax.swing.JLabel lbl_id_kyd;
    private com.toedter.calendar.JDateChooser tgl_masa_berlaku_ktp_kyd;
    public static javax.swing.JTextField txt_nama_kyd;
    public static javax.swing.JTextField txt_nik_kyd;
    public static javax.swing.JTextField txt_no_kyd;
    public static javax.swing.JTextField txt_shdk_kyd;
    // End of variables declaration//GEN-END:variables
}