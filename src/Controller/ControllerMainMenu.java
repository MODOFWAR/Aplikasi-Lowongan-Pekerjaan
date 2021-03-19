/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import LowonganPekerjaan.Aplikasi;
import View.MainMenu;
import Controller.ControllerPerusahaanLogin;

/**
 *
 * @author MODOFWAR
 */
public class ControllerMainMenu implements ActionListener {

    MainMenu mainmenu;
    Aplikasi app;

    public ControllerMainMenu(Aplikasi app) {
        this.mainmenu = new MainMenu();
        this.mainmenu.setVisible(true);
        
        this.app= app;

        this.mainmenu.getPerusahaan().addActionListener(this);
        this.mainmenu.getPelamar().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if(x.equals(mainmenu.getPerusahaan())){
            if(ControllerPerusahaanLogin.X == 0){
            ControllerPerusahaanLogin cmm= new ControllerPerusahaanLogin(app);
            this.mainmenu.setVisible(false);}
            else{
            ControllerPerusahaan cp = new ControllerPerusahaan(app);
            this.mainmenu.setVisible(false);
            }
            
        }
        
        else if(x.equals(mainmenu.getPelamar())){
            if(ControllerPelamarLogin.X == 0){            
            ControllerPelamarLogin cpl = new ControllerPelamarLogin(app);
            this.mainmenu.setVisible(false);}
            else{
            ControllerPelamar cpl = new ControllerPelamar(app);
            this.mainmenu.setVisible(false);
            }
        

    }

}
}
