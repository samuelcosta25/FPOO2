package Controller;

import javax.swing.JOptionPane;
import DAO.ConclusaoCompraDAO;
import Model.ConclusaoCompraModel;
import View.JanelaConclusaoCompra;

public class ConclusaoCompraControl {
    private JanelaConclusaoCompra view;
    private ConclusaoCompraModel model;
    private ConclusaoCompraDAO dao;

    public ConclusaoCompraControl(JanelaConclusaoCompra view, ConclusaoCompraModel model, ConclusaoCompraDAO dao) {
        this.view = view;
        this.model = model;
        this.dao = dao;
    }

    public void finalizarCompra(double totalCompra, String metodoPagamento) {
        // Lógica para finalizar a compra
        // Pode incluir atualizações no modelo e no banco de dados
        // Exemplo:
        dao.registrarConclusaoCompra(totalCompra, metodoPagamento);
        JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso!");
    }
}
