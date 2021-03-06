/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import static Form.MenuUtama.desktopPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author Arya Wicaksana
 */
public class DapatkanId_daftar_kyd extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form DapatkanId_daftar_kyd
     */
    private void id_daftar_kyd_siap(){
          try
       {
            String Sql = "select max(id_daftar_kyd) from daftar_kyd";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_bakal_id_daftar_kyd.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_bakal_id_daftar_kyd.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_bakal_id_daftar_kyd.setText(siap);
            }
       }
catch (Exception e)
{String x;
        x="1";
    lbl_bakal_id_daftar_kyd.setText(x);
    System.out.println(e);
}    
}
    
    private void id_pendaftaran_yg_digunakan(){
          try
       {
            String Sql = "select max(id_pendaftaran) from pendaftaran";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_no_pendaftaran.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_no_pendaftaran.getText());
                String siap = Integer.toString(value1);
                lbl_no_pendaftaran.setText(siap);
            }
       }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}   
}
    private void MasukkanDataIDDaftarKYD(){
        try{
            String Sql = "insert into daftar_kyd (id_daftar_kyd, id_pendaftaran) values (?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setInt(2, Integer.parseInt(lbl_no_pendaftaran.getText()));

            pst.execute();
           }
        catch (Exception e){
            
        }
    }
    
    public DapatkanId_daftar_kyd() {
        initComponents();
        setLocation(450, 125);
        conn = KoneksiDB.ConnectDb();
        id_daftar_kyd_siap();
        id_pendaftaran_yg_digunakan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_bakal_id_daftar_kyd = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("id_daftar_kyd Anda adalah :");

        lbl_bakal_id_daftar_kyd.setFont(new java.awt.Font("SFNS Display", 0, 48)); // NOI18N
        lbl_bakal_id_daftar_kyd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bakal_id_daftar_kyd.setText("XXX");
        lbl_bakal_id_daftar_kyd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setFont(new java.awt.Font("SFNS Display", 0, 18)); // NOI18N
        jButton1.setText("Lanjutkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl_no_pendaftaran.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_no_pendaftaran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_no_pendaftaran.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("No. Pendaftaran :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bakal_id_daftar_kyd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_no_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_no_pendaftaran)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbl_bakal_id_daftar_kyd)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MasukkanDataIDDaftarKYD();
        KeluargaYangDatang kyd = new KeluargaYangDatang();
        desktopPane.add(kyd);
        kyd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel lbl_bakal_id_daftar_kyd;
    public static final javax.swing.JLabel lbl_no_pendaftaran = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
