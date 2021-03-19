/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import LowonganPekerjaan.Aplikasi;
import LowonganPekerjaan.Perusahaan;
import View.MainMenu;
import View.TambahPerusahaan;
import javax.swing.JOptionPane;

/**
 *
 * @author MODOFWAR
 */
public class ControllerTambahPerusahaan implements ActionListener {

    TambahPerusahaan tambahperusahaan;
    Aplikasi app;

    public ControllerTambahPerusahaan(Aplikasi app) {
        this.app = app;

        this.tambahperusahaan = new TambahPerusahaan();
        this.tambahperusahaan.setVisible(true);

        this.tambahperusahaan.getTambahButton().addActionListener(this);
        this.tambahperusahaan.getBackButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();

        if (x.equals(tambahperusahaan.getTambahButton())) {
            String namaPemilik = tambahperusahaan.getNamaPemilik().getText();
            String namaPerusahaan = tambahperusahaan.getNamaPerusahaan().getText();
            app.getDaftarPerusahaan().add(new Perusahaan(namaPemilik, namaPerusahaan));
            JOptionPane.showMessageDialog(null,"COMPANY ADDED");
        } else if (x.equals(tambahperusahaan.getBackButton())) {
            this.tambahperusahaan.setVisible(false);

            ControllerPerusahaan cmm = new ControllerPerusahaan(app);
        }

    }
}
