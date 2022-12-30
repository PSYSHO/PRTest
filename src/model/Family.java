package model;

import java.util.ArrayList;
import java.util.List;

public class Family {
    List<Human> humans;

    public Family(){
        humans = new ArrayList<>();
        addHuman(new Human("dad",FamilyRole.Father));
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public Human findHuman(String name){
        for (int i = 0; i < humans.size(); i++) {
            if(humans.get(i).name == name){
                return humans.get(i);
            }
        }
        return null;
    }
    public String whatDo(Human myHuman){
        if(myHuman.familyRole== FamilyRole.Father){
            return ((Human)myHuman).Job();
        }
        else if(myHuman.familyRole== FamilyRole.Mather){
            return ((Human)myHuman).Job();
        }
        else if (myHuman.familyRole== FamilyRole.Child){
            return((Human)myHuman).Job();
        }
        return null;
    }
}

