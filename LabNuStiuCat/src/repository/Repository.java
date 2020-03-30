package repository;

import domain.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Entity> implements IRepository<T> {

    protected ArrayList<T> elems = new ArrayList<>();

    @Override
    public void add(T elem) {
        this.elems.add(elem);
    }

    @Override
    public void delete(int i) {
        this.elems.remove(i);
    }

    @Override
    public void update(T e, T newe) {
        if(e instanceof Teacher && newe instanceof Teacher)
        {
            ((Teacher) e).setId(((Teacher) newe).getId());
            ((Teacher) e).setName(((Teacher) newe).getName());
            ((Teacher) e).setEmail(((Teacher) newe).getEmail());
        }
        if(e instanceof Discipline && newe instanceof Discipline)
        {
            ((Discipline) e).setId(((Discipline) newe).getId());
            ((Discipline) e).setName(((Discipline) newe).getName());
            ((Discipline) e).setNrOfCredits(((Discipline) newe).getNrOfCredits());
        }
        if (e instanceof Activity && newe instanceof Activity)
        {
            ((Activity) e).setDiscipline(((Activity) newe).getDiscipline());
            ((Activity) e).setActivityName(((Activity) newe).getActivityName());
        }
        if(e instanceof Room && newe instanceof Room)
        {
            ((Room) e).setId(((Room) newe).getId());
            ((Room) e).setBuilding(((Room) newe).getBuilding());
        }

    }

    @Override
    public ArrayList<T> getAll() {
        return this.elems;
    }

    @Override
    public int size() {
        return this.elems.size();
    }

    @Override
    public int getIndex(int id) {
        for (int i = 0; i < this.elems.size(); i++)
            if (this.elems.get(i).getId() == id)
            {
                return i;
            }
        return -1;
    }

    @Override
    public T searchById(int id)
    {
        for (int i = 0; i < this.elems.size(); i++)
            if (this.elems.get(i).getId() == id)
            {
                return this.elems.get(i);
            }
        return null;
    }

    @Override
    public void readFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {}

    @Override
    public void writeFile(String filname) throws IOException {
    }


}
