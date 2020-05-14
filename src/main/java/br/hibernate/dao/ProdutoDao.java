package br.hibernate.dao;

import br.hibernate.model.Produto;
import java.util.List;
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

    public List<Produto> listarTodas() {
        List<Produto> produtos = null;
        try {
            produtos = em.createQuery("from Produto p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return produtos;
    }
}
