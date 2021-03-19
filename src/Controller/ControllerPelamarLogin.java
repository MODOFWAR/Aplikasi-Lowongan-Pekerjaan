/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author MODOFWAR
 */import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import LowonganPekerjaan.Aplikasi;
import LowonganPekerjaan.Pelamar;
import View.MainMenu;
import View.PelamarLogin;
import javax.swing.JOptionPane;


public class ControllerPelamarLogin implements ActionListener {
    
    PelamarLogin P;
    Aplikasi app;
    public static int X = 0;

    public ControllerPelamarLogin(Aplikasi app) {
        this.P = new PelamarLogin();
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
            ControllerPelamar cmm= new ControllerPelamar(app);
            X = 1;
            this.P.setVisible(false);
           }
            else{
                JOptionPane.showMessageDialog(null, "WRONG EMAIL OR PASSWORD");
                this.P.setVisible(false);
                ControllerPelamarLogin cpl = new ControllerPelamarLogin(app);
            }
            
        }
        
        else if(x.equals(P.getSignUp())){
            this.P.setVisible(false);
            ControllerPelamarSignUp cp = new ControllerPelamarSignUp(app);
        }
        else if(x.equals(P.getButtonBack())) {
            this.P.setVisible(false);
            ControllerMainMenu cmm = new ControllerMainMenu(app);

        }

    }

}
