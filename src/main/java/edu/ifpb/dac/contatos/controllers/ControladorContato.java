
package edu.ifpb.dac.contatos.controllers;

import edu.ifpb.dac.contatos.dao.ContatoDao;
import edu.ifpb.dac.contatos.model.Contato;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@SessionScoped
public class ControladorContato implements Serializable{
    
    private Contato contato = new Contato();
    private boolean editando = false;
    
    @Inject
    private ContatoDao dao;    
    
    public String cadastrar(){
        dao.salvar(contato);
        contato = new Contato();
        return null;
    }
    public String excluir(Contato c){
        dao.deletar(c);
        if(editando == true && contato.equals(c)){
            editando = false;
            contato = new Contato();
        }
        
        return "index.xhtml";
        
    }
    public String editar(Contato c){
        this.contato = c;
        editando = true;
        return null;
    }
    
    public String atualizar(){
        dao.atualizar(contato);
        contato = new Contato();
        editando = false;
        return null;
    }
    
    public List<Contato> listarTodos(){
        return dao.listar();
    }
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
    
}
