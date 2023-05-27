package modelo;

public class Visitante {

    private String id;
    private String nome;
    private String cpf;
    private String valoraserpago;
    private String[] colunas = new String[]{"id", "nome", "cpf", "valoraserpago"};

    public Visitante() {
    }

    public Visitante(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValoraserpago() {
        return valoraserpago;
    }

    public void setValoraserpago(String valoraserpago) {
        this.valoraserpago = valoraserpago;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] Colunas) {
        this.colunas = Colunas;
    }

}
