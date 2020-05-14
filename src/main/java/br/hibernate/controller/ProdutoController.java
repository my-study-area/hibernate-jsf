package br.hibernate.controller;

import br.hibernate.dao.ProdutoDao;
import br.hibernate.model.Produto;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoController {
    private Produto produto = new Produto();
    private ProdutoDao dao = new ProdutoDao();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar() {
        dao.salvar(produto);
        System.out.println("Salvar produto");
        produto = new Produto();
    }
}
