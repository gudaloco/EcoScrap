
import java.util.Date;


public class Denuncia {
private int id_denuncia;
private int id_usuario;
private String endereco;
private String bairro;
private Date dataOcorrido;
private String descricao;

public Denuncia(){}

public Denuncia(int id_denuncia, int id_usuario, String endereco, String bairro, Date dataOcorrido, String descricao){
   this.id_denuncia = id_denuncia;
   this.id_usuario = id_usuario;
   this.endereco = endereco;
   this.bairro = bairro;
   this.dataOcorrido = dataOcorrido;
   this.descricao = descricao;
}

    public int getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(int id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public Date getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(Date dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
