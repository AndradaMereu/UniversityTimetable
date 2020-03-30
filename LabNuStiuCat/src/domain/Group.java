package domain;

import java.util.ArrayList;

public class Group extends Entity{
    ArrayList<Subgroup> subgroups;

    public Group(int id, ArrayList<Subgroup> subgroups) {
        super(id);
        this.subgroups = subgroups;
    }

    public ArrayList<Subgroup> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(ArrayList<Subgroup> subgroups) {
        this.subgroups = subgroups;
    }

    @Override
    public String toString() {
        return "Group{" +
                "subgroups=" + subgroups +
                '}';
    }
}
