
package Form;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author novika
 */
public class lapSuratPindahDatang extends javax.swing.JInternalFrame {

    String tanggal_1;
    String tanggal_2;

    /** Creates new form lapPembelian */
    public lapSuratPindahDatang() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCari = new javax.swing.JButton();
        tanggal1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        tanggal2 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("Laporan Pendaftaran Surat Pindah Datang");

        btnCari.setText("View");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tanggal1.setDateFormatString("yyyy-MM-dd");
        tanggal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal1PropertyChange(evt);
            }
        });

        jLabel2.setText("sampai dengan");

        tanggal2.setDateFormatString("yyyy-MM-dd");
        tanggal2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnCari)
                .addContainerGap(212, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(30, 30, 30)
                    .addComponent(tanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(btnCari)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(92, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/kependudukan1";
            Connection cn = (Connection) DriverManager.getConnection(url, "root", "");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tgl1 = sdf.format(tanggal1.getDate());
            String tgl2 = sdf.format(tanggal2.getDate());
            //String SQL = "select * from tampilpembelian where (tanggalbeli BETWEEN '" + tgl1 + "' and '" + tgl2 + "')";
            String SQL = "SELECT pendaftaran.id_pendaftaran,pendaftaran.jenis_permohonan,pendaftaran.tgl_daftar,pendaftaran.tgl_jadi,pendaftaran.id_pengguna,pendaftar.id_pendaftar, pendaftar.nama, pendaftar.jk, pendaftar.desakelurahan_pendaftar, pendaftar.alamat, pendaftar.RT, pendaftar.RW\n" +
                         "FROM pendaftaran " +
                         "LEFT JOIN pendaftar " +
                         "ON pendaftaran.id_pendaftar=pendaftar.id_pendaftar" + 
                         " where (`tgl_daftar` BETWEEN '"+tgl1+"' and '"+tgl2+"') and jenis_permohonan = 'Surat Pindah Datang' ";
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            JasperPrint jasperPrint;
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            JasperReport jasperReport = JasperCompileManager.compileReport(System.getProperties().getProperty("java.class.path").split(";")[System.getProperties().getProperty("java.class.path").split(";").length - 1] + "/Laporan/lapPendaftaran.jrxml");
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint);
            JDialog viewer = new JDialog();
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            viewer.setBounds(470, 30, screenSize.width, screenSize.height);
            viewer.setSize(900, 700);
            viewer.setTitle(" Laporan Loket I - Surat Pindah Datang");
            viewer.setVisible(true);

            st.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tanggal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal1PropertyChange
        // TODO add your handling code here:
        if (tanggal1.getDate() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal_1 = simpleDateFormat.format(tanggal1.getDate());
        }
}//GEN-LAST:event_tanggal1PropertyChange

    private void tanggal2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal2PropertyChange
        // TODO add your handling code here:
        if (tanggal2.getDate() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            tanggal_2 = simpleDateFormat.format(tanggal2.getDate());
        }
}//GEN-LAST:event_tanggal2PropertyChange
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JDateChooser tanggal1;
    private com.toedter.calendar.JDateChooser tanggal2;
    // End of variables declaration//GEN-END:variables
}
