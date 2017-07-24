/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hospital.services;

import java.sql.Connection;
import java.sql.Date;
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
import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Marin
 */
@Service
public class CitaServiceImp implements CitaService{

    private final static String INSERT = "INSERT INTO citas(nombreP, nombreD, fecha, diagnostico, foto, cedulaP, cedulaD) VALUES (?,?,?,?,?);";
    private final static String UPDATE = "UPDATE citas SET nombreP = ?, nombreD = ?, foto = ?, cedulaP = ?, cedulaD = ?, fecha = ? WHERE id = ?";
    private final static String DELETE = "DELETE FROM citas WHERE id = ?";
    private final static String GET_BY_ID = "SELECT * FROM cita WHERE id = ?";
    private final static String GET_ALL = "SELECT * FROM cita WHERE cedulaD = ?";
    
    Connection con;
    PreparedStatement statement;
    
    @Override
    public void insert(Cita cita) {
        try {
            con = connect();
            statement = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cita.getNombreD());
            statement.setString(2, cita.getNombreP());     
            statement.setString(3, cita.getFecha());     
            statement.setString(4, cita.getDiagnostico());     
            statement.setString(5, cita.getFoto());     
            statement.setLong(6, cita.getCedulaP()); 
            statement.setLong(7, cita.getCedulaD());     
            
            long id = statement.executeUpdate();
            cita.setId(id);
            closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean update(Cita cita) {
        
        try {
            connect();
            statement = con.prepareStatement(UPDATE);
            statement.setString(1, cita.getNombreD());
            statement.setString(2, cita.getNombreP());     
            statement.setString(3, cita.getFecha());     
            statement.setString(4, cita.getDiagnostico());     
            statement.setString(5, cita.getFoto());     
            statement.setLong(6, cita.getCedulaP()); 
            statement.setLong(7, cita.getCedulaD()); 
            statement.setLong(8, cita.getId());
            
            int rows = statement.executeUpdate();
            
            closeConnection();
            return rows > 0;
        } catch (SQLException ex) {
            return false;
        }
             
        
    }

    @Override
    public boolean delete(Long id) {
         try {
            connect();
            statement = con.prepareStatement(UPDATE);
            statement.setLong(0, id);            
            int rows = statement.executeUpdate();
            
            closeConnection();
            return rows > 0;
        } catch (SQLException ex) {
            return false;
        }
        
    }

    @Override
    public Cita getById(Long id) {
        Cita cita = null;
        try {
            connect();
            statement = con.prepareStatement(GET_BY_ID);
            statement.setLong(0, id);
            
            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                cita = new Cita();
                cita.setId(result.getLong("id"));
                cita.setNombreP(result.getString("nombreP"));
                cita.setNombreD(result.getString("nombreD"));
                cita.setFecha(result.getString("fecha"));
                cita.setDiagnostico(result.getString("diagnostico"));
                cita.setFoto(result.getString("foto"));
                cita.setCedulaP(result.getLong("cedulaP"));
                cita.setCedulaD(result.getLong("cedulaD"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

    @Override
    public List<Cita> all(long cedulaD) {
      
        List<Cita> citas = new ArrayList<>();
        try {
            connect();
            statement = con.prepareStatement(GET_ALL);            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Cita cita = new Cita();
                cita.setId(result.getLong("id"));
                cita.setNombreP(result.getString("nombreP"));
                cita.setNombreD(result.getString("nombreD"));
                cita.setFecha(result.getString("fecha"));
                cita.setDiagnostico(result.getString("diagnostico"));
                cita.setFoto(result.getString("foto"));
                cita.setCedulaP(result.getLong("cedulaP"));
                cita.setCedulaD(result.getLong("cedulaD"));
                citas.add(cita);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CitaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return citas;
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
