package repository;

import domain.Entity;
import domain.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoomFileRepository<T extends Entity> extends Repository<T> {

    public void readFile(String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            String[] splitstr = str.split(",");
            T r = (T) new Room(Integer.parseInt(splitstr[0]), splitstr[1]);
            this.elems.add(r);
        }

    }

    @Override
    public void writeFile(String filename) throws IOException {
        File file = new File(filename);

        FileWriter fw = new FileWriter(file);
        for (Entity e : this.elems) {
            fw.write(e.fileToString());
            fw.flush();
        }

    }
}

