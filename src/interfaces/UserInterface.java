package interfaces;

import model.Family;

import java.util.List;

public interface UserInterface {
    void start();

    void menu();

    Family createFamily();

    void sortByName(Family family);

    void sortByAge(Family family);

    List getBrotherAndSister(String name);
}
