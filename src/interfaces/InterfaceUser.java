package interfaces;

import model.FamilyTree;

import java.util.List;

public interface InterfaceUser {
    void start();

    void menu();

    FamilyTree createFamily();

    void sortByName(FamilyTree familyTree);

    void sortByAge(FamilyTree familyTree);

    List getBrotherAndSister(String name);
}