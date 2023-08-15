import javax.swing.JOptionPane;

public class Carros {
    String modelo;
    String cor;
    String marca;
    String ano;

    // metodos
    // construtor cheio
    public Carros(String marca, String modelo, String cor, String ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
    }

    // construtor vazio
    public Carros() {
    }

    // getters and setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    //metodo proprio
        public String imprimirLN() {
            String imprimir = " "+marca+" "+modelo+" "+ano+" "+cor+"\n";
            return imprimir;
        }

        public void imprimir(){
            JOptionPane.showMessageDialog(null, marca+"\n "+modelo+"\n "+ano+"\n "+cor);
        }

}
