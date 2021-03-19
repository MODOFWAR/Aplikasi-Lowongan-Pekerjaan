/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Driver.Database;
import View.TambahPelamar;
import View.TerimaBerkas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import LowonganPekerjaan.Aplikasi;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MODOFWAR
 */
public class ControllerTambahBerkas implements ActionListener {

    Aplikasi app;
    TerimaBerkas tb;

    public ControllerTambahBerkas(Aplikasi app) {
        this.app = app;
        this.tb = new TerimaBerkas();

        this.tb.getComboBoxPerusahaan().addItem("");
        for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {
            this.tb.getComboBoxPerusahaan().addItem(app.getDaftarPerusahaan().get(i).getNamaPerusahaan());

        }

        this.tb.getComboBoxLowongan().addActionListener(this);
        this.tb.getComboBoxPerusahaan().addActionListener(this);
        this.tb.setVisible(true);
        this.tb.getBackButton().addActionListener(this);
        this.tb.getTerimaButton().addActionListener(this);
    
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
            tb.setComboboxPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
        
        try {
            int no=1;
            String sql = "select Job_Vacancy from lowongan";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listJobVacancy = new ArrayList();
            while(res.next()){
                listJobVacancy.add(res.getString(1));
            }
            
            tb.setComboBoxLowongan(listJobVacancy);
        } catch (Exception e) {
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        Object a = tb.getComboBoxPerusahaan().getSelectedItem();

        if (x.equals(tb.getBackButton())) {
            this.tb.setVisible(false);
            ControllerHalLowongan cp = new ControllerHalLowongan(app);
        } else if (x.equals(tb.getComboBoxPerusahaan())) {
            for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {

                if (a.equals(app.getDaftarPerusahaan().get(i).getNamaPerusahaan())) {
                    this.tb.getComboBoxLowongan().removeAllItems();
                    for (int j = 0; j < app.getDaftarPerusahaan().get(i).getnLowongan(); j++) {
                        this.tb.getComboBoxLowongan().addItem(app.getDaftarPerusahaan().get(i).getLowongan(j).getNamaLowongan());

                    }
                }

            }

        } else if (x.equals(tb.getTerimaButton())) {
            String namaPelamar = tb.getNamaPelamarField().getText();
            String idBerkas = tb.getIdBerkasField().getText();
            JOptionPane.showMessageDialog(null, "ADDED FILE");
        }                    
    }

    
    
}
