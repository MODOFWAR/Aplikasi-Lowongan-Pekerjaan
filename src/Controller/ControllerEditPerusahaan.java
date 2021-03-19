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
import javax.swing.JOptionPane;
import View.EditPerusahaan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
/**
 *
 * @author MODOFWAR
 */
public class ControllerEditPerusahaan extends MouseAdapter implements ActionListener{
    EditPerusahaan tp;
    Aplikasi app;
    Perusahaan p;

    public ControllerEditPerusahaan(Aplikasi ap)  {
        this.app = ap;
        this.tp = new EditPerusahaan();
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
            
            String ID_Perusahaan = tm.getValueAt(modelIndex, 0).toString();
            String Owner = tm.getValueAt(modelIndex, 1).toString();
            String Nama_Perusahaan = tm.getValueAt(modelIndex, 2).toString();          
            
            tp.setJt1(Owner);
            tp.setJt2(Nama_Perusahaan);  
            tp.setTfIdPerusahaan(ID_Perusahaan);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(tp.getBackButton())) {
            this.tp.setVisible(false);
            ControllerPerusahaan cm = new ControllerPerusahaan(app);

        }
    }

}

