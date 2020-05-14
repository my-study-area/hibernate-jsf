package br.hibernate.controller;

import br.hibernate.model.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@RequestScoped
public class UsuarioController {
    private Usuario usuario = new Usuario();

    public UsuarioController() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar() {
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
        System.out.println("Usuário: " + usuario);
        
        usuario = new Usuario();
        
    }
    
}
