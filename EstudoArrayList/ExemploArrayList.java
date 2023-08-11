package EstudoArrayList;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * ExemploArrayList
 */
public class ExemploArrayList {
    //atributo
    //Declarando o ArrayList do Tipo String
    ArrayList<String> carros = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    //métodos
    public void teste() {
        //Adicionar Valores ao ArrayList
        carros.add(JOptionPane.showInputDialog("Informe o Nome do Carro"));
        carros.add("Chevette");
        carros.add("Celta");
        carros.add("Monza");
        carros.add("Gol");
        //Imprimir toda a Lista
        System.out.println(carros);
        //Ordenando a Lista
        Collections.sort(carros);
        //pegando o valor correspondente a 5 posição(index 4)
        System.out.println(carros.get(4));
        //percorrendo a lista com FOR
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
        //percorrendo a lista com o FOR-EACH
        for (String i : carros) {
            System.out.println(i);
        }
        //Apagar a Lista
        carros.clear();
        System.out.println(carros);
    }
    public void exercicio() {
        //criar um arraylist (Integer) + 5 valores
        //preencher 5 nº int
        for (int i = 0; i < 5; i++) {
            num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um nº")));
        }
        //collection.reverse();
        Collections.reverse(carros);
        for (int i : num) {
            System.out.println(i);
        }
    }
    
}