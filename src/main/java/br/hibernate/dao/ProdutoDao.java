package br.hibernate.dao;

import br.hibernate.model.Produto;
import javax.persistence.EntityManager;

public class ProdutoDao {
    private EntityManager em = ConnectionFactory.getConnection();
    
    public Produto salvar(Produto produto) {
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }
    
}
