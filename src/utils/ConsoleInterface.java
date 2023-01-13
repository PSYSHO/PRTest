package utils;

import interfaces.UserInterface;
import model.Family;
import model.Human;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface implements UserInterface {
    private Family family;

    private Scanner in = new Scanner(System.in);

    public ConsoleInterface(){
    }

    public ConsoleInterface(Family family, Scanner in) {
        this.family = family;
        this.in = in;
    }

    @Override
    public void start() {
        System.out.println("Старт программы");
        menu();
    }

    @Override
    public void menu() {
        System.out.println("Выберите действие которое хотите сделать");
        System.out.println("1)Создать семью");
        System.out.println("2)выполнить сортировку семьи по году рождения");
        System.out.println("3)выполнить сортировку семьи по имени");
        System.out.println("4)вывести брата и сестру");
        System.out.println("5)вывести в файл");
        System.out.println("6)считать из файла");
        System.out.println("7)Вывести семью");
        int number = in.nextInt();
        switch (number){
            case 1:
                this.family=createFamily();
                break;
            case 2:
                sortByAge(family);
                break;
            case 3:
                sortByName(family);
                break;
            case 4:
                System.out.println(family);
                System.out.println("Укажите имя нужного человека в семье");
                System.out.println(getBrotherAndSister(in.next()));
                break;
            case 5:
                family.save();
                break;
            case 6:
                this.family = family.read();
                break;
            case 7:
                System.out.println(family);
                break;
        }
        System.out.flush();
        menu();

    }

    @Override
    public Family createFamily() {
        Family family = new Family();

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

        family.add(gran);
        family.add(dad);
        family.add(gran1);
        family.add(gran2);
        family.add(mom);
        family.add(mom2);
        family.add(son);
        family.add(granson1);
        family.add(granson2);
        family.add(granson);
        return family;
    }

    @Override
    public void sortByName(Family family) {
        family.sortByName();
    }

    @Override
    public void sortByAge(Family family) {
        family.sortByAge();
    }

    @Override
    public List<Human> getBrotherAndSister(String name) {
        family.sortBrotherAndSister(name);
        return family.sortBrotherAndSister(name);
    }


}
