package br.hibernate.hibernate;

import br.hibernate.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatePU");
        EntityManager em = emf.createEntityManager();
        Usuario usuario = new Usuario();
        usuario.setNome("avelino");
        
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
    }
}
