/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Mahasiswa;

/**
 *
 * @author PC PRAKTIKUM
 */
import View.Mahasiswa.ViewData;
import Controller.Controllermahasiswa;
import Model.Connector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputData extends JFrame {

    JLabel header = new JLabel("Input Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JTextField inputAngkatan = new JTextField();
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    Controllermahasiswa controller;
    
    public InputData() {
        setTitle("Daftar Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 500);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(labelInputAngkatan);
        add(inputNama);
        add(inputNIM);
        add(inputAngkatan);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 440, 36);
        labelInputAngkatan.setBounds(20, 160, 440, 24);
        inputAngkatan.setBounds(18, 190, 440, 36);
        tombolKembali.setBounds(20, 240, 215, 40);
        tombolTambah.setBounds(240, 240, 215, 40);

        /* 
          Memberikan event handling untuk tombol kembali,
          Ketika tombol kembali diklik, maka akan kembali ke halaman ViewData().
         */
        
        controller = new Controllermahasiswa(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertMahasiswa();
            }
        });
    }
    public String getInputNama(){
        return inputNama.getText();
    }
    
     public String getInputNim(){
        return inputNIM.getText();
    }
     
     public String getInputAngkatan(){
        return inputAngkatan.getText();
    }
     
}
