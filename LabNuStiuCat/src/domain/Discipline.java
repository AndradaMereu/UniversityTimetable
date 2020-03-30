package domain;

public class Discipline extends Entity {

    private String name;
    private int nrOfCredits;

    public Discipline(int id, String name, int nrOfCredits) {
        super(id);
        this.name = name;
        this.nrOfCredits = nrOfCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfCredits() {
        return nrOfCredits;
    }

    public void setNrOfCredits(int nrOfCredits) {
        this.nrOfCredits = nrOfCredits;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + this.getId() + '\'' +
                "name='" + name + '\'' +
                ", nrOfCredits=" + nrOfCredits +
                '}';
    }

    @Override
    public String fileToString()
    {
        return this.getId()+","+this.getName()+","+this.getNrOfCredits()+"\n";
    }
}
