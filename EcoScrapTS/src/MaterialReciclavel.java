
public class MaterialReciclavel {
private int id_material;
private int id_ferrovelho;
private String reciclavel;
private float preco_kg;
private String categoria;

public MaterialReciclavel(){}

public MaterialReciclavel(int id_material,String reciclavel, float preco_kg, String categoria){
    this.id_material = id_material;
    this.preco_kg = preco_kg;
    this.reciclavel = reciclavel;
    this.categoria = categoria;
}

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public float getPreco_kg() {
        return preco_kg;
    }

    public void setPreco_kg(float preco) {
        this.preco_kg = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getReciclavel() {
        return reciclavel;
    }

    public void setReciclavel(String reciclavel) {
        this.reciclavel = reciclavel;
    }

    public int getId_ferrovelho() {
        return id_ferrovelho;
    }

    public void setId_ferrovelho(int id_ferrovelho) {
        this.id_ferrovelho = id_ferrovelho;
    }

    
}
