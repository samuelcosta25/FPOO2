package Model;

public class Clientes {

    private String Nome;
    private String CPF;

    public Clientes(String nome, String cpf) {
        Nome = nome;
        CPF = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        CPF = cpf;
    }

    public Object getContato() {
        return null;
    }
}
