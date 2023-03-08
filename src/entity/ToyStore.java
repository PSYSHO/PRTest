package entity;

import Services.FileWorker;
import interfaces.StoreInterface;

import java.util.List;

public class ToyStore implements StoreInterface {
    private List<Toy> toys;
    FileWorker fileWorker = new FileWorker();

    public ToyStore(List<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public <Toy> Toy raffleTheGoods() {
        Toy toy = (Toy) chooseWeight(toys);
        return toy;
    }

    @Override
    public void savePriceToy() {
        Toy toy  = raffleTheGoods();
        fileWorker.save(toy);
        toys.remove(toy);
    }


    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }
    public Toy chooseWeight(List<Toy> toys) {
        double weight = 0.0;
        for (Toy toy : toys)
            weight += toy.getWeight();
        double r = Math.random() * weight;
        double countWeight = 0.0;
        for (Toy toy : toys) {
            countWeight += toy.getWeight();
            if (countWeight >= r)
                return toy;
        }
        throw new RuntimeException("Should never be shown.");
    }
}
