package br.hibernate.dao;

import br.hibernate.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDao {
    public Usuario salvar(Usuario usuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        emf.close();
        
        usuario = new Usuario();
        return usuario;
    }
}
