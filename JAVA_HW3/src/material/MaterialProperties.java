package material;


public class MaterialProperties implements IMaterialProperties {
    private final int length;
    private final int width;
    private final int height;
    private final String code;
    private final int cost;
    private final String name;

    public MaterialProperties() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
        this.code = null;
        this.cost = 0;
        this.name = null;
    }
    public MaterialProperties(MaterialProperties material) {
        this.length = material.length;
        this.width = material.width;
        this.height = material.height;
        this.code = material.code;
        this.cost = material.cost;
        this.name = material.name;
    }
    public MaterialProperties( String code,int length, int width, int height, int cost) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.code = code;
        this.cost = cost;
        this.name = nameAssigning();
    }

    public int getVolume() {
        return length * width * height;
    }

    public String getCode() {
        return code;
    }
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "length=" + length + ", height=" + height+ ", width=" + width +", cost=" + cost+ " ";
    }
    @Override
    public MaterialProperties clone() {
        return new MaterialProperties(this);
    }
    private String nameAssigning() {
        for (NameOfTheMaterialCode element: NameOfTheMaterialCode.values()){
            if(element.toString().equals(code)){
                return element.name;
            }
        }
        System.out.println("wrong code");
        System.exit(0);
        return null;
    }
}

