package br.hibernate.dao;

import static br.hibernate.dao.ConnectionFactory.emf;
import br.hibernate.model.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDao {
    private EntityManager em = ConnectionFactory.getConnection();

    public Usuario salvar(Usuario usuario) {
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
