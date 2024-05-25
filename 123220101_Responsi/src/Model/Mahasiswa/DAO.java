/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Mahasiswa;

/**
 *
 * @author PC PRAKTIKUM
 */

import Model.Connector;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DAO implements InterfaceDAO{
    
    @Override
    public void Insert(ModelMahasiswa mahasiswa) {
    try {
        // Perintah query disimpan ke dalam variabel "query"
        String query = "INSERT INTO mahasiswa (nama, nim, email, password,angkatan) VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement statement;
        statement = Connector.Koneksi().prepareStatement(query);
        statement.setString(1, mahasiswa.getNama());
        statement.setString(2, mahasiswa.getNim());
        statement.setNull(3, java.sql.Types.VARCHAR); // Kolom 3
        statement.setNull(4, java.sql.Types.VARCHAR); // Kolom 4
        statement.setString(5, mahasiswa.getAngkatan()); // Sesuaikan dengan kolom angkatan
        
        // Menjalankan query untuk memasukkan data mahasiswa baru
        statement.executeUpdate();
        
        // Menutup koneksi untuk menghemat penggunaan memory.
        statement.close();
    } catch (SQLException e) {
        // Menampilkan pesan error ketika gagal input data.
        System.out.println("Input Failed: " + e.getLocalizedMessage());
    }
}
    
    @Override
    public void Update(ModelMahasiswa mahasiswa) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE mahasiswa SET nama=?, nim=?, angkatan=? WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNim());
            statement.setString(3, mahasiswa.getAngkatan());
            statement.setInt(4, mahasiswa.getId());
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }
    
       @Override
    public void Delete(int id) {
         try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM mahasiswa WHERE id=?;";
            
            /* 
              Memasukkan id berdasarkan data yang mau dihapus ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setInt(1, id);
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal hapus data.
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }
    
     @Override
    public List<ModelMahasiswa> getAll() {
         List<ModelMahasiswa> listMahasiswa = null;
  
        try {
            /* 
              Membuat sebuah variabel bernama "listMahasiswa".
              Variabel ini memiliki tipe data List karena berfungsi untuk menyimpan banyak data
              Variabel ini nantinya akan digunakan untuk menyimpan daftar mahasiswa
              hasil query dari database.
            */
           
            listMahasiswa = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Koneksi().createStatement();
            
            /* 
                Menyimpan query database ke dalam varibel "query".
                Dalam hal ini, kita akan mengambil seluruh data mahasiswa pada tabel "mahasiswa".
            */
            String query = "SELECT * FROM mahasiswa;";
            
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);
            
            /* 
                Karena hasil query memiliki tipe data List, supaya dapat mencetak semua data mahasiswa,
                Kita perlu melakukan looping (perulangan) untuk mencetak tiap-tiap elemen.
            */
            while (resultSet.next()) {
                // Membuat sebuah objek "Mahasiswa" untuk menyimpan data tiap-tiap mahasiswa
                ModelMahasiswa mhs = new ModelMahasiswa();
                
                // Memasukkan hasil query ke objek mahasiswa
                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setAngkatan(resultSet.getString("angkatan"));
                
                /* 
                  Menambahkan mahasiswa ke dalam daftar mahasiswa.
                  Daftar mahasiswa disimpan ke dalam variabel "listMahasiswa"
                  yang memiliki tipe data List.
                */
                listMahasiswa.add(mhs);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMahasiswa;
    }
    
}
