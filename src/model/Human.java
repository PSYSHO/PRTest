package model;

public class Human {
    String name;
    FamilyRole familyRole;

    public Human(String name){
        this.name = name;
    }

    public Human(String name, FamilyRole familyRole) {
        this.name = name;
        this.familyRole = familyRole;
    }

    public String getName(){
        return this.name;
    }

    public FamilyRole getFamilyRole() {
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
    }
}
