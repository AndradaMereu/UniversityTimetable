package repository;

import domain.Activity;
import domain.Discipline;
import domain.Entity;
import domain.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ActivityFileRepository<T extends Entity>  extends Repository<T> {

    @Override
    public void readFile (String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner s = new Scanner(file);
        while(s.hasNextLine())
        {
            String str=s.nextLine();
            String[] splitstr = str.split(",");
            Discipline d =  new Discipline(Integer.parseInt(splitstr[1]),splitstr[2],Integer.parseInt(splitstr[3]));
            T a = (T) new Activity(Integer.parseInt(splitstr[0]),d,splitstr[4]);
            this.elems.add(a);
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
