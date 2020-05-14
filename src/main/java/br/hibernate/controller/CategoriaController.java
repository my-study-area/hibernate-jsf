package br.hibernate.controller;

import br.hibernate.dao.CategoriaDao;
import br.hibernate.model.Categoria;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoriaController {
    private Categoria categoria = new Categoria();
    private CategoriaDao dao = new CategoriaDao();

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void salvar() {
        dao.salvar(categoria);
        categoria = new Categoria();
    }
    
}
