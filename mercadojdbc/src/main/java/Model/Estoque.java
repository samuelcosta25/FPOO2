package Model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public List<Produto> listarProdutosDoBanco() {
        return null;
    }

    public Produto get(String codigoBarras) {
        return null;
    }

    public Produto obterProdutoPorCodigoBarras(String codigoBarras) {
        return null;
    }
}
