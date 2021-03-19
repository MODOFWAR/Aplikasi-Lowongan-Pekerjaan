/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.Database;
import View.TampilkanBerkasDiterima;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LowonganPekerjaan.Aplikasi;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MODOFWAR
 */
public class ControllerTampilkanBerkasDiterima implements ActionListener{
    TampilkanBerkasDiterima tp;
    Aplikasi app;

    public ControllerTampilkanBerkasDiterima(Aplikasi ap) {
        this.app = ap;
        this.tp = new TampilkanBerkasDiterima();
        
        this.tp.getComboBoxPErusahaan().addItem("");
        for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {
            this.tp.getComboBoxPErusahaan().addItem(app.getDaftarPerusahaan().get(i).getNamaPerusahaan());

        }
        try {
            String sql = "select Job_Vacancy from lowongan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listJobVacancy = new ArrayList();
            while(res.next()){
                listJobVacancy.add(res.getString(1));
            }
            tp.setComboBoxLowongan(listJobVacancy);
        } catch (Exception e) {System.out.println(e);
        }
        
        this.tp.setVisible(true);
        
        this.tp.getComboBoxPErusahaan().addActionListener(this);
        this.tp.getComboBoxPErusahaan1().addActionListener(this);

        this.tp.getBackButton().addActionListener(this);
        this.tp.getTampilkanButton().addActionListener(this);
        
        try {
            int no=1;
            String sql = "select Perusahaan from perusahaan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listPerusahaan = new ArrayList();
            while(res.next()){
                listPerusahaan.add(res.getString(1));
            }
            tp.setComboboxPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
             Object x = ae.getSource();
             Object a= tp.getComboBoxPErusahaan().getSelectedItem();
        if (x.equals(tp.getBackButton())) {
            this.tp.setVisible(false);
            ControllerPelamar cm = new ControllerPelamar(app);
        }
        else if(x.equals(tp.getComboBoxPErusahaan())){
            for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {

                if (a.equals(app.getDaftarPerusahaan().get(i).getNamaPerusahaan())) {
                    this.tp.getComboBoxPErusahaan1().removeAllItems();
                    for (int j = 0; j < app.getDaftarPerusahaan().get(i).getnLowongan(); j++) {
                        this.tp.getComboBoxPErusahaan1().addItem(app.getDaftarPerusahaan().get(i).getLowongan(j).getNamaLowongan());

                    }
                }
        }
        }
    
}
}