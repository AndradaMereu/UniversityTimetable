package domain;

import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Teacher extends Entity implements java.io.Serializable {

    private String name;
    private String email;
    private String rank;

    public Teacher(int id, String name, String email, String rank) {
        super(id);
        this.name = name;
        this.email = email;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    @Override
    public String fileToString() {
        return this.getId() + "," + this.getName() + "," + this.getEmail() + ","
                + this.getRank() + "\n";
    }

}
