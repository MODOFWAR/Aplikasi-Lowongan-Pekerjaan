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
import javax.swing.JTextField;
import LowonganPekerjaan.Aplikasi;
import View.minatlowongan;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MODOFWAR
 */
public class ControllerMinatLowongan implements ActionListener {

    Aplikasi app;
    minatlowongan ml;

    public ControllerMinatLowongan(Aplikasi ap) {
        this.app = ap;
        this.ml = new minatlowongan();

        this.ml.getComboBoxnamaPerusahaan().addItem("");
        for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {
            this.ml.getComboBoxnamaPerusahaan().addItem(app.getDaftarPerusahaan().get(i).getNamaPerusahaan());

        }
        
        this.ml.getComboBoxjenisPekerjaan().addItem("");
        for (int i = 0; i < app.getDaftarLowongan().size(); i++) {
            this.ml.getComboBoxjenisPekerjaan().addItem(app.getDaftarLowongan().get(i).getNamaLowongan());

        }

        this.ml.setVisible(true);

        this.ml.getDaftarButton().addActionListener(this);
        this.ml.getMenu().addActionListener(this);
        this.ml.getComboBoxjenisPekerjaan().addActionListener(this);
        this.ml.getComboBoxnamaPerusahaan().addActionListener(this);
        
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
            ml.setComboboxPerusahaan(listPerusahaan);
        } catch (Exception e) {
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        Object a = ml.getComboBoxnamaPerusahaan().getSelectedItem();
        if (x.equals(ml.getComboBoxnamaPerusahaan())){
            String namaPerusahaan = String.valueOf(ml.getComboBoxnamaPerusahaan().getSelectedItem());
             
            try {
            int no=1;
            
            String sql = "select Job_Vacancy from lowongan WHERE Company = '"+namaPerusahaan+ "'";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            ArrayList<String> listLowongan = new ArrayList();
            while(res.next()){
                listLowongan.add(res.getString(1));
            }
            
            ml.setComboboxjenisPekerjaan(listLowongan);
        } catch (Exception e) {
                System.out.println(e);
        }
            
        }
        if (x.equals(ml.getDaftarButton())) {
            String namaPerusahaan = String.valueOf(ml.getComboBoxnamaPerusahaan().getSelectedItem());
            String namaPelamar = ml.getNamaPelamar().getText();
            String idBerkas = ml.getIdBerkas().getText();
            String jenisPekerjaan = String.valueOf(ml.getComboBoxjenisPekerjaan().getSelectedItem());

             //app.getPerusahaan(namaPerusahaan).getLowongan(jenisPekerjaan).addBerkas(app.getPelamar(namaPelamar).getBerkas(idBerkas));
            JOptionPane.showMessageDialog(null, "SAVED");
        } else if (x.equals(ml.getMenu())) {
            this.ml.setVisible(false);
            ControllerPelamar cp = new ControllerPelamar(app);
        } else if (x.equals(ml.getComboBoxnamaPerusahaan())) {
            for (int i = 0; i < app.getDaftarPerusahaan().size(); i++) {

                if (a.equals(app.getDaftarPerusahaan().get(i).getNamaPerusahaan())) {
                    this.ml.getComboBoxjenisPekerjaan().removeAllItems();
                    for (int j = 0; j < app.getDaftarPerusahaan().get(i).getnLowongan(); j++) {
                        this.ml.getComboBoxjenisPekerjaan().addItem(app.getDaftarPerusahaan().get(i).getLowongan(j).getNamaLowongan());

                    }
                }

            }

        }

    }

}
