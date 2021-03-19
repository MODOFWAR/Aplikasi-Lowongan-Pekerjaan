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
import LowonganPekerjaan.BerkasLamaran;
import javax.swing.JOptionPane;
import View.EditBerkas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
/**
 *
 * @author MODOFWAR
 */
public class ControllerEditBerkas extends MouseAdapter implements ActionListener{
    EditBerkas tp;
    Aplikasi app;
    BerkasLamaran p;

    public ControllerEditBerkas(Aplikasi ap)  {
        this.app = ap;
        this.tp = new EditBerkas();
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
            
            String FileID = tm.getValueAt(modelIndex, 0).toString();
            String Name = tm.getValueAt(modelIndex, 1).toString();
            String Type = tm.getValueAt(modelIndex, 2).toString();   
            String Applied = tm.getValueAt(modelIndex, 3).toString(); 
            
            tp.setJt0(FileID);
            tp.setJt1(Name);  
            tp.setJt2(Type);
            tp.setJt3(Applied);
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


