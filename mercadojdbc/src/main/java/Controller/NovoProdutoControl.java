package Controller;

import DAO.NovoProdutoDAO;
import Model.NovoProdutoModel;
import View.JanelaNovoProduto;

public class NovoProdutoControl {
    private JanelaNovoProduto view;
    private NovoProdutoModel model;
    private NovoProdutoDAO dao;

    public NovoProdutoControl(JanelaNovoProduto view, NovoProdutoModel model, NovoProdutoDAO dao) {
        this.view = view;
        this.model = model;
        this.dao = dao;
    }

    public void cadastrarNovoProduto(String nome, String codigoBarras, double preco) {
    }

    // Adicione mais métodos conforme necessário para o controle do cadastro de novo produto
}
