package br.hibernate.controller;

import br.hibernate.dao.CategoriaDao;
import br.hibernate.dao.ProdutoDao;
import br.hibernate.model.Categoria;
import br.hibernate.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoController {
    private Produto produto = new Produto();
    private ProdutoDao dao = new ProdutoDao();
    private CategoriaDao categoriaDao = new CategoriaDao();
    private List<Categoria> categorias = new ArrayList<Categoria>();

    public ProdutoController() {
        categorias = categoriaDao.listarTodas();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void salvar() {
        dao.salvar(produto);
        produto = new Produto();
    }
}
