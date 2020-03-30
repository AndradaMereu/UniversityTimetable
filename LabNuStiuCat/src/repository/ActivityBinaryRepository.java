package repository;

import domain.Entity;

import java.io.*;
import java.util.ArrayList;

public class ActivityBinaryRepository<T extends Entity> extends Repository<T> {

    @Override
    public void readFile (String filename) throws IOException, ClassNotFoundException {
        File file = new File(filename);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        elems = (ArrayList<T>) in.readObject();

    }

    @Override
    public void writeFile(String filename) throws IOException {
        ObjectOutputStream out =null;
        out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(elems);

    }
}
