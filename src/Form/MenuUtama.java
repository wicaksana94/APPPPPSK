/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Arya Wicaksana
 */
public class MenuUtama extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public static int idpengguna;
    public static String jabatan;


    public int getIdpengguna() {
        return idpengguna;
    }

    public static String getJabatan() {
        return jabatan;
    }
public void JAM() {

ActionListener taskPerformer = new ActionListener() {
public void actionPerformed(ActionEvent evt) {
String nol_jam = "";
String nol_menit = "";
String nol_detik = "";
String status_hari="";


Calendar dt = Calendar.getInstance();
// Mengambil nilai JAM, MENIT, dan DETIK Sekarang
int nilai_jam = dt.get(dt.HOUR_OF_DAY);
int nilai_menit = dt.get(dt.MINUTE);
int nilai_detik = dt.get(dt.SECOND);

if (nilai_jam <= 9) {
// Tambahkan "0" didepannya
nol_jam = "0";
}
// Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
if (nilai_menit <= 9) {
// Tambahkan "0" didepannya
nol_menit = "0";
}
// Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
if (nilai_detik <= 9) {
// Tambahkan "0" didepannya
nol_detik = "0";
}

// Membuat String JAM, MENIT, DETIK
String jam = nol_jam + Integer.toString(nilai_jam);
String menit = nol_menit + Integer.toString(nilai_menit);
String detik = nol_detik + Integer.toString(nilai_detik);
lblJam.setText(jam + ":" + menit + ":" + detik);
//Tanggal();
}

};
// Timer
new javax.swing.Timer(1000, taskPerformer).start();

}

private void tanggal(){
        Date now = new Date();
        SimpleDateFormat frm = new SimpleDateFormat("dd MMMM yyyy");
        String tgl = frm.format(now);
        lblTanggal.setText(tgl);
}
    
    /**
     * Creates new form Utama
     */

