package br.hibernate.dao;

import br.hibernate.model.Categoria;
import java.util.List;
import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em = ConnectionFactory.getConnection();

    public Categoria salvar(Categoria categoria) {
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return categoria;
    }

    public List<Categoria> listarTodas() {
        List<Categoria> categorias = null;
        try {
            categorias = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return categorias;
    }
    
}
