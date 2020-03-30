package domain;

public class Activity extends Entity {

    private Discipline discipline;
    String activityName;

    public Activity(int id, Discipline discipline, String activityName) {
        super(id);
        this.discipline = discipline;
        this.activityName = activityName;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + this.getId() + '\'' +
                "discipline=" + discipline +
                ", activityName='" + activityName + '\'' +
                '}';
    }

    @Override
    public String fileToString()
    {
        return this.getId()+ "," + this.getDiscipline().getId()+ "," +this.getDiscipline().getName()
                + "," +this.getDiscipline().getNrOfCredits()
                + "," + this.getActivityName() + "\n";
    }
}
