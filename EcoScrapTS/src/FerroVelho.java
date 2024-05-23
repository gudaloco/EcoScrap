public class FerroVelho {
private int id_ferrovelho;
private String nome;
private int cnpj;
private String endereco;
private String bairro;
private String email;
private String senha;

public FerroVelho(){}

public FerroVelho(int id_ferrovelho, String nome, int cnpj, String endereco, String bairro,String email, String senha){
    this.id_ferrovelho = id_ferrovelho;
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.bairro = bairro;
    this.email = email;
    this.senha = senha;
}

    public int getId_ferrovelho() {
        return id_ferrovelho;
    }

    public void setId_ferrovelho(int id_ferrovelho) {
        this.id_ferrovelho = id_ferrovelho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
