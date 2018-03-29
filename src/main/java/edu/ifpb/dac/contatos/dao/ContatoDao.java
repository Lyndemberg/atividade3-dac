
package edu.ifpb.dac.contatos.dao;

import edu.ifpb.dac.contatos.model.Contato;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lyndemberg
 */
@Stateless
public class ContatoDao {
    @PersistenceContext(unitName = "pu-contatos")
    private EntityManager em;
    
    public void salvar(Contato novo){
        em.persist(novo);
    }
    public void atualizar(Contato atualizado){
        em.merge(atualizado);
    }
    public void deletar(Contato c){
        Contato find = em.find(Contato.class, c.getId());
        em.remove(find);
    }
    public List<Contato> listar(){
        TypedQuery<Contato> query = em.createQuery("SELECT c FROM Contato c ORDER BY c.nome ASC", Contato.class);
        List<Contato> list = query.getResultList();
        return list;
    }
    
}
