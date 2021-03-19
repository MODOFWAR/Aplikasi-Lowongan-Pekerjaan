/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.Database;
import View.TambahLowongan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import LowonganPekerjaan.Aplikasi;
import LowonganPekerjaan.Perusahaan;
import LowonganPekerjaan.Lowongan;
import java.sql.Connection;
import java.util.ArrayList;
import View.TambahLowongan;
        

/**
 *
 * @author MODOFWAR
 */
public class ControllerTambahLowongan implements ActionListener {

    TambahLowongan tl;
    Aplikasi app;

    public ControllerTambahLowongan(Aplikasi ap) {
        this.app = ap;
        this.tl = new TambahLowongan();
        
        this.tl.getComboBoxPerusahaan().addItem("");
        for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {
            this.tl.getComboBoxPerusahaan().addItem(app.getDaftarPerusahaan().get(i).getNamaPerusahaan());

        }
        
        this.tl.setVisible(true);
        this.tl.getComboBoxPerusahaan().addActionListener(this);
        this.tl.getBackButton().addActionListener(this);
        this.tl.getTambahButton().addActionListener(this);
    
    try {
            
            String sql = "select Perusahaan from perusahaan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listPerusahaan = new ArrayList();
            while(res.next()){
                listPerusahaan.add(res.getString(1));
            }
            tl.setComboboxPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        
        if (x.equals(tl.getTambahButton())) {
            String namaLowongan = tl.getNamaLowonganField().getText();
            String idLowongan = tl.getIdLowonganField().getText();
            String deadline = tl.getDeadlineFieldText().getText();
            int waktuKerja = tl.getWaktuKerjaFieldText1();
            JOptionPane.showMessageDialog(null, "JOB VACANCY ADDED");
        } else if (x.equals(tl.getBackButton())) {
            this.tl.setVisible(false);
            ControllerHalLowongan cp = new ControllerHalLowongan(app);
        }
    }

}
