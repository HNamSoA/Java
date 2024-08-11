package manufacturer;

import furnitures.NameOfFurniture;

public class WaitingLineObject{
        private String code ;
        private int numberOfFurnitures;
        private String name;
        
        public WaitingLineObject(String nameOfTheFurniture, int numberOfFurnitures){
            this.code = nameOfTheFurniture;
            this.numberOfFurnitures = numberOfFurnitures;
            this.name = nameAssigning();
        }

        public WaitingLineObject(WaitingLineObject  object){
            this.code = object.getFurnitureCode();
            this.numberOfFurnitures = object.numberOfFurnitures;
        }

        public String getName(){
            return name;
        }

        public WaitingLineObject clone(){
            return new WaitingLineObject(this);
        }

        public String getFurnitureCode() {
            return code;
        }
        public int getNumberOfFurnitures() {
            return numberOfFurnitures;
        }
        public void reducerNumberOfFurnitures(){
            numberOfFurnitures--;
        }
        private String nameAssigning() {
            for (NameOfFurniture element: NameOfFurniture.values()){
                if(element.toString().equals(code)){
                    return element.nameOfTheFurniture;
                }
            }
            System.out.println("wrong code");
            System.exit(0);
            return null;
        }
    }

