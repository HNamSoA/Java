package material;

public interface IMaterial {

    /**
     * returns the material code.
     * @return String
     */
    public String getMaterialCode();

    /**
     * returns the material quality out of 100.
     * @return int
     */
    public int getMaterialQuality();

    /**
     * returns the material's properties.
     * @return string
     */
    public String toString();

    /**
     * returns a copy of the material.
     * @return IMaterial
     */
    public IMaterial clone();
}
