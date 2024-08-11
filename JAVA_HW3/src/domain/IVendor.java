package domain;

import java.util.ArrayList;
import java.util.Map;

import material.Material;

public interface IVendor {
    /**
     * returns the vendor's material list.
     * @return ArrayList<IMaterial>
     */
    public Map<String,ArrayList<Material>>getListOfMaterials();
    
    /**
     * returns the vendor's copy.
     * @return IVendor
     */
    public IVendor clone();

    /**
     * returns the vendor's list as string
     * @return String
     */
    public String toString();
}
