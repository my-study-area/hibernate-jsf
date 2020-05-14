package br.hibernate.controller;

import br.hibernate.dao.CategoriaDao;
import br.hibernate.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoriaController {
    private Categoria categoria = new Categoria();
    private CategoriaDao dao = new CategoriaDao();
    private List<Categoria> categorias = new ArrayList<>();

    public CategoriaController() {
        categorias = dao.listarTodas();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void salvar() {
        dao.salvar(categoria);
        categorias.add(categoria);
        categoria = new Categoria();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
