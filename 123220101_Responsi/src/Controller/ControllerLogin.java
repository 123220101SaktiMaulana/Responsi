/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aibra
 */

public class ControllerLogin {
     public boolean authenticate(String username, String password) {
        
        
            try {
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement statement;
                statement = Connector.Koneksi().prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        return false;
    }
}