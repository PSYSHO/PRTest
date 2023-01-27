package files;

import interfaces.InterfaceWorkFile;
import model.FamilyTree;

import java.io.*;

public class FileWorker implements InterfaceWorkFile,Serializable {
    @Override
    public void save(FamilyTree familyTree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.txt"))) {
            oos.writeObject(familyTree);
            System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public FamilyTree read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.txt"))) {
            return (FamilyTree) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void remove() {

    }
}
