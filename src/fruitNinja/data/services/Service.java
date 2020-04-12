package fruitNinja.data.services;

import java.util.ArrayList;

public interface Service<T> {
    ArrayList<T> readData();
    void writeData(T data);
}
