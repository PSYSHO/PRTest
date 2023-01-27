package interfaces;

import model.FamilyTree;

import java.io.Serializable;

public interface InterfaceWorkFile {
    void save(FamilyTree familyTree);
    FamilyTree read();
    void create();
    void remove();
}
