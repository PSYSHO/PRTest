package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable,Comparable<Human> {
    private String name;
    //private FamilyRole familyRole;
    private int yearBirth;
    private Human father;
    private Human mother;
    private List<Human> childrens;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int yearBirth, Human father, Human mother) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.father = father;
        this.mother = mother;
        childrens = new ArrayList<Human>();
    }

    public Human(String name, int yearBirth, Human father, Human mother, List<Human> childrens) {
        this.name = name;
        //  this.familyRole = familyRole;
        this.yearBirth = yearBirth;
        this.father = father;
        this.mother = mother;
        this.childrens = childrens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }

    public String getName() {
        return this.name;
    }

    /*public FamilyRole getFamilyRole() {
        return familyRole;
    }

    public void setFamilyRole(FamilyRole familyRole) {
        this.familyRole = familyRole;
    }
    public String Job() {
        if(familyRole == FamilyRole.Father)return "Зарабатывать бабло и сажать дерево";
        else if (familyRole==FamilyRole.Mather)return "Готовить еду и смотреть сериальчики";
        else if(familyRole==FamilyRole.Child)return "Смотреть мультики и учиться";
        return "Who is YOU?";
    }*/


    @Override
    public String toString() {

        String str = "Human{" +
                "name='" + name + '\'' +
                ", yearBirth=" + yearBirth;
        if (father != null) {
            str = str + ", father: " + father.getName();
        }
        if (mother != null) {
            str = str + ", mother: " + mother.getName();
        }
        str = str + '}';
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return yearBirth == human.yearBirth && Objects.equals(name, human.name) && Objects.equals(father, human.father) && Objects.equals(mother, human.mother) && Objects.equals(childrens, human.childrens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearBirth, father, mother, childrens);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}
