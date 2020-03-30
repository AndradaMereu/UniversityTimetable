package domain;

import java.util.Objects;

public class Room extends Entity {

    private String Building;

    public Room(int id, String building) {
        super(id);
        Building = building;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nr=" + this.getId() + '\'' +
                "Building='" + Building + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return Objects.equals(Building, room.Building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Building);
    }

    @Override
    public String fileToString()
    {
        return this.id + "," + this.getBuilding()+"\n";
    }
}
