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
import LowonganPekerjaan.Pelamar;
import View.HalAwalPelamar;

public class ControllerPelamar implements ActionListener {
    
    HalAwalPelamar pelamar;
    Aplikasi app;


    ControllerPelamar(Aplikasi app) {
                   this.app = app;
        this.pelamar = new HalAwalPelamar();
        this.pelamar.setVisible(true);
        
        this.pelamar.getTambahPelamar().addActionListener(this);
        this.pelamar.getDataPelamar().addActionListener(this);
        this.pelamar.getHapusPelamar().addActionListener(this);
        this.pelamar.getBuatBerkas().addActionListener(this);
        this.pelamar.getMinatLowongan().addActionListener(this);
        this.pelamar.getButtonBack().addActionListener(this);
        this.pelamar.getEditPelamar().addActionListener(this);
        this.pelamar.getEditBerkas().addActionListener(this);
        this.pelamar.getTampilkanBerkasDiterima().addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object x = ae.getSource();
        if(x.equals(pelamar.getTambahPelamar())){
            this.pelamar.setVisible(false);
            ControllerTambahPelamar ctp = new ControllerTambahPelamar(app);
        }
        else if(x.equals(pelamar.getDataPelamar())){
            this.pelamar.setVisible(false);
            ControllerTampilPelamar cdp = new ControllerTampilPelamar(app);
            
        }
        else if(x.equals(pelamar.getHapusPelamar())){
            this.pelamar.setVisible(false);
            ControllerHapusPelamar chp = new ControllerHapusPelamar(app);      
        }
        else if(x.equals(pelamar.getBuatBerkas())){
            this.pelamar.setVisible(false);
            ControllerBuatBerkas cbb = new ControllerBuatBerkas(app);
        }
        else if(x.equals(pelamar.getMinatLowongan())){
            this.pelamar.setVisible(false);
            ControllerMinatLowongan cml = new ControllerMinatLowongan(app);
        } else if (x.equals(pelamar.getEditPelamar())) {
            ControllerEditPelamar cep = new ControllerEditPelamar(app);
            this.pelamar.setVisible(false);        
        } 
        else if (x.equals(pelamar.getEditBerkas())) {
            ControllerEditBerkas ceb = new ControllerEditBerkas(app);
            this.pelamar.setVisible(false);        
        } 
        else if(x.equals(pelamar.getButtonBack())){
            this.pelamar.setVisible(false);
            ControllerMainMenu cmm = new ControllerMainMenu(app);
        }
        else if (x.equals(pelamar.getTampilkanBerkasDiterima())) {
            this.pelamar.setVisible(false);
            ControllerTampilkanBerkasDiterima ctbd = new ControllerTampilkanBerkasDiterima(app);
        }
   }
    
    
}
