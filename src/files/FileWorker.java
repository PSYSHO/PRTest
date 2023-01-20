package files;

import interfaces.FileWorkerI;
import model.FamilyTree;

import java.io.*;

public class FileWorker implements FileWorkerI,Serializable {
    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.txt"))) {
            oos.writeObject(serializable);
            System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object read() {
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
