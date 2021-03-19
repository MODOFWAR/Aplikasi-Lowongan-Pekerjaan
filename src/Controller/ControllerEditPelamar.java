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
import LowonganPekerjaan.Pelamar;
import javax.swing.JOptionPane;
import View.EditPelamar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
/**
 *
 * @author MODOFWAR
 */
public class ControllerEditPelamar extends MouseAdapter implements ActionListener{
    EditPelamar tp;
    Aplikasi app;
    Pelamar p;

    public ControllerEditPelamar(Aplikasi ap)  {
        this.app = ap;
        this.tp = new EditPelamar();
        this.tp.setVisible(true);
        tp.addMouseAdapter(this);
        this.tp.getBackButton().addActionListener(this);
    }

        public void mousePressed(MouseEvent me) {
        Object source = me.getSource();
     
        if(source.equals(tp.gettedit())) {
            int viewIndex = tp.gettedit().getSelectedRow();
            int modelIndex = tp.gettedit().convertRowIndexToModel(viewIndex);
            
            TableModel tm = tp.gettedit().getModel();
            
            String No_ID = tm.getValueAt(modelIndex, 0).toString();
            String Nama = tm.getValueAt(modelIndex, 1).toString();
            String Email = tm.getValueAt(modelIndex, 2).toString();   
            String No_HP = tm.getValueAt(modelIndex, 3).toString(); 
            
            tp.setJt1(Nama);
            tp.setJt2(Email);  
            tp.setTfIdPelamar(No_ID);
            tp.setJt3(No_HP);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(tp.getBackButton())) {
            this.tp.setVisible(false);
            ControllerPelamar cm = new ControllerPelamar(app);

        }
    }

}


