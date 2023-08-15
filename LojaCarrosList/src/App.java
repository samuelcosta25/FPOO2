import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        //classe carros com metodos e atributos
        //App
        List<Carros> listaCarros = new ArrayList<>();
        boolean navegar = true;
        while (navegar) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("1- Cadastrar Carro \n2- Listar Carros\n3- Consultar Carro\n4- Apagar Carro"));
             
            if (acao == 1){ // cadastrar carro
                //criar um objteto
                String marcaCarro = JOptionPane.showInputDialog("Marca do carro: ");
                String modeloCarro = JOptionPane.showInputDialog("Modelo do carro: ");
                String corCarro = JOptionPane.showInputDialog("Cor do carro: ");
                String anoCarro = JOptionPane.showInputDialog("Ano do carro: ");
                Carros car = new Carros(marcaCarro, modeloCarro, corCarro, anoCarro);
                listaCarros.add(car);

            } else if (acao==2) { //Listar carros cadasrados
               String listar="";
                for (Carros carros : listaCarros) {
                    listar += carros.imprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            } else if (acao==3) { //Consultar carros
                String consultar="";
                int i=0;
                for (Carros carros : listaCarros) {
                    consultar+= i+carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha o carro: \n"+consultar));
                listaCarros.get(acao2).imprimir();
            } else if (acao == 4){
                String excluir="";
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha o carro a ser excluído: \n"+excluir));
                listaCarros.get(acao2).imprimir();
                listaCarros.remove(acao2);
            }
        }
        //1- Cadastrar Carros na lista
        //2- Listar Carros cadastrados
        //3- Consultar um Carro cadastrado
        //4- Apagar Carro cadastrado
    }
}
