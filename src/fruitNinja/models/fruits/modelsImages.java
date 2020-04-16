package fruitNinja.models.fruits;

import fruitNinja.data.services.FruitService;
import fruitNinja.models.fruits.ordinary.Apple;

public class modelsImages {
    FruitService fruitService = new FruitService();
    OrdinaryFruitFactory fruitFactory=new OrdinaryFruitFactory();
    public modelsImages() {
    }

    public void setImages() {

        for (FruitData fruitData:fruitService.readData()){
            switch (fruitData.getFruitname()){
                case "banana":
                   // Banana.setImage(fruitData.getPicture());
                   // System.out.println("in banana"+Banana.getImage());
                    break;
                case "apple":
                    //Apple.setImage(fruitData.getPicture());
                    // System.out.println("in apple"+Apple.getImage());
                    break;
                case "pineapple":
                    //Pineapple.setImage(fruitData.getPicture());
                    //System.out.println("in pineapple"+Pineapple.getImage());
                    break;
            }


        }
        Apple apple=new Apple();
       System.out.println(apple.getImage());
    }
 }


