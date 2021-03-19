/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import LowonganPekerjaan.Aplikasi;
import View.buatberkas;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MODOFWAR
 */
public class ControllerBuatBerkas implements ActionListener{
     Aplikasi app;
    buatberkas bb;
    
    public ControllerBuatBerkas(Aplikasi ap){
        this.app = ap;
        this.bb = new buatberkas();
        this.bb.setVisible(true);
        
        this.bb.getBuatBerkas().addActionListener(this);
        this.bb.getBackButton().addActionListener(this);
    
        try {
            
            String sql = "select Perusahaan from perusahaan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listPerusahaan = new ArrayList();
            while(res.next()){
                listPerusahaan.add(res.getString(1));
            }
            bb.setComboPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
    
    }
        
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
  Object x = ae.getSource();
        if(x.equals(bb.getBuatBerkas())){
            String namaPelamar = bb.getNamaPelamar().getText();
            String idBerkas = bb.getIdBekas().getText();
            String jenisBerkas = bb.getJenisBerkasPilihan().getSelectedItem().toString();
            String tanggalMasuk = bb.getTanggalMasuk().getText();
            String Perusahaan = bb.getjComboBox1().getSelectedItem().toString();
                             
//            app.getPelamar(namaPelamar).createBerkas(idBerkas, jenisBerkas, tanggalMasuk);
            JOptionPane.showMessageDialog(null, "SUCCESSFUL!");
             ControllerPelamar cp = new ControllerPelamar(app);
             this.bb.setVisible(false);
            
             boolean ada = false;
            try {
                int no=1;
                String sql = "select Nama from pelamar WHERE Nama = '"+namaPelamar+"'";
                java.sql.Connection conn=(Connection)Database.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                
                String nama = "";
                while(res.next()){
                    nama = res.getString(1);
                }
                if(nama.equals(namaPelamar)) {
                    ada = true;
                }
            } catch (Exception e) {
                System.out.println("cek nama exception : "+e);
            }  
             if(ada == true) {
              String ID_Perusahaan = "";
                 try{
                String sql = "select ID_Perusahaan from perusahaan WHERE Perusahaan = '"+Perusahaan+"'";
                java.sql.Connection conn=(Connection)Database.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                
                while(res.next()){
                    ID_Perusahaan = res.getString(1);
                }
                 }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        }
              try {
                String sql = "INSERT INTO berkas VALUES ('"+idBerkas+"','"+namaPelamar+"','"+jenisBerkas+"','"+tanggalMasuk+"','"+ID_Perusahaan+"')";
                java.sql.Connection conn=(com.mysql.jdbc.Connection)Database.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }  
            }
             
    }
        else if(x.equals(bb.getBackButton())){
              
               ControllerPelamar cp = new ControllerPelamar(app);
                bb.setVisible(false);
           }
    }  
         
}
