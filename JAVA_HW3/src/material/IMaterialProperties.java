package material;

public interface IMaterialProperties {

    /**
     * returns the material's volume.
     * @return int
     */
    public int getVolume();

    /**
     * returns the material's code.
     * @return String
     */
    public String getCode();

    /**
     * returns the material's cost.
     * @return int
     */
    public int getCost();

    /**
     * returns the material's properties.
     * @return string
     */
    public String toString();

    /**
     * returns a copy of the material.
     * @return IMaterialProperties
     */
    public IMaterialProperties clone();
}
