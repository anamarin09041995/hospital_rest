/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hospital.models.Cita;
import org.hospital.models.Usuario;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Marin
 */
@Service 
public class UsuarioServiceImp implements UsuarioService{

    private final static String INSERT = "INSERT INTO usuarios(ceddulaU, pass) VALUES (?,?);";
    
    Connection con;
    PreparedStatement statement;
    
    @Override
    public void insert(Usuario usuario) {
        try {
            con = connect();
            statement = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, usuario.getCedulaU());
            statement.setString(2, usuario.getPass());     
            
            
            long id = statement.executeUpdate();
            usuario.setId(id);
            closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     private Connection connect() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
        return con;
    }
     
     private void closeConnection() throws SQLException{
         if(statement != null)
             statement.close();
         
         if(con != null){
             con.close();
         }
         
         statement = null;
         con = null;
     }
    
}
