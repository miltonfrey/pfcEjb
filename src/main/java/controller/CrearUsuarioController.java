
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Usuario;
import model.UsuarioFacade;


@Named(value = "crearUsuarioController")
@ViewScoped
public class CrearUsuarioController implements Serializable{

    @EJB
    private UsuarioFacade usuarioFacade;
    
    
    private String valor;
    private ArrayList<Usuario> lista;
    
    public CrearUsuarioController() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Usuario> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Usuario> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        
        lista=new ArrayList<Usuario>();
        lista.addAll(usuarioFacade.findAll());
        
    }
    
    
    
    
    public void accion(){
        
        FacesMessage message=new FacesMessage("blablalbla");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    
    
}
