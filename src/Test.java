import entity.Toy;
import entity.ToyStore;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        Toy toy1 = new Toy(0, "Меч", 124,15,1);
        Toy toy2 = new Toy(1, "Машинка", 200,50,2);
        Toy toy3 = new Toy(2, "Пистолет",400, 83,1);
        Toy toy4 = new Toy(3, "Барабан", 150,65,1);

        List<Toy> toys = new ArrayList<Toy>();
        toys.add(toy4);
        toys.add(toy3);
        toys.add(toy2);
        toys.add(toy1);

        ToyStore toyStore = new ToyStore(toys);
        toyStore.savePriceToy();
        toyStore.savePriceToy();
        toyStore.savePriceToy();
        toyStore.savePriceToy();


    }
}
