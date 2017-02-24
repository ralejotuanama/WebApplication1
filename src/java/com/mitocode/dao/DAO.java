
package com.mitocode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {
    
    
   private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public  void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             String servidor = "jdbc:mysql://localhost:3306/mitocode";
             String usuario = "root";
             String clave = "";
            cn = DriverManager.getConnection(servidor, usuario, clave);
        } catch (Exception e) {
            throw  e;
        }
    }
    
    public void Cerrar() throws SQLException {
        
        if(cn != null) {
            if(cn.isClosed() == false){
                cn.close();
                
                
            }
                    
            
        }
    }
}
