/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hospital.models.Cita;
import org.hospital.models.Medico;


/**
 *
 * @author Ana Marin
 */
public class MedicoServiceImp implements MedicoService {
    
     private final static String INSERT = "INSERT INTO medicos(nombre, especialidad, activo, cedula) VALUES (?,?,?);";
    private final static String UPDATE = "UPDATE medicos SET nombre = ?, especialidad = ?, activo = ?, cedula = ?,  WHERE id = ?";
    private final static String DELETE = "DELETE FROM medicos WHERE id = ?";
    private final static String GET_BY_ID = "SELECT * FROM medicos WHERE id = ?";
    private final static String GET_ALL = "SELECT * FROM medicos";
    
    Connection con;
    PreparedStatement statement;

    @Override
    public void insert(Medico medico) {
       try {
            con = connect();
            statement = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getEspecialidad());     
            statement.setBoolean(3, medico.isActivo());     
            statement.setLong(4, medico.getCedula());        
            
            long id = statement.executeUpdate();
            medico.setId(id);
            closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean update(Medico medico) {
       try {
            connect();
            statement = con.prepareStatement(UPDATE);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getEspecialidad());     
            statement.setBoolean(3, medico.isActivo());     
            statement.setLong(4, medico.getCedula());    
            statement.setLong(5, medico.getId());
            
            int rows = statement.executeUpdate();
            
            closeConnection();
            return rows > 0;
        } catch (SQLException ex) {
            return false;
        }
             
    }

    @Override
    public Medico getById(long cedula) {
       Medico medico = null;
        try {
            connect();
            statement = con.prepareStatement(GET_BY_ID);
            statement.setLong(0, cedula);
            
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                medico = new Medico();
                medico.setId(result.getLong("id"));
                medico.setNombre(result.getString("nombre"));
                medico.setEspecialidad(result.getString("especialidad"));
                medico.setActivo(result.getBoolean("activo"));
                medico.setCedula(result.getLong("cedula"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    @Override
    public List<Medico> all() {
        List<Medico> medicos = new ArrayList<>();
        try {
            connect();
            statement = con.prepareStatement(GET_ALL);            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Medico medico = new Medico();
                medico.setId(result.getLong("id"));
                medico.setNombre(result.getString("nombre"));
                medico.setEspecialidad(result.getString("especialidad"));
                medico.setActivo(result.getBoolean("activo"));
                medico.setCedula(result.getLong("cedula"));
                medicos.add(medico);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
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
