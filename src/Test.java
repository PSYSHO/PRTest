import files.FileWorker;
import model.Family;
import model.FamilyRole;
import model.Human;

import java.util.Arrays;

public class Test {
   public static void main(String[] args){
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
       family.save();
       Family readFamily = family.read();
       System.out.println(readFamily);
       System.out.println(family.findHumanForName("Viktor"));
       System.out.println(family.getBrotherAndSister("Viktor"));
       System.out.println(family.getBrotherAndSister("Blake"));
       family.sortByAge();
       System.out.println(family);
       family.sortByName();
       System.out.println(family);
   }
}
