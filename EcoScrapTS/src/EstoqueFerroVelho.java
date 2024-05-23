public class EstoqueFerroVelho {
    private int id_estoque;
    private int id_ferrovelho;
    private int id_material;
    private int kg;
    
    public EstoqueFerroVelho(){
        
    }
    public EstoqueFerroVelho(int id_estoque,int id_ferrovelho,int id_material,int kg){
        this.id_estoque = id_estoque;
        this.id_ferrovelho = id_ferrovelho;
        this.id_material = id_material;
        this.kg = kg;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
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

    public int getKg() {
        return kg;
    }

    public void setKg(int quantidade) {
        this.kg = kg;
    }
}
