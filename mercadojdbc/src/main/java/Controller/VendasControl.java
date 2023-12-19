
package Controller;

import javax.swing.JOptionPane;
import DAO.VendasDAO;
import Model.VendasModel;
import View.JanelaVendas;

public class VendasControl {
    private JanelaVendas view;
    private VendasModel model;
    private VendasDAO dao;

    public VendasControl(JanelaVendas view, VendasModel model, VendasDAO dao) {
        this.view = view;
        this.model = model;
        this.dao = dao;
    }

    public void adicionarProduto(String codigoProduto, int quantidade) {
        // Lógica para adicionar um produto à venda
        // Pode incluir verificação de desconto para clientes VIP
        // e atualizações no modelo e no banco de dados
        // Exemplo:
        dao.registrarVenda(codigoProduto, quantidade);
        JOptionPane.showMessageDialog(null, "Produto adicionado à venda!");
    }

    public void removerProduto(String codigoProduto, int quantidade) {
        // Lógica para remover um produto da venda
        // Pode incluir atualizações no modelo e no banco de dados
        // Exemplo:
        // dao.removerProdutoDaVenda(codigoProduto, quantidade);
        JOptionPane.showMessageDialog(null, "Produto removido da venda!");
    }
}
