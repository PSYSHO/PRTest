package model;

import files.FileWorker;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private FileWorker fileWorker;
    private List<Human> humans;

    public Family(List<Human> humans) {
        this.humans = humans;
        this.fileWorker = new FileWorker();
    }

    public Family() {
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
        Set<String> uniq_name = new HashSet<>(sortFatherandMather(name));
        List<String> res = new ArrayList<>(uniq_name);
        res.remove(name);
        if (res.isEmpty()) {
            res.add("нет братьев или сестер");
        }
        return res;
    }

    public List sortFatherandMather(String name) {
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


    public Human findHumanForName(String name) {
        Human find = null;
        for (Human human : humans) {
            if (human.getName().contains(name)) {
                find = human;
            }
        }
        return find;
    }

    public void save() {
        fileWorker.save(this);
    }

    public void setFileHandler(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    public Family read() {
        return (Family) fileWorker.read();
    }

    @Override
    public String toString() {
        return "Family{" +
                "humans=" + humans +
                '}';
    }
}

