package model;

import comparators.ComparatorHumans;
import files.FileWorker;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable,Iterable<Human>{
    private FileWorker fileWorker;
    private List<Human> humans;

    public FamilyTree(List<Human> humans) {
        this.humans = humans;
        this.fileWorker = new FileWorker();
    }

    public FamilyTree() {
        this.fileWorker = new FileWorker();
        humans = new ArrayList<Human>();
    }

    public void add(Human human) {
        if (human != null) {
            humans.add(human);
            if (human.getFather() != null) {
                human.getFather().getChildrens().add(human);
            }
            if (human.getMother() != null) {
                human.getMother().getChildrens().add(human);
            }
        }
    }

    public List<String> getBrotherAndSister(String name) {
        Set<String> uniq_name = new HashSet<>(sortBrotherAndSister(name));
        List<String> res = new ArrayList<>(uniq_name);
        res.remove(name);
        if (res.isEmpty()) {
            res.add("нет братьев или сестер");
        }
        return res;
    }

    public List<String> sortBrotherAndSister(String name) {
        List<String> humans = new ArrayList<>();
        Human find = findHumanForName(name);
        if (find.getFather() != null && find.getFather().getChildrens() != null) {
            for (Human child : find.getFather().getChildrens()) {
                humans.add(child.getName());
            }
        }
        if (find.getMother() != null && find.getMother().getChildrens() != null) {
            for (Human child : find.getMother().getChildrens()) {
                humans.add(child.getName());
            }
        }
        return humans;
    }

    public void sortByName(){
        Collections.sort(this.getHumans());
    }


    public void sortByAge(){
        Collections.sort(this.getHumans(), new ComparatorHumans());
    }

    public Human findHumanForName(String name) {
        Human find = null;
        for (Human human : humans) {
            if (human.getName().contains(name)) {
                find = human;
            }
        }
        return find;
    }

    public void setFileWorker(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public String toString() {
        return "Family{" +
                "humans=" + humans +
                '}';
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator(humans);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree humans1 = (FamilyTree) o;
        return Objects.equals(fileWorker, humans1.fileWorker) && Objects.equals(humans, humans1.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileWorker, humans);
    }

}

