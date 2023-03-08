package Services;

import entity.Toy;
import interfaces.FileWorkerInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileWorker implements FileWorkerInterface {
    @Override
    public <Toy> void save(Toy toy) {
            String text = toy.toString();
            try(FileWriter writer = new FileWriter("Toys.txt", true))
            {
                writer.write(text);
                writer.append('\n');
                writer.flush();
            }
            catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
    }


    @Override
    public LinkedList<Toy> load() {
        return null;
    }
}