private void panelMenuUtama(){
    lbl_selamat_datang.setFont(new java.awt.Font("SNFS Display", 1, 24));
    lblJam.setFont(new java.awt.Font("SNFS Display", 1, 24));
    lblTanggal.setFont(new java.awt.Font("SNFS Display", 1, 24));
    tanggal();
    JAM();
}

    public MenuUtama() {
        initComponents();
        conn = KoneksiDB.ConnectDb(); 
        setLocationRelativeTo(null);
        panelMenuUtama();
        tanggal();
        JAM();
        lbl_selamat_datang.setText("Selamat datang, " + jabatan + " " + idpengguna);
        if (jabatan.equals("Petugas")){
                     mnPetugas.setVisible(false);
                     mnubahpetugas.setEnabled(false);
                     mnPetugas.setEnabled(false);                   
        }
        ImageIcon ico = new ImageIcon("src\\Gambar\\book.png");
        setIconImage(ico.getImage());
        setTitle("Menu Utama");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clGlossyPanel1 = new GlossyPanel.ClGlossyPanel();
        lbl_selamat_datang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnPetugas = new javax.swing.JMenu();
        mnubahpetugas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktopPane.setName(""); // NOI18N

        lbl_selamat_datang.setFont(new java.awt.Font("SFNS Display", 1, 24)); // NOI18N
        lbl_selamat_datang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selamat_datang.setText("Selamat datang, Admin 20");

        lblTanggal.setFont(new java.awt.Font("SFNS Display", 1, 24)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggal.setText("18 Januari 2016");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Places-user-identity-icon.png"))); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Calendar-icon.png"))); // NOI18N

        lblJam.setFont(new java.awt.Font("SFNS Display", 1, 24)); // NOI18N
        lblJam.setForeground(new java.awt.Color(255, 255, 255));
        lblJam.setText("00:00:00");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Clock-icon.png"))); // NOI18N

        javax.swing.GroupLayout clGlossyPanel1Layout = new javax.swing.GroupLayout(clGlossyPanel1);
        clGlossyPanel1.setLayout(clGlossyPanel1Layout);
        clGlossyPanel1Layout.setHorizontalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_selamat_datang, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                    .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                        .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblJam, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clGlossyPanel1Layout.setVerticalGroup(
            clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clGlossyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_selamat_datang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(clGlossyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        desktopPane.add(clGlossyPanel1);
        clGlossyPanel1.setBounds(20, 20, 390, 150);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Psfries_Polygonal black_ak1kRw.jpg"))); // NOI18N
        desktopPane.add(jLabel5);
        jLabel5.setBounds(0, 0, 1536, 960);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Keluar");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("Pendaftaran");

        jMenuItem1.setText("Input Pendaftaran");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem10.setText("Ubah Pendaftaran");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem2.setText("Ubah Data Pendaftar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu3.setText("Ubah Pendaftaran Data Kependudukan");

        jMenuItem7.setText("Ubah Pendaftaran KTP");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Ubah Pendaftaran Surat Pindah");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Ubah Pendaftaran Surat Pindah Datang");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenu1.add(jMenu3);

        menuBar.add(jMenu1);

        jMenu2.setText("Laporan");

        jMenuItem3.setText("KTP");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Surat Pindah");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Surat Pindah Datang");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Data Pendaftar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        menuBar.add(jMenu2);

        mnPetugas.setText("Petugas");
        mnPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPetugasActionPerformed(evt);
            }
        });

        mnubahpetugas.setText("Ubah Petugas");
        mnubahpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnubahpetugasActionPerformed(evt);
            }
        });
        mnPetugas.add(mnubahpetugas);

        menuBar.add(mnPetugas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:       
        Pendaftar P = new Pendaftar();
        
        desktopPane.add(P);
            P.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here: 
        Pendaftar xp = new Pendaftar();
        
        desktopPane.add(xp);
            xp.setVisible(true);
            xp.setSize(1280, 580);
            Pendaftar.btnlanjutpendaftaran.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnubahpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnubahpetugasActionPerformed
        // TODO add your handling code here:
        UbahPetugas U = new UbahPetugas();
        
        desktopPane.add(U);
            U.setVisible(true);
    }//GEN-LAST:event_mnubahpetugasActionPerformed

    private void mnPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPetugasActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_mnPetugasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        lapKTP Lktp = new lapKTP();
        
        desktopPane.add(Lktp);
            Lktp.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        lapSuratPindah Lsp = new lapSuratPindah();
        
        desktopPane.add(Lsp);
            Lsp.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        lapSuratPindahDatang Lspd = new lapSuratPindahDatang();
        
        desktopPane.add(Lspd);
            Lspd.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        lapDataPendaftar Ldp = new lapDataPendaftar();
        
        desktopPane.add(Ldp);
            Ldp.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        UbahPendKTP uktp = new UbahPendKTP();
        
        desktopPane.add(uktp);
            uktp.setVisible(true);
            uktp.setSize(1280, 525);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        UbahPendSP usp = new UbahPendSP();
        
        desktopPane.add(usp);
            usp.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        UbahPendSPD uspd = new UbahPendSPD();
        
        desktopPane.add(uspd);
            uspd.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        UbahPendaftaran up = new UbahPendaftaran();
        
        desktopPane.add(up);
            up.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menutup Aplikasi?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    }//GEN-LAST:event_formWindowClosing

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menutup Aplikasi?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GlossyPanel.ClGlossyPanel clGlossyPanel1;
    public static final javax.swing.JDesktopPane desktopPane = new javax.swing.JDesktopPane();
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static final javax.swing.JLabel lblJam = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblTanggal = new javax.swing.JLabel();
    private javax.swing.JLabel lbl_selamat_datang;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnPetugas;
    public static javax.swing.JMenuItem mnubahpetugas;
    // End of variables declaration//GEN-END:variables
}
