package repository;

import domain.Activity;
import domain.Discipline;
import domain.Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DisciplineFileRepository<T extends Entity> extends Repository<T> {

    @Override
    public void readFile (String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner s = new Scanner(file);
        while(s.hasNextLine())
        {
            String str=s.nextLine();
            String[] splitstr = str.split(",");
            T d = (T) new Discipline(Integer.parseInt(splitstr[0]),splitstr[1],Integer.parseInt(splitstr[2]));
            this.elems.add(d);
        }

    }

    @Override
    public void writeFile(String filename) throws IOException {
        File file = new File(filename);

        FileWriter fw = new FileWriter(file);
        for (Entity e: this.elems)
        {
            fw.write(e.fileToString());
            fw.flush();
        }


    }
}
