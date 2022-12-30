import model.Family;
import model.FamilyRole;
import model.Human;

public class Test {
   public static void main(String[] args){
       Family myFamily = new Family();

       myFamily.addHuman(new Human("Pit",FamilyRole.Father));
       myFamily.addHuman(new Human("Alis",FamilyRole.Mather));
       myFamily.addHuman(new Human("BOOY",FamilyRole.Child));
       myFamily.addHuman(new Human("GIIIRLL",FamilyRole.Child));
       myFamily.addHuman(new Human("Carl",FamilyRole.Child));

       Human human = myFamily.findHuman("Pit");
       System.out.println(human.getName() +"   "+human.getFamilyRole().toString()+ "\r\n" + myFamily.whatDo(human));
   }
}
