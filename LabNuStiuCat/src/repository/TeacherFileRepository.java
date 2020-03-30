package repository;

import domain.Entity;
import domain.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherFileRepository<T extends Entity>  extends Repository<T> {



    @Override
    public void readFile (String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner s = new Scanner(file);
        while(s.hasNextLine())
        {
            String str=s.nextLine();
            String[] splitstr = str.split(",");
            T t = (T) new Teacher(Integer.parseInt(splitstr[0]),splitstr[1],splitstr[2],splitstr[3]);
            this.elems.add(t);
        }

    }

    @Override
    public void writeFile(String filename) throws IOException {
        File file = new File(filename);

        FileWriter fw = new FileWriter(filename);
        for (Entity e: this.elems)
        {
            fw.write(e.fileToString());
            fw.flush();
        }


    }
}
