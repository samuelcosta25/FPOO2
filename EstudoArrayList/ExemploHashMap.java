package EstudoArrayList;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class ExemploHashMap {
    //atrib
    HashMap<String,String> capitalEstados = new HashMap<>();
    //method
    public void teste() {
        capitalEstados.put("SP", "São Paulo");
        capitalEstados.put("MG", "Belo Horizonte");
        capitalEstados.put("RJ", "Rio de Janeiro");
        capitalEstados.put("ES", "Vitória");
        boolean jogo = true;
        while (jogo) {
            String estado = JOptionPane.showInputDialog("Digite a Sigla do estado:");
            JOptionPane.showMessageDialog(null, capitalEstados.get(estado));
        }
    }
    HashMap<String,String> pessoasIdade = new HashMap<>();
    public void ExercicioHashMap() {
        pessoasIdade.put("samuel", "23");
        pessoasIdade.put("natan", "22");
        pessoasIdade.put("diogo", "36");
        pessoasIdade.put("otavio", "20");
        for (String nome: pessoasIdade.keySet()) {
            JOptionPane.showMessageDialog(null, "Nome: " + nome +", " +pessoasIdade.get(nome));
        }
    }
}