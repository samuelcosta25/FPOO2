package Controller;

import View.JanelaRelatorioVendas;
import DAO.RelatorioVendasDAO;

public class RelatorioVendasControl {
    private JanelaRelatorioVendas view;
    private RelatorioVendasDAO dao;

    public RelatorioVendasControl(JanelaRelatorioVendas view) {
        this.view = view;
        this.dao = new RelatorioVendasDAO(); // Certifique-se de criar essa classe
    }

    // Método para gerar o relatório
    public void gerarRelatorio() {
        // Aqui você pode chamar métodos do DAO para obter os dados do relatório
        Object[][] data = dao.obterDadosRelatorio();
        String[] columnNames = {"Produto", "Quantidade", "Preço"};

        // Atualiza a tabela na view com os dados do relatório
        view.atualizarTabela(data, columnNames);
    }
}
