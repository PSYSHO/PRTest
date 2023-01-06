package interfaces;

import java.io.Serializable;

public interface FileWorkerI {
    void save(Serializable serializable);
    Object read();
    void create();
    void remove();
}
