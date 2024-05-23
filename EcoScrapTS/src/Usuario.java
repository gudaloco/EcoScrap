import java.util.Date;

public class Usuario {
    private int id_usuario;
    private String nome_completo;
    private String endereco;
    private String bairro;
    private String email;
    private String senha;
    private Date datanascimento;
    private char sexo;
    private char vendedor;
    
    public Usuario(){}
    
    public Usuario(int id_usuario, String nome_completo, String endereco, String bairro, String email, String senha, Date datanascimento, char sexo, char vendedor){
        this.id_usuario = id_usuario;
        this.nome_completo = nome_completo;
        this.endereco = endereco;
        this.bairro = bairro;
        this.email = email;
        this.senha = senha;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.vendedor = vendedor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
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

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getVendedor() {
        return vendedor;
    }

    public void setVendedor(char vendedor) {
        this.vendedor = vendedor;
    }
}
