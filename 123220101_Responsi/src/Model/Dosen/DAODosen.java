/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dosen;

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aibra
 */
public class DAODosen implements InterfaceDAODosen{

    @Override
    public void Insert(ModelDosen dosen) {
        try {
            String query = "INSERT INTO dosen (nama, no_hp, email) VALUES (?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNo_hp());
            statement.setString(3, dosen.getEmail());
            
            
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void Update(ModelDosen dosen) {
        try {
            String query = "UPDATE dosen SET nama=?, no_hp=?, email=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNo_hp());
            statement.setString(2, dosen.getEmail());
            statement.setInt(3, dosen.getId());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void Delete(int id) {
         try {
            String query = "DELETE FROM dosen WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

   
    @Override
    public List<ModelDosen> getAll() {
         List<ModelDosen> listDosen = null;
  
        try {
            listDosen = new ArrayList<>();
            
            Statement statement = Connector.Koneksi().createStatement();
            
            String query = "SELECT * FROM dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()) {
                ModelDosen dsn = new ModelDosen();
                
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNo_hp(resultSet.getString("no_hp"));
                dsn.setNo_hp(resultSet.getString("email"));
                
                listDosen.add(dsn);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
    
    
}