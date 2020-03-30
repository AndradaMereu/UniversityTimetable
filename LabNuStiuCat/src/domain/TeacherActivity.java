package domain;

public class TeacherActivity extends Entity{

    private int tid;
    private int aid;

    public TeacherActivity(int id, int t, int a) {
        super(id);
        this.tid = t;
        this.aid = a;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String fileToString()
    {
        return Integer.toString(this.id) + "," + this.getTid()+ "," + this.getAid()+"\n";
    }
}
