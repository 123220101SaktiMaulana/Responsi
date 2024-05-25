/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Dosen;

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Aibra
 */
public class EditDataDosen extends JFrame{
    JLabel header = new JLabel("Edit Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("No HP");
    JLabel labelInputEmail = new JLabel("Email");
    JTextField inputNama = new JTextField();
    JTextField inputnohp = new JTextField();
    JTextField inputemail = new JTextField();
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");
    
    Controller.ControllerDosen controller;
    
    public EditDataDosen(ModelDosen Dosen) {
        setTitle("Edit Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 500);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(labelInputEmail);
        add(inputNama);
        add(inputnohp);
        add(inputemail);
        add(tombolEdit);
        add(tombolKembali);

       header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputnohp.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 150, 440, 24);
        inputemail.setBounds(18, 190, 440, 36);
        tombolKembali.setBounds(20, 230, 215, 40);
        tombolEdit.setBounds(240, 230, 215, 40);
        
        inputNama.setText(Dosen.getNama());
        inputnohp.setText(Dosen.getNo_hp());
        inputemail.setText(Dosen.getEmail());
        
        controller = new ControllerDosen(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.EditDosen(Dosen.getId());
            }
        });             
    }
    
    public String getInputNama(){
        return inputNama.getText();
    }
    
     public String getInputNo_hp(){
        return inputnohp.getText();
    }
     
     public String getInputEmail(){
        return inputemail.getText();
    }
}