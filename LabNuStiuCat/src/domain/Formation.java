package domain;

import java.util.ArrayList;

public class Formation extends Entity {

    ArrayList<Group> groups;

    public Formation(int id, ArrayList<Group> groups) {
        super(id);
        this.groups = groups;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "groups=" + groups +
                ", id=" + id +
                '}';
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
