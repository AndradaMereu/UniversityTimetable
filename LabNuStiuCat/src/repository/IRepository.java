package repository;

import domain.Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IRepository<T extends Entity> {


    public void add(T elem);
    public void delete(int id);
    public void update(T e, T newe);
    public ArrayList<T> getAll();
    public int size();
    public T searchById(int id);
    public int getIndex(int id);
    public void readFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException;
    public void writeFile(String filename) throws IOException;

}
