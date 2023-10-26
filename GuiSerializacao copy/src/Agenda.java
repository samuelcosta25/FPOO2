import java.io.Serializable;

public class Agenda implements Serializable {
    // Atributos
    private String data;
    private String hora;
    private String usuario;
    private String descricao;

    public Agenda(String data, String hora, String usuario, String descricao) {
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
