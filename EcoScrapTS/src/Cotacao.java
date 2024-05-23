public class Cotacao {
private int id_cotacao;
private int id_ferrovelho;
private int id_material;
private double peso;
private float valor_total;

public Cotacao(){
}

public Cotacao(int id_cotacao, int id_ferrovelho, int id_material, double peso, float valor_total){
    this.id_cotacao = id_cotacao;
    this.id_ferrovelho = id_ferrovelho;
    this.id_material = id_material;
    this.peso = peso;
    this.valor_total = valor_total;
}

    public int getId_cotacao() {
        return id_cotacao;
    }

    public void setId_cotacao(int id_cotacao) {
        this.id_cotacao = id_cotacao;
    }

    public int getId_ferrovelho() {
        return id_ferrovelho;
    }

    public void setId_ferrovelho(int id_ferrovelho) {
        this.id_ferrovelho = id_ferrovelho;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

}