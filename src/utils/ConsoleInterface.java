package utils;

import interfaces.UserInterface;
import model.FamilyTree;
import model.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface implements UserInterface {
    private FamilyTree familyTree;
    private List<String> comand;

    private Scanner in = new Scanner(System.in);

    public ConsoleInterface(){
        comand = new ArrayList<String>();
        comand.add("Выберите действие которое хотите сделать");
        comand.add("1)Создать семью");
        comand.add("2)выполнить сортировку семьи по году рождения");
        comand.add("3)выполнить сортировку семьи по имени");
        comand.add("4)вывести брата и сестру");
        comand.add("5)вывести в файл");
        comand.add("6)считать из файла");
        comand.add("7)Вывести семью");
    }

    public ConsoleInterface(FamilyTree familyTree, Scanner in) {
        this.familyTree = familyTree;
        this.in = in;
    }

    @Override
    public void start() {
        System.out.println("Старт программы");
        menu();
    }

    @Override
    public void menu() {
        System.out.println(comand.get(0));
        System.out.println(comand.get(1));
        System.out.println(comand.get(2));
        System.out.println(comand.get(3));
        System.out.println(comand.get(4));
        System.out.println(comand.get(5));
        System.out.println(comand.get(6));
        System.out.println(comand.get(7));
        int number = in.nextInt();
        switch (number){
            case 1:
                this.familyTree =createFamily();
                break;
            case 2:
                sortByAge(familyTree);
                break;
            case 3:
                sortByName(familyTree);
                break;
            case 4:
                System.out.println(familyTree);
                System.out.println("Укажите имя нужного человека в семье");
                System.out.println(getBrotherAndSister(in.next()));
                break;
            case 5:
                familyTree.save();
                break;
            case 6:
                this.familyTree = familyTree.read();
                break;
            case 7:
                System.out.println(familyTree);
                break;
        }
        System.out.flush();
        menu();

    }

    @Override
    public FamilyTree createFamily() {
        FamilyTree familyTree = new FamilyTree();

        Human gran = new Human("Veronika", 1950, null, null);
        Human gran1 = new Human("Mikhail", 1961, null,null);
        Human gran2 = new Human("Anna", 1973, null,null);
        Human dad = new Human("Viktor", 1950, null,gran);
        Human mom = new Human("Oksana", 1993, gran1,gran2);
        Human mom2 = new Human("Kate",  1966, null,null);
        Human son = new Human("Bob", 1992, dad,mom2);
        Human granson = new Human("Tom",  2020, son,mom);
        Human granson1 = new Human("Blake",  2017, son,mom);
        Human granson2 = new Human("Jake",  2014, son,mom);

        familyTree.add(gran);
        familyTree.add(dad);
        familyTree.add(gran1);
        familyTree.add(gran2);
        familyTree.add(mom);
        familyTree.add(mom2);
        familyTree.add(son);
        familyTree.add(granson1);
        familyTree.add(granson2);
        familyTree.add(granson);
        return familyTree;
    }

    @Override
    public void sortByName(FamilyTree familyTree) {
        familyTree.sortByName();
    }

    @Override
    public void sortByAge(FamilyTree familyTree) {
        familyTree.sortByAge();
    }

    @Override
    public List<Human> getBrotherAndSister(String name) {
        familyTree.sortBrotherAndSister(name);
        return familyTree.sortBrotherAndSister(name);
    }


}
