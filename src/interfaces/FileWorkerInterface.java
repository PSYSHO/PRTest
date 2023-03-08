package interfaces;

import entity.Toy;
import java.util.LinkedList;

public interface FileWorkerInterface {
    <E> void save(E e);
    LinkedList load();
}
