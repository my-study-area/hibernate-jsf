package br.hibernate.controller;

import br.hibernate.model.Usuario;
import br.hibernate.dao.UsuarioDao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UsuarioController {
    private Usuario usuario = new Usuario();
    private UsuarioDao dao = new UsuarioDao();

    public UsuarioController() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar() {
        System.out.println("Usuario cadastrado");
        dao.salvar(usuario);
        usuario = new Usuario();
    }
    
}
