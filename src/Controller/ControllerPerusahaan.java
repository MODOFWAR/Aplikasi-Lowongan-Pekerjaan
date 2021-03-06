/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author MODOFWAR
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import LowonganPekerjaan.Aplikasi;
import LowonganPekerjaan.Perusahaan;
import View.MainMenu;
import View.HalAwalPerusahaan;

public class ControllerPerusahaan implements ActionListener {
    
    HalAwalPerusahaan p;
    Aplikasi app;
    
    public ControllerPerusahaan(Aplikasi ap) {
        this.p = new HalAwalPerusahaan();
        this.p.setVisible(true);
        this.app = ap;
        
        this.p.getButtonBack().addActionListener(this);
        this.p.getTampilkanPerusahaan().addActionListener(this);
        this.p.getTambahPerusahaan().addActionListener(this);
        this.p.getHapusPerusahaan().addActionListener(this);
        this.p.getVacancy().addActionListener(this);
        this.p.getEditPerusahaan().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(p.getTambahPerusahaan())) {
            this.p.setVisible(false);
            ControllerTambahPerusahaan cp = new ControllerTambahPerusahaan(app);
        } else if (x.equals(p.getTampilkanPerusahaan())) {
            this.p.setVisible(false);
            ControllerTampilkanPerusahaan ctp = new ControllerTampilkanPerusahaan(app);
            
        } else if (x.equals(p.getHapusPerusahaan())) {
            ControllerHapusPerusahaan chp = new ControllerHapusPerusahaan(app);
            this.p.setVisible(false);
            
         } else if (x.equals(p.getVacancy())) {
            ControllerHalLowongan chl = new ControllerHalLowongan(app);
            this.p.setVisible(false);
            
        } else if (x.equals(p.getEditPerusahaan())) {
            ControllerEditPerusahaan cep = new ControllerEditPerusahaan(app);
            this.p.setVisible(false);        
        } else if (x.equals(p.getButtonBack())) {
            this.p.setVisible(false);
            ControllerMainMenu cmm = new ControllerMainMenu(app);
      
    }
    }
}
