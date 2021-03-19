/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author MODOFWAR
 * 
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import LowonganPekerjaan.Aplikasi;
import LowonganPekerjaan.Perusahaan;
import View.MainMenu;
import View.HalAwalPerusahaan;
import View.PerusahaanLogin;
import javax.swing.JOptionPane;


public class ControllerPerusahaanLogin implements ActionListener {
    
    PerusahaanLogin P;
    Aplikasi app;
    public static int X = 0;

    public ControllerPerusahaanLogin(Aplikasi app) {
        this.P = new PerusahaanLogin();
        this.P.setVisible(true);
        this.X = X;
        this.app= app;

        this.P.getLogin().addActionListener(this);
        this.P.getSignUp().addActionListener(this);
        this.P.getButtonBack().addActionListener(this);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        if(x.equals(P.getLogin())){

            String Password = P.getPassword().getText();
            String Email = P.getEmail().getText();  
            if(Password.equals("TUBES")&& Email.equals("PBO")){
            ControllerPerusahaan cmm= new ControllerPerusahaan(app);
            X = 1;
            this.P.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "WRONG EMAIL OR PASSWORD");
                this.P.setVisible(false);
                ControllerPerusahaanLogin cpl = new ControllerPerusahaanLogin(app);
           }

        }
        
        else if(x.equals(P.getSignUp())){
            this.P.setVisible(false);
            ControllerPerusahaanSignUp cpsu = new ControllerPerusahaanSignUp(app);
        }
        
        else if(x.equals(P.getButtonBack())) {
            this.P.setVisible(false);
            ControllerMainMenu cmm = new ControllerMainMenu(app);

        }

}
}
