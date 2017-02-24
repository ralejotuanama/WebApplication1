
package com.mitocode.bean;
import com.mitocode.model.Persona;
import com.mitocode.dao.personaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class PersonaBean {
    
    private Persona persona = new Persona();
    private List<Persona> listado;

    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public List<Persona> getListado() {
        return listado;
    }

    public void setListado(List<Persona> listado) {
        this.listado = listado;
    }
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
   public  void operar() throws Exception {
        switch(accion){
            case "registrar" :
                this.registrar();
                this.limpiar();
                break;
                
            case "modificar" :
                this.modificar();
                 this.limpiar();
                break;
        }
    }
    
    private void registrar() throws Exception {
        
        personaDAO per;
        
        try {
            per = new personaDAO();
            per.registrar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        } 
    }
    
     private void modificar() throws Exception {
        
        personaDAO per;
        
        try {
            per = new personaDAO();
            per.modificar(persona);
           this.listar();
        } catch (Exception e) {
            throw e;
        } 
    }
    
    public void listar() throws Exception {
        
        personaDAO per;
        
        try {
            per = new personaDAO();
           listado = per.listar();
        } catch (Exception e) {
            throw e;
        } 
    }
    
   public void leerID(Persona per) throws Exception {
        
        personaDAO p ;
       Persona temp;
        try {
           p = new personaDAO();
         temp =  p.leerID(per);
         if(temp != null) {
             this.persona = temp;
             this.accion = "modificar" ;
                     
         }
        } catch (Exception e) {
            throw e;
        } 
        
        
        
    }
   
   public void limpiar() {
       
       this.persona.setCodigo(0);
       this.persona.setNombre("");
       this.persona.setSexo("");
   }
   
     
      
        public void eliminar() throws Exception {
        
        personaDAO per;
        
        try {
            per = new personaDAO();
            per.eliminar(persona);
           this.listar();
        } catch (Exception e) {
            throw e;
        } 
    }
    
    
    
}
