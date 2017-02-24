
package com.mitocode.dao;

import java.sql.PreparedStatement;
import com.mitocode.model.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class personaDAO extends DAO{
    
    public  void registrar(Persona persona) throws Exception{
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("insert into persona(nombre, sexo) values (?, ?)");
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getSexo());
            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
            
        }
    } 
    
    
    
    public List<Persona> listar() throws Exception {
        
        List<Persona> lista ;
        ResultSet rs ;
        
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareCall("select codigo, nombre , sexo from persona");
            rs = pst.executeQuery();
            lista = new ArrayList<>();
            
            while(rs.next()) {
                
                Persona p = new Persona();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setSexo(rs.getString("sexo"));
                
               lista.add(p);
            }
            
            
        } catch (Exception e) {
            throw  e;
        } finally {
            this.Cerrar();
        }
        
        
        return lista;
        
    }
    
    
    
  public Persona leerID(Persona per) throws Exception {
        ResultSet rs;
        Persona pers = null;
        try {
            this.Conectar();
            
            PreparedStatement pst = this.getCn().prepareStatement("select codigo, nombre, sexo from persona where codigo = ? ");
            pst.setInt(1, per.getCodigo());
           rs = pst.executeQuery();
           
           while(rs.next()) {
               
               pers = new Persona();
               pers.setCodigo(rs.getInt("codigo"));
               pers.setNombre(rs.getString("nombre"));
                pers.setSexo(rs.getString("sexo"));
               
               
           }
            
            
            
        } catch (Exception e) {
            throw  e;
        } finally {
         this.Cerrar();
        }
        
        return  pers;
        
        
    }
  
  
   public  void modificar(Persona persona) throws Exception{
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("update persona set nombre = ?, sexo = ?  where codigo = ? ");
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getSexo());
             pst.setInt(3, persona.getCodigo());
                       

            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
            
        }
    } 
   
   
    public  void eliminar(Persona persona) throws Exception{
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("delete from persona  where codigo = ? ");
          
             pst.setInt(1, persona.getCodigo());
                       

            pst.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
            
        }
    } 
   
   
}
