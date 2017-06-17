/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Arya Wicaksana
 */
public class Pendaftar extends javax.swing.JInternalFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String jeniskelamin;
         
public static int idpengguna;
public static String jabatan;
public static String alamat;


    public static int getIdpengguna() {
        return idpengguna;
    }

    public static String getJabatan() {
        return jabatan;
    }
    
    /**
     * Creates new form Pendaftar
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
jPanel1.paint(g2);
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
    
    public void bersih(){
    lbl_id_pendaftar.setText("-");
        txtnama.setText("");
        jeniskelamin = "";
        bgjk.setSelected(null, false);
        cbdesakelurahan.setSelectedIndex(0);
        txtalamat.setText(null);
        txtRT.setText("");
        txtRW.setText("");
} 

public void lebarKolom(){ 
        TableColumn column;
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = jTable1.getColumnModel().getColumn(0); 
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(1); 
        column.setPreferredWidth(160); 
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

private void cekIsi(){
    if ( (txtnama.getText().equals("")) ){
		JOptionPane.showMessageDialog(null, "Nama harus diisi","[ PERHATIAN ]",2);
		}
	
	else if		(jeniskelamin==null){
		JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin","[ PERHATIAN ]",2);
	}
	
	else if		(txtalamat.getText().equals("")){
		JOptionPane.showMessageDialog(null, "Alamat harus diisi","[ PERHATIAN ]",2);
		}
		
	else if		(txtRT.getText().equals("")){
		JOptionPane.showMessageDialog(null, "RT harus diisi","[ PERHATIAN ]",2);
		}
				
	else if		(txtRW.getText().equals("")){
		JOptionPane.showMessageDialog(null, "RW harus diisi","[ PERHATIAN ]",2);
		}
	        
        
        else {
            btnlanjutpendaftaran.setEnabled(true);
        }
}

private void id_siap(){
          try
       {
            String Sql = "select max(id_pendaftar) from pendaftar";
            pst=conn.prepareStatement(Sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                lbl_id_pendaftar.setText(rs.getString(1));
                int value1 =  Integer.parseInt(lbl_id_pendaftar.getText());
                int value2 = value1+1;
                String siap = Integer.toString(value2);
                lbl_id_pendaftar.setText(siap);
            }
       }
catch (Exception e)
{String i;
        i="1";
    lbl_id_pendaftar.setText(i);
    System.out.println(e);
}   
}

private void UpdateTabelPendaftar(){
    try
        {
            String sql = "select id_pendaftar as 'ID', nama as 'Nama', jk as 'JK', "
                    + "desakelurahan_pendaftar as 'Desa/Kelurahan', alamat as 'Alamat',"
                    + "RT as 'RT', RW as 'RW', id_pengguna as 'ID Penginput' "
                    + "from pendaftar order by id_pendaftar desc;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}
}

    public Pendaftar() {
        initComponents();
        conn = KoneksiDB.ConnectDb(); 
        bersih();
        UpdateTabelPendaftar();
        jLabel1.setText("Form ini diisi oleh "+jabatan+" "+idpengguna);
        lebarKolom();
        id_siap();
        this.setSize(500, 580);
      txtnama.setDocument(new batasInput((byte)50).getKata(txtnama));
      txtRT.setDocument(new batasInput((byte)3).getOnlyNumber(txtRT));
      txtRW.setDocument(new batasInput((byte)3).getOnlyNumber(txtRW));

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgjk = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        rblaki = new javax.swing.JRadioButton();
        rbperempuan = new javax.swing.JRadioButton();
        btnsimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblRT = new javax.swing.JLabel();
        lblRW = new javax.swing.JLabel();
        btnubahdata = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_id_pendaftar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbdesakelurahan = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pendaftar");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1270, 560));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Desa/Kelurahan :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, -1, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Alamat :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 217, -1, -1));

        txtnama.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamaKeyTyped(evt);
            }
        });
        jPanel1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 110, 310, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Jenis Kelamin :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 110, 50));

        lblnama.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblnama.setText("Nama :");
        jPanel1.add(lblnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        bgjk.add(rblaki);
        rblaki.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rblaki.setText("Laki-Laki");
        rblaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rblakiActionPerformed(evt);
            }
        });
        jPanel1.add(rblaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 30));

        bgjk.add(rbperempuan);
        rbperempuan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rbperempuan.setText("Perempuan");
        rbperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbperempuanActionPerformed(evt);
            }
        });
        jPanel1.add(rbperempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 30));

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtalamat.setRows(5);
        txtalamat.setAutoscrolls(false);
        txtalamat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 300, 100));

        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 50));

        btnlanjutpendaftaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlanjutpendaftaran.setText("Lanjutkan");
        btnlanjutpendaftaran.setEnabled(false);
        btnlanjutpendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlanjutpendaftaranActionPerformed(evt);
            }
        });
        jPanel1.add(btnlanjutpendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 490, 130, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("nama pengguna yang mengisi form pendaftaran ini");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        txtRT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel1.add(txtRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 359, 34, -1));

        txtRW.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel1.add(txtRW, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 400, 34, -1));

        lblRT.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblRT.setText("RT :");
        jPanel1.add(lblRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 362, -1, -1));

        lblRW.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblRW.setText("RW :");
        jPanel1.add(lblRW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 403, -1, -1));

        btnubahdata.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnubahdata.setText("Ubah/Pakai Data");
        btnubahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahdataActionPerformed(evt);
            }
        });
        jPanel1.add(btnubahdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 440, 210, 44));

        btnhapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnhapus.setText("Hapus Data");
        btnhapus.setEnabled(false);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, 44));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("ID Pendaftar :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lbl_id_pendaftar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbl_id_pendaftar.setText("XXXXX");
        jPanel1.add(lbl_id_pendaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 50, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Jenis Kelamin", "Desa/Kelurahan", "Alamat", "RT", "RW"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jTable1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Jenis Kelamin");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Desa/Kelurahan");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Alamat");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("RT");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("RW");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 80, 780, -1));

        jLabel4.setFont(new java.awt.Font("SFNS Display", 0, 48)); // NOI18N
        jLabel4.setText("Pendaftar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cbdesakelurahan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbdesakelurahan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gilingsari", "Guntur", "Joho", "Lungge", "Mudal", "Nampirejo", "Banyuurip", "Butuh", "Giyanti", "Jampirejo", "Jampiroso", "Jurang", "Kebonsari", "Kertosari", "Kowangan", "Madureso", "Manding", "Mungseng", "Purworejo", "Sidorejo", "Temanggung I", "Temanggung II", "Tlogorejo", "Walitelon Selatan", "Walitelon Utara" }));
        cbdesakelurahan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbdesakelurahanItemStateChanged(evt);
            }
        });
        cbdesakelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdesakelurahanActionPerformed(evt);
            }
        });
        jPanel1.add(cbdesakelurahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 177, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void rblakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rblakiActionPerformed
        // TODO add your handling code here:
        jeniskelamin="L";
    }//GEN-LAST:event_rblakiActionPerformed

    private void rbperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbperempuanActionPerformed
        // TODO add your handling code here:
        jeniskelamin="P";
    }//GEN-LAST:event_rbperempuanActionPerformed

    private void btnlanjutpendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlanjutpendaftaranActionPerformed
        // TODO add your handling code here:
//new Pendaftar().setIconifiable(true);  
        this.setVisible(false);
        Pendaftaran Pd = new Pendaftaran();
        MenuUtama.desktopPane.add(Pd);
            Pd.setVisible(true);
    }//GEN-LAST:event_btnlanjutpendaftaranActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
          cekIsi();
          int  rt =  Integer.parseInt(txtRT.getText());
          int  rw =  Integer.parseInt(txtRW.getText());
          String nama = txtnama.getText();
        try
        {
            String Sql = "insert into pendaftar (id_pendaftar,nama,jk,desakelurahan_pendaftar,alamat,RT,RW,id_pengguna) values (?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(Sql);

            pst.setInt(1, 0);
            pst.setString(2, nama);
            pst.setString(3, jeniskelamin);
            pst.setString(4, (String) cbdesakelurahan.getSelectedItem());
            pst.setString(5, txtalamat.getText());
            pst.setInt(6, rt);
            pst.setInt(7, rw);
            pst.setInt(8, idpengguna); 
            
            pst.execute();
           
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan.","[ SUKSES ]",1);
            UpdateTabelPendaftar();
            
            lebarKolom();
            
            //btnlanjutpendaftaran.setEnabled(true);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Penambahan data ke tabel SQL : Error");
        }
        
        
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void txtnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyTyped
        // TODO add your handling code here:
   
    }//GEN-LAST:event_txtnamaKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        btnubahdata.setFont(new java.awt.Font("Tahoma", 1, 9));
        btnubahdata.setText("Simpan Perubahan / Gunakan Data");
        btnsimpan.setEnabled(false);
        btnlanjutpendaftaran.setEnabled(false);
        btnhapus.setEnabled(true);
        try{
            int row = jTable1.getSelectedRow();
            String Table_click = (jTable1.getModel().getValueAt(row, 0).toString());
            String sql= "select * from pendaftar where id_pendaftar='"+Table_click+"' ";
            
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
              if(rs.next()) {
                String add0= rs.getString("id_pendaftar");
                lbl_id_pendaftar.setText(add0); 
                String add1= rs.getString("nama");
                txtnama.setText(add1);
                String add2= rs.getString("jk");
                if (add2.equals("P") ) {
                jeniskelamin="P";
                rbperempuan.setSelected(true); 
                } else {
                jeniskelamin="L";
                rblaki.setSelected(true); 
                }
                
                String add3= rs.getString("desakelurahan_pendaftar");
                cbdesakelurahan.setSelectedItem(add3);
                String add4= rs.getString("alamat");
                txtalamat.setText(add4);
                String add5= rs.getString("rt");
                txtRT.setText(add5);
                String add6= rs.getString("rw");
                txtRW.setText(add6);
            }
      }
        catch(Exception e){
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void btnubahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahdataActionPerformed
        // TODO add your handling code here:
        this.setSize(1280, 580);
        btnhapus.setEnabled(false);
        try
        {
            int value1 = Integer.parseInt(lbl_id_pendaftar.getText());
            String value2 = txtnama.getText();
            String value3 = jeniskelamin;
            String value4 = (String) cbdesakelurahan.getSelectedItem();
            String value5 = txtalamat.getText();
            int value6 = Integer.parseInt(txtRT.getText());
            int value7 = Integer.parseInt(txtRW.getText());
            
            String sql="update pendaftar set id_pendaftar='"+value1+"', nama='"+value2+"', "
                    + "jk='"+value3+"', desakelurahan_pendaftar='"+value4+"', alamat='"+value5+"', "
                    + "rt='"+value6+"', rw='"+value7+"' where id_pendaftar='"+value1+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Tersimpan.","[ SUKSES ]",1);
            UpdateTabelPendaftar();
            lebarKolom();
            btnlanjutpendaftaran.setEnabled(true);
        }
        catch (Exception e){
        }
    }//GEN-LAST:event_btnubahdataActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        
       { 
        String ObjButtons[] = {"Ya","Tidak"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Apakah Anda ingin menghapus data yang anda pilih?","[ PENTING ]",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
           try {
            String sql = "delete from pendaftar where id_pendaftar=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, lbl_id_pendaftar.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Terhapus.","[ SUKSES ]",1);
            UpdateTabelPendaftar();
            lebarKolom();
            bersih();
            id_siap();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
        else {
            
        }
                
            }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void cbdesakelurahanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbdesakelurahanItemStateChanged
    
    }//GEN-LAST:event_cbdesakelurahanItemStateChanged

    private void cbdesakelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdesakelurahanActionPerformed
   
    }//GEN-LAST:event_cbdesakelurahanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgjk;
    private javax.swing.JButton btnhapus;
    public static final javax.swing.JButton btnlanjutpendaftaran = new javax.swing.JButton();
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubahdata;
    public static javax.swing.JComboBox cbdesakelurahan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRT;
    private javax.swing.JLabel lblRW;
    public static javax.swing.JLabel lbl_id_pendaftar;
    private javax.swing.JLabel lblnama;
    private javax.swing.JRadioButton rblaki;
    private javax.swing.JRadioButton rbperempuan;
    public static final javax.swing.JTextField txtRT = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtRW = new javax.swing.JTextField();
    public static final javax.swing.JTextArea txtalamat = new javax.swing.JTextArea();
    public static final javax.swing.JTextField txtnama = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}