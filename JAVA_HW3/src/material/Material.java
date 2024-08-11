package material;

public class Material implements IMaterial {
    private int quality;
    private MaterialProperties properties;

    public Material(String materialCode, int quality, MaterialProperties properties){
        this.quality = quality;
        this.properties = properties;
    }

    public Material(Material material) {
        this.quality = material.quality;
        this.properties = material.properties.clone();
    }

    @Override
    public Material clone() {
    return new Material(this);
}

    @Override
    public String getMaterialCode() {
        return properties.getCode();
    }

    public int getVolume(){
        return properties.getVolume();
    }

    public int getMaterialCost(){
        return properties.getCost();
    }

    @Override
    public int getMaterialQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return "Material [code="+ getMaterialCode()+" quality= " + quality + properties.toString() + "]";
    }

    
}
