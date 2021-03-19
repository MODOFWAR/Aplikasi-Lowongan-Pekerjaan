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
import LowonganPekerjaan.Lowongan;
import javax.swing.JOptionPane;
import View.EditLowongan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
/**
 *
 * @author MODOFWAR
 */
public class ControllerEditLowongan extends MouseAdapter implements ActionListener{
    EditLowongan tp;
    Aplikasi app;
    Lowongan p;

    public ControllerEditLowongan(Aplikasi ap)  {
        this.app = ap;
        this.tp = new EditLowongan();
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
            
            String Company = tm.getValueAt(modelIndex, 0).toString();
            String JobVacancy = tm.getValueAt(modelIndex, 1).toString();
            String WorkHour = tm.getValueAt(modelIndex, 2).toString();   
            String VacancyID = tm.getValueAt(modelIndex, 3).toString(); 
            
            tp.setJt0(Company);
            tp.setJt1(JobVacancy);  
            tp.setJt2(WorkHour);
            tp.setJt3(VacancyID);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(tp.getBackButton())) {
            this.tp.setVisible(false);
            ControllerHalLowongan cm = new ControllerHalLowongan(app);

        }
    }

}


