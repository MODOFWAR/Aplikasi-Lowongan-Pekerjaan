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
import View.PelamarLogin;
import View.PelamarSignUp;
import javax.swing.JOptionPane;


public class ControllerPelamarSignUp implements ActionListener {
    
    PelamarSignUp P;
    Aplikasi app;

    public ControllerPelamarSignUp(Aplikasi app) {
        this.P = new PelamarSignUp();
        this.P.setVisible(true);
        
        this.app= app;

        this.P.getSignUp().addActionListener(this);
        this.P.getButtonBack().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if(x.equals(P.getSignUp())){
            this.P.setVisible(true);
            JOptionPane.showMessageDialog(null, "SIGN UP PROCESS SUCCESSFUL");
            this.P.setVisible(false);
            ControllerPelamar cp = new ControllerPelamar(app);
        }
        else if(x.equals(P.getButtonBack())) {
            this.P.setVisible(false);
            ControllerPelamarLogin cmm = new ControllerPelamarLogin(app);
        }
    }

}
