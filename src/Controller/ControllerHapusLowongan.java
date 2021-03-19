/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.Database;
import View.HapusLowongan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import LowonganPekerjaan.Aplikasi;
import View.TambahLowongan;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MODOFWAR
 */
public class ControllerHapusLowongan implements ActionListener {

    Aplikasi app;
    HapusLowongan hl;

    public ControllerHapusLowongan(Aplikasi ap) {
        this.app = ap;
        this.hl = new HapusLowongan();
        
        this.hl.getComboBoxPerusahaan().addItem("");
        for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {
            this.hl.getComboBoxPerusahaan().addItem(app.getDaftarPerusahaan().get(i).getNamaPerusahaan());
        }
        
        this.hl.getComboBoxIDLOWONGAN().addItem("");
        for (int i = 0; i < app.getDaftarLowongan().size(); i++) {
            this.hl.getComboBoxIDLOWONGAN().addItem(app.getDaftarLowongan().get(i).getNamaLowongan());
        }
 
        this.hl.setVisible(true);

        this.hl.getComboBoxPerusahaan().addActionListener(this);
        this.hl.getComboBoxIDLOWONGAN().addActionListener(this);
        this.hl.getHapusButton().addActionListener(this);
        this.hl.getBackButton().addActionListener(this);
        
        try {
            
            String sql = "select Perusahaan from perusahaan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listPerusahaan = new ArrayList();
            while(res.next()){
                listPerusahaan.add(res.getString(1));
            }
            hl.setComboboxPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        Object a = hl.getComboBoxPerusahaan().getSelectedItem();
        if (x.equals(hl.getComboBoxPerusahaan())){
            String namaPerusahaan = String.valueOf(hl.getComboBoxPerusahaan().getSelectedItem());
             
            try {
            int no=1;
            
            String sql = "select VacancyID from lowongan WHERE Company = '"+namaPerusahaan+ "'";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listLowongan = new ArrayList();
            while(res.next()){
                listLowongan.add(res.getString(1));
            }
            
            hl.setComboboxVid(listLowongan);
        } catch (Exception e) {
                System.out.println(e);
        }
            
        }
        if (x.equals(hl.getComboBoxPerusahaan())) {
            for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {

                if (a.equals(app.getDaftarPerusahaan().get(i).getNamaPerusahaan())) {
                    this.hl.getComboBoxIDLOWONGAN().removeAllItems();
                    for (int j = 0; j < app.getDaftarPerusahaan().get(i).getnLowongan(); j++) {
                        this.hl.getComboBoxIDLOWONGAN().addItem(app.getDaftarPerusahaan().get(i).getLowongan(j).getIdLowongan());

                    }
                }

            }
        } else if (x.equals(hl.getHapusButton())) {
            
            JOptionPane.showMessageDialog(null, "DELETED");
            ControllerHalLowongan cp = new ControllerHalLowongan(app);
                    
        } 
        else if (x.equals(hl.getBackButton())) {
            this.hl.setVisible(false);
            ControllerHalLowongan cmm = new ControllerHalLowongan(app);

        }
    }

}
